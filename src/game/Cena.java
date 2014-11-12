package game;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Vector;

import javax.imageio.ImageIO;

import base.MyActionListener;
import base.MyComponent;

public class Cena extends MyComponent implements MyActionListener{
		private Vector<Pista> pistas;
		private Vector<Suspeito> suspeitos;
		private ArmaDoCrime armaUtilizada;
		
		private String descricao;
		private BufferedImage fotoCrime;
		
		
		
		//Construtor
		public Cena(String imagem) {
			super(200,100,0,0);
			
			iniciaMatrix(imagem);
			this.setVisible(true);
			
		}
		
		
		//Metodos para Atributos
		public void addPistas(Pista pista){
			//Inicializa
			if (this.pistas == null)
				this.pistas = new Vector<Pista>();
			
			this.pistas.add(pista);
		}
		public void addSuspeitos(Suspeito suspeito){
			//Inicializa
			if (this.suspeitos == null)
				this.suspeitos =  new Vector<Suspeito>();
			
			this.suspeitos.add(suspeito);
		}
		private void setArmaDoCrime(ArmaDoCrime arma){
			this.armaUtilizada = arma;
		}
		public void setFotoCrime(String caminho){
			try 
			{
			    
			    fotoCrime = ImageIO.read(new File(caminho));
			} 
			catch (IOException e) 
			{
			    e.printStackTrace();
			}
		}
		public void setDescricao(String descricao){
			this.descricao = descricao;
		}
		//Métodos para load da Cena
		
		
		
		
		public void iniciaMatrix(String imagem){
			setFotoCrime(imagem);
		}
		
		
		//Método para resolucao de crime
		public boolean resolveCrime(){
			
			return false;
		}



		@Override
		public void paint(Graphics g) {
			g.drawImage(fotoCrime,this.x,this.y,null);
			for (Pista pista : pistas) {
				pista.paint(g);
			}
			
		}


		@Override
		public void actionPerformed(MyComponent c) {
			// TODO Auto-generated method stub
			
		}
}
