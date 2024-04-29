package cn.dsscm.pojo;

import java.util.Date;

public class BookWithTypeInfo {
    private Integer bookId;// 书籍ID

    private String bookCode;// 书籍编号

    private String bookName;// 书籍名称

    private String typeName; // 假设这是图书类型的名称

    private String bookAuthor;// 书籍作者

    private String publishPress;// 出版社

    private Date publishDate; // 出版日期

    private Integer borrowed;// 是否借出（0表示未借出，1表示借出）



    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    public String getBookCode() {
        return bookCode;
    }

    public void setBookCode(String bookCode) {
        this.bookCode = bookCode;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getBookAuthor() {
        return bookAuthor;
    }

    public void setBookAuthor(String bookAuthor) {
        this.bookAuthor = bookAuthor;
    }

    public String getPublishPress() {
        return publishPress;
    }

    public void setPublishPress(String publishPress) {
        this.publishPress = publishPress;
    }

    public Date getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(Date publishDate) {
        this.publishDate = publishDate;
    }

    public Integer getBorrowed() {
        return borrowed;
    }

    public void setBorrowed(Integer borrowed) {
        this.borrowed = borrowed;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public BookWithTypeInfo() {
    }


    public BookWithTypeInfo(
            Integer bookId,
            String bookCode,
            String bookName,
            String bookAuthor,
            String publishPress,
            Date publishDate,
            Integer borrowed,
            String typeName
    ) {
        this.bookId = bookId;
        this.bookCode = bookCode;
        this.bookName = bookName;
        this.bookAuthor = bookAuthor;
        this.publishPress = publishPress;
        this.publishDate = publishDate;
        this.borrowed = borrowed;
        this.typeName = typeName;
    }

    @Override
    public String toString() {
        return "BookWithTypeInfo{" +
                "bookId=" + bookId +
                ", bookCode='" + bookCode + '\'' +
                ", bookName='" + bookName + '\'' +
                ", bookAuthor='" + bookAuthor + '\'' +
                ", publishPress='" + publishPress + '\'' +
                ", publishDate=" + publishDate +
                ", borrowed=" + borrowed +
                ", typeName='" + typeName + '\'' +
                '}';
    }
}
