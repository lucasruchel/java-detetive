package game;

import java.awt.Color;
import java.awt.Graphics;

import base.MyComponent;
import base.MyLabel;

public class EndGame extends MyComponent{
	private MyButton gameRestart, gameExit;
	
	private Color enabledColor;
	
	public EndGame(int width, int height,Color bckColor) {
		this.setHeight(height);
		this.setWidth(width);
		this.enabledColor = bckColor;
		
		gameRestart = new MyButton(width/3, height/3, "Reiniciar jogo!! ");
		gameExit = new MyButton(width/3, height/3*2, "Sair do Jogo!! ");
	}
	
	
	@Override
	public void paint(Graphics g) {
		if (isVisible()){
			g.setColor(this.enabledColor);
			g.fillRect(0, 0, this.width,this.height );
			
			gameRestart.paint(g);
			gameExit.paint(g);
		}
		
		
	}
	
	
}
