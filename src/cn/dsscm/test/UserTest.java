package cn.dsscm.test;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.Test;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import cn.dsscm.dao.BookLendingMapper;
import cn.dsscm.pojo.User;
import cn.dsscm.utils.MyBatisUtils;

public class UserTest {
	private Logger logger = Logger.getLogger(UserTest.class);
	@Test
	public void testGetUserList(){
		SqlSession sqlSession = null;
		List<User> userList = new ArrayList<User>();
		try {
			sqlSession = MyBatisUtils.createSqlSession();
			String userName = "";
			Integer roleId = null;
			Integer pageSize = 5;
			Integer currentPageNo = 0;
			userList = sqlSession.getMapper(BookLendingMapper.class)
					.getUserList(userName,roleId,currentPageNo,pageSize);
			logger.debug("userlist.size ----> " + userList.size());
			for (User user : userList) {
				logger.debug(user);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			MyBatisUtils.closeSqlSession(sqlSession);
		}

	}



	@Test
	public void testGetUserList3(){
		SqlSession sqlSession = null;
		List<User> userList = new ArrayList<User>();
		try {
			sqlSession = MyBatisUtils.createSqlSession();
			String userName = "";
			Integer roleId = null;
			Integer pageNum=1;
			Integer pageSize =5;

			//������ҳ
			PageHelper.startPage(pageNum,pageSize);
			// ��ȡ��ѯ���ݷ����ҳ����
			// ��ѯʱ�����ע��ѯ������ ����Ҫ��Dao���еķ�������limit��ߵ��������� (limit 1 ,5)
			// ����Dao�㷽��
			userList = sqlSession.getMapper(BookLendingMapper.class).getUserList3(userName, roleId);
			///��װpageInfo���󲢷���   PageInfo���Կ���Դ���������������˼
			PageInfo<User> pageInfo=new PageInfo<User>(userList);
			for (User user : pageInfo.getList()) {
				logger.debug(user);
			}
			logger.debug("��ǰҳ����"+ pageInfo.getPageNum());
			logger.debug("ÿҳ������"+ pageInfo.getPageSize());
			logger.debug("��ҳ����"+ pageInfo.getPages());
			logger.debug("��������"+ pageInfo.getTotal());

		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			MyBatisUtils.closeSqlSession(sqlSession);
		}

	}
}
