package game;

import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Suspeito {
	private String nome;
	private String funcao;
	private String causo;
	private Image foto;
	
	public Suspeito(String nome,String funcao, String causo, String foto) {
		this.nome = nome;
		this.funcao = funcao;
		this.causo = causo;
		loadImage(foto);
	}
	public void loadImage(String image){
		try 
		{
		    this.foto = ImageIO.read(new File(image));
		} 
		catch (IOException e) 
		{
		    e.printStackTrace();
		}
	}
	
	
	public Image getFoto() {
		return foto;
	}
	public void setFoto(Image foto) {
		this.foto = foto;
	}
public String contarHistoria(){
		return this.causo;
	}
	
	@Override
	public String toString() {
		return "["+"nome:"+this.nome+","+"funcao:"+this.funcao+"]";
	}
}
