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
            book.setBookName("���������鼮002");
            book.setBookType(1);
            book.setBookAuthor("��������");
            book.setPublishPress("���Գ�����");
            book.setPublishDate(new Date());
            book.setBorrowed(0);
            book.setCreatedBy("���Դ�����");
            book.setCreationTime(new Date());
            book.setLastUpdateTime(new Date());

            count = sqlSession.getMapper(BookLendingMapper.class).insertBook(book);

            if (count == 1) {
                System.out.println("�ɹ�����" + count + "�����ݣ�");
            } else {
                System.out.println("ִ�в������ʧ�ܣ����飡");
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

            Integer delbookId = 9; // ��Ҫɾ���Ĺ�Ӧ��ID

            count = sqlSession.getMapper(BookLendingMapper.class).deleteBookById(delbookId);

            if (count == 1) {
                System.out.println("�ɹ�ɾ��" + count + "�����ݣ�");
            } else {
                System.out.println("ִ��ɾ������ʧ�ܣ����飡");
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
                // ������Ӹ�������������������
            }
            System.out.println("��ǰҳ����" + pageInfo.getPageNum());
            System.out.println("ÿҳ������" + pageInfo.getPageSize());
            System.out.println("��ҳ����" + pageInfo.getPages());
            System.out.println("��������" + pageInfo.getTotal());
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
            book.setBookId(9); // ��Ҫ���µ��鼮ID

            // ������Ҫ���µ��ֶ�ֵ������ֻ��ʾ��������Ҫ����ʵ���������
            book.setBookCode("Updatetest001");
            book.setBookName("�޸Ĳ�������001");
            book.setBookType(1);
            book.setBookAuthor("��������");
            book.setPublishPress("���Գ�����");
            book.setPublishDate(new Date());
            book.setBorrowed(0);
            book.setCreatedBy("���Դ�����");
            book.setCreationTime(new Date());
            book.setLastUpdateTime(new Date());

            count = sqlSession.getMapper(BookLendingMapper.class).updateBookBySet(book);

            if (count == 1) {
                System.out.println("�ɹ������鼮��Ϣ��");
            } else {
                System.out.println("ִ�и��²���ʧ�ܣ����飡");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            MyBatisUtils.closeSqlSession(sqlSession);
        }
        return count;
    }
}
