import java.util.Scanner;


class Employee implements Cloneable{
    private String name;
    private String[] projects;
    public Employee(String n, String[] p){
        name = n;
        projects = p;
    }
    public String getName(){
        return name;
    }
    public String getProject(int i){
        return projects[i];
    }
    public void setName(String n){
        this.name = n;
    }
    public void setProject(int i, String p){
        this.projects[i] = p;
    }
    public Employee clone() throws CloneNotSupportedException{
        Employee e = (Employee)super.clone();
        e.projects = projects.clone();
        return e;
    }

}
public class week8replit1 {
    
public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    String[] e1Projects = {"Project A", "Project B", "Project C"};
    Employee e1 = new Employee("John", e1Projects);
    try{
      Employee e2 = (Employee)e1.clone();
      String e2Name = sc.next();
      String newProject = sc.nextLine();
      e2.setName(e2Name);
      e2.setProject(1,newProject);

      System.out.println(e1.getName());
      System.out.println(e2.getName());
      System.out.println(e1.getProject(1));
      System.out.println(e2.getProject(1));
    }
    catch(CloneNotSupportedException e){
      e.printStackTrace();
    }
    sc.close();
    
  }
}
