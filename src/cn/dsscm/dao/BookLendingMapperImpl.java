package cn.dsscm.dao;

import cn.dsscm.pojo.Book;
import cn.dsscm.pojo.BookWithTypeInfo;
import cn.dsscm.pojo.PaginationData;
import cn.dsscm.pojo.User;
import cn.dsscm.test.BookTest;
import cn.dsscm.utils.MyBatisUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BookLendingMapperImpl implements BookLendingMapper{

    public BookLendingMapper bookLendingMapper;

    private Logger logger = Logger.getLogger(BookTest.class);

    public BookLendingMapper getBookLendingMapper() {
        return bookLendingMapper;
    }

    public void setBookLendingMapper(BookLendingMapper bookLendingMapper) {
        this.bookLendingMapper = bookLendingMapper;
    }

    @Override
    public int count() {
        return 0;
    }

    @Override
    public List<User> getUserList(String userName, Integer roleId, Integer currentPageNo, Integer pageSize) {
        return null;
    }

    @Override
    public List<User> getUserList3(String userName, Integer roleId) {
        return null;
    }

    @Override
    public int insertBook(Book book) {
        logger.debug("testInsertBook!====================");
        SqlSession sqlSession = null;
        int count = 0;
        try {
            sqlSession = MyBatisUtils.createSqlSession();

            book.setBookCode("addtest002");
            book.setBookName("新增测试书籍002");
            book.setBookType(1);
            book.setBookAuthor("测试作者");
            book.setPublishPress("测试出版社");
            book.setPublishDate(new Date());
            book.setBorrowed(0);
            book.setCreatedBy("测试创建者");
            book.setCreationTime(new Date());
            book.setLastUpdateTime(new Date());

            count = sqlSession.getMapper(BookLendingMapper.class).insertBook(book);

            if (count == 1) {
                System.out.println("成功插入" + count + "条数据！");
            } else {
                System.out.println("执行插入操作失败，请检查！");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            MyBatisUtils.closeSqlSession(sqlSession);
        }
       return count;
    }

    @Override
    public int deleteBookById(Integer bookId) {
        return 0;
    }

    @Override
    public int deleteBookById() {

        logger.debug("testDeleteBookById!====================");
        SqlSession sqlSession = null;
        int count = 0;
        try {
            sqlSession = MyBatisUtils.createSqlSession();

            Integer delbookId = 9; // 需要删除的供应商ID

            count = sqlSession.getMapper(BookLendingMapper.class).deleteBookById(delbookId);

            if (count == 1) {
                System.out.println("成功删除" + count + "条数据！");
            } else {
                System.out.println("执行删除操作失败，请检查！");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            MyBatisUtils.closeSqlSession(sqlSession);
        }
        return count;
    }


    public List<BookWithTypeInfo> selectBooksWithTypeInfo() {
        SqlSession sqlSession = null;
        List<BookWithTypeInfo> booksWithTypeInfoList = new ArrayList<BookWithTypeInfo>();
        PaginationData paginationData = null;
        try {
            sqlSession = MyBatisUtils.createSqlSession();

            Integer pageNum = 1;
            Integer pageSize = 3;
            PageHelper.startPage(pageNum,pageSize);

            booksWithTypeInfoList = sqlSession.getMapper(BookLendingMapper.class).selectBooksWithTypeInfo();

//            booksWithTypeInfoList = bookLendingMapper.selectBooksWithTypeInfo();

            PageInfo<BookWithTypeInfo> pageInfo = new PageInfo<BookWithTypeInfo>(booksWithTypeInfoList);

            for (BookWithTypeInfo book : booksWithTypeInfoList) {
                System.out.println(
                        "-- bookId: " + book.getBookId() +
                                "-- bookCode: " + book.getBookCode() +
                                "-- bookName: " + book.getBookName() +
                                "-- typeName: " + book.getTypeName() +
                                "-- bookAuthor: " + book.getBookAuthor() +
                                "-- publishPress: " + book.getPublishPress() +
                                "-- publishDate: " + book.getPublishDate() +
                                "-- borrowed: " + book.getBorrowed() + "\n"
                );
                // 可以添加更多断言来检查其他属性
            }
            System.out.println("当前页数：" + pageInfo.getPageNum());
            System.out.println("每页条数：" + pageInfo.getPageSize());
            System.out.println("总页数：" + pageInfo.getPages());
            System.out.println("总条数：" + pageInfo.getTotal());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            MyBatisUtils.closeSqlSession(sqlSession);
        }
        return booksWithTypeInfoList;
    }


    public int updateBookBySet(Book book) {
        logger.debug("testUpdateBook!====================");
        SqlSession sqlSession = null;
        int count = 0;
        try {
            sqlSession = MyBatisUtils.createSqlSession();

//            Book book = new Book();
            book.setBookId(9); // 需要更新的书籍ID

            // 设置需要更新的字段值，这里只是示例，你需要根据实际情况设置
            book.setBookCode("Updatetest001");
            book.setBookName("修改测试数据001");
            book.setBookType(1);
            book.setBookAuthor("测试作者");
            book.setPublishPress("测试出版社");
            book.setPublishDate(new Date());
            book.setBorrowed(0);
            book.setCreatedBy("测试创建者");
            book.setCreationTime(new Date());
            book.setLastUpdateTime(new Date());

            count = sqlSession.getMapper(BookLendingMapper.class).updateBookBySet(book);

            if (count == 1) {
                System.out.println("成功更新书籍信息！");
            } else {
                System.out.println("执行更新操作失败，请检查！");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            MyBatisUtils.closeSqlSession(sqlSession);
        }
        return count;
    }
}
