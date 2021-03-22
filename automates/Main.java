package automates;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Automate a = new Automate("file.txt");
		a.afficherAutomate();
		System.out.println("Entrer un mot");
		String mot = sc.nextLine();
		if(a.reconnaitreMot(mot)) {
			System.out.println("le mot est reconnu");
		}else {
			System.out.println("Le mot n'est pas reconnu");
		}
		sc.close();
		
	}

}
