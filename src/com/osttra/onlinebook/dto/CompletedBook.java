package com.osttra.onlinebook.dto;

public class CompletedBook {
    private Integer bookId;

    private String userName;


    CompletedBook(){

    }
    public CompletedBook(Integer bookId, String userName){
        this.bookId=bookId;
        this.userName=userName;
    }

    public Integer getBookId() {
        return bookId;
    }
    //    public void setBookName(String bookName) {
//        this.bookName = bookName;
//    }
    public String getUserName() {
        return userName;
    }
//    public void setAuthorName(String authorName) {
//        this.authorName = authorName;
//    }
}
