import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class LerArquivo {
	public static String line = "";
	
	public static int qtdLinhas(String path, int contLine, int coluna) throws FileNotFoundException {
		BufferedReader br = new BufferedReader(new FileReader(path));
    	
    	try {
			while ((line = br.readLine()) != null) {
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
}
