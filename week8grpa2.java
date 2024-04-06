import java.util.*;

class Items implements Cloneable{
    public String[] item;
    public Items(String[] i){
        this.item = i;
    }

    public Items clone() throws CloneNotSupportedException{
      Items it =   (Items)super.clone();
      it.item = item.clone();
      return it;
    }
    public String toString() {
        String s = "";
        for(int i = 0; i < item.length; i++){
            s = s + item[i] + " ";
        }
        return s;
    }
    
}

class Customer implements Cloneable{
    private String name;
    private Items items;
    public Customer(String n, Items i){
        name = n;
        items = i;
    }
    public String getName(){
        return name;
    }
    public Items getItems(){
        return items;
    }
    public void setName(String s){
        this.name = s;
    }
    public Customer clone() throws CloneNotSupportedException{
        Customer c = (Customer)super.clone();
        c.items = items.clone();
        return c;

    }
    public String toString(){
        return name + " : " + items;
    }

}

public class week8grpa2 {
    public static void main(String[] args) throws CloneNotSupportedException{
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt(); // number of items
    String[] itm = new String[n];
    for(int i = 0; i < n; i++){
      itm[i] = sc.next(); // list of items
    } 
    var c1 = new Customer("naresh", new Items(itm));
    Customer c2 = c1.clone();   
    c2.getItems().item[0] = sc.next();   //Update first item of c2
    c2.setName("suresh"); //Update name of c2
    System.out.println(c1);
    System.out.println(c2);
  }
}   
