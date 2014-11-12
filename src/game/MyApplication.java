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
	private Pista p1;
	private SuspeitoAdapter s1;
	
	//metodo de trabalho (helper)
	private void createGUI()
	{
		this.jf = new JFrame("Meu Projeto");
		this.mp = new MyPanel();
		jf.getContentPane().add(mp);
		
		mp.setSize(1024, 768);
		mp.setPreferredSize(new Dimension(1024,768));
		
		c1 = new Cena("Images/cena1.jpg");

		this.mp.add(c1);
		
		this.p1 = new Pista(200,200,50,50,"Olá Ruchel Viado!");
		p1.setVisible(true);
		c1.addPistas(p1);
		this.s1 = new SuspeitoAdapter(200,10,50,100,new Suspeito());
		this.s1.setVisible(true);
		mp.add(s1);
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
