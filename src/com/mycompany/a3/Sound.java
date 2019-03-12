package com.mycompany.a3;
import java.io.InputStream;
import com.codename1.media.Media;
import com.codename1.ui.Display;
import com.codename1.media.MediaManager;
import java.io.IOException;

public class Sound {
	private Media m;
	
	Sound(String n){
		try {
			InputStream is = Display.getInstance().getResourceAsStream(getClass(), "/"+n);
			m = MediaManager.createMedia(is, "audio/wav");
//			m = MediaManager.createMedia("/home/ender/eclipse-workspace/A3Prj/src/" + n, false);

		} 
		catch (IOException e) {e.printStackTrace();
		}
	}
	
	public void playSound(boolean f) {
		if(f) {
		m.setTime(0);
		m.play();
		}else m.pause();
	}
}
