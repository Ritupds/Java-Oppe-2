// Recall that Java throws an ArithmeticException if there is an attempt to divide by zero. Similar to this, 
// we can generate an exception if there is a division by three. Given two integers as input, 
// complete the Java code given below to generate such an exception. 
// Create a class DivisionException that extends the class Exception.
// Override the toString() method to return "Division by 3 is not allowed".
// In the class Test, define divide(int a, int b) to return a/b, if the value of b is not equal to 3. 
// If the value of b is 3, then throw an instance of DivisionException.
// Inside the method main(), invoke divide(x, y), and handle any possible exception by printing the said message.

import java.util.*;

class DivisionException extends Exception{
    public String toString(){
        return "Division by 3 is not allowed";
    }
    
}

class week7grpa1{
    public static int divide(int a, int b) throws DivisionException{
       if (b==3){
        throw new DivisionException();
       }
       else{
       return a/b;
       }
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int y = sc.nextInt();
        try{
            int c = divide(x , y);
            System.out.println(c);
        }
        catch(DivisionException e){
            System.out.println(e);
        }
    }
}
