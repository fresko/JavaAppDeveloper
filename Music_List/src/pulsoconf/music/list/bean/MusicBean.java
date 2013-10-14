package pulsoconf.music.list.bean;

import java.util.ArrayList;
import java.util.List;

import pulsoconf.music.list.logic.MusicListGeneric;

public class MusicBean {
	
	private List<MusicListGeneric> lstMusic;
	
	/**
	 * 
	 * Consult Music
	 * @return
	 */
	public String action_consult(){
		lstMusic = new ArrayList<MusicListGeneric>();
		lstMusic = loadMusic();
		
	 return "";	
	}
	
	public List<MusicListGeneric> loadMusic(){
		
	   lstMusic = new ArrayList<MusicListGeneric>();
	   MusicListGeneric music = new MusicListGeneric("Sport", "Rap", "Inda House", "50cent", "0", "http://prueba", "2");
	   MusicListGeneric music1 = new MusicListGeneric("Sport", "Rap", "Inda House", "50cent", "0", "http://prueba", "2");
	   MusicListGeneric music2 = new MusicListGeneric("Sport", "Rap", "Inda House", "50cent", "0", "http://prueba", "2");
	   MusicListGeneric music3 = new MusicListGeneric("Sport", "Rap", "Inda House", "50cent", "0", "http://prueba", "2");
	   MusicListGeneric music4 = new MusicListGeneric("Sport", "Rap", "Inda House", "50cent", "0", "http://prueba", "2");
	   MusicListGeneric music5 = new MusicListGeneric("Sport", "Rap", "Inda House", "50cent", "0", "http://prueba", "2");
	   
	   lstMusic.add(music);
	   
	 return lstMusic;	
	} 

}
