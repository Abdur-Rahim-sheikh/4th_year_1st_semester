package abstract_factory_pattern;

public class AbstractFactoryDemo {
    public static void main(String[] args){
        //get shape factory
        // System.out.println("here");
        AbstractFactory shapeFactory = FactoryProducer.getFactory(false);
        //get an object of Shape Rectangle
        Shape shape1 = shapeFactory.getShape("rectangle");
        //call draw method of Shape Rectangle
        shape1.draw();
        //get an object of Shape Square 
        Shape shape2 = shapeFactory.getShape("square");
        //call draw method of Shape Square
        shape2.draw();
        //get shape factory
        AbstractFactory shapeFactory1 = FactoryProducer.getFactory(true);
        //get an object of Shape Rectangle
        Shape shape3 = shapeFactory1.getShape("rectangle");
        //call draw method of Shape Rectangle
        shape3.draw();
        //get an object of Shape Square 
        Shape shape4 = shapeFactory1.getShape("square");
        //call draw method of Shape Square
        shape4.draw();
    }
}
