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
	        			key[linha][c] = lineArq[c];
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
	public static void qSort(String[][] mat, int inicio, int fim){
		int i, j, index; 
		String x;
		String[] aux = new String[1];
		i = inicio;
		j = fim;
		if(mat[i][4].equals("")) {
			x = mat[i][3]+mat[i][7];
			index = 3;
        } else {
        	x = mat[i][4]+mat[i][7];
        	index = 4;
        }
		do{
			while((mat[i][index]+mat[i][7]).compareToIgnoreCase(x) < 0 && i < fim) 
				i++;
			while((mat[j][index]+mat[j][7]).compareToIgnoreCase(x) > 0 && j > inicio) 
				j--;
			if(i <= j){
				aux = mat[i];
				mat[i] = mat[j];
				mat[j] = aux;
				i++;
				j--;
			}
		} while(i<=j);
		if(inicio < j)
			qSort(mat, inicio, j);
		if(i < fim)
			qSort(mat, i, fim);
	}

}
