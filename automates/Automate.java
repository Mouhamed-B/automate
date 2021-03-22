package automates;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;


public class Automate{

	public static Scanner sc = new Scanner(System.in);
	ArrayList<Character> alphabet;
	ArrayList<Etat> ensEtat;
	
	
	
	public Automate(String file) {
		lireFichier(file);
		
	}
	
	
	//METHODE QUI PERMET DE CONSTRUIRE UN AUTOMATE A PARTIR D'UN FICHIER PASSE EN ARGUMENT
	private void lireFichier(String f) {
		alphabet = new ArrayList<>();
		ensEtat = new ArrayList<>();
		try
	    {
	      
	      File file = new File("file.txt");    
	      FileReader fr = new FileReader(file);         
	      BufferedReader br = new BufferedReader(fr);     
	      String line;
	      char c = ' ';
	      int number = 0;
	      for(int j = 1; (line = br.readLine()) != null  ; j++) {
	    	  //alphabet
	    	  if(j == 1) {
	    		  for(int i = 0 ; i < line.length(); i++) {
					 c = line.charAt(i);
					 if(c != ' ') {
						 alphabet.add(c);
					 }
		    	  }
	    		  
	    	  }
	    	  //etat
	    	  else if(j == 2) {
	    		  for(int i = 0 ; i < line.length(); i++) {
						 c = line.charAt(i);
						 if(c != ' ') {
							 number = c - '0';
							 ensEtat.add(new Etat(number));
						 }
			    	  }
	    		  
	    	  }
	    	  //etat initiaux
	    	  else if(j == 3) {
	    		  for(int i = 0 ; i < line.length(); i++) {
	    			  c = line.charAt(i);
	    			  for (Etat e : ensEtat) {
	    				  if(c != ' ') {
							 number = c - '0';
							 if(e.numero == number) {
									 e.setEstInitial();
								 }
						}
					}
	    		  }  
	    	 }
	    	  //etat finaux
	    	  else if(j == 4) {
	    		  for(int i = 0 ; i < line.length(); i++) {
	    			  c = line.charAt(i);
	    			  for (Etat e : ensEtat) {
	    				  if(c != ' ') {
							 number = c - '0';
							 if(e.numero == number) {
									 e.setEstFinal();
							 }
						}
					}
	    		  }  
	    	  }
	    	  //transition
	    	  else if( j > 4){
	    		 for ( Etat e : ensEtat) {
					if(e.numero == (line.charAt(0)-'0')) {
						e.ajouterTransition(line.charAt(2), (line.charAt(4)-'0'));
					}
				}
	    		  
	    	  }
	    	  
	      }
	     
	      fr.close();    
	       
	    }
	    catch(IOException e)
	    {
	      e.printStackTrace();
	    }
		
	}
	
	//PRESENTER L'AUTOMATE
	public void afficherAutomate() {
		System.out.print(" Alphabet  : (");
		for (Character c : alphabet) {
			System.out.print(" "+c+" ");
		}
		System.out.println(") ");
		System.out.print("ensemble des etat : [ ");
		for (Etat e : ensEtat) {
			e.afficherNumeroEtat();
			System.out.print(" ");
		}
		System.out.print("] \n");
		System.out.print("ensemble des etat initiaux: [ ");
		for (Etat e : ensEtat) {
			if(e.isEstInitial()) {
				e.afficherNumeroEtat();
				System.out.print(" ");
			}
			
		}
		System.out.print("] \n");
		System.out.print("ensemble des etat finaux: [ ");
		for (Etat e : ensEtat) {
			if(e.isEstFinal()) {
				e.afficherNumeroEtat();
				System.out.print(" ");
			}
			
		}
		System.out.print("] \n");
		System.out.println("les transitions : ");
		for (Etat e : ensEtat) {
			e.afficherTransition();
			
		}
	}
	
	
	//METHODE POUR RECCUPER LE NUMERO DE ETAT SUIVANT A L'initial
	public int numeroEtat(Etat e, char c) {
		int succ = 0;
		if(e.transition.containsKey(c)) {
			succ = e.transition.get(c);
		}
		return succ;
		
	}
	
	//METHODE POUR RECCUPER LE STATU FINAL
	public boolean retourStatu(int n) {
		boolean rep = false;
		for (Etat e : ensEtat) {
			if(e.numero == n) {
				rep = e.isEstFinal();
				break;
			}
			
		}
		return rep;
	}
	
	
	//METHODE QUI PREND EN ENTREE UN MOT ET DIT SI LE MOT EST VALIDE OU PAS
	public boolean reconnaitreMot(String mot) {
		char c = ' ';
		boolean rep = false;
		int succ = -1;
		int prec = -1;
		c = mot.charAt(0);
		//recuperer le successeur de l'etat initial
		for (Etat e : ensEtat) {
			if(e.isEstInitial()) {
				prec = e.numero;
				succ = numeroEtat(e, c);
				rep = retourStatu(succ);
				break;
			}
			
		}
		
		System.out.println( prec +" ' "+ c +" '  -> "+ succ);
		for (int i = 1; i < mot.length(); i++) {
			c = mot.charAt(i);
			for (Etat e : ensEtat) {
				if(e.numero == succ) {
					prec = succ;
					succ = numeroEtat(e, c);
					rep = retourStatu(succ);
					System.out.println( prec +" ' "+ c +" '  -> "+ succ);
					break;
				}		
			}	
		}
		
		
		return rep;
		
	}
	
	
	
	
	
		
}
