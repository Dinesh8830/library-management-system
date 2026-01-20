package com.dinesh.lms.ui;

import java.util.List;
import java.util.Scanner;

import com.dinesh.lms.dao.BookDao;
import com.dinesh.lms.model.Books;
public class LibraryUI {
	
	private Scanner sc = new Scanner(System.in);
	BookDao bd = new BookDao();
	public void start()
	{
		int choice;
		do {
			showMenu();
			choice = sc.nextInt();
			switch(choice) {
			
			case 1:
				addBookUI();
				break;
			case 2:
				showBookUI();
				break;
			case 3:
				showAllBookUI();
				break;
			case 4:
				deleteBookUI();
				break;
			case 5:
				updateBookUI();
				break;
			case 0:
				System.out.println("Thank you!");
				break;
			}
		}
		while(choice !=0);
	}
	
	private void addBookUI()
	{
		System.out.println("Enter title:");
		sc.nextLine();
		String title = sc.nextLine();
		
		System.out.println("Enter author:");
		String author = sc.nextLine();
		
		System.out.println("Enter category:");
		String category = sc.nextLine();
		
		System.out.println("Enter quantity");
		int quantity = sc.nextInt();
		
		Books book = new Books();
		book.setTitle(title);
		book.setAuthor(author);
		book.setCategory(category);
		book.setQuantity(quantity);
		bd.addBook(book);
		
		System.out.println("Book added successfully.");
	}
	
	private void showBookUI()
	{
		System.out.println("Enter book_Id: ");
		int bookId = sc.nextInt();
		
		Books book = bd.viewBookById(bookId);
		
		if(book != null)
		{
			System.out.println("\n Book details: ");
			System.out.println("ID       : " + book.getBook_Id());
			System.out.println("Title	 : " + book.getTitle());
			System.out.println("Author   : " + book.getAuthor());
			System.out.println("Category : " + book.getCategory());
			System.out.println("Quantity : " + book.getQuantity());
		}
		else {
			System.out.println("❌ Book not found with ID: ");
			return;
		}
	}
	
	private void showAllBookUI()
	{
		List<Books> list = bd.viewAllBooks();
		for(Books b:list)
		{
		System.out.println(
				b.getBook_Id() + " " +
				b.getTitle() + " " +
				b.getAuthor() + " " +
				b.getCategory() + " " +
				b.getQuantity()
				);
		System.out.println();
		}
		
	}
	
	private void deleteBookUI()
	{
		System.out.println("Enter book_Id");
		int bookId = sc.nextInt();
		
		int check = bd.deleteBooksById(bookId);
		if(bookId !=0)
		{
			System.out.println("Book Record Delete Successfully. " + check );
		}
		else {
			System.out.println("Book record not found!");
		}
	}

	private void updateBookUI()
	{
		int bookId = sc.nextInt();
		Books book = bd.viewBookById(bookId);
		if(book !=null)
		{
			book = new Books();
			
			System.out.println("Enter title: ");
			book.setTitle(sc.nextLine());
			
			System.out.println("Enter author: ");
			book.setAuthor(sc.nextLine());
			
			System.out.println("Enter category: ");
			book.setCategory(sc.nextLine());
			
			System.out.println("Enter quantity: ");
			book.setQuantity(sc.nextInt());
			
			bd.updateBooks(book);
			System.out.println("Books updated successfully.");
		}
		else
		{
			System.out.println("Book not found!");
		}
	}
	private void showMenu()
	{
				System.out.println("======Library-Management-System======");
		        System.out.println("1. Add Book");
		        System.out.println("2. Show Book");
		        System.out.println("3. Show All Book");
		        System.out.println("4. Delete Book");
		        System.out.println("5. Update Book");
		        System.out.println("0. Exit");
		        System.out.print("Enter choice: ");
	}
}

	
	
	
	
	