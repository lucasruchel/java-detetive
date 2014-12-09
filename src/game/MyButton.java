package game;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.event.MouseEvent;

import base.MyLabel;




public class MyButton extends MyLabel
{	
	private boolean flagActivated;
    private Color disabledColor;
	
    private void init()
    {
    	super.selectedColor = Color.LIGHT_GRAY;
		this.flagActivated = true;
		this.disabledColor = Color.DARK_GRAY;
    }
	public MyButton() 
	{
		super();
		init();
		this.setBackgroundSelectedColor(Color.DARK_GRAY);
	}
	
	public MyButton(int x, int y,String txt)
	{
		super(txt, x, y);
		init();
		
		
	}
	
	public boolean isActivated() 
	{
		return flagActivated;
	}
	public void setActivated(boolean flagActivated) 
	{
		this.flagActivated = flagActivated;
	}
	
	public Color getDisabledColor() 
	{
		return disabledColor;
	}
	
	public void setDisabledColor(Color disabledColor)
	{
		this.disabledColor = disabledColor;
	}
	
	public void paint(Graphics g)
	{
		FontMetrics fm = g.getFontMetrics();
		int max = (fm.stringWidth(this.getTxt()));
		this.setWidth(max);
		this.setHeight(fm.getDescent()+20);
		
		
		if (!isActivated())
		{
			Color old = this.getBackgroundColor();
			this.setBackgroundColor(this.disabledColor);
			super.paint(g);
			this.setBackgroundColor(old);
		}
		else
			super.paint(g);
	}	
	
}
