package com.library.search;

import javax.ws.rs.Consumes;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;
import java.util.ArrayList;

public class SearchService {

    @Context
    private UriInfo context;

    public SearchService() {
    }

    @PUT
    @Produces({MediaType.APPLICATION_JSON})
    @Consumes({MediaType.APPLICATION_JSON})
    @Path( "/search" )
    public ArrayList<Book> bookSerch (String title, String description, String publisher) throws Exception {
        return BookRepository.getInstance ( context ).searchBook (title, description, publisher);
    }
}
