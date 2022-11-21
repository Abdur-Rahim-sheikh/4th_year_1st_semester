package adapter_pattern;

public class MediaAdapter implements MediaPlayer{
    AdvancedMediaPlayer advancedMediaPlayer;
    public MediaAdapter(String type){
        if(type=="vlc"){
            advancedMediaPlayer = new VlcPlayer();
        }
        else if(type=="mp4"){
            advancedMediaPlayer = new Mp4Player();
        }
    }
    public void play(String type,String song){
        advancedMediaPlayer.play(song);
    }
}
