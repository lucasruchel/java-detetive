package game;
import java.awt.Dimension;

import javax.swing.JFrame;

import base.MyLabel;
import base.MyPanel;


public class MyApplication
{
	private JFrame jf;
	private MyPanel mp;
	
	private MyLabel ml;
	private Cena c1;
	private Pista p1,p2;
	private SuspeitoAdapter s1,s2,s3,s4,s5;
	private Suspeito susp1,susp2,susp3,susp4,susp5;
	private Caso caso;
	private ContemDicas dicasDisplay;
	private MyButton bEnunciado, bGod;
	
	//metodo de trabalho (helper)
	private void createGUI()
	{
		
		//Estáticos
		this.jf = new JFrame("Meu Projeto");
		this.mp = new MyPanel();
		jf.getContentPane().add(mp);
		
		mp.setSize(1024, 768);
		mp.setPreferredSize(new Dimension(1024,768));
		
		
		
		
		
		//Instancia variaveis
		this.dicasDisplay = new ContemDicas(150,768);
		this.c1 = new Cena("Images/cena1.jpg",dicasDisplay);
		this.p1 = new Pista(200,200,100,100,"Teste!    sssssss");
		this.p2 = new Pista(200,400,100,100,"#TheZueiraNeverEnd");
		
		
		this.susp1 = new Suspeito("Ruchel", "faxineiro", "Estava pescando", "Images/char1.png");
		this.susp2 = new Suspeito("Ruchel", "faxineiro", "Estava pescando", "Images/char2.png");
		this.susp3 = new Suspeito("Ruchel", "faxineiro", "Estava pescando", "Images/char3.png");
		this.susp4 = new Suspeito("Ruchel", "faxineiro", "Estava pescando", "Images/char4.png");
		this.susp5 = new Suspeito("Ruchel", "faxineiro", "Estava pescando", "Images/char5.png");
		
		
		this.s1 = new SuspeitoAdapter(200,10,100,100,susp1 );
		this.s2 = new SuspeitoAdapter(200,10,100,100,susp2 );
		this.s3 = new SuspeitoAdapter(200,10,100,100,susp3 );
		this.s4 = new SuspeitoAdapter(200,10,100,100,susp4 );
		this.s5 = new SuspeitoAdapter(200,10,100,100,susp5 );
		
		//Adiciona ao caso
		this.caso = new Caso(0,0,1024,768,c1,dicasDisplay);
		this.caso.addSuspeitos(s1);
		this.caso.addSuspeitos(s2);
		this.caso.addSuspeitos(s3);
		this.caso.addSuspeitos(s4);
		this.caso.addSuspeitos(s5);
		
		//Adiciona elementos
		this.mp.add(c1);
		
		c1.addPistas(p1);
		c1.addPistas(p2);
		mp.add(caso);
		
		
		this.bEnunciado = new MyButton( 1000, 50,"Enunciado");
		this.bEnunciado.setVisible(true);
		
		
		this.mp.add(bEnunciado);
		
		
		//Seta Atributos
		p1.setVisible(true);
		this.s1.setVisible(true);
		
		
		jf.pack();//redimensiona para conter os componentes
		jf.setVisible(true);
		
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public MyApplication()
	{
		createGUI();
	}
	
	
	public void go()
	{
		while(this.jf.isVisible())
		{
			try
			{			
				this.mp.invalidate();
				this.mp.repaint();
								
				Thread.sleep(33);
			}
			catch(InterruptedException ie)
			{
				ie.printStackTrace();
			}			
		}
	}
}
