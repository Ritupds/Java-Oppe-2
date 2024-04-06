import java.util.*;

public class Q9 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Rectangle<Integer> r1 = new Rectangle<>(sc.nextInt(), sc.nextInt());
        Rectangle<Double> r2 = new Rectangle<>(sc.nextDouble(), sc.nextDouble());
        double large_area = r1.compare(r2);
        System.out.println(large_area);
    }
}


class Rectangle<T extends Number> {
    private T length;
    private T breadth;

    public Rectangle(T l, T b) {
        length = l;
        breadth = b;
    }

    public double area() {
        return length.doubleValue() * breadth.doubleValue();
    }

    public <T extends Number> double compare(Rectangle<T> r) {
        // double rarea = r.area();
        if (this.area() > r.area()) {
            return this.area();
        } else {
            return r.area();
        }
    }



}