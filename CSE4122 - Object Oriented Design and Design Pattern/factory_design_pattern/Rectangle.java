package factory_design_pattern;

public class Rectangle implements Shape {

    @Override
    public void draw() {
       System.out.println("Inside Rectangle::draw() method.");
    }
    public void more(){
        System.out.println("Loved to know!");
    }
 }
