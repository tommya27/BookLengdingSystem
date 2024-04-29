package cn.dsscm.pojo;

import java.util.ArrayList;
import java.util.List;

public class PaginationData {
    private Integer pageNum;
    private Integer pageSize;
    private List<BookWithTypeInfo> booksWithTypeInfoList;

    public PaginationData(Integer pageNum, Integer pageSize, List<BookWithTypeInfo> booksWithTypeInfoList) {
        this.pageNum = pageNum;
        this.pageSize = pageSize;
        this.booksWithTypeInfoList = booksWithTypeInfoList;
    }

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public List<BookWithTypeInfo> getBooksWithTypeInfoList() {
        return booksWithTypeInfoList;
    }

    public void setBooksWithTypeInfoList(List<BookWithTypeInfo> booksWithTypeInfoList) {
        this.booksWithTypeInfoList = booksWithTypeInfoList;
    }

    // toString 方法，用于方便地打印对象信息  
    @Override
    public String toString() {
        return "PaginationData{" +
                "pageNum=" + pageNum +
                ", pageSize=" + pageSize +
                ", booksWithTypeInfoList=" + booksWithTypeInfoList +
                '}';
    }
}