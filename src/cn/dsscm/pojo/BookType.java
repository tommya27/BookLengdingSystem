package cn.dsscm.pojo;

public class BookType {
    private Integer BookTypeId;
    private String typeName;

    public Integer getBookTypeId() {
        return BookTypeId;
    }

    public void setBookTypeId(Integer bookTypeId) {
        BookTypeId = bookTypeId;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public BookType() {
    }

    public BookType(Integer bookTypeId) {
        BookTypeId = bookTypeId;
    }

    public BookType(String typeName) {
        this.typeName = typeName;
    }

    public BookType(Integer bookTypeId, String typeName) {
        BookTypeId = bookTypeId;
        this.typeName = typeName;
    }

    @Override
    public String toString() {
        return "BookType{" +
                "BookTypeId=" + BookTypeId +
                ", typeName='" + typeName + '\'' +
                '}';
    }
}
