package com.library.search.book;

import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;
import java.util.ArrayList;


@Path( "/search" )
public class SearchService {

    @Context
    private UriInfo context;

    public SearchService() {
    }

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    @Consumes({MediaType.APPLICATION_JSON})
    @Path( "/search" )
    public ArrayList<Book> bookSearch (Book book) throws Exception {
        return BookRepository.getInstance ( context ).searchBook (book);
    }
}
