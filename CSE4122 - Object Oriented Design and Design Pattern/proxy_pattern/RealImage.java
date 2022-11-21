package proxy_pattern;

public class RealImage implements Image{
    private String filename;
    public RealImage(String filename){
        this.filename = filename;
        loadFromDisk(filename);
    }
    private void loadFromDisk(String fileName){
        System.out.println("Loading "+fileName);
    }

    public void display(){
        System.out.println("Displaying "+filename);
    }
}
