package com.osttra.onlinebook.dto;

public class Book {

    private String bookName;

    private String authorName;
    private String description;
    private Integer bookId;

    public Book(Integer bookId,String bookName, String authorName, String description) {

        this.bookName = bookName;
        this.authorName = authorName;
        this.description = description;
        this.bookId = bookId;

    }
    public String getBookName() {
        return bookName;
    }
    public void setBookName(String bookName) {
        this.bookName = bookName;
    }
    public String getAuthorName() {
        return authorName;
    }
    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description=description;
    }
    public Integer getBookId() {
        return bookId;
    }
    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }


}
