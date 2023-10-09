package ComplexProject;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static Books books = new Books();
    public static String getUserString() {
        Scanner in = new Scanner(System.in);
        return in.nextLine();
    }
    public static String getUserString(String caption) {
        System.out.println(caption);
        return getUserString();
    }
    public static int getUserInt() {
        Scanner in = new Scanner(System.in);
        return in.nextInt();
    }

    public static void inputBook(){
        Scanner in = new Scanner(System.in);
        String name, author;
        int year;
        double price;
        System.out.println("Enter book title: ");
        name = in.nextLine();
        System.out.println("Enter book author: ");
        author = in.nextLine();
        System.out.println("Enter book year of release: ");
        year = in.nextInt();
        System.out.println("Enter book price: ");
        price = in.nextDouble();
        Book book = new Book(name,author,year,price);
        books.add(book);
    }
    public static void searchBookByAuthor(String author){
        books.printOne(books.searchIndexOfAuthor(author));
    }
    public static void searchBookByYear(int year){
        books.printOne(books.searchIndexOfByYear(year));
    }

    public static void removeBook(){
        Scanner in = new Scanner(System.in);
        System.out.println("Please enter number of book in the list you want to remove: ");
        int i = in.nextInt();
        books.remove(i);
    }

    public static void readFromFile() throws FileNotFoundException {
        FileInputStream file = new FileInputStream("books.txt");
        Scanner in = new Scanner(file);

        while (in.hasNextLine()){
            String line = in.nextLine();
            String words[] = line.split(",");
            Book b = new Book(words[0],words[1], Integer.parseInt(words[2]),Double.parseDouble(words[3]));
            books.add(b);
        }
    }


    public static void main(String[] args) throws FileNotFoundException {
        Scanner in = new Scanner(System.in);
        boolean exit = false;
        do{
            System.out.println("Welcome to the book database!");
            System.out.println("Choose an option to proceed: ");
            System.out.println("1 - print book list");
            System.out.println("2 - add new book");
            System.out.println("3 - remove book");
            System.out.println("4 - sort books by year");
            System.out.println("5 - search books by author");
            System.out.println("6 - search books by year");
            System.out.println("7 - print detailed book list");
            System.out.println("8 - read books from the file");
            System.out.println("0 - exit the program");
            int choice=in.nextInt();
            switch (choice){
                case 1:
                    books.printList();
                    break;
                case 2:
                    inputBook();
                    break;
                case 3:
                    removeBook();
                    break;
                case 4:
                    books.sort();
                    break;
                case 5:
                    System.out.println("Please enter author's name and surname: ");
                    in.nextLine();
                    String author = in.nextLine();
                    searchBookByAuthor(author);
                    break;
                case 6:
                    System.out.println("Please enter book's release year: ");
                    in.nextLine();
                    int year = in.nextInt();
                    searchBookByYear(year);
                    break;
                case 7:
                    books.printAll();
                    break;
                case 8:
                    readFromFile();
                    break;
                case 0:
                    exit = true;
                    break;
                default:
                    System.out.println("Wrong Input");
                    break;
            }

        }
        while (!exit);








    }
}