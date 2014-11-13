package base;

import java.awt.Graphics;
import java.util.Vector;

import game.Cena;
import game.SuspeitoAdapter;

public class Caso extends MyComponent{
	
	private Vector<SuspeitoAdapter> suspeitos;
	private Cena cena;
	private ContemDicas contemDicas;
	
	public Caso(Cena cena, ContemDicas contemDicas){
		this.suspeitos = new Vector<SuspeitoAdapter>();
		this.cena = cena;
		this.contemDicas = contemDicas;
		this.cena.addActionListener(contemDicas);
		
	}
	public void addSuspeitos(SuspeitoAdapter suspeito){
		this.suspeitos.add(suspeito);
	}
	@Override
	public void paint(Graphics g) {
		for (SuspeitoAdapter suspeitoAdapter : suspeitos) {
			
		}
		
	}
	
	
	
}
