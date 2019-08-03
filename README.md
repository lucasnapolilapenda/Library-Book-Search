# LibrarySearchBook

LibrarySearchBook is a part of the project Library Micro Services. This module is a server that sends book info
REST service

## Installation

Project created in Maven, all the dependencies are in a .pom document.

Compile the code but first check the Server Url in the following class:

```
public class EntryPublisher {

    private static final int port = 8091;
    private static final String uri = "/books/";
    private static final String url = "http://localhost:" + port + uri;
    

    

```
Update URL depending on server configuration

Additonally update the txt repo in:
```
    public class DataBaseManager {
    .......
        public ArrayList<Book> repoReader () {
            ......
                String file = "src/main/webapp/WEB-INF/books.json";;

```

## Contributing
Academic Project for McGill University. No contributing is requested. 

## License
[MIT](https://choosealicense.com/licenses/mit/)