public class Song implements IComponent{

    public String songName,artist;
	public float speed = 1; // Default playback speed

	public Song(String songName, String artist ) {
		this.songName = songName;
		this.artist = artist; 
	}
    public void play() {
        System.out.println("Playing song: "+songName+" of artist: "+artist);
    }

    @Override
    public void setPlaybackSpeed(float speed) {
        System.out.println("Speed is set to "+speed);
        this.speed = speed;
        
    }

    @Override
    public String getName() {
        return songName;
    }
    public String getArtist(){
        return artist;
    }
}
