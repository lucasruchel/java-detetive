package base;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Vector;

import javax.imageio.ImageIO;

import game.Cena;
import game.SuspeitoAdapter;

public class Caso extends MyComponent{
	
	private Vector<SuspeitoAdapter> suspeitos;
	private Cena cena;
	private ContemDicas contemDicas;
	
	//Atributos Campo
	private BufferedImage suspeitoBackground;
	
	public Caso(int x,int y, int w, int h, Cena cena, ContemDicas contemDicas){
		super(x, y, w, h);
		
		this.suspeitos = new Vector<SuspeitoAdapter>();
		this.cena = cena;
		this.contemDicas = contemDicas;
		this.cena.addActionListener(contemDicas);
		
		loadImageBackgoundSuspeito("Images/suspeitoBackground.png");
		
	}
	public void addSuspeitos(SuspeitoAdapter suspeito){
		this.suspeitos.add(suspeito);
	}
	public void loadImageBackgoundSuspeito(String image){
		try 
		{
		    suspeitoBackground = ImageIO.read(new File(image));
		} 
		catch (IOException e) 
		{
		    e.printStackTrace();
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
			g.drawImage(suspeitoBackground, positionMaxX, this.y+10, null);
			
			positionMaxX += 120;
		}
		
	}
	
	
	
}
