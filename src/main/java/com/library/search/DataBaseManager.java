package com.library.search;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class DataBaseManager {

    public ArrayList<Book> repoReader () {
        ArrayList<Book> bookList = new ArrayList<>();
        try {
            File file = new File ("/Volumes/FILES/Projects/LibraryServerRest/src/main/jsondb/db.json");

            ObjectMapper objectMapper = new ObjectMapper( );
            Book [] arrayBook = objectMapper.readValue (file ,Book[].class);
            Collections.addAll(bookList, arrayBook);
        }catch (IOException e) {
            e.printStackTrace ( );
        }
        return bookList;
    }
}
