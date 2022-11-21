package decorator_pattern;

public class Demo {
    public static void main(String[] args) {
        Shape circle = new Circle();
        Shape rectangle = new Rectangle();

        BlueCircleDecorator blueCircle = new BlueCircleDecorator(rectangle);
        BlueCircleDecorator blueRectangle = new BlueCircleDecorator(circle);

        circle.draw();
        blueCircle.draw();
        blueRectangle.draw();
    }
}
