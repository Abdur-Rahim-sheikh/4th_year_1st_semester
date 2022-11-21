package decorator_pattern;

public abstract class ShapeDecorator implements Shape{
    protected Shape shape=null;
    public ShapeDecorator(Shape shape){
        this.shape = shape;
    }

    public void draw(){
        shape.draw();
    }

}
