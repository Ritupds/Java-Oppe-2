import java.util.stream.Stream;
import java.util.*;
import java.text.*;

class Student{
    private int roll_num;
    private Date dose_one = new Date(); 
    private Date dose_two = new Date();	
    
    public int getRollNo() {
        return roll_num;
    }	
    public Student(int roll_num, String dd_str) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        this.roll_num = roll_num;
        try {			
            dose_one = sdf.parse(dd_str);		
            dose_two = sdf.parse("30/03/2022");
        }
        catch(ParseException e){
            System.out.println("Incorrect Date Format");
        }
    }


    // define isEligible()
    public boolean isEligible(){
        if (((dose_one.getTime()-dose_two.getTime()) / 1000l * 60 * 60 * 24) > 28){
            return true;
        }
        return false;
    }
}

// define StudentList
class StudentList{
    public Stream<Student> getEligibleList(List<Student> list){
        return list.stream().filter(st-> st.isEligible());
    }
    public boolean isEmpty(Stream<Student> stream){
        if (stream.count() == 0)
            return true;
        return false;
    }
}

    public class week8ppa2{
        public static void main(String[] args) {		
            Scanner sc = new Scanner(System.in);
            int roll_num;		
            String dose_one_str;
            List<Student> full_list = new ArrayList<Student>();
            
            int num = sc.nextInt(); //Number of students
            for (int i=0; i<num; i++) {
                roll_num = sc.nextInt(); //Roll Number
                dose_one_str = sc.next(); //Date of Dose One			
                Student st = new Student(roll_num, dose_one_str);
                full_list.add(st); // Add the student to an ArrayList
            }
            
            StudentList list = new StudentList();		
            Stream<Student> eligible_list = list.getEligibleList(full_list);
            if (!list.isEmpty(eligible_list)) {
                System.out.println("The list of eligible students are: ");
                eligible_list = list.getEligibleList(full_list);
                eligible_list.forEach(s -> System.out.println(s.getRollNo()));
            }
            else {
                System.out.println("There are no eligible students.");
            }
            sc.close();
        }
}

