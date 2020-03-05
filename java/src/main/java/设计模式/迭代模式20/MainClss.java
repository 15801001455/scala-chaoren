package 设计模式.迭代模式20;

import java.util.Iterator;


public class MainClss {
	public static void main(String[] args) {
		BookList bookList = new BookList();
		
		Book book1 = new Book("010203","Java编程思想",90);
		Book book2 = new Book("010204","Java从入门到精通",60);
		
		bookList.addBook(book1);
		bookList.addBook(book2);


		/*
			容器自己实现，容器负担太重
			while(bookList.hasNext()) {
				Book book = bookList.getNext();
				book.display();
			}
		*/
		
//		List<Book> bookDateList = bookList.getBookList();
//		for(int i = 0; i < bookDateList.size(); i++) {
//			Book book = bookDateList.get(i);
//			book.display();
//		}
		
		Iterator iter = bookList.Iterator();
		while(iter.hasNext()) {
			Book book = (Book) iter.next();
			book.display();
		}
		
		
	}
}
