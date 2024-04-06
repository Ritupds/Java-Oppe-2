import java.util.Scanner;
import java.util.ArrayList;

class AgeOutOfBoundException extends Exception{
    AgeOutOfBoundException(String n){
        super("Age of " + n + " is outside the limits");
    }
}
class Applicant{
    String name;
    int age;
    Applicant(String n, int a){
        name= n;
        age=a;
    }
    public String checkAndGetName() throws AgeOutOfBoundException{
        // complete definition of method checkandgetname
        if(this.age>=18 && this.age <=30){
            return this.name;
        }
        else{
            throw new AgeOutOfBoundException(this.name);
            
        }
    }
        
    }


public class Exceptionprevy{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        ArrayList<Applicant> aList = new ArrayList<Applicant>();

        for (int i = 0; i<4; i++){
           Applicant a = new Applicant(sc.next(), sc.nextInt());
           aList.add(a);

        }
        for (Applicant a: aList){
            try{
                String name = a.checkAndGetName();
                System.out.println(name);
            }
            catch(AgeOutOfBoundException e){
                System.out.println(e.getMessage());
            }
        }
        sc.close();
    }
}


