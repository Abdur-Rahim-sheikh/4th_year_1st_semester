package proxy_pattern;

public class Demo {
    public static void main(String[] args) {
        Image image = new ProxyImage("test_abir.jpg");

        image.display();
        image.display();
    }
}
