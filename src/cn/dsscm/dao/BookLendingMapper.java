package cn.dsscm.dao;

import java.util.List;

import cn.dsscm.pojo.Book;
import cn.dsscm.pojo.BookWithTypeInfo;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import cn.dsscm.pojo.User;

public interface BookLendingMapper {
	
	/**
	 * ��ѯ�û����¼��
	 * @return
	 */
	public int count();

	public List<User> getUserList(@Param("userName")String userName,
					@Param("userRole")Integer roleId,
					@Param("from")Integer currentPageNo,
					@Param("pageSize")Integer pageSize);

	
	/**
	 * ��ѯ�û��б�(��ҳ��ʾ)
	 * @param userName
	 * @param roleId
	 * @return
	 */
	public List<User> getUserList3(@Param("userName")String userName,
			@Param("userRole")Integer roleId);

	//����
	public int insertBook(Book book);

	//ɾ��
	public int deleteBookById(@Param("bookId")Integer bookId);

	int deleteBookById();

	//��ѯ
	public  List<BookWithTypeInfo> selectBooksWithTypeInfo();

	//�޸�
	public int updateBookBySet(Book book);

}
