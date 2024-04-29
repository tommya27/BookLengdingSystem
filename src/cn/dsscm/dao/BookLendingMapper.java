package cn.dsscm.dao;

import java.util.List;

import cn.dsscm.pojo.Book;
import cn.dsscm.pojo.BookWithTypeInfo;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import cn.dsscm.pojo.User;

public interface BookLendingMapper {
	
	/**
	 * 查询用户表记录数
	 * @return
	 */
	public int count();

	public List<User> getUserList(@Param("userName")String userName,
					@Param("userRole")Integer roleId,
					@Param("from")Integer currentPageNo,
					@Param("pageSize")Integer pageSize);

	
	/**
	 * 查询用户列表(分页显示)
	 * @param userName
	 * @param roleId
	 * @return
	 */
	public List<User> getUserList3(@Param("userName")String userName,
			@Param("userRole")Integer roleId);

	//增加
	public int insertBook(Book book);

	//删除
	public int deleteBookById(@Param("bookId")Integer bookId);

	int deleteBookById();

	//查询
	public  List<BookWithTypeInfo> selectBooksWithTypeInfo();

	//修改
	public int updateBookBySet(Book book);

}
