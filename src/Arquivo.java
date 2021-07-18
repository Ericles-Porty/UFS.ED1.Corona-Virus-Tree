import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Arquivo {
    public static String line = "";

    public static int ContaLinhas(String path, int quantidadeDeLinhas) throws FileNotFoundException {
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

    public static int PreencheMatriz(String path, String[][] key, int indiceLinha, int quantidadeDeColunas)
            throws FileNotFoundException {
        String[] linhaTemp;

        BufferedReader abreArquivo = new BufferedReader(new FileReader(path));
        int firstTime = 0; // Serve pra pular o cabeçalho do excel
        try {
            while ((line = abreArquivo.readLine()) != null) {
                if (firstTime == 0) {
                    firstTime++;
                    continue;
                }
                linhaTemp = line.split(";");
                for (int indiceColuna = 0; indiceColuna < quantidadeDeColunas; indiceColuna++) {
                    try {
                        key[indiceLinha][indiceColuna] = linhaTemp[indiceColuna];
                    }catch (ArrayIndexOutOfBoundsException e){
                        continue;
                    }
                }
                indiceLinha += 1;
            }

            abreArquivo.close();
        } catch (IOException e) {
            e.printStackTrace();

        }
        return indiceLinha;
    }

    public static void QuickSort(String[][] matriz, int inicio, int fim) {
        int i, j, index;
        String x;
        String[] aux;
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
