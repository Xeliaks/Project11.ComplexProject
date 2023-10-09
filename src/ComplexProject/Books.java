package ComplexProject;
import java.util.ArrayList;
import java.util.Collections;


public class Books {
    private int count;


    private ArrayList<Book> books;

    public Books() {
        books = new ArrayList<>();
    }

    public void add(Book b) {
        books.add(b);
    }

    public void remove(int i){
        books.remove(i-1);
    }

    public void printOne(int i) {
        if (i >= 0 && i < books.size()) {
            System.out.print("Book you required: " + " Title: " + books.get(i).name + " Author: " + books.get(i).author);
            System.out.println();
            System.out.print("    Price: " + books.get(i).getPrice() + " Year: " + books.get(i).getYear());
            System.out.println();

        } else {
            System.out.print("Book not found");
            System.out.println();
        }
    }

    public void printAll() {
        System.out.println("Full collection of books: ");
        for (int i = 0; i < books.size(); i++) {
            System.out.print((i+1) + ". " + " Title: " + books.get(i).name + " Author: " + books.get(i).author);
            System.out.println();
            System.out.print("    Price: " + books.get(i).getPrice() + " Year: " + books.get(i).getYear());
            System.out.println();
        }
    }

    public void printList(){
        System.out.println("Full list of books names: ");
        for (int i=0; i<books.size();i++){
            System.out.print((i+1) + ". " + books.get(i).name );
            System.out.println();
        }
    }

    public int searchIndexOfAuthor(String s) {
        for (int i = 0; i < books.size(); i++) {
            if (books.get(i).author.equalsIgnoreCase(s)) {
                System.out.print("Your book: ");
                System.out.println();
                return i;
            }
        }

        return -1;
    }

    public void sort() {
        boolean swapped;
        for (int i = 0; i < books.size() - 1; i++) {
            swapped = false;
            for (int j = 0; j < books.size() - i - 1; j++) {
                if (books.get(j).getYear() > books.get(j + 1).getYear()) {

                    Collections.swap(books, j, j + 1);

                    swapped = true;
                }
            }
            if (!swapped)
                break;
        }


    }

    public int searchIndexOfByYear(int s) {
        for (int i = 0; i < books.size(); i++) {
            if (books.get(i).getYear() == s) {
                System.out.print("Your book");
                System.out.println();
                return i;
            }
        }

        return -1;
    }

}