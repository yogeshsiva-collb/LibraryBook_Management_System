import java.util.*;
import java.io.*;
// Book class represents a book record
class Book
{
    int bookId;
    String bookName;
    String authorName;
    String category;
    int publicationYear;
    String status;

    // Constructor to initialize book details
    Book(int bookId, String bookName, String authorName,String category, int publicationYear, String status)
    {
        this.bookId = bookId;
        this.bookName = bookName;
        this.authorName = authorName;
        this.category = category;
        this.publicationYear = publicationYear;
        this.status = status;
    }
    // ArrayList acts as in-memory storage for books
    static ArrayList<Book> books = new ArrayList<>();

    // Scanner object for user input
    static Scanner sc = new Scanner(System.in);

    // Method to add a new book
    static void addBook()
    {

        System.out.print("Enter Book ID : ");
        int id = sc.nextInt();
        sc.nextLine();
        for(Book b : books)
        {
            // Check if Book ID already exists
            if (b.bookId == id)
            {
                System.out.println("Book ID already exists.");
                return;
            }
        }
        // Get book details from user
        System.out.print("Enter Book Name : ");
        String name = sc.nextLine();

        System.out.print("Enter Author Name : ");
        String author = sc.nextLine();

        System.out.print("Enter Category : ");
        String category = sc.nextLine();

        System.out.print("Enter Publication Year : ");
        int year = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Status (Available/Issued) : ");
        String status = sc.nextLine();

        // Create and add new book object to ArrayList
        books.add(new Book(id, name, author, category, year, status));

        // Save updated records to file
        saveToFile();
        System.out.println("Book added successfully.");
    }
    // Method to display all books
    static void viewBooks()
    {
        if (books.isEmpty())
        {
            System.out.println("No books available.");
            return;
        }
        // Traverse ArrayList and display book details
        for (Book b : books)
            {
            System.out.println(b.bookId + " | " +b.bookName + " | " +b.authorName + " | " +b.category + " | " +
                                b.publicationYear + " | " +b.status);
        }
    }
    // Method to search book using Book ID
    static void searchBook()
    {
        System.out.print("Enter Book ID : ");
        int id = sc.nextInt();
        // Search book in ArrayList
        for (Book b : books) {

            if (b.bookId == id) {

                System.out.println("Book Found");
                System.out.println("Name : " + b.bookName);
                System.out.println("Author : " + b.authorName);
                System.out.println("Category : " + b.category);
                System.out.println("Year : " + b.publicationYear);
                System.out.println("Status : " + b.status);
                return;
            }
        }
        // If no matching book found
        System.out.println("Book not found.");
    }
    // Method to update book details
    static void updateBook() {
        // Search book by ID
        System.out.print("Enter Book ID : ");
        int id = sc.nextInt();
        sc.nextLine();
        // Update book information
        for (Book b : books) {

            if (b.bookId == id) {

                System.out.print("Enter New Book Name : ");
                b.bookName = sc.nextLine();

                System.out.print("Enter New Author Name : ");
                b.authorName = sc.nextLine();

                System.out.print("Enter New Category : ");
                b.category = sc.nextLine();

                System.out.print("Enter New Publication Year : ");
                b.publicationYear = sc.nextInt();
                sc.nextLine();

                System.out.print("Enter New Status : ");
                b.status = sc.nextLine();
                // Save updated records to file
                saveToFile();

                System.out.println("Book updated successfully.");
                return;
            }
        }

        System.out.println("Book not found.");
    }
    // Method to delete a book
    static void deleteBook() {

        System.out.print("Enter Book ID : ");
        int id = sc.nextInt();

        for (Book b : books) {

            if (b.bookId == id) {
                // Remove book from ArrayList
                books.remove(b);
                // Save updated records after deletion
                saveToFile();

                System.out.println("Book deleted successfully.");
                return;
            }
        }

        System.out.println("Book not found.");
    }
    // FILE HANDLING: Save all book records into books.txt
    static void saveToFile()
    {

        try
        {
            // Create books.txt if it does not exist and open it for writing
            FileWriter fw = new FileWriter("books.txt");
            // Write each book record into file
            for (Book b : books)
            {

                fw.write(b.bookId + "," +b.bookName + "," +b.authorName + "," +b.category
                +"," +b.publicationYear + "," +b.status + "\n");
            }
            // Close file after writing
            fw.close();

        }
        catch (Exception e)
        {

            System.out.println("Error saving file.");
        }
    }
    // FILE HANDLING: Load book records from books.txt
    static void loadFromFile()
    {
        try
        {
            File file  = new File("books.txt");
            // Check if file exists
            if (!file.exists())
                return;

            Scanner fileScanner = new Scanner(file);
            // Read records line by line
            while (fileScanner.hasNextLine())
            {

                String line = fileScanner.nextLine();
                // Split data using comma delimiter
                String[] data = line.split(",");
                // Create Book object and add to ArrayList
                books.add(new Book(
                        Integer.parseInt(data[0]),
                        data[1],
                        data[2],
                        data[3],
                        Integer.parseInt(data[4]),
                        data[5]
                ));
            }
            // Close file after reading
            fileScanner.close();

        } 
        catch (Exception e)
        {
            System.out.println("Error loading file.");
        }
    }
    // Main method
    public static void main(String[] args) 
    {
        // Load existing records from file when program starts
        loadFromFile();
        // Infinite loop to repeatedly display menu
        while (true)
        {
            System.out.println("\n******** LIBRARY BOOK MANAGEMENT SYSTEM ********");
            System.out.println("1. Add Book");
            System.out.println("2. View Books");
            System.out.println("3. Search Book");
            System.out.println("4. Update Book");
            System.out.println("5. Delete Book");
            System.out.println("6. Exit");
            System.out.println("************************************************");
            // Perform operation based on user choice
            System.out.print("Enter Choice : ");
            int choice = sc.nextInt();
            System.out.println("************************************************");

            switch (choice)
            {
                case 1:
                    addBook(); // Add Book
                    break;

                case 2:
                    viewBooks(); // View Books
                    break;

                case 3:
                    searchBook(); // Search Book
                    break;

                case 4:
                    updateBook(); // Update Book
                    break;

                case 5:
                    deleteBook(); // Delete Book
                    break;

                case 6:
                    System.exit(0); // Exit the program

                default:
                    System.out.println("Invalid Choice"); // Handle invalid menu choice
            }
        }
    }
}