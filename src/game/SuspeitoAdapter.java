package game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;

import base.MyComponent;

public class SuspeitoAdapter extends MyComponent{
	private Suspeito suspeito;
	private Color selectedColor;
	
	
	public Suspeito getSuspeito() {
		return suspeito;
	}
	public SuspeitoAdapter(int x, int y, int w, int h, Suspeito suspeito) {
		super(x,y,w,h);
		this.suspeito = suspeito;
		selectedColor = Color.RED;
	}
	@Override
	public void mouseClicked(MouseEvent me) {
		// TODO Auto-generated method stub
		super.mouseClicked(me);
		if (isOver(me.getX(), me.getY()))
			setSelected(true);
	}
	@Override
	public void paint(Graphics g) {
		if (suspeito.getFoto() != null){
			Color old = g.getColor();
			g.setColor(Color.BLUE);
			
			if (isSelected()){
				g.setColor(selectedColor);
				g.fillRect(this.x, this.y, this.width, this.height);
			}else{
				g.fillRect(this.x, this.y, this.width, this.height);
			}
			
			g.setColor(old);
			
			g.fillRect(this.x+5, this.y+5, this.width-10, this.height-10);
			
			g.drawImage(suspeito.getFoto(), this.x+(this.width/6), this.y+(this.height/6), null);
			
		}
			
	}
	

}
