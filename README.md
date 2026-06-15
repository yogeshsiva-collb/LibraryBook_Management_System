# Library Book Management System

## Overview

The **Library Book Management System** is a simple console-based Java application that allows users to manage library book records efficiently. The system provides functionalities such as adding books, viewing book details, searching books by ID, updating book information, deleting book records, and storing data permanently using file handling.

This project demonstrates the use of:

* Object-Oriented Programming (OOP)
* Java Collections Framework (`ArrayList`)
* User Input Handling using `Scanner`
* CRUD Operations (Create, Read, Update, Delete)
* File Handling
* Menu-Driven Programming

---

# Definition

A **Library Book Management System (LBMS)** is a software application designed to store, manage, and maintain book information within a library. It helps librarians perform book-related operations such as:

* Adding new books
* Searching book records
* Updating book information
* Removing book records
* Viewing all book details

The primary goal of a Library Management System is to organize library records and reduce manual book management.

---

# Features

### 1. Add Book

Allows the user to add a new book by providing:

* Book ID
* Book Name
* Author Name
* Category
* Publication Year
* Status

Validation:

* Duplicate Book IDs are not allowed.

---

### 2. View Books

Displays all book records currently stored in the system.

Output Format:

```text
Book_ID | Book_Name | Author_Name | Category | Publication_Year | Status
```

---

### 3. Search Book

Searches for a book using the Book ID.

If found:

```text
Book Found

Name : [Book Name]
Author : [Author Name]
Category : [Category]
Year : [Publication Year]
Status : [Status]
```

Otherwise:

```text
Book not found
```

---

### 4. Update Book

Allows modification of book information.

Steps:

1. Enter Book ID.
2. Enter new book details.
3. Book information gets updated.

Output:

```text
Book updated successfully
```

---

### 5. Delete Book

Removes a book record from the system using Book ID.

If found:

```text
Book deleted successfully
```

Otherwise:

```text
Book not found
```

---

### 6. File Storage

All book records are automatically saved into:

```text
books.txt
```

The records are loaded when the application starts.

---

### 7. Exit

Terminates the application.

---

# Technologies Used

| Technology    | Purpose                  |
| ------------- | ------------------------ |
| Java          | Programming Language     |
| ArrayList     | Dynamic Storage of Books |
| Scanner       | User Input               |
| File Handling | Permanent Data Storage   |
| OOP Concepts  | Book Object Creation     |

---

# Class Structure

## Book Class

The Book class contains:

### Attributes

```java
int bookId;
String bookName;
String authorName;
String category;
int publicationYear;
String status;
```

### Constructor

```java
Book(int bookId,
     String bookName,
     String authorName,
     String category,
     int publicationYear,
     String status)
```

Used to initialize book objects.

---

# Data Storage

Book records are stored in:

```java
static ArrayList<Book> books
```

This ArrayList acts as an in-memory database during execution.

Example:

```java
[
 Book(22,"The Cure At Troy","Sophocles","Poetry",2018,"Available"),
 Book(23,"The Greek Plays","Sophocles","Drama",2016,"Available")
]
```

---

# Program Flow

## Application Startup

```text
Program Starts
      │
      ▼
Load Books From File
      │
      ▼
Display Main Menu
      │
      ▼
User Selects Option
```

---

## Main Menu

```text
1. Add Book
2. View Books
3. Search Book
4. Update Book
5. Delete Book
6. Exit
```

---

# Detailed Flow Diagram

## Add Book Flow

```text
Start
  │
  ▼
Enter Book ID
  │
  ▼
Check Existing IDs
  │
  ├── ID Exists?
  │       │
  │      Yes
  │       │
  │       ▼
  │ Display Error
  │       │
  │       ▼
  │      End
  │
  ▼ No
Enter Book Details
  │
  ▼
Create Book Object
  │
  ▼
Store in ArrayList
  │
  ▼
Save To File
  │
  ▼
Success Message
  │
  ▼
End
```

---

## View Books Flow

```text
Start
  │
  ▼
Read Book List
  │
  ▼
Display Each Book
  │
  ▼
End
```

---

## Search Book Flow

```text
Start
  │
  ▼
Enter Book ID
  │
  ▼
Traverse ArrayList
  │
  ▼
Book Found?
  │
 ├── Yes
 │      │
 │      ▼
 │ Display Details
 │
 └── No
        │
        ▼
 Display Not Found
  │
  ▼
End
```

---

## Update Book Flow

```text
Start
  │
  ▼
Enter Book ID
  │
  ▼
Search Book
  │
  ▼
Book Found?
  │
 ├── Yes
 │      │
 │      ▼
 │ Enter New Details
 │      │
 │      ▼
 │ Update Book
 │      │
 │      ▼
 │ Save To File
 │      │
 │      ▼
 │ Success Message
 │
 └── No
        │
        ▼
 Display Not Found
  │
  ▼
End
```

---

## Delete Book Flow

```text
Start
  │
  ▼
Enter Book ID
  │
  ▼
Search Book
  │
  ▼
Book Found?
  │
 ├── Yes
 │      │
 │      ▼
 │ Remove Book
 │      │
 │      ▼
 │ Save To File
 │      │
 │      ▼
 │ Success Message
 │
 └── No
        │
        ▼
 Display Not Found
  │
  ▼
End
```

---

# File Handling

## Save Records

Book records are written into:

```text
books.txt
```

Format:

```text
BookID,BookName,AuthorName,Category,PublicationYear,Status
```

Example:

```text
22,The Cure At Troy,Sophocles,Poetry,2018,Available
23,The Greek Plays,Sophocles,Drama,2016,Available
```

---

## Load Records

When the application starts:

```text
books.txt
```

is read line-by-line and converted into Book objects.

---

# Time Complexity Analysis

| Operation      | Complexity |
| -------------- | ---------- |
| Add Book       | O(n)       |
| View Books     | O(n)       |
| Search Book    | O(n)       |
| Update Book    | O(n)       |
| Delete Book    | O(n)       |
| Save To File   | O(n)       |
| Load From File | O(n)       |

Where **n** is the number of books stored in the ArrayList.

---

# Sample Execution

```text
******** LIBRARY BOOK MANAGEMENT SYSTEM ********

1. Add Book
2. View Books
3. Search Book
4. Update Book
5. Delete Book
6. Exit

************************************************

Enter Choice : 1
```

Add Book:

```text
Enter Book ID : 101
Enter Book Name : Java Programming
Enter Author Name : James Gosling
Enter Category : Programming
Enter Publication Year : 2024
Enter Status : Available

Book added successfully.
```

View Books:

```text
101 | Java Programming | James Gosling | Programming | 2024 | Available
```

Search Book:

```text
Book Found

Name : Java Programming
Author : James Gosling
Category : Programming
Year : 2024
Status : Available
```

---

# Limitations

* Uses linear search for record lookup.
* Single-user console application.
* No login authentication.
* No database connectivity.
* Limited validation for user inputs.

---

# Future Enhancements

* MySQL/PostgreSQL Integration
* Book Issue and Return Management
* User Authentication
* Fine Calculation System
* Search by Author and Category
* Sorting and Filtering Books
* GUI using Java Swing or JavaFX
* REST API Integration
* Multi-user Support

---

# Conclusion

This Library Book Management System is a beginner-friendly Java project that demonstrates CRUD operations, file handling, object-oriented programming concepts, and collection framework usage. It serves as a foundation for building more advanced Library Management Systems with database support, authentication, and enterprise-level features.

