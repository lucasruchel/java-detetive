package game;

import java.awt.Graphics;

import base.MyComponent;

public class SuspeitoAdapter extends MyComponent{
	private Suspeito suspeito;
	
	public SuspeitoAdapter(int x, int y, int w, int h, Suspeito suspeito) {
		super(x,y,w,h);
		this.suspeito = suspeito;
	}
	@Override
	public void paint(Graphics g) {
		g.drawRect(this.x, this.y, this.width, this.height);
		
	}
	

}
