package com.library.search.book;

/**
 *
 * @author Lucas Napoli
 * V1.0
 * Library Microservices
 * Service Book Search
 */


import java.util.ArrayList;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;

/**
 *
 * Class to manage the book search Book Repository
 */
public class BookRepository {

    @Context
    private UriInfo context;

    private ConcurrentHashMap<Integer, Book> map;

    private BookRepository() {
        map = new ConcurrentHashMap<Integer, Book>();
    }

    private static BookRepository instance = null;

    /**
     *
     * Intance of BookRepository
     * @param context URI contect
     * @return BookRepository map
     */

    public static BookRepository getInstance(UriInfo context){
        return instance == null && context != null?
                (instance = new BookRepository()): instance;
    }


    /**
     *
     * Receive a book info return the search result
     * @param book Book send by Client
     * @return Array with Book info to be transformed to Json
     * @throws Exception Exception
     */

    public ArrayList<Book> searchBook(Book book) throws Exception {

        ArrayList<Book> bookArrayList = new DataBaseManager().repoReader();
        Integer id = 0;
        System.out.println(book.getTitle());
        System.out.println(bookArrayList.get(0).getTitle());
        if (book.getTitle() != null) {
            for (Book b : bookArrayList) {
                if (b.getTitle().toLowerCase().contains(book.getTitle().toLowerCase())) {
                    id++;
                    map.put(id, b);
                }
            }
        }

        if (book.getDescription() != null){
            for (Book b : bookArrayList) {
                String [] words = b.getDescription().split(" ");
                for (String aux : words) {
                    if (aux.toLowerCase().equals(book.getDescription().toLowerCase())) {
                        id++;
                        map.put (id, b);
                    }
                }
            }
        }

        if (book.getPublisher() != null) {
            for (Book b : bookArrayList) {
                if (book.getPublisher().toLowerCase().contains(b.getPublisher().toLowerCase())) {
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
