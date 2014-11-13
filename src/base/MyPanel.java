package base;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.Vector;

import javax.swing.JPanel;


public class MyPanel extends JPanel
{
	private Vector<MyComponent> vMyComponent=null;

	public MyPanel()
	{
		super(); //chama o construtor da classe base
	}
	public MyPanel(int width, int height)
	{
		super();
		this.setPreferredSize(new Dimension(width, height));
		this.setSize(width, height);
	}
	
	public void add(MyComponent mc)
	{
		//inicializacao sob demanda
		if(this.vMyComponent == null)
			this.vMyComponent = new Vector<MyComponent>();
		
		this.vMyComponent.add(mc);
		this.addMouseListener(mc);
		this.addMouseMotionListener(mc);
	}
	
	//reescrever o metodo paint
	@Override
	public void paint(Graphics g)
	{
		super.paint(g);
		
		if(vMyComponent != null)
		{
			for(MyComponent ml : vMyComponent) //for each
			{
				ml.paint(g);
			}
		}
		
	}
}
