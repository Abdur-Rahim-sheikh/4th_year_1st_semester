package decorator_pattern;

public class BlueCircleDecorator extends ShapeDecorator{
    public BlueCircleDecorator(Shape shape){
        super(shape);
    }
    public void draw(){
        this.shape.draw();
        setBlueBorder(shape);
    }
    void setBlueBorder(Shape shape){
        System.out.println("Blue Border drawn");
    }
}
