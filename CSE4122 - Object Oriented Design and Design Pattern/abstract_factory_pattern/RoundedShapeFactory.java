package abstract_factory_pattern;


public class RoundedShapeFactory extends AbstractFactory{

    @Override
    Shape getShape(String type) {
        // TODO Auto-generated method stub
        if(type=="rectangle"){
            return new RoundedRectangle();
        }
        else if(type=="square"){
            return new RoundedSquare();
        }
        
        return null;
    }
    

    
}
