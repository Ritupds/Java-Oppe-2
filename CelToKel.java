import java.util.*;
class InvalidInputEx extends Exception{
    public InvalidInputEx(String s){
        super(s);
    }
}

public class CelToKel {
    // define method convertcelstokelvine
    public static int convertcelstokelvine(int cel)throws InvalidInputEx{
    
            if (cel < -273){
                throw new InvalidInputEx("Invalid Celsius value");
            }
            else{
                return cel + 273;
              
    }
}
    public static int convertKelvToCels(int kel) throws InvalidInputEx{
        if (kel < 0){
            throw new InvalidInputEx("Invalid kelvin value");
        }
        else{
            return kel - 273;
          
}
    }
public static void main(String[] args){
    int cels, kelv, cels_new, kelv_new;
    Scanner sc = new Scanner(System.in);
    cels = sc.nextInt();
    kelv = sc.nextInt();
    try{
        kelv_new = convertcelstokelvine(cels);
        cels_new = convertKelvToCels(kelv);
        System.out.println(kelv_new);
        System.out.println(cels_new);

    }
    catch(InvalidInputEx ie){
        System.out.println(ie.getMessage());
    }
    sc.close();
}

}

