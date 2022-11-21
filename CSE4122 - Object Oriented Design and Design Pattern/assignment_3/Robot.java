import java.util.ArrayList;

public class Robot {
    ArrayList<Walk> arr;
    int x,y,pos;
    public static int UP=0,RIGHT=1,DOWN=2,LEFT=3;
    public Robot(int x,int y,int pos){
        this.x = x;
        this.y = y;
        this.pos = pos;
        arr = new ArrayList<Walk>();
    }

    public void turn(String direction){
        if(direction.equalsIgnoreCase("turnleft")) pos = (pos + 3)%4;
        else if(direction.equalsIgnoreCase("turnright")) pos = (pos + 1)%4;
    }

    public void addCommand(String command){
        if(command.equalsIgnoreCase("turnLeft") || command.equalsIgnoreCase("turnright")){
            turn(command);
        }
        else if (command.equalsIgnoreCase("forward")){
            arr.add(new WalkForward(pos));
        }
        else if(command.equalsIgnoreCase("backward")){
            arr.add(new WalkBackward(pos));
        }
    }

    public void start(){
        for(Walk w: arr){
            w.setX(x);
            w.setY(y);
            w.execute();
            x = w.getX();
            y = w.getY();
        }
        arr.clear();
    }
}
