package cn.dsscm.service;

import cn.dsscm.pojo.Book;

public interface BookWithTypeInfoService {

    public void insertNewBook();

    public void deleteNewBookById();

    public void selectNewBooksWithTypeInfo();

    public void updateNewBookBySet();

}
