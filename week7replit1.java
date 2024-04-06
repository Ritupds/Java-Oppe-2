import java.util.Scanner;

class DiscountException extends Exception{
    public String getMessage(){
      return "NonDiscountable Expense";
    }
}

class Customer{
    private String name;
    private double expense;
    private final double discountrate =0.05;

    public Customer(String n, double e){
        name = n;
        expense = e;
    }

    public String getName(){
        return name;
    }
    public double checkDiscount() throws DiscountException{
        if( expense > 1000){
            return expense * discountrate;
            
        }
        else{
            throw new DiscountException();
        }

    }
}


public class week7replit1 {
    public static void displayCustomers(Customer[] customers){
    for(Customer c : customers){
      try{
        System.out.println(c.getName() + " : " + c.checkDiscount());
      }
      catch(DiscountException e){
        System.out.println(c.getName() + " : " + e.getMessage());
      }
    }
  }
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    Customer[] customers = new Customer[3];
    for(int i = 0; i< 3; i++){
      customers[i] = new Customer(sc.next(), sc.nextDouble()); 
    }
    displayCustomers(customers);
    sc.close();
  }
}
