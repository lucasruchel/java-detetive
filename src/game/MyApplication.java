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
	private Suspeito susp;
	private Caso caso;
	private ContemDicas dicasDisplay;
	
	//metodo de trabalho (helper)
	private void createGUI()
	{
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
		
		
		this.susp = new Suspeito("Ruchel", "faxineiro", "Estava pescando", null);
		
		this.s1 = new SuspeitoAdapter(200,10,100,100,susp );
		this.s2 = new SuspeitoAdapter(200,10,100,100,susp );
		this.s3 = new SuspeitoAdapter(200,10,100,100,susp );
		this.s4 = new SuspeitoAdapter(200,10,100,100,susp );
		this.s5 = new SuspeitoAdapter(200,10,100,100,susp );
		
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
