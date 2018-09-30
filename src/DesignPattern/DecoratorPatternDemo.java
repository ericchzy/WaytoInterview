package DesignPattern;

public class DecoratorPatternDemo {
    public static void main(String[] args) {
        Shape circle = new Circle();
        Shape rectangle = new Rectangle();

        circle.draw();
        rectangle.draw();

        new RedBorderShapeDecorator(circle).draw();
        new RedBorderShapeDecorator(rectangle).draw();
    }
}
