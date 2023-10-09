package ComplexProject;

public class Book {
    public String name;
    public String author;

    private int  year;
    public int getYear() {
        return year;
    }

    public void setYear(int age) {
        this.year = age;
    }
    private double price;
    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Book(String name, String author, int year, double price){
        this.name = name;
        this.author = author;
        setYear(year);
        setPrice(price);
    }

    public void getTitle(){
        System.out.print("Title: " + name);
        System.out.print("/n");
    }

    public void getDescription(){
        System.out.print("Name: " + name + " Author: " + author);
        System.out.print("/n");
        System.out.print(" Year: " + year + " Price: " + price);
        System.out.print("/n");
    }
}
