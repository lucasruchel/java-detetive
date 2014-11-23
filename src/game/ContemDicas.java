package game;

import game.Dica;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Paint;
import java.util.Vector;

import base.MyActionListener;
import base.MyComponent;
import base.MyLabel;

public class ContemDicas extends MyComponent implements MyActionListener{

	private Vector<MyLabel>painel;
	private Color backgroundColor;
	
	
	public ContemDicas(int w,int h) {
		super(0,0,w,h);
		this.backgroundColor = Color.DARK_GRAY;
		
	}
	
	public void addDicas(String texto){
		if (painel == null)
			this.painel = new Vector<MyLabel>();
		
		this.painel.add(new MyLabel(texto));
	}
	@Override
	public void paint(Graphics g) {
		g.fillRect(0, 0, this.width, this.height);
		
		if (painel != null){
			int posx = 0;
			for (MyLabel dicaLida : painel) {
				posx += 50;
				dicaLida.setPosition(0, posx);
				dicaLida.paint(g);
			}
		}
	}

	@Override
	public void actionPerformed(MyComponent c) {
		Pista p = (Pista) c;
		if (!p.foiLida())
			this.addDicas(p.getDica());
	}
	
}
