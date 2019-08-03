package com.library.search.book;

/**
 *
 * @author Lucas Napoli
 * V1.0
 * Library Microservices
 * Service Book Search
 */

import com.fasterxml.jackson.databind.ObjectMapper;

import javax.ws.rs.core.UriInfo;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.ConcurrentHashMap;

/**
 *
 *Class to manage the database
 */


public class DataBaseManager {

    private static DataBaseManager instance = null;

    /**
     *
     * Intance of Database in Memory
     * @param context URI contect
     * @return BookRepository map
     */

    public static DataBaseManager getInstance(UriInfo context){
        return instance == null && context != null?
                (instance = new DataBaseManager()): instance;
    }

    /**
     *
     * repoReader
     * @return BookRepository Array with the stored data
     */

    public ArrayList<Book> repoReader () {
        ArrayList<Book> bookList = new ArrayList<>();
        BufferedReader reader = null;
        try {
            String file = "src/main/webapp/WEB-INF/books.json";
            reader = new BufferedReader(new FileReader(file));
            ObjectMapper objectMapper = new ObjectMapper ( );
            Book [] arrayBook = objectMapper.readValue (reader ,Book[].class);
            Collections.addAll(bookList, arrayBook);
        }catch (IOException e) {
            System.out.println("Error: " + e);
        }
        return bookList;
    }
}
