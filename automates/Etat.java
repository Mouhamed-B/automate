package automates;

import java.util.HashMap;
import java.util.Map;

public class Etat {
	
	public int numero; 
	private boolean estInitial;
	private boolean estFinal;  
	public HashMap<Character, Integer> transition; 
	
	public Etat(int numero) {
		this.numero = numero;
		this.estInitial = false;
		this.estFinal = false;
		transition = new HashMap<>();
		
	}

	public boolean isEstInitial() {
		return estInitial;
	}

	public void setEstInitial() {
		this.estInitial = true;
	}

	public boolean isEstFinal() {
		return estFinal;
	}

	public void setEstFinal() {
		this.estFinal = true;
	}
	
	public void ajouterTransition(char c, int j) {
		transition.put(c, j);
	}
	
	//Afficher etat 
	public void afficherNumeroEtat() {
		System.out.print(this.numero);
	}
	
	@SuppressWarnings("rawtypes")
	public void afficherTransition() {
		for (Map.Entry m : transition.entrySet()) {
			System.out.print(this.numero+ " , ");
            System.out.print(m.getKey()+" , "+m.getValue());
            System.out.println(" ");
        }
	}
	
	
	
	
	
	
	
	 

}
