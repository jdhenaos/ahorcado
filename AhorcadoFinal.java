/*
 * This is a exercise
 * created by:
 * Bradember Yesid Beltran Cardozo: bybeltranc@unal.edu.co
 * Juan David Henao Sanchez: judhenaosa@unal.edu.co
 */

package AhorcadoFinal;

import java.util.Random;
import java.util.Scanner;

public class AhorcadoFinal {
	
	public static void main(String[] args) {
		
		Random ran = new Random();
		int random = ran.nextInt(10) + 1;
		String palabra = "";
		switch(random){
		case 1: palabra = "plato";
		break;
		case 2: palabra = "hola";
		break;
		case 3: palabra = "cargo";
		break;
		case 4: palabra = "arbol";
		break;
		case 5: palabra = "casa";
		break;
		case 6: palabra = "vela";
		break;
		case 7: palabra = "cielo";
		break;
		case 8: palabra = "gato";
		break;
		case 9: palabra = "lapiz";
		break;
		case 10: palabra = "luz";
		break;
		}
		
		char[] palabra0 = palabra.toCharArray();
		int counter0 = palabra0.length;
		System.out.print("Hola, hoy jugaremos ahorcado.\n");
		System.out.print("Solo podras equivocarte 7 veces.\n");
		char[] palabra_secreta = new char[palabra0.length];
		char[] intentos = new char[palabra0.length + 7 ];
		
		for (int i = 0; i<intentos.length; i++){
			intentos[i] = ' ';
		}
		
		int longitud = palabra0.length;
		System.out.println("La palabra que debes advinar posee "+longitud+" letras");
		
		for(int s = 0;s<palabra_secreta.length;s++){
			palabra_secreta[s]='_';
		}
		
		Scanner reader = new Scanner(System.in);
		String letra;
		
		char[] palabra1 = palabra.toCharArray();
		char[] palabra2 = palabra1;
			
		for(int s = 0 ; s < palabra_secreta.length ; s++){
			palabra_secreta[s] = '_';
			System.out.print(palabra_secreta[s] + " ");
		}
		
		char e = 'q';
		int counter4 = 0;
		int counter6 = 0;
		int counter7 = 0;
		String muere1 = "";
		
		while(counter4 != 7){
			System.out.printf("\nIntroduce una letra:\n");
			letra = reader.nextLine();
			char[] charletra = letra.toCharArray();
			
			for(int x = 0; x<palabra2.length;x++){
				if(charletra[0] == palabra0[x]){
					palabra_secreta[x]=charletra[0];
				}
			}
			
			if(palabra.indexOf(letra) < 0){
				char[] muere = {'(','X','_','X',')','p'};
				for(int counter3 = 1 ; counter3 <= counter4 ; counter3++){
					String muere0 = new String(muere, 0 , counter3);
					muere1 = muere0;
					if(counter3 == 6){
						System.out.printf(e+"%s\n", muere1);
						System.out.print("Has perdido.\nLa palabra que buscabas era: \n");
						System.out.printf("%s\n",palabra);
						System.exit(0);
					}
				}
				
				counter4++;
				
			}
			
			for(int i = 0; i<palabra_secreta.length;i++){
				System.out.print(palabra_secreta[i]+" ");
			}
			
			for(int s = 0; s<=counter6;s++){
				if(intentos[s] == ' '){
					intentos[s] = charletra[0];
					break;
				}else{
					if(intentos[s] == charletra[0]){
						break;
					}
				}
			}
			counter6++;
			System.out.print("\n");
			if(counter4 == muere1.length()+1){
				System.out.printf(e+"%s\n", muere1);
			}
			
			System.out.print("Las letras usadas son: ");
			System.out.print(intentos);
			
			for(int a = 0 ; a < counter0 ; a++){
				if(palabra_secreta[a] == '_'){
					counter7++;
					break;
				}else{
					counter7=0;
				}
			}
			
			if(counter7 == 0){
				System.out.print("\nHAS GANADO");
				System.exit(0);
			}
		}
		
		reader.close();
		
	}
}