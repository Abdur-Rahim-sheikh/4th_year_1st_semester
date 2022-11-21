package adapter_pattern;

public class Mp4Player implements AdvancedMediaPlayer{
    public void play(String name){
        System.out.println("Mp4 player is playing: "+name);
    }
}
