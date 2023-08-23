package com.osttra.onlinebook.dao;

import com.osttra.onlinebook.dto.Book;
import com.osttra.onlinebook.dto.CompletedBook;
import com.osttra.onlinebook.dto.FavBook;
import com.osttra.onlinebook.dto.NewBook;
import com.osttra.onlinebook.service.UserService;
import com.osttra.onlinebook.utils.DbUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class BookDAO {

    public void addBookByAdmin(Book book) {
        try {

            Connection con = DbUtils.getConnection();

            PreparedStatement statement = con.prepareStatement("insert into book values(?,?,?,?)");

            statement.setString(1, String.valueOf(book.getBookId()));
            statement.setString(2, book.getBookName());
            statement.setString(3, book.getAuthorName());
            statement.setString(4, book.getDescription());


            statement.executeUpdate();
        } catch (Exception e) {
            System.out.println("inside catch of addBookByAdmin() of BookDAO...");
            e.printStackTrace();
        }

    }

    public void addNewBookByUser(NewBook newbook) {
        try {

            Connection con = DbUtils.getConnection();

            PreparedStatement statement = con.prepareStatement("insert into UserNewBooks values(?,?)");

            statement.setString(1, String.valueOf(newbook.getBookId()));
            statement.setString(2, newbook.getUserName());

            statement.executeUpdate();
        } catch (Exception e) {
            System.out.println("inside catch of addNewBookByUser() of BookDAO...");
            e.printStackTrace();
        }
    }

    public void addFavBookByUser(FavBook favbook) {
        try {

            Connection con = DbUtils.getConnection();

            PreparedStatement statement = con.prepareStatement("insert into UserFavBooks values(?,?)");

            statement.setString(1, String.valueOf(favbook.getBookId()));
            statement.setString(2, favbook.getUserName());

            statement.executeUpdate();
        } catch (Exception e) {
            System.out.println("inside catch of addFavBookByUser() of BookDAO...");
            e.printStackTrace();
        }
    }

    public void addCompletedBookByUser(CompletedBook completedbook) {
        try {

            Connection con = DbUtils.getConnection();

            PreparedStatement statement = con.prepareStatement("insert into UserCompletedBooks values(?,?)");

            statement.setString(1, String.valueOf(completedbook.getBookId()));
            statement.setString(2, completedbook.getUserName());

            statement.executeUpdate();
        } catch (Exception e) {
            System.out.println("inside catch of addCompletedBookByUser() of BookDAO...");
            e.printStackTrace();
        }
    }

    public List<Book> getAllBooksDetails() {
            ResultSet resultSet=null;
            ArrayList<Book>books=new ArrayList<Book>();

        try {

            Connection conn = DbUtils.getConnection();

            PreparedStatement statement = conn.prepareStatement("select * from book ");


             resultSet = statement.executeQuery();

            while (resultSet.next()) {

                int bookId = resultSet.getInt("book_id");
                String bookName = resultSet.getString("book_name");
                String authorName = resultSet.getString("author_name");
                String desc = resultSet.getString("descp");

                Book book=new Book(bookId,bookName,authorName,desc);
                books.add(book);

            }

        } catch (Exception e) {
            System.out.println("inside catch of getBook() of BookDAO...");
            e.printStackTrace();
        }
       return books;

    }

    public List<Book> getNewBooksDetails() {
          ResultSet resultSet=null;
          ArrayList<Book> books=new ArrayList<Book>();

        try {

            Connection conn = DbUtils.getConnection();

            PreparedStatement statement = conn.prepareStatement("select b.book_id,b.book_name,b.author_name,b.descp from book b inner join UserNewBooks unb ON b.book_id=unb.book_id where unb.user_id=?;");

            statement.setString(1, UserService.userName);
             resultSet = statement.executeQuery();

            while (resultSet.next()) {

                int bookId = resultSet.getInt("book_id");
                String bookname = resultSet.getString("book_name");
                String authorname = resultSet.getString("author_name");
                String desc = resultSet.getString("descp");
                Book book=new Book(bookId,bookname,authorname,desc);
                books.add(book);


            }

        } catch (Exception e) {
            System.out.println("inside catch of getNewBooksDetails() of BookDAO...");
            e.printStackTrace();
        }
        return books;
    }

    public List<Book> getFavBooksDetails() {
        ResultSet resultSet=null;
        ArrayList<Book> books=new ArrayList<Book>();

        try {

            Connection conn = DbUtils.getConnection();

            PreparedStatement statement = conn.prepareStatement("select b.book_id,b.book_name,b.author_name,b.descp from book b inner join UserFavBooks unb ON b.book_id=unb.book_id where unb.user_id=?;");

            statement.setString(1, UserService.userName);
            resultSet = statement.executeQuery();

            while (resultSet.next()) {

                int bookId = resultSet.getInt("book_id");
               String bookname = resultSet.getString("book_name");
                String authorname = resultSet.getString("author_name");
                String desc = resultSet.getString("descp");

                Book book=new Book(bookId,bookname,authorname,desc);
                books.add(book);


            }

        } catch (Exception e) {
            System.out.println("inside catch of getFavBooksDetails() of BookDAO...");
            e.printStackTrace();
        }
        return books;
    }

    public List<Book> getCompletedBooksDetails() {
ResultSet resultSet=null;
ArrayList<Book> books=new ArrayList<Book>();

        try {

            Connection conn = DbUtils.getConnection();

            PreparedStatement statement = conn.prepareStatement("select b.book_id,b.book_name,b.author_name,b.descp from book b inner join UserCompletedBooks unb ON b.book_id=unb.book_id where unb.user_id=?;");

            statement.setString(1, UserService.userName);
             resultSet = statement.executeQuery();

            while( resultSet.next()) {

                int bookId = resultSet.getInt("book_id");
                String bookname = resultSet.getString("book_name");
                String authorname = resultSet.getString("author_name");
                String desc = resultSet.getString("descp");

                Book book=new Book(bookId,bookname,authorname,desc);
                books.add(book);

            }

        } catch (Exception e) {
            System.out.println("inside catch of getCompletedBooksDetails() of BookDAO...");
        }
        return books;
    }
    public static Book getBookById(int id) {
 ResultSet resultSet=null;
 Book book=null;

        try {

            Connection conn = DbUtils.getConnection();

            PreparedStatement statement = conn.prepareStatement("select * from book where book_id=? ");

            statement.setString(1, Integer.toString(id));
            resultSet = statement.executeQuery();

            while (resultSet.next()) {

                int bookId = resultSet.getInt("book_id");
                String bookName = resultSet.getString("book_name");
                String authorName = resultSet.getString("author_name");
                String desc = resultSet.getString("descp");
                book=new Book(bookId,bookName,authorName,desc);

            }

        } catch (Exception e) {
            System.out.println("inside catch of getBook() of BookDAO...");
            e.printStackTrace();
        }
        return book;

    }
}