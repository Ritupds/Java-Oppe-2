import java.util.*;

abstract class Shape {
    public abstract double area();
}

class Rectangle<T extends Number> extends Shape {
    private T length, breadth;

    public Rectangle(T len, T bre) {
        length = len;
        breadth = bre;
    }

    public double area() {
        return length.doubleValue() * breadth.doubleValue();
    }
}

class Square<T extends Number> extends Shape {
    private T side;

    public Square(T s) {
        side = s;
    }

    public double area() {
        return side.doubleValue() * side.doubleValue();
    }
}

public class RecSquareTest {
    // Define the method findMaxArea( ) here.

    public static double findMaxArea(List<? extends Shape> list){
        double maxArea = 0;
        for(Shape shape : list){
            double area = shape.area();
            if (area > maxArea){
                maxArea = area;
            }            
        }
        return maxArea;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Rectangle<Integer> r1 = new Rectangle<>(sc.nextInt(), sc.nextInt());
        Rectangle<Integer> r2 = new Rectangle<>(sc.nextInt(), sc.nextInt());
        List<Rectangle<Integer>> rList = new ArrayList<>();
        rList.add(r1);
        rList.add(r2);

        Square<Integer> s1 = new Square<>(sc.nextInt());
        Square<Integer> s2 = new Square<>(sc.nextInt());
        List<Square<Integer>> sList = new ArrayList<>();
        sList.add(s1);
        sList.add(s2);

        double r = findMaxArea(rList);
        double s = findMaxArea(sList);

        System.out.println(r);
        System.out.println(s);
    }
}