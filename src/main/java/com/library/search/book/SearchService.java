package com.library.search.book;

/**
 *
 * @author Lucas Napoli
 * V1.0
 * Library Microservices
 * Service Book Search
 */

import sun.misc.BASE64Decoder;

import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;
import java.io.IOException;
import java.util.ArrayList;

/**
 *Services
 */


@Path( "/search" )
public class SearchService {

    @Context
    private UriInfo context;

    public SearchService() {
    }

    /**
     *Services
     * @return ArrayList with books
     * @param auth Authorization String
     * @param book Book with info
     */

    @POST
    @Produces({MediaType.APPLICATION_JSON})
    @Consumes({MediaType.APPLICATION_JSON})
    @Path( "/list" )
    public ArrayList<Book> bookSearch (@HeaderParam("authorization")String auth, Book book)  {
        if (credentialValidation(auth)) {
            try {
                return BookRepository.getInstance(context).searchBook(book);
            } catch (Exception ex) {
                System.out.println("Error: " + ex);
            }
        }
        return null;
    }

    /**
     * Validation Credentials Service
     * @return ArrayList with books
     * @param auth Authorization String
     */

    public Boolean credentialValidation (String auth) {
        String decodeAuth = "";
        String[] authParts = auth.split("\\s+");
        String authInfo = authParts[1];
        byte[] bytes = null;
        try {
            bytes = new BASE64Decoder().decodeBuffer(authInfo);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            System.out.println("Error: " + e);
        }
        decodeAuth = new String(bytes);
        System.out.println(decodeAuth);

        String [] userCredentials = decodeAuth.split(":");
            if (userCredentials[0].equals("book-service") && userCredentials[1].equals("book-service-secure-password-1234")){
                return true;
            } else {
                return false;
            }
    }


}
