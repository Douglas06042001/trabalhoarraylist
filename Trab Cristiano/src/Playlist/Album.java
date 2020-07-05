package Playlist;

import java.util.List;

public class Album {
	
	private String nomeAlbum;
	private String nomeCantor;
	private List<Musicas> musicasList;
	
	public Album(String nomeAlbum, String nomeCantor, List<Musicas> musicasList) {
		super();
		this.nomeAlbum = nomeAlbum;
		this.nomeCantor = nomeCantor;
		this.musicasList = musicasList;
	}
	
	public String getNomeAlbum() {
		return nomeAlbum;
	}
	
	public void setnomeAlbum(String nomeAlbum) {
		this.nomeAlbum = nomeAlbum;
	}
	
	public String getNomeCantor() {
		return nomeCantor;
	}
	
	public void setNomeCantor(String singer) {
		this.nomeCantor = singer;
	}
	
	public List<Musicas> getMusicasList() {
		return musicasList;
	}
	
	public void setSongList(List<Musicas> musicasList) {
		this.musicasList = musicasList;
	}
	
	@Override
	public String toString() {
		return nomeAlbum + "\t" + nomeCantor;
	}


}
