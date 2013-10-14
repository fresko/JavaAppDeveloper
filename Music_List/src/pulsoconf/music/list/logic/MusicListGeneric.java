package pulsoconf.music.list.logic;
/**
 * Class Music 
 * @author USSER
 *
 */
public class MusicListGeneric {

	 private String  type;
	 private String  genre;
	 private String  nameSong;
	 private String  nameBand;
	 private String  start;
	 private String  url;
	 private String  speed;
	 
	 
	 
	public MusicListGeneric(String type, String genre, String nameSong,
			String nameBand, String start, String url, String speed) {
		super();
		this.type = type;
		this.genre = genre;
		this.nameSong = nameSong;
		this.nameBand = nameBand;
		this.start = start;
		this.url = url;
		this.speed = speed;
	}
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getSpeed() {
		return speed;
	}
	public void setSpeed(String speed) {
		this.speed = speed;
	}
	public String getNameSong() {
		return nameSong;
	}
	public void setNameSong(String nameSong) {
		this.nameSong = nameSong;
	}
	public String getNameBand() {
		return nameBand;
	}
	public void setNameBand(String nameBand) {
		this.nameBand = nameBand;
	}
	public String getStart() {
		return start;
	}
	public void setStart(String start) {
		this.start = start;
	}
	
 

}
