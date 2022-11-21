package singleton_pattern;

public class Singleton {
    public static Singleton instance= null;
    private Singleton(){}
    int i=0;
    public static Singleton getInstance(){
        if(instance==null)instance = new Singleton();
        return instance;
    }
    public void execute(){
        System.out.println("Hello world "+i);
        i+=1;
    }
}
