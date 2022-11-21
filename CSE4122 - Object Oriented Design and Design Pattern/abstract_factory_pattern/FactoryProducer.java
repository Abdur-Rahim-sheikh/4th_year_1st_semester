package abstract_factory_pattern;

public class FactoryProducer {
    public static AbstractFactory getFactory(boolean rounded){
        if(rounded){
            return new RoundedShapeFactory();
        }
        else return new ShapeFactory();
    }
}
