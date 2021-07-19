import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Arquivo {
    public static String linhaTemp = "";

    public static int ContaLinhas(String path, int quantidadeDeLinhas) throws FileNotFoundException {
        BufferedReader abreArquivo = new BufferedReader(new FileReader(path));

        try {
            while ((linhaTemp = abreArquivo.readLine()) != null) {
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
        int firstTime = 0; // Serve pra pular o cabecalho do excel
        try {
            while ((Arquivo.linhaTemp = abreArquivo.readLine()) != null) {
                if (firstTime == 0) {
                    firstTime++;
                    continue;
                }
                linhaTemp = Arquivo.linhaTemp.split(";");
                int indiceColuna = 0;
                for (int col = 0; col < quantidadeDeColunas; col++) {
                    try {
                        if (col == 5 || col == 6 || col == 8 || col == 9 || col == 14 || col == 15 || col == 16)
                            continue;
                        key[indiceLinha][indiceColuna++] = linhaTemp[col];
                    } catch (ArrayIndexOutOfBoundsException e) {
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
            x = matriz[i][3] + matriz[i][5];
            index = 3;
        } else {
            x = matriz[i][4] + matriz[i][5];
            index = 4;
        }
        do {
            while ((matriz[i][index] + matriz[i][5]).compareToIgnoreCase(x) < 0 && i < fim)
                i++;
            while ((matriz[j][index] + matriz[j][5]).compareToIgnoreCase(x) > 0 && j > inicio)
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

    public static String PegaLastDate(String path) {
        String[] linhaTemp = path.split(".csv");

        String dataDir = linhaTemp[0].split("_")[5];
        String[] meses = {"jan", "fev", "mar", "abr", "mai", "jun", "jul", "ago", "set", "out", "nov", "dez"};
        String lastDate;
        lastDate = dataDir.substring(5, 9) + '-';

        for (int i = 0; i < meses.length; i++) {
            if (meses[i].equalsIgnoreCase(dataDir.substring(2, 5))) {
                if (i + 1 < 10)
                    lastDate += "0" + (i + 1) + '-';
                else
                    lastDate += (i + 1) + '-';
                break;
            }
        }

        lastDate += dataDir.substring(0, 2);
        return lastDate;
    }

}
