package com.library.search.book;

import sun.misc.BASE64Decoder;

import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;
import java.io.IOException;
import java.util.ArrayList;


@Path( "/search" )
public class SearchService {

    @Context
    private UriInfo context;

    public SearchService() {
    }

    @POST
    @Produces({MediaType.APPLICATION_JSON})
    @Consumes({MediaType.APPLICATION_JSON})
    @Path( "/list" )
    public ArrayList<Book> bookSearch (@HeaderParam("authorization")String auth, Book book)  {
        System.out.println(credentialValidation(auth));
        if (credentialValidation(auth)) {
            try {
                return BookRepository.getInstance(context).searchBook(book);
            } catch (Exception ex) {
                System.out.println("Error: " + ex);
            }
        }
        return null;
    }

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
