// Write a program to clone an object e1 of class  Employee by implementing the interface Cloneable.
//  After cloning, update the department and the address of  e1. Complete the program as detailed below to achieve this functionality.   
// Define classes Address and Department that implement the interface Cloneable, and have the following members: 
// In both classes, add an instance variable of String type (to store the address and the department respectively) 
// Implement the required constructor(s) and accessors. 
// Override the method clone.
// Define a class Person that implements the interface Cloneable, and has the following members:
// Instance variables name of type String and addr of type Address	
// Implement the required constructor(s) and accessors
// Override the method clone
// Define a class Employee that implements the interface Cloneable, extends the class Person, and has the following members:
// Instance variable dept of type Department	
// Implement the required constructor(s) and accessors.
// Override the method clone.
// Define a method updateEmp to update the dept and addr of an Employee object

import java.util.*;

class Address implements Cloneable{
    private String s;
    public Address(String a){
        s = a;
    }
    public String getAddr(){
        return s;
    }
    public void setAddr(String a){
        this.s = a;
    }
    public Address clone() throws CloneNotSupportedException{
        return (Address)super.clone();
    }
   

}

class Department implements Cloneable {
    private String s;

    public Department(String d) {
        s = d;
    }

    public void setDept(String d) { 
        this.s = d;
    }

    public String getDept() {
        return s;
    }

    public Department clone() throws CloneNotSupportedException {
        return (Department) super.clone();
    }
}

class Person implements Cloneable{
    private String name;
    private Address addr;
    public Person(String name, Address addr){
        this.name = name;
        this.addr = addr;
    }
    public String getName(){
        return name;
    }
    public Person clone() throws CloneNotSupportedException{
        Person p = (Person)super.clone();
        p.addr = addr.clone();
        return p;

    }
    public String toString(){
        return super.toString() + " : " + addr.getAddr();
    }
    public void updatePer(String a){
        addr.setAddr(a);
    }

}

class Employee extends Person implements Cloneable{
    private Department dept;
    public Employee(String name, Address addr, Department dept){
        super(name, addr);
        this.dept = dept;
    }
    @Override
    public Employee clone() throws CloneNotSupportedException{
        Employee e = (Employee)super.clone();
        e.dept = dept.clone();
        return e;
    }
    public String toString(){
        return super.toString() + " : " + dept.getDept();
    }
    public void updateEmp(String a, String d){
        super.updatePer(a);
        dept.setDept(d);
    }
}



public class week8ppa1{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String n = sc.next(); //read name
        String a1 = sc.next(); //read address
        String d1 = sc.next(); //read department
        String a2 = sc.next(); //read new address
        String d2 = sc.next(); //read new department
        try {
            Employee e1 = new Employee(n, new Address(a1), new Department(d1));
            Employee e2 = e1.clone(); 
            e1.updateEmp(a2, d2);
            System.out.println(e1 + ", " + e2);
        }
        catch(CloneNotSupportedException e) {
            System.out.println("clone() not supported");
        }
    }
}
