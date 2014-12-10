package game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Vector;

import javax.imageio.ImageIO;

import base.MyComponent;
import game.Cena;
import game.SuspeitoAdapter;

public class Caso extends MyComponent{
	
	private Vector<SuspeitoAdapter> suspeitos;
	private Cena cena;
	private ContemDicas contemDicas;
	
	
	public Caso(int x,int y, int w, int h, Cena cena, ContemDicas contemDicas){
		super(x, y, w, h);
		
		this.suspeitos = new Vector<SuspeitoAdapter>();
		this.cena = cena;
		this.contemDicas = contemDicas;
		this.cena.addActionListener(contemDicas);
	}
	public void addSuspeitos(SuspeitoAdapter suspeito){
		this.suspeitos.add(suspeito);
	}
	public SuspeitoAdapter getSelectedSuspeito() {
		for (SuspeitoAdapter suspeito : suspeitos)
			if (suspeito.isSelected())
				return suspeito;
		return null;
	}
	@Override
	public void mouseClicked(MouseEvent me) {
		// TODO Auto-generated method stub
		super.mouseClicked(me);
		if (isOver(me.getX(), me.getY()))
			for (SuspeitoAdapter suspeitoAdapter : suspeitos) {
				suspeitoAdapter.mouseClicked(me);
			}
	}
	
	@Override
	public void paint(Graphics g) {
		Color old;
		
		int positionMaxX = this.x + (this.width/3);
		
		old = g.getColor();
		
		g.setColor(Color.cyan);
		g.fillRect(0, 0, this.width, 140);
		
		g.setColor(Color.BLACK);
		contemDicas.paint(g);
		
		for (SuspeitoAdapter suspeitoAdapter : suspeitos) {
			
			//g.drawImage(suspeitoBackground, positionMaxX, this.y+10, null);
			suspeitoAdapter.setPosition(positionMaxX+5, this.y+30);
			
			suspeitoAdapter.paint(g);
			positionMaxX += 120;
		}
		
	}
	
	
	
}
