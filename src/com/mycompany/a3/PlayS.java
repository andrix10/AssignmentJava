package com.mycompany.a3;
import com.codename1.ui.Display;
import java.io.InputStream;
import com.codename1.media.Media;
import com.codename1.media.MediaManager;
import com.codename1.ui.Command;
import com.codename1.ui.events.*;

public class PlayS extends Command implements ActionListener
{
	private BGSound bgSound;
	private boolean bPause = false;
	
	PlayS(BGSound s){
		super("BGSound");
		//bgSound.play();
		bgSound = s;
	}
	
	public void actionPerformed(ActionEvent evt) {
		bPause = !bPause;
		if (bPause)
			bgSound.pause();
		else
			bgSound.play();
	}
}
