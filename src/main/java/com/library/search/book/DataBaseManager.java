package com.library.search.book;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;


public class DataBaseManager {

    public ArrayList<Book> repoReader () {
        ArrayList<Book> bookList = new ArrayList<>();
        try {
            File file = new File ("/Users/lucasnapoli/Documentos Lucas/Projects/Mcgill/WebServices/Assingment4Micro/LibrarySearch/src/main/java/com/library/search/db.json");

            ObjectMapper objectMapper = new ObjectMapper ( );
            Book [] arrayBook = objectMapper.readValue (file ,Book[].class);
            Collections.addAll(bookList, arrayBook);
        }catch (IOException e) {
            e.printStackTrace ( );
        }
        return bookList;
    }
}
