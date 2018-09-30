package DesignPattern;

public class RedBorderShapeDecorator extends ShapeDecorator {
    private Shape decoratedShape;

    public RedBorderShapeDecorator(Shape shape) {
        super(shape);
        this.decoratedShape = shape;
    }

    @Override
    public void draw() {
        decoratedShape.draw();
        setBorder(decoratedShape);
    }

    private void setBorder(Shape decoratedShape) {
        System.out.println("Border Color: Red");
    }
}
