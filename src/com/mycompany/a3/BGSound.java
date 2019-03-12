package com.mycompany.a3;
import com.codename1.ui.Display;
import java.io.InputStream;
import com.codename1.media.Media;
import com.codename1.media.MediaManager;
import com.codename1.io.FileSystemStorage;

public class BGSound implements Runnable{
		private Media m;
		private boolean playing = true;
		public BGSound(String fileName){
			try{
					InputStream is = Display.getInstance().getResourceAsStream(getClass(),"/"+fileName);
					m = MediaManager.createMedia(is, "audio/mpeg");
					
			}
			catch(Exception e){
				e.printStackTrace();
			}
		}
		public void pause(){ 
			m.pause();
			playing = false;
		} 
		public void play(){ 
			m.play();
			playing = true;
		} 

		public void run() {
			m.setTime(0);
			m.play();
		}
}