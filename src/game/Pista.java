package game;

import java.awt.Graphics;
import java.util.Vector;

import base.MyComponent;

public class Pista extends MyComponent
{
	private Dica dica;
	
	public Pista(int x, int y, int w, int h, String informacao){
		super(x,y,w,h);
		this.addDicas(informacao);
	}
	
	public void addDicas(String informacoes){
		if(this.dica == null)
			this.dica = new Dica(this.x+50, this.y, this.width, this.height); 
			this.dica.setDica(informacoes);
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
	public void paint(Graphics g) {
		//if (this.dica.isSelected())
			this.dica.paint(g);
	}

}
