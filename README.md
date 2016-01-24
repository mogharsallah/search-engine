## Search Engine ##
A java web search engine based on html parsing technology, with Spring, Hibernate, Jsoup and AngularJS

### How it works ###
Each website has an entity describing it related patterns (search-url construction & search-page css style).
When entering a search keyword, the Search Engine create a search URI for each activated website and extract product details from the html search page.
The engine then returns the products list in a JSON format which will be parsed to the current search page.

### Dependencies ###
The project is based on a maven structure:

 - JDK 1.8
 - Spring MVC /+depencies.
 - Hibernate Session/ORM.
 - JSP
 - Mysql
 - Jsoup (html parser)
 - FasterXml (JSON rendering)
 - AngularJS

Please refer to pom.xml file for the detailed list.

### Preview ###

![Front Page](http://i.imgur.com/6LOWhVX.png)
![Website CRUD page](http://i.imgur.com/cfJK1GS.png)
