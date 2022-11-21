package singleton_pattern;

public class demo {
    public static void main(String[] args) {
        Singleton obj1 = Singleton.getInstance();
        obj1.execute();

        Singleton obj2 = Singleton.getInstance();
        obj2.execute();
    }
}
