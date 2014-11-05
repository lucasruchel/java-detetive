package base;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.geom.Rectangle2D;

public class MyLabel extends MyComponent //heran�a
{
	
	private String txt;
	private Color txtColor;
	private Font font;
	
	
	private Color backgroundColor;
	private Color backgroundSelectedColor;
	
	private boolean flagBorda;
	private Color borderColor;
	
	
	
	public MyLabel()
	{
		super();
		this.txt = "Label";
		this.font = new Font(Font.SANS_SERIF,Font.PLAIN,10);
		this.flagBorda = true;
		this.backgroundColor = new Color(82,172,239);
		this.txtColor = Color.BLACK;
		this.backgroundSelectedColor = new Color(80,170,236);
		this.borderColor = new Color(83,58,224);
		
	}
	
	public MyLabel(String txt)
	{
		this();//invoca o construtor padr�o
		this.setLabel(txt);
	}
	
	public MyLabel (String txt, int x, int y)
	{
		this();
		this.setLabel(txt);
		this.setPosition(x,y);
	}
	
	public Color getBorderColor()
	{
		return borderColor;
	}

	public void setBorderColor(Color borderColor)
	{
		this.borderColor = borderColor;
	}

	
	
	public void hasBorder(boolean flag)
	{
		this.flagBorda = flag;
	}
	
	public Color getBackgroundColor()
	{
		return backgroundColor;
	}

	public void setBackgroundColor(Color backgroundColor)
	{
		this.backgroundColor = backgroundColor;
	}

	public Color getBackgroundSelectedColor()
	{
		return backgroundSelectedColor;
	}

	public void setBackgroundSelectedColor(Color backgroundSelectedColor)
	{
		this.backgroundSelectedColor = backgroundSelectedColor;
	}

	public void setLabel(String txt)
	{
		this.txt = txt;
	}
	
	public void setFont(Font font)  // sobrecarga - polimorfismo est�tico
	{
		this.font = font;
	}
	public void setFont(String name)
	{
		this.font = new Font(name, this.font.getStyle(), this.font.getSize());
	}
	
	public void setFontColor(Color color)
	{
		this.txtColor = color;
	}
	
	public void setFontColor(int r, int g, int b)
	{
		this.txtColor = new Color(r,g,b);
	}
	
	public void setFontSize(int size)
	{
		this.font = new Font(this.font.getName(),this.font.getStyle(), size);
	}
	
	public void setFontStyle(int style)
	{
		this.font = new Font(this.font.getName(),style, this.font.getSize());
	}
	
	public void paint(Graphics g)
	{
		if(!isVisible())
			return;
		
		Font oldFont = g.getFont();
		Color oldColor = g.getColor();
		
		g.setFont(this.font);
		FontMetrics fm = g.getFontMetrics();
		Rectangle2D rect = fm.getStringBounds(this.txt, g);
		
		if (this.isSelected())
			g.setColor(this.selectedColor);
		else
			g.setColor(this.backgroundColor);
		g.fillRect(x, y, width, height);
		
		g.setColor(this.txtColor);
		g.drawString(txt, x+4, y+height/2+(int)rect.getHeight()/2);
		
		g.setColor(Color.BLACK);
		if(flagBorda)
			g.drawRect(x,  y, width, height );
			
		g.setFont(oldFont);
		g.setColor(oldColor);
	}
}
