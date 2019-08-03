package com.library.search.book;
/**
 *
 * @author Lucas Napoli
 * V1.0
 * Library Microservices
 * Service Book Search
 */

/**
 * Book class to manage book
 */

public class Book implements Cloneable {

    /**
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param title the title to set
     */
    public void setTitle(String title) {
        this.title = title;
    }
    private String isbn;
    private String title;
    private String author;
    private String description;
    private String summary;
    private String publisher;
    private String publishingdate;


    public Book() {}

    public Book(String title){
        this.title = title;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return the isbn
     */
    public String getIsbn() {
        return isbn;
    }

    /**
     * @param isbn the isbn to set
     */
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    /**
     * @return the author
     */
    public String getAuthor() {
        return author;
    }

    /**
     * @param author the author to set
     */
    public void setAuthor(String author) {
        this.author = author;
    }

    /**
     * @return the publisher
     */
    public String getPublisher() {
        return publisher;
    }

    /**
     * @param publisher the publisher to set
     */
    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    /**
     * To manage String
     * @return String String
     */

    @Override
    public String toString(){
        return String.format("%d: %s (%s)", this.title, this.description);
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getPublishingdate() {
        return publishingdate;
    }

    public void setPublishingDate(String publishingdate) {
        this.publishingdate = publishingdate;
    }

    public Book clone() {
        Book b = new Book();
        b.setIsbn(this.isbn);
        b.setTitle(this.title);
        b.setAuthor(this.author);
        b.setDescription(this.description);
        b.setSummary(this.summary);
        b.setPublisher(this.publisher);
        b.setPublishingDate(this.publishingdate);
        return b;
    }
}