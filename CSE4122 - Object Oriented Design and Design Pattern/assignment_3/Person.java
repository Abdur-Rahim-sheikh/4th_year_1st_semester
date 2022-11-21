public class Person {
    public static void main(String[] args){
        Robot robot = new Robot(0,0,Robot.UP);
        robot.addCommand("turnright");
        robot.addCommand("forward");
        robot.addCommand("forward");
        robot.addCommand("turnright");
        robot.addCommand("backward");
        robot.start();
    }
}
