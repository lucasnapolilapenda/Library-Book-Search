package com.library.search;


import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import javax.ws.rs.core.UriInfo;

/**
 *
 * @author Ali
 */
public class BookRepository {

    private AtomicInteger ai;
    private ConcurrentHashMap<Integer, Book> map;

    private BookRepository() {
        map = new ConcurrentHashMap<Integer, Book>();
    }

    private static BookRepository instance = null;

    public static BookRepository getInstance(UriInfo context){
        return instance == null && context != null?
                (instance = new BookRepository()): instance;
    }



    public List<Book> searchBook(String title, String description, String publisher) throws Exception {
        ArrayList<Book> bookArrayList = new DataBaseManager().repoReader();
        Integer id = 0;
        if (title != null) {
            for (Book book : bookArrayList) {
                if (book.getTitle().equals(title)) {
                    id++;
                    map.put(id, book);
                }
            }
        }

        if (description != null){
            for (Book book : bookArrayList) {
                String [] words = book.getDescription().split(" ");
                for (String aux : words) {
                    if (aux.equals(description)) {
                        id++;
                        map.put (id, book);
                    }
                }
            }
        }

        if (publisher != null) {
            for (Book book : bookArrayList) {
                if (book.getPublisher().equals(publisher)) {
                    id++;
                    map.put(id, book);
                }
            }
        }


    }

}
