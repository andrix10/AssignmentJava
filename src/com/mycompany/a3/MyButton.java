package com.mycompany.a3;
import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Button;
import com.codename1.ui.Component;
import com.codename1.ui.plaf.Border;
import com.codename1.charts.util.ColorUtil;

import java.lang.String;

public class MyButton extends Button {
	private Button but;
	private int padding = 2;
	MyButton(String n){
		super(n);
		//System.out.println(n);
		super.getAllStyles().setBgTransparency(0);
		super.getAllStyles().setPadding(Component.TOP, padding);
		super.getAllStyles().setPadding(Component.BOTTOM, padding);
		super.getUnselectedStyle().setFgColor(ColorUtil.BLUE);
		super.getUnselectedStyle().setBgColor(ColorUtil.BLACK);
		super.getAllStyles().setBorder(Border.createLineBorder(4, ColorUtil.BLUE));
	}
	
	public void changePadding(int x){
		padding = x;
	}
	
	public void changeName(String n) {
		this.setName(n);
	}

}
