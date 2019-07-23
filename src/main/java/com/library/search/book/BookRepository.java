package com.library.search.book;


import java.util.ArrayList;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import javax.ws.rs.core.UriInfo;

/**
 *
 * @lucasnapoli
 */
public class BookRepository {

    private ConcurrentHashMap<Integer, Book> map;

    private BookRepository() {
        map = new ConcurrentHashMap<Integer, Book>();
    }

    private static BookRepository instance = null;

    public static BookRepository getInstance(UriInfo context){
        return instance == null && context != null?
                (instance = new BookRepository()): instance;
    }



    public ArrayList<Book> searchBook(Book book) throws Exception {
        ArrayList<Book> bookArrayList = new DataBaseManager().repoReader();
        Integer id = 0;
        if (book.getTitle() != null) {
            for (Book b : bookArrayList) {
                if (b.getTitle().equals(book.getTitle())) {
                    id++;
                    map.put(id, b);
                }
            }
        }

        if (book.getDescription() != null){
            for (Book b : bookArrayList) {
                String [] words = b.getDescription().split(" ");
                for (String aux : words) {
                    if (aux.equals(book.getDescription())) {
                        id++;
                        map.put (id, b);
                    }
                }
            }
        }

        if (book.getPublisher() != null) {
            for (Book b : bookArrayList) {
                if (book.getPublisher().equals(b.getPublisher())) {
                    id++;
                    map.put(id, b);
                }
            }
        }

        if (map.get(1) == null){
            return bookArrayList;
        }



        Set<Integer> ids = map.keySet();
        ArrayList<Book> finalBookList = new ArrayList<>();
        for (Integer aux : ids) {
            finalBookList.add(map.get(aux).clone());
        }
        map.clear();
        return finalBookList;

    }
}
