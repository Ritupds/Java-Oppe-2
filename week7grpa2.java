import java.util.Scanner;

class InvalidInputEx extends Exception{
    public InvalidInputEx(String s){
        super(s);
    }
}

class IntList{

    private int[] array;
    public IntList(){
        array = new int[5];
    }
    public void set_value(int i, int v) throws InvalidInputEx{
        try{
            array[i] = v;
        }
        catch(ArrayIndexOutOfBoundsException e){
            e.initCause(new InvalidInputEx("invalid index input"));
            throw e;
        }

    }
    public int[] getArray() {
        return array;
    }
}

public class week7grpa2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        IntList ilist = new IntList();
        try {
            for(int i = 0; i < 5; i++) {			
                int n = sc.nextInt();
                int m = sc.nextInt();
                ilist.set_value(n, m);
            }
        }
        catch(InvalidInputEx e) {
            System.out.println(e.getMessage());
            Throwable ori = e.getCause();
            System.out.println(ori.getMessage());
        }	
        int[] i_arr = ilist.getArray();
        for(int i = 0; i < i_arr.length; i++)
            System.out.print(i_arr[i] + " ");
    }
}
