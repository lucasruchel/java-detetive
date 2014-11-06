package game;

public class ArmaDoCrime {
	private String descricao;
	private Suspeito assassino;

	public ArmaDoCrime(Suspeito assassino, String descricao){
		this.descricao = descricao;
		this.assassino = assassino;
	}
	public String getDescricao() {
		return descricao;
	}
	public Suspeito getAssassino() {
		return assassino;
	}
}
