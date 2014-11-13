package game;

import java.awt.Image;

public class Suspeito {
	private String nome;
	private String funcao;
	private String causo;
	private Image foto;
	
	public Suspeito(String nome,String funcao, String causo, Image foto) {
		this.nome = nome;
		this.funcao = funcao;
		this.causo = causo;
		this.foto = foto;
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
