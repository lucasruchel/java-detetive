package game;
import java.awt.Color;
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
	private Pista p1,p2,p3;
	private SuspeitoAdapter s1,s2,s3,s4,s5;
	private Suspeito susp1,susp2,susp3,susp4,susp5;
	private Caso caso;
	private ContemDicas dicasDisplay;
	private MyButton bSubmete;
	private SuspeitoListener submeteAction;
	private EndGame fim;
	
	
	//metodo de trabalho (helper)
	private void createGUI()
	{
	
		
		//Estáticos
		this.jf = new JFrame("Meu Projeto");
		this.mp = new MyPanel();
		jf.getContentPane().add(mp);
		
		mp.setSize(1024, 768);
		mp.setPreferredSize(new Dimension(1024,768));
		jf.setResizable(false);
		
		//Instancia variaveis
		this.dicasDisplay = new ContemDicas(150,768);
		this.c1 = new Cena("Images/cena1.jpg",dicasDisplay);
		this.p1 = new Pista(190,250,100,100,"Papel em Branco");
		this.p2 = new Pista(350,470,100,100,"Pegada Nº 41");
		this.p3 = new Pista(450,400,100,100,"Coisas Jardineiro");
		
		this.susp1 = new Suspeito("Jair", "Jardineiro", "Regando Flores", "Images/char1.png");
		this.susp2 = new Suspeito("Beto", "Mordomo", "Fazendo Chá", "Images/char2.png");
		this.susp3 = new Suspeito("Will", "Segurança", "Estava Fazendo a Ronda", "Images/char3.png");
		this.susp4 = new Suspeito("Cristina", "Faxineira", "Estava Fazendo o Lanche", "Images/char4.png");
		this.susp5 = new Suspeito("Arnold", "Motorista", "Estava Na cidade", "Images/char5.png");
		
		this.s1 = new SuspeitoAdapter(200,10,100,100,susp1 );	
		this.s2 = new SuspeitoAdapter(200,10,100,100,susp2 );
		this.s3 = new SuspeitoAdapter(200,10,100,100,susp3 );
		this.s4 = new SuspeitoAdapter(200,10,100,100,susp4 );
		this.s5 = new SuspeitoAdapter(200,10,100,100,susp5 );
		
		//interfaces
		submeteAction = new SuspeitoListener(susp1);
		this.s1.addActionListener(submeteAction);
		this.s2.addActionListener(submeteAction);
		this.s3.addActionListener(submeteAction);
		this.s4.addActionListener(submeteAction);
		this.s5.addActionListener(submeteAction);
	
		
		
		//Adiciona ao caso
		this.caso = new Caso(0,0,1024,768,c1,dicasDisplay);
		this.caso.addSuspeitos(s1);
		this.caso.addSuspeitos(s2);
		this.caso.addSuspeitos(s3);
		this.caso.addSuspeitos(s4);
		this.caso.addSuspeitos(s5);
		
		this.caso.addActionListener(submeteAction);
		
		//Adiciona elementos
		this.mp.add(c1);
		
		c1.addPistas(p1);
		c1.addPistas(p2);
		c1.addPistas(p3);
		mp.add(caso);
		
		//botões de acoes
		
		this.bSubmete = new MyButton(200, 50, "Checa Resposta");
		
		
		this.bSubmete.setVisible(true);
		
		
		this.bSubmete.addActionListener(submeteAction);
		
		this.mp.add(bSubmete);
		
		
		this.fim = new EndGame(mp.getWidth(), mp.getHeight(), Color.gray);
		this.fim.setVisible(false);
		this.mp.add(fim);
		
		
		
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
				if(submeteAction.getCulpadoFlag()){
					this.fim.setVisible(true);
				}				
				Thread.sleep(33);
			}
			catch(InterruptedException ie)
			{
				ie.printStackTrace();
			}			
		}
	}
}
