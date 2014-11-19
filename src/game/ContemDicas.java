package base;

import game.Dica;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Vector;

public class ContemDicas extends MyComponent implements MyActionListener{

	private Vector<Dica>dicas;
	private Color backgroundColor;
	
	
	public ContemDicas(int w,int h) {
		super(0,0,w,h);
		this.backgroundColor = Color.DARK_GRAY;
		
	}
	
	public void addDicas(Dica dicas){
		if (dicas == null)
			this.dicas = new Vector<Dica>();
		this.dicas.add(dicas);
	}
	@Override
	public void paint(Graphics g) {
		g.fillRect(0, 0, this.width, this.height);
	}

	@Override
	public void actionPerformed(MyComponent c) {
		System.out.println("Teste doruchel gay!");
		
	}
	
}
