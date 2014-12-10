package base;
import base.MyActionListener;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.Vector;



public abstract class MyComponent
		implements MouseListener, MouseMotionListener
{
	//lista dos interessados em serem notificados da a��o
	//calback
	private Vector<MyActionListener> vActionListener=null;
	
	protected int x, y;
	protected int width, height;
	
	protected boolean flagVisible;
	protected Color selectedColor;
	protected boolean flagSelected;
	
	protected boolean flagFoco;
	
	
	protected MyComponent()
	{
		this.x = this.y = 0;		
		this.width = 30;
		this.height = 15;
		this.flagVisible = true;
		this.flagSelected = false;
	}
	
	protected MyComponent(int x, int y, int w, int h)
	{
		this();
		this.setPosition(x, y);
		this.setWidth(w);
		this.setHeight(h);
	}
	public Color getSelectedColor()
	{
		return selectedColor;
	}

	public void setSelectedColor(Color selectedColor)
	{
		this.selectedColor = selectedColor;
	}

	public void setSelected(boolean flag)
	{
		this.flagSelected = flag;
	}
	public boolean isSelected()
	{
		return this.flagSelected;
	}
	public void setVisible(boolean flag)
	{
		this.flagVisible = flag;
	}
	public boolean isVisible()
	{
		return this.flagVisible;
	}
	
	public int getWidth()
	{
		return width;
	}

	public void setWidth(int width)
	{
		this.width = width;
	}

	public int getHeight()
	{
		return height;
	}

	public void setHeight(int height)
	{
		this.height = height;
	}
	
	public void setPosition(int x, int y)
	{
		this.x = x;
		this.y = y;
	}
	
	public boolean isOver(int x, int y)
	{
		if(x> this.x && x < this.x+this.width &&
		   y>this.y && y< this.y + this.height)
			return true;
		return false;
	}
	

	public void addActionListener(MyActionListener listener)
	{
		//inicializa��o sob demanda
		if(this.vActionListener==null)
			this.vActionListener = new Vector<MyActionListener>();
			
		this.vActionListener.add(listener);
	}
	
	
	public void removeActionListener(MyActionListener listener)
	{
		if(this.vActionListener == null || 
			this.vActionListener.size()==0)
			return;
		
		this.vActionListener.remove(listener);		
	}
	
	protected void fireActionPerformed()
	{
		
		if(this.vActionListener == null)
			return;
		
		for(MyActionListener listener : this.vActionListener)
			listener.actionPerformed(this);
	}
	
	//eventos do mouse
	@Override
	public void mouseEntered(MouseEvent arg0)
	{
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseExited(MouseEvent arg0)
	{
		// TODO Auto-generated method stub
		
	}	

	@Override
	public void mouseClicked(MouseEvent me)
	{
		if(isOver(me.getX(), me.getY()))
			this.fireActionPerformed();
		
	}
	
	public void mouseMoved(MouseEvent me)
	{
		this.setSelected(isOver(me.getX(), me.getY()));
		
	}
	
	
	
	@Override
	public void mousePressed(MouseEvent arg0)
	{
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseReleased(MouseEvent arg0)
	{
		// nothing
		
	}
	@Override
	public void mouseDragged(MouseEvent arg0)
	{
		//nothing
		
	}

		
	//abstract methods
	public abstract void paint(Graphics g);
	
}
