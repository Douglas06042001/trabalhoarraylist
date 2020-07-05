package Playlist;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Scanner;

public class Player {
	
	static List<Musicas> playList = new LinkedList<>();
	static ListIterator<Musicas> iterator;
	static boolean avancar;
	static Musicas atual;
    static Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		List<Album> albumList = criarAlbumList();
		
		ExibirAlbumMusica(albumList);
		
		addMusicasPlayList(albumList);
		
		musicasList();
		
		System.out.println("Iniciando playlist..\n");
		iterator = playList.listIterator();
		if (iterator.hasNext()) {
			atual = iterator.next();
			System.out.println("Tocando >> " + atual);
			
			boolean sair = false;
			avancar = true;
			System.out.println("");
			
			
			menu();
			while (!sair) {
				String opcao = null;
				System.out.print("Digite a opção : ");
				opcao = scanner.next();
				System.out.println("");
				
				switch (opcao) {
				case "S":
					System.out.println("FIM");
					sair = true;
					break;
				case "A":
					avançar();
					break;
				case "V":
					voltar();
					break;
				case "P":
					pausar();
					break;
				
				default:
					break;
				}
			}
		} else {
			System.err.println("Nenhuma música na playlist..");
		}
	}

	private static List<Album> criarAlbumList() {
		List<Album> albumList = new ArrayList<>();
		List<Musicas> musicasList = new ArrayList<>();
		
		musicasList.add(new Musicas("Enter Sandman","5:30"));
		musicasList.add(new Musicas("The Unforgiven","6:27"));
		musicasList.add(new Musicas("Nothing Else Matters","6:28"));
		musicasList.add(new Musicas("Wherever I May Roam","6:47"));
		musicasList.add(new Musicas("Sad But True","5:24"));	
		albumList.add(new Album("Metallica", "Metallica", musicasList));
		
		musicasList = new ArrayList<>();
		musicasList.add(new Musicas("Bohemian Rhapsody", "5:55"));
		musicasList.add(new Musicas("You are My Best Friend", "2:52"));
		albumList.add(new Album("A Night at Opera", "Queen", musicasList));
		
		musicasList = new ArrayList<>();
		musicasList.add(new Musicas("Consideration", "2:41"));
		musicasList.add(new Musicas("James Joint", "1:12"));
		musicasList.add(new Musicas("Kiss It Better", "4:13"));
		musicasList.add(new Musicas("Work", "3:39"));
		albumList.add(new Album("ANTI", "Rihanna", musicasList));
		
		return albumList;
	}

	private static void addMusicasPlayList(List<Album> albumList) {
		int albumNumero  = -1;
		int musicaNumero = -1;
		boolean fimAddMusicas = false;
		System.out.println("\n\nEscolha a música a partir do Album\n");
		while (!fimAddMusicas ) {
			System.out.print("Escolher número do albúm (Digite 0 para iniciar a playlist) : ");
			try {
				albumNumero = scanner.nextInt();
				scanner.nextLine();
				if (albumNumero  == 0) {
					fimAddMusicas  = true;
				} else if(albumNumero  > 0 && albumNumero  <= albumList.size()) {
					List<Musicas> songs = albumList.get(albumNumero -1).getMusicasList();
					System.out.print("Escolher número da música: ");
					try {
						musicaNumero = scanner.nextInt();
						scanner.nextLine();
						if(musicaNumero > 0 && musicaNumero <= songs.size()) {
							playList.add(songs.get(musicaNumero-1));
						} else {
							System.err.println("Escolha inválida ..");
						}
					} catch (Exception e) {
						System.out.println(e);
					}
				} else {
					System.err.println("Escolha inválida ..");
				}
			} catch (Exception e) {
				System.out.println(e);
			}
		}
	}

	private static void ExibirAlbumMusica(List<Album> albumList) {
		ListIterator<Album> albumIterator = albumList.listIterator();
		ListIterator<Musicas> musicasIterator;
		System.out.println("\nMúsicas para adicionar: \n");
		while (albumIterator.hasNext()) {
			Album album = (Album) albumIterator.next();
			System.out.println("********************************************");
			System.out.println("\nAlbum [" + albumIterator.nextIndex() + "] : " + album+"\n");
			musicasIterator = album.getMusicasList().listIterator();
			while (musicasIterator.hasNext()) {
				Musicas musica = (Musicas) musicasIterator.next();
				System.out.println("Música [" + musicasIterator.nextIndex() + "] : " + musica);
			}
			System.out.println();
		}
		System.out.println();
	}


	private static void musicasList() {
		System.out.println("\n--- PlayList ---\n");
		for (Musicas musica : playList) {
			System.out.println(musica);
		}
		System.out.println("");
		System.out.println("--------------------");
	}

	private static void pausar() {
		System.out.println("Tocando >> " + atual);
	}

	private static void voltar() {
		if (!avancar) {
			if (iterator.hasPrevious()) {
				atual= iterator.previous();
				System.out.println("Tocando >> " + atual);
			} else {
				System.out.println("Início da playlist..\n");
			}
		} else {
			if (iterator.hasPrevious()) {
				iterator.previous();
				if (iterator.hasPrevious()) {
					atual = iterator.previous();
					System.out.println("Tocando >> " + atual);
					avancar = false;
				} else {
					System.out.println("Fim da playlist..\n");
				}
			} else {
				System.out.println("Fim da playlist..");
			}
		}
	}

	private static void avançar() {
		if (avancar) {
			if (iterator.hasNext()) {
				atual = iterator.next();
				System.out.println("Tocando >> " + atual);
			} else {
				System.out.println("Fim da playlist..");
			}
		} else {
			if (iterator.hasNext()) {
				iterator.next();
				if (iterator.hasNext()) {
					atual = iterator.next();
					System.out.println("Tocando >> " + atual);
					avancar = true;
				} else {
					System.out.println("Fim da playlist..");
				}
			} else {
				System.out.println("Fim da playlist..");
			}
		}
	}

	private static void menu() {
		System.out.println("--- Player Menu  ---\n");
		System.out.println("(S). Sair");
		System.out.println("(P). Pausar");
		System.out.println("(A). Avançar");
		System.out.println("(V). Voltar");		
		System.out.println("");
		System.out.println("--------------------");
	}

}
