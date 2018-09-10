package DesignPattern;

public class FactoryProducer {

    // static method to get factory
    public static AbstractFactory getFactory(String factoryName) {
        if (factoryName.equalsIgnoreCase("shapefactory")) {
            return new ShapeFactory();
        } else if (factoryName.equalsIgnoreCase("colorfactory")) {
            return new ColorFactory();
        }
        return null;
    }
}
