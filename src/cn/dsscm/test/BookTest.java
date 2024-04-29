package cn.dsscm.test;

import cn.dsscm.dao.BookLendingMapper;
import cn.dsscm.pojo.Book;
import cn.dsscm.pojo.BookWithTypeInfo;
import cn.dsscm.service.BookWithTypeInfoService;
import cn.dsscm.utils.MyBatisUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BookTest {

    //Ôö¼Ó
    @Test
    public void testInsertBook() {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        BookWithTypeInfoService bookWithTypeInfoService = (BookWithTypeInfoService) context.getBean("BookWithTypeInfoService");
        bookWithTypeInfoService.insertNewBook();

    }

    //É¾³ý
    @Test
    public void testDeleteBookById() {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        BookWithTypeInfoService bookWithTypeInfoService = (BookWithTypeInfoService) context.getBean("BookWithTypeInfoService");
        bookWithTypeInfoService.deleteNewBookById();
    }

    //²éÑ¯
    @Test
    public void testSelectBooksWithTypeInfo() {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        BookWithTypeInfoService bookWithTypeInfoService = (BookWithTypeInfoService) context.getBean("BookWithTypeInfoService");
        bookWithTypeInfoService.selectNewBooksWithTypeInfo();
    }


    @Test
    public void testUpdateBook() {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        BookWithTypeInfoService bookWithTypeInfoService = (BookWithTypeInfoService) context.getBean("BookWithTypeInfoService");
        bookWithTypeInfoService.updateNewBookBySet();
    }
}
