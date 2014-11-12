package game;

public class Suspeito {
	private String nome;
	private String funcao;
	private String causo;
	
	public String contarHistoria(){
		return this.causo;
	}
	@Override
	public String toString() {
		return "["+"nome:"+this.nome+","+"funcao:"+this.funcao+"]";
	}
}
