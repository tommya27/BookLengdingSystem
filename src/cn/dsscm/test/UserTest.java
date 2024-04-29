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

			//开启分页
			PageHelper.startPage(pageNum,pageSize);
			// 获取查询数据放入分页对象、
			// 查询时无需关注查询的条数 不需要向Dao层中的方法传入limit后边的两个参数 (limit 1 ,5)
			// 调用Dao层方法
			userList = sqlSession.getMapper(BookLendingMapper.class).getUserList3(userName, roleId);
			///封装pageInfo对象并返回   PageInfo可以看到源码你就明白所有意思
			PageInfo<User> pageInfo=new PageInfo<User>(userList);
			for (User user : pageInfo.getList()) {
				logger.debug(user);
			}
			logger.debug("当前页数："+ pageInfo.getPageNum());
			logger.debug("每页条数："+ pageInfo.getPageSize());
			logger.debug("总页数："+ pageInfo.getPages());
			logger.debug("总条数："+ pageInfo.getTotal());

		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			MyBatisUtils.closeSqlSession(sqlSession);
		}

	}
}
