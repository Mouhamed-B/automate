import automaton.Automaton;
import java.util.Scanner;

public class App {
    public static void main (String[]args){
		
		Automaton res;
		String filepath;
		Scanner scan = new Scanner(System.in);

		System.out.println("Chemin du fichier de l'automate : ");
		filepath = scan.next();

		try {
			res= new Automaton(filepath);
			res.afficherAutomate();
		} catch (Exception e) {
			System.err.println("Fichier non valide");
		}
		
	}
}