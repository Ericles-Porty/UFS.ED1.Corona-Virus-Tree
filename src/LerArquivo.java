import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class LerArquivo {
	public static String line = "";
	
	public static int qtdLinhas(String path, int contLine, int coluna) throws FileNotFoundException {
		BufferedReader br = new BufferedReader(new FileReader(path));
		//String[] lineArq; 
		
    	try {
			while ((line = br.readLine()) != null) {
				/*lineArq = line.split(";");
				if(lineArq[4].equalsIgnoreCase(""))
					continue;*/
				contLine++;
			}
    	} catch (Exception e) {
    		e.printStackTrace();
		}
    	
    	return contLine;
	}
	
	public static int readFile(String path,  int linha, String[][] key, int coluna) throws FileNotFoundException {
    	String[] lineArq; 
    	
    	BufferedReader ar = new BufferedReader(new FileReader(path));
    	
    	int ft=0;
    	try {
			while ((line = ar.readLine()) != null) {
				if(ft == 0) {
					ft++;
					continue;
				}
				lineArq = line.split(";");
				/*if(lineArq[4].equalsIgnoreCase(""))
					continue;*/
	        	for(int c = 0; c < coluna; c++) {
	        		try {
	        			key[c][linha] = lineArq[c];
	        		}catch (ArrayIndexOutOfBoundsException e) {
	                    continue;
	                }	
	        	}
	        	linha += 1;   
	        }
		} catch (FileNotFoundException e) {
            e.printStackTrace();

        } catch (IOException e) {
            e.printStackTrace();
        }
    	return linha;
	}
	// Método para ordenar a matriz
	/*public void qSort(String[][] vetor, int inicio, int fim){
		int i, j, x, aux;
		i = inicio;
		j = fim;
		x = vetor[i];
		do{
			while(vetor[i] < x && i < fim) 
				i++;
			while(vetor[j] > x && j > inicio) 
				j--;
			if(i<=j){
				aux = vetor[i];
				vetor[i] = vetor[j];
				vetor[j] = aux;
				i++;
				j--;
			}
		} while(i<=j);
		if(inicio < j)
			qSort(vetor, inicio, j);
		if(i < fim)
			qSort(vetor,i,fim);
	}*/

}
