package abstract_factory_pattern;

public class ShapeFactory extends AbstractFactory {

    @Override
    Shape getShape(String type) {
        // TODO Auto-generated method stub
        if(type=="rectangle"){
            return new Rectangle();
        }
        else if(type =="square"){
            return new Square();
        }
        return null;
    }
    
}
