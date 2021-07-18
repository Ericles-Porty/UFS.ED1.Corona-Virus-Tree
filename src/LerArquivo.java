import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class LerArquivo {
	public static String line = "";

	public static int contaLinhas(String path, int quantidadeDeLinhas, int coluna) throws FileNotFoundException {
		BufferedReader abreArquivo = new BufferedReader(new FileReader(path));

		try {
			while ((line = abreArquivo.readLine()) != null) {
				quantidadeDeLinhas++;
			}
			abreArquivo.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return quantidadeDeLinhas;
	}

	public static int readFile(String path, int indiceLinha, String[][] key, int quantidadeDeColunas)
			throws FileNotFoundException {
		String[] lineArq;

		BufferedReader abreArquivo = new BufferedReader(new FileReader(path));
		int ft = 0;
		try {
			while ((line = abreArquivo.readLine()) != null) {
				if (ft == 0) {
					ft++;
					continue;
				}
				lineArq = line.split(";");
				for (int indiceColuna = 0; indiceColuna < quantidadeDeColunas; indiceColuna++) {
					try {
						key[indiceLinha][indiceColuna] = lineArq[indiceColuna];
					} catch (ArrayIndexOutOfBoundsException e) {
						continue;
					}
				}
				indiceLinha += 1;
			}
			
			abreArquivo.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();

		} catch (IOException e) {
			e.printStackTrace();
		}
		return indiceLinha;
	}

	// Método para ordenar a matriz
	public static void QuickSort(String[][] matriz, int inicio, int fim) {
		int i, j, index;
		String x;
		String[] aux = new String[1];
		i = inicio;
		j = fim;
		if (matriz[i][4].equals("")) {
			x = matriz[i][3] + matriz[i][7];
			index = 3;
		} else {
			x = matriz[i][4] + matriz[i][7];
			index = 4;
		}
		do {
			while ((matriz[i][index] + matriz[i][7]).compareToIgnoreCase(x) < 0 && i < fim)
				i++;
			while ((matriz[j][index] + matriz[j][7]).compareToIgnoreCase(x) > 0 && j > inicio)
				j--;
			if (i <= j) {
				aux = matriz[i];
				matriz[i] = matriz[j];
				matriz[j] = aux;
				i++;
				j--;
			}
		} while (i <= j);
		if (inicio < j)
			QuickSort(matriz, inicio, j);
		if (i < fim)
			QuickSort(matriz, i, fim);
	}

}
