import java.util.*;
import java.util.stream.*;

class Employee{
    private String name;
    private String department;
    private int salary;
    public Employee(String n, String d, int s){
        name = n;
        department = d;
        salary = s;
    }
    public String getName(){
        return name;
    }
    public int getSalary(){
        return salary;
    }
    public String getDept(){
        return department;
    }
    public String toString(){
        return name + " : " + department + " : " + salary;
    }
}
// Define a function query that takes a list of employees, a department and a salary as input. 
// It returns a stream comprising the Employee objects that have the same department and have salary greater and equal to the given salary.	
public class week8grpa1 {
    public static Stream<Employee> query(List<Employee> emp, String d, double s){
            return emp.stream().filter(e-> e.getDept().equals(d) && e.getSalary() >= s);
    }
    



    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        var eList = new ArrayList<Employee>();
        eList.add(new Employee("Jack", "HR", 30000));
        eList.add(new Employee("Aria", "HR", 40000));
        eList.add(new Employee("Nora", "IT", 50000));
        eList.add(new Employee("Bella", "IT", 60000));
        eList.add(new Employee("Jacob", "IT", 70000));
        eList.add(new Employee("James", "HR", 80000));
        String d = sc.next();       //read department
        double s = sc.nextInt();    //read salary
		
        var st = query(eList, d, s);
        st.forEach(n -> System.out.println(n + " "));
    }
}

