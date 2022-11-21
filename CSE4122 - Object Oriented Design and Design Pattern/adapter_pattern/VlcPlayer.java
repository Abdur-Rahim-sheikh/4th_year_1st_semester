package adapter_pattern;

public class VlcPlayer implements AdvancedMediaPlayer{
    public void play(String name){
        System.out.println("vlc player is playing: "+name);
    }
}
