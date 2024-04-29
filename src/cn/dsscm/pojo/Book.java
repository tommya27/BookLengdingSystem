package cn.dsscm.pojo;

import java.util.Date;

public class Book {

    private Integer bookId;// 书籍ID

    private String bookCode;// 书籍编号

    private String bookName;// 书籍名称

    private Integer bookType;// 书籍类型ID

    private String bookAuthor;// 书籍作者

    private String publishPress;// 出版社

    private Date publishDate; // 出版日期

    private Integer borrowed;// 是否借出（0表示未借出，1表示借出）

    private String createdBy;// 创建者

    private Date creationTime;// 创建时间

    private Date lastUpdateTime;// 最后更新时间

    // 无参构造函数
    public Book() {
    }

    // 带参构造函数
    public Book(Integer bookId, String bookCode, String bookName, Integer bookType, String bookAuthor, String publishPress, Date publishDate, Integer borrowed, String createdBy, Date creationTime, Date lastUpdateTime) {
        this.bookId = bookId;
        this.bookCode = bookCode;
        this.bookName = bookName;
        this.bookType = bookType;
        this.bookAuthor = bookAuthor;
        this.publishPress = publishPress;
        this.publishDate = publishDate;
        this.borrowed = borrowed;
        this.createdBy = createdBy;
        this.creationTime = creationTime;
        this.lastUpdateTime = lastUpdateTime;
    }

    // Getter 和 Setter 方法
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

    public Integer getBookType() {
        return bookType;
    }

    public void setBookType(Integer bookType) {
        this.bookType = bookType;
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

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Date getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(Date creationTime) {
        this.creationTime = creationTime;
    }

    public Date getLastUpdateTime() {
        return lastUpdateTime;
    }

    public void setLastUpdateTime(Date lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }

    // 重写 toString 方法，用于对象打印输出
    @Override
    public String toString() {
        return "Book{" +
                "bookId=" + bookId +
                ", bookCode='" + bookCode + '\'' +
                ", bookName='" + bookName + '\'' +
                ", bookType=" + bookType +
                ", bookAuthor='" + bookAuthor + '\'' +
                ", publishPress='" + publishPress + '\'' +
                ", publishDate=" + publishDate +
                ", borrowed=" + borrowed +
                ", createdBy='" + createdBy + '\'' +
                ", creationTime=" + creationTime +
                ", lastUpdateTime=" + lastUpdateTime +
                '}';
    }
}
