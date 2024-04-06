import java.util.ArrayList;
import java.util.Scanner;
import java.util.*;

class Athlete implements Cloneable{
String athleteChestNum;
ArrayList<String> events = new ArrayList<String>();

public Athlete(){
     athleteChestNum = "100";
     events.add("Relay");
     events.add("Ind Evt 1");
     events.add("Ind evt 2");
  }
 
   //Add mutator method for  athletechestnum ,ind evt1 ,ind evt 2
  public void setAthleteChestNum(String s){
    this.athleteChestNum = s;
  }

  public void setIndividualEvt1(String s){
        this.events.remove(1);
        this.events.add(1,s);
  }

  public void setIndividualEvt2(String s){
        this.events.remove(2);
        this.events.add(2,s);
  }

   //implement method clone()

//    public Athlete clone() throws CloneNotSupportedException{
//     Athlete a = (Athlete)super.clone();
//     ArrayList<String> ab = new ArrayList<String>();
//     ab.add(0, "Relay");
//     ab.add(1, this.events.get(1));
//     ab.add(2, this.events.get(2));
//     a.events=ab;
//     return a;
//    }

    @Override
    public Athlete clone() throws CloneNotSupportedException {
    Athlete clonedAthlete = (Athlete) super.clone();
//     ArrayList<String> ev = new ArrayList<String>();
//     for (String events : this.events){
//       ev.add(events);
//     }
//     clonedAthlete.events = ev;
//     return clonedAthlete;

      clonedAthlete.events = new ArrayList<>(this.events);
      return clonedAthlete;

    
}

   public String toString(){
    return athleteChestNum +" :" + events;
   }
 }
public class AthleteTest{
      public static void main(String[] args){
            Scanner sc = new Scanner (System.in);
            Athlete dummyAthlete = new Athlete();
      try{
       Athlete a1 = (Athlete)dummyAthlete.clone();
       a1.setAthleteChestNum(sc.next());
       a1.setIndividualEvt1(sc.next());
       a1.setIndividualEvt2(sc.next());
       
       Athlete a2 = (Athlete)a1.clone();
       a2.setAthleteChestNum(sc.next());
       a2.setIndividualEvt2(sc.next());
       System.out.println(a1+"\n"+a2);
   }
   catch(CloneNotSupportedException e) {
       
   }
   sc.close();
        }
}
