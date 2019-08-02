package com.library.search.book;

import com.fasterxml.jackson.databind.ObjectMapper;

import javax.ws.rs.core.UriInfo;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.ConcurrentHashMap;


public class DataBaseManager {

    private static DataBaseManager instance = null;

    public static DataBaseManager getInstance(UriInfo context){
        return instance == null && context != null?
                (instance = new DataBaseManager()): instance;
    }

    public ArrayList<Book> repoReader () {
        ArrayList<Book> bookList = new ArrayList<>();
        BufferedReader reader = null;
        try {
            String file = "/Users/lucasnapoli/Documentos Lucas/Projects/Mcgill/WebServices/Assingment4Micro/LibrarySearchBook/src/main/java/com/library/search/book/books.json";
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
