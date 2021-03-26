import automaton.Automaton;

public class App {
    public static void main (String[]args){
		
		Automaton res;
		if(args.length==0) {
			System.out.println("Chemin du fichier de l'automate a tester attendu sur la ligne de commande");
		}
		for(int i=0;i<args.length;i++){
			System.out.println("Chaıne testee:"+args[i]);
			res= new Automaton(args[0]);
			res.afficherAutomate();
		}
	}
}