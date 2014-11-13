package game;
import java.awt.Dimension;

import javax.swing.JFrame;

import base.Caso;
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
	private Suspeito susp;
	private Caso caso;
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
		
		this.p1 = new Pista(200,200,100,100,"Teste!");
		
		p1.setVisible(true);
		c1.addPistas(p1);
		susp = new Suspeito("Ruchel", "faxineiro", "Estava cagando", null);
		this.s1 = new SuspeitoAdapter(200,10,100,100,susp );
		this.s1.setVisible(true);
		mp.add(s1);
		mp.add(caso);
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
