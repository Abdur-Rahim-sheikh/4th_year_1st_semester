package adapter_pattern;

public class AudioPlayer implements MediaPlayer{
    MediaAdapter mediaAdapter;
    
    public void play(String type,String name){
        if(type=="mp3"){
            System.out.println("mp3 player is playing "+name);
        }
        else if(type == "mp4" || type=="vlc"){
            mediaAdapter = new MediaAdapter(type);
            mediaAdapter.play(type, name);
        }
        else{
            System.out.println(type + " extension has no support yet,, tune in.");
        }
    }
}
