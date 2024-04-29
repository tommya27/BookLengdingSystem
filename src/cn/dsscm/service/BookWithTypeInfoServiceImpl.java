package cn.dsscm.service;

import cn.dsscm.dao.BookLendingMapper;
import cn.dsscm.pojo.Book;
import cn.dsscm.pojo.BookWithTypeInfo;

import java.util.List;

public class BookWithTypeInfoServiceImpl implements BookWithTypeInfoService{

    private BookLendingMapper bookLendingMapper;

    Book book = new Book();


    public BookLendingMapper getBookLendingMapper() {
        return bookLendingMapper;
    }

    public void setBookLendingMapper(BookLendingMapper bookLendingMapper) {
        this.bookLendingMapper = bookLendingMapper;
    }



    public void insertNewBook() {
        bookLendingMapper.insertBook(book);
    }

    public void deleteNewBookById(){
        bookLendingMapper.deleteBookById();
    }

    public void selectNewBooksWithTypeInfo() {
        bookLendingMapper.selectBooksWithTypeInfo();
    }

    public void updateNewBookBySet() {
        bookLendingMapper.updateBookBySet(book);
    }


}
