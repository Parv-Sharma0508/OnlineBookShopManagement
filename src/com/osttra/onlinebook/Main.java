package com.osttra.onlinebook;

import com.osttra.onlinebook.service.UserService;
import com.osttra.onlinebook.service.BookService;

import java.util.Scanner;

public class Main {

		static Scanner sc = new Scanner(System.in);

		public static void main (String[]args) throws Exception {

			UserService userService = new UserService();
			BookService bookService= new BookService();

			boolean mainMenuFlag = true;

			while (mainMenuFlag) {

				System.out.println("-> Enter 1 for Registration");
                System.out.println("-> Enter 2 for Login ");
				System.out.println("-> Enter 0 for Exit");
				int mainMenuInput = sc.nextInt();
				switch (mainMenuInput) {
					case 1:

						userService.register();
						break;

					case 2:
//
					//	boolean loginFlag = true;

//
						int loginStatus = userService.login();

							String loginusername=UserService.userName;

							if (loginStatus==1) {
								boolean normalLoginFlag=true;
								while(normalLoginFlag){
								System.out.println("<-----Welcome To Online Book Shop----->");

								System.out.println("Press 1 :To view all available books in the shop");
								System.out.println("Press 2 :To add book in NEW BOOKS CATEGORY ");
								System.out.println("Press 3 :To add book in FAVOURITE BOOKS CATEGORY");
								System.out.println("Press 4 :To add book in COMPLETED BOOKS CATEGORY");
								System.out.println("Press 5 : To get Book Detail by BookId");
                                 System.out.println("Press 0: To Exit");
								int input1 = sc.nextInt();

								if (input1 == 1) {

									bookService.getAllBooksDetails();
								} else if (input1 == 2) {
									bookService.addNewBookByUser(loginusername);
									System.out.println("New Books-:");

									bookService.getNewBooksDetails();
								} else if (input1 == 3) {
									bookService.addFavBook(loginusername);
									System.out.println("Fav Books-:");

									bookService.getFavBooksDetails();
								} else if (input1 == 4) {
									bookService.addCompletedBook(loginusername);
									System.out.println("Completed Books-:");

									bookService.getCompletedBooksDetails();
								}else if(input1==5){
									bookService.getDetailsFromBookId();
								} else{
									normalLoginFlag = false;
									break;
								}
							}}else if(loginStatus==2){
								boolean adminLoginFlag =true;
								while(adminLoginFlag) {
									System.out.println("<-----Welcome To Online Book Shop----->");

									System.out.println("Press 1 :To see all user details");
									System.out.println("Press 2 : To add book in the system");
									System.out.println("Press 3 : Available books in the system");
									System.out.println("Press 0: To Exit");
									int input2 = sc.nextInt();
									if (input2 == 1) {
										userService.getUsers();
									} else if (input2 == 2) {
										bookService.addNewBooksByAdmin();
									} else if (input2 == 3) {

										bookService.getAllBooksDetails();
									} else {
										adminLoginFlag = false;
										break;
									}
								}
							}else{
								System.out.println("Wrong Credentials...Please try Again");
								mainMenuFlag = true;
							}
						break;
					case 0:
						mainMenuFlag = false;
						break;
				}
			}
		}

}
