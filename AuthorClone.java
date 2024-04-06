import java.util.*;

class Author implements Cloneable{
    private String name;
    private int age;
    public Author(String n, int a){
        name = n; 
        age = a;
    }
    public String getName(){
        return name;
    }
    public int getAge(){
        return age;
    }
    public void setName(String s){
        this.name = s;
    }
    public void setAge(int i){
        this.age = i;
    }
    public String toString(){
        return "Author: " + name + "(Age: " + age + ")";
    }

    public Author clone() throws CloneNotSupportedException{
        return (Author)super.clone();

    }
}
class Book implements Cloneable{
    private String title;
    private Author author;
    public Book(String t, Author a){
        title = t;
        author = a;

    }
    public void setAuthor(Author author) {
        this.author.setName(author.getName());
        this.author.setAge(author.getAge());
        }

    public String toString(){
        return "Book: " + title + "\n" + author;
    }
    public Book clone() throws CloneNotSupportedException{
        Book b = (Book)super.clone();
        b.author = author.clone();
        return b;
    }
}
public class AuthorClone {
    public static void main(String[] args) throws CloneNotSupportedException {
    Scanner sc = new Scanner(System.in);
    Book b1 = new Book(sc.next(), new Author(sc.next(), sc.nextInt()));
    Book b2 = b1.clone();
    
  
    
    b2.setAuthor(new Author(sc.next(), sc.nextInt()));
    System.out.println("Original Book:\n" + b1);
    System.out.println("Cloned Book:\n" + b2);
    sc.close();
    }
    }