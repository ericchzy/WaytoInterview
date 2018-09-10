package DesignPattern;

public class AbstractFactoryPatternDemo {
    public static void main(String[] args) {

        AbstractFactory shapeFactory = FactoryProducer.getFactory("shapeFactory");
        if (shapeFactory == null) {
            System.out.println("Fail to get the shape factory.");
        } else {
            Circle circle = (Circle) shapeFactory.getShape("circle");
            circle.draw();
        }

        AbstractFactory colorFactory = FactoryProducer.getFactory("colorFactory");
        if (colorFactory == null) {
            System.out.println("Fail to get the color factory.");
        } else {
            Red red = (Red) colorFactory.getColor("red");
            red.fill();
        }
    }
}
