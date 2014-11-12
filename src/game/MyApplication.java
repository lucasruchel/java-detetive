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
	
	
	//metodo de trabalho (helper)
	private void createGUI()
	{
		this.jf = new JFrame("Meu Projeto");
		this.mp = new MyPanel();
		jf.getContentPane().add(mp);
		
		mp.setSize(1024, 768);
		mp.setPreferredSize(new Dimension(1024,768));
		
		c1 = new Cena("Images/cina1.png");
		this.mp.add(c1);
		
		
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
