package automaton;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Automaton {
    
    ArrayList<Character> alphabet;
    ArrayList<Integer> ensEtat;
    ArrayList<Integer> ensInitial;
    ArrayList<Integer> ensFinal;
    char[][]transition;
    
    
    public Automaton(String f) {
        lireFichier(f);
    }
       
    //METHODE QUI PERMET DE CONSTRUIRE UN AUTOMATE A PARTIR D'UN FICHIER PASSE EN ARGUMENT
    private void lireFichier(String f) {
        alphabet = new ArrayList<Character>();
        ensEtat = new ArrayList<Integer>();
        ensInitial = new ArrayList<Integer>();
        ensFinal = new ArrayList<Integer>();
        transition = new char[80][80];
        for(int i = 0; i< 20; i++)
        {
            for(int j = 0; j < 20 ; j++)
            {
                transition[i][j] = '0';
            }
        }
        try
        {
            
            File file = new File(f);    
            FileReader fr = new FileReader(file);         
            BufferedReader br = new BufferedReader(fr); 
            String line;
            
            for(int i = 1; (line = br.readLine()) != null ; i++) 
            {
                if(i == 1) 
                {
                    for(int j = 0; j<line.length(); j++)
                    {
                        alphabet.add(line.charAt(j));
                    }
                }
                else if(i == 2)
                {
                    for(int j = 0; j<line.length(); j++)
                    {
                        ensEtat.add((line.charAt(j)-'0'));
                    }
                }
                else if(i == 3)
                {
                    for(int j = 0; j<line.length(); j++)
                    {
                        ensInitial.add((line.charAt(j)-'0'));
                    }
                }
                else if(i == 4)
                {
                    for(int j = 0; j<line.length(); j++)
                    {
                        ensFinal.add((line.charAt(j)-'0'));
                    }
                }
                else
                {
                    transition[(line.charAt(0) - '0')][(line.charAt(2) - '0')] = line.charAt(1);
                }
            }
            
            br.close();
            fr.close();  
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
        
    }
        
    //Afficher l'automates
    public void afficherAutomate() {
        System.out.print("Alphabet : [ ");
        for (Character i : alphabet) {
            System.out.print(" "+ i+ " ");
        }
        System.out.print(" ] \n");
        
        System.out.print("etat initiaux : [ ");
        for (Integer i : ensEtat) {
            System.out.print(" "+ i+ " ");
        }
        System.out.print(" ] \n");
        
        
        System.out.print("etat initiaux : [ ");
        for (Integer i : ensInitial) {
            System.out.print(" "+ i+ " ");
        }
        System.out.print(" ] \n");
        
        System.out.print("etat final : [ ");
        for (Integer i : ensFinal) {
            System.out.print(" "+ i+ " ");
        }
        System.out.print(" ] \n");
        
        System.out.println("transition");
        for (int i = 0 ; i < ensEtat.size() ; i++) {
            for (int j = 0 ; j < ensEtat.size() ; j++) {
                System.out.print(transition[i][j]+"\t");
            }
            System.out.println("\n");
        }
    }    
    
}
