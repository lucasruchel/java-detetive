package game;

import java.awt.Graphics;

import base.MyComponent;
import base.MyLabel;

public class Dica extends MyComponent
{
	private MyLabel label;	
	
	public Dica(int x, int y, int w, int h){
		super(x, y, w, h);
		label = new MyLabel();
		label.setPosition(x+20, y+10);
	}
	public void setDica(String dica){
		this.label.setLabel(dica);
	}
	@Override
	public void paint(Graphics g) {
		label.paint(g);
	}
	
}
