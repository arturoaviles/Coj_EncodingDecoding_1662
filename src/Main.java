import java.util.ArrayList;
import java.util.Scanner;
import java.lang.StringBuilder;

public class Main {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int cases = s.nextInt();
		int cases_From_One = 1;
		while(cases>0){
			String unknown = s.next();
			String unknown2 = unknown + " ";
			//System.out.println(unknown);
			System.out.println("Case "+cases_From_One+": "+decoder(unknown2));
			cases_From_One++;
			cases--;
		}
		s.close();
	}
	
	public static String decoder(String encoded){
		StringBuilder decodedMessage = new StringBuilder();
		///////////////////////////////////////////////////
		char[] a = encoded.toCharArray();
		StringBuilder numero_Decenas_Centenas_Millares = new StringBuilder();
		ArrayList<Character> letras = new ArrayList<Character>(a.length);
		ArrayList<Integer> num = new ArrayList<Integer>(a.length);
		
		numero_Decenas_Centenas_Millares.append(0);
		int numeroTotal=0; // Puede tener unidades o decenas o etc.
		boolean bandera = false;
		
		
		for (int i = 0; i < a.length; i++) {
			if(Character.isLetter(a[i])){
				letras.add(a[i]);
				numeroTotal=Integer.parseInt(numero_Decenas_Centenas_Millares.toString());
				num.add(numeroTotal);
				numero_Decenas_Centenas_Millares.setLength(0);
				bandera = false;
			}else if(Character.isSpaceChar(a[i])){
				numeroTotal=Integer.parseInt(numero_Decenas_Centenas_Millares.toString());
				num.add(numeroTotal);
				break;
			}
			
			
			if(Character.isDigit(a[i]) && bandera == false){
				bandera = true;
				numero_Decenas_Centenas_Millares.append(a[i]);
			}else if(Character.isDigit(a[i]) && bandera == true){
				numero_Decenas_Centenas_Millares.append(a[i]);
			}
		}
		/////////////////////////////////////////////////////
		num.remove(0);
		int valor = 0;
		
		for (int i = 0; i < letras.size(); i++) {
			valor = num.get(i);
			while(valor>0){
				decodedMessage.append(letras.get(i));
				valor--;
			}
		}
		return decodedMessage.toString();
	}
}
