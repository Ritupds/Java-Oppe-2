import java.util.*;

class ImproperHeadCountException extends Exception{
    public ImproperHeadCountException(String msg){
        super(msg);
    }   
}
class WrongDestinationException extends Exception{
    public WrongDestinationException(String msg){
        super(msg);
    }
}


class CarRental{
    int passenger_count;
    String chosen_destination;
    HashMap<String,Double> available_destinations;  

    public CarRental(int pc, String dest) {
        passenger_count = pc;
        chosen_destination = dest;
        
        available_destinations = new HashMap<String,Double>();
        available_destinations.put("Marina Beach", 2000.0);
        available_destinations.put("Elliot's Beach", 5000.0);
        available_destinations.put("Film City", 8000.0);
    }

    public void carBooker(){
        double cost = available_destinations.get(chosen_destination);

        try{
            if(passenger_count<1){
                throw new ImproperHeadCountException("Head count should be positive non-zero value");
            }
            double head_cost = passenger_count / cost;
            System.out.println("Destination: "  + chosen_destination + "Head Cost:  " + head_cost);
            
        }
        catch(ImproperHeadCountException e){
            System.out.println(e);
        }
        catch(NullPointerException n){
            n.initCause(new WrongDestinationException("Invalid Destination"));
            throw n;
        }
    }

}

public class week7ppa1{
    public static void main(String args[]) {
        Scanner s = new Scanner(System.in);
        
        int num = s.nextInt(); //input the number of car rental requests
        try {
            for(int i=1;i<=num;i++) {
                int heads = s.nextInt(); //enter head count
                s.nextLine();  //enter destination
                String dest = s.nextLine();     
                CarRental obj = new CarRental(heads,dest);
                obj.carBooker();
            }
        }catch(Exception e) {
            System.out.println(e.getCause());
        }
        s.close();
    }
}
