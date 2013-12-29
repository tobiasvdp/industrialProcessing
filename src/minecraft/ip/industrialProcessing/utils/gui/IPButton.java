package ip.industrialProcessing.utils.gui;

import org.lwjgl.util.Point;
import org.lwjgl.util.Rectangle;

public class IPButton {
	private Rectangle LOCATION;
	
	public IPButton(int x,int y,int width,int height) {
		LOCATION = new Rectangle(x, y, width, height);
	}
	
	public boolean clickedInside(int x,int y){
		if(x > LOCATION.getX() && x < LOCATION.getX() + LOCATION.getWidth()){
			if(y > LOCATION.getY() && y < LOCATION.getY()+ LOCATION.getHeight()){
				return true;
			}
		}
		return false;
	}
}
