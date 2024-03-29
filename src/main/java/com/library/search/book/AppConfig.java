package com.library.search.book;

/**
 *
 * @author Lucas Napoli
 * V1.0
 * Library Microservices
 * Service Book Search
 */

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

/**App Config
 */

@ApplicationPath("/books/")
public class AppConfig extends Application {

    /**
     * Get classe for configuration
     * @return resourses
     */

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();
        System.out.println("REST configuration starting: getClasses()");
        resources.add(org.glassfish.jersey.jackson.JacksonFeature.class);
        resources.add(com.library.search.book.SearchService.class);
        System.out.println("REST configuration ended successfully.");
        return resources;
    }

    /**
     * Get classes for configuration
     * @return Collection to Singleton
     */

    @Override
    public Set<Object> getSingletons() {
        return Collections.emptySet();
    }

    /**
     * Get classe for configuration
     * @return properties in a Map
     */

    @Override
    public Map<String, Object> getProperties() {
        Map<String, Object> properties = new HashMap<>();
        properties.put("jersey.config.server.wadl.disableWadl", true);
        return properties;
    }
}

