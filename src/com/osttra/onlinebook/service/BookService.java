package com.osttra.onlinebook.service;

import com.osttra.onlinebook.dto.Book;
import com.osttra.onlinebook.dto.CompletedBook;
import com.osttra.onlinebook.dto.FavBook;
import com.osttra.onlinebook.dto.NewBook;
import com.osttra.onlinebook.dao.BookDAO;

import java.util.List;
import java.util.Scanner;

public class BookService {
    Scanner sc = new Scanner(System.in);

    BookDAO bookDAO = new BookDAO();

    public void addNewBooksByAdmin() {

        System.out.println("Enter BookId");
        Integer bookId = sc.nextInt();

        System.out.println("Enter Book Name:");
        String bookName = sc.next();

        System.out.println("Enter Author Name:");
        String authorName = sc.next();

        System.out.println("Enter Description:");
        String description = sc.next();

        Book book = new Book(bookId,bookName,authorName,description);

        bookDAO.addBookByAdmin(book);

    }

    public void addNewBookByUser(String username) {

        System.out.println("Enter BookId");
        Integer bookId = sc.nextInt();

        NewBook newBook = new NewBook(bookId,username);

        bookDAO.addNewBookByUser(newBook);
    }
    public void addFavBook(String username) {

        System.out.println("Enter BookId");
        Integer bookId = sc.nextInt();

        FavBook favbook = new FavBook(bookId,username);

        bookDAO.addFavBookByUser(favbook);
    }
    public void addCompletedBook(String username) {

        System.out.println("Enter BookId");
        Integer bookId = sc.nextInt();

        CompletedBook completedbook = new CompletedBook(bookId,username);

        bookDAO.addCompletedBookByUser(completedbook);
    }
 public void getDetailsFromBookId(){
     System.out.println("Enter BookId:");
     int bookId = sc.nextInt();

     Book book=BookDAO.getBookById(bookId);
    // System.out.println(book);
     System.out.println("Book Id:"+book.getBookId());
     System.out.println("Book Name:"+book.getBookName());
     System.out.println("Author Name:"+book.getAuthorName());
     System.out.println("Book Desc:"+book.getDescription());
     System.out.println("---------------------");

    }
    public void getAllBooksDetails(){
        List<Book> books=bookDAO.getAllBooksDetails();
        for(Book book:books){
            //System.out.println(book);
            System.out.println("Book Id:"+book.getBookId());
            System.out.println("Book Name:"+book.getBookName());
            System.out.println("Author Name:"+book.getAuthorName());
            System.out.println("Book Desc:"+book.getDescription());
            System.out.println("------------------");
        }
    }
    public void getNewBooksDetails(){
        List<Book> books=bookDAO.getNewBooksDetails();
        for(Book book:books){
           // System.out.println(book);
            System.out.println("Book Id:"+book.getBookId());
            System.out.println("Book Name:"+book.getBookName());
            System.out.println("Author Name:"+book.getAuthorName());
            System.out.println("Book Desc:"+book.getDescription());
            System.out.println("------------------");
        }
    }
    public void getFavBooksDetails(){
        List<Book> books=bookDAO.getFavBooksDetails();
        for(Book book:books){
            //System.out.println(book);
            System.out.println("Book Id:"+book.getBookId());
            System.out.println("Book Name:"+book.getBookName());
            System.out.println("Author Name:"+book.getAuthorName());
            System.out.println("Book Desc:"+book.getDescription());
            System.out.println("------------------");
        }
    }
    public void getCompletedBooksDetails(){
        List<Book> books=bookDAO.getCompletedBooksDetails();
        for(Book book:books){
           // System.out.println(book);
                System.out.println("Book Id:"+book.getBookId());
                System.out.println("Book Name:"+book.getBookName());
                System.out.println("Author Name:"+book.getAuthorName());
                System.out.println("Book Desc:"+book.getDescription());
            System.out.println("------------------");
        }
    }


}
