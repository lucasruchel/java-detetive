package game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.util.Vector;

import base.MyComponent;

public class Pista extends MyComponent
{
	private Dica dica;
	private boolean lida;
	
	

	public Pista(int x, int y, int w, int h, String informacao){
		super(x,y,w,h);
		this.addDicas(informacao);
		lida = false;
	}
	public boolean foiLida(){
		return lida;
	}
	public void addDicas(String informacoes){
		if(this.dica == null)
			this.dica = new Dica(this.x, this.y, this.width, this.height); 
			this.dica.setDica(informacoes);
	}

	public String getDica(){
		return this.dica.getTxt();
	}
	@Override
	public boolean isOver(int x, int y) {
		if(x> this.x && x < this.x+this.width && y>this.y && y< this.y + this.height){
			this.dica.setSelected(true);
			return true;
		}
		return false;
		
	}
	@Override
	public void mouseClicked(MouseEvent me) {
		super.mouseClicked(me);
		
		if (isOver(me.getX(), me.getY())){
			this.dica.mouseClicked(me);
			this.lida = true;
		}
		
		
		
	}
	@Override
	public void mouseMoved(MouseEvent me) {
		if (isOver(me.getX(), me.getY())){
			this.dica.setSelected(true);
			this.setSelected(true);
		}else{
			this.dica.setSelected(false);
			this.setSelected(false);
		}
			
	}
	
	
	@Override
	public void paint(Graphics g) {
		
			
			Color old = g.getColor();
			g.setColor(Color.WHITE);
			
			if(isSelected())
				g.drawOval(x, y, width, height);
			
			g.setColor(old);
			
			if (this.dica.isSelected())
				this.dica.paint(g);
	}

}
