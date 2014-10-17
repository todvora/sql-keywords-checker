### SQL Keywords checker for JPA Entities
JPA layer of abstraction shields us from database. And often we forget, that not every identificator used in Java
entity can be directly mapped to database column. Some names are reserved, some names working within one database and 
does not work in another. 

What is working in your test HSQLDB does not need to work in production Oracle and vice versa. 

Lets try your judgement. Which of these words are reserved?

- user
- valid
- login
- value
- domain
- checksum
- file
- language

If you guess all, you are right. And there are at least 800 other (see [https://www.drupal.org/node/141051](https://www.drupal.org/node/141051)), reserved words. 
No surprise, that we use by mistake word, that is reserved. And sometimes, it will work. Sometimes...

There are at least ten different specifications, that covers reserved keywords: ANSI SQL 92, ANSI SQL 99, ANSI SQL 2003, MySQL 3.23.x, MySQL 4.x, MySQL 5.x, PostGreSQL 8.1, MS SQL Server 2000, MS ODBC, Oracle 10.2

If you want to avoid problems with reserved words, you have to be aware of them. You need control mechanism, 
that will tell you what's wrong. We all write tests (right?!). So why not to append check to verify, that our entities does not 
contain those reserved words?

SqlKeywordsChecker comes with prepared Assertion just for that:

```
SqlKeywordsVerifier.forClass(User.class).verify();
```

If your entity is OK, no exception is thrown and test will pass. If not, AssertionException is thrown, test fails and
you will get message with all invalid fields.

```
com.acme.User.exceptions.AssertionException: Invalid identificators: [com.acme.User$TestEntityBase#call:call, com.acme.User#name:name, com.acme.UserBase#statement:statement]
```

You can define, which fields will be ignored and skipped:
 
```
SqlKeywordsVerifier.forClass(User.class).ignore("call").verify();
```

And result will be:

```
com.acme.User.exceptions.AssertionException: Invalid identificators: [com.acme.User#name:name, com.acme.UserBase#statement:statement]
```
  
## How to remap fields to columns
JPA gives you simple possibility to remap java field name to different column name. You can annotate your fields with annotation
```@Column(name="safe_name")``` and provide non-reserved column name. SqlKeywordsChecker then verifies also this name and tell
you, if you remapped field name is OK. 