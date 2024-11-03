package application;

import model.entities.Circle;
import model.entities.Color;
import model.entities.Rectangle;
import model.entities.Shape;

public class Main3 {

    public static void main(String[] args) {

        Shape shape1 = new Circle(Color.BLACK, 2.0);
        Shape shape2 = new Rectangle(Color.WHITE, 3.0, 4.0);

        System.out.println("Circle color: " + shape1.getColor());
        System.out.println("Circle area: " + String.format("%.3f", shape1.area()));
        System.out.println("Rectangle color: " + shape2.getColor());
        System.out.println("Rectangle area: " + String.format("%.3f", shape2.area()));
    }
}
