package Playlist;

public class Musicas {
	
	private String nome;
	private String tempoMusica;
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getTempoMusica() {
		return tempoMusica;
	}
	
	public void setTempoMusica(String tempoMusica) {
		this.tempoMusica = tempoMusica;
	}
	
	public Musicas(String nome, String tempoMusica) {
		super();
		this.nome = nome;
		this.tempoMusica = tempoMusica;
	}
	
	@Override
	public String toString() {
		return nome + "\t" + tempoMusica;
	}

}
