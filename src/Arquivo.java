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
                for (int col = 0; col < 17; col++) {
                    try {
                        if (col == 5 || col == 6 || col == 8 || col == 9 || col > 13)
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

    public static int[][] GuardaRegioes(String lastDate, Arvore arv) {

        String[] norte = {"11", "12", "13", "14", "15", "16", "17"};
        String[] nordeste = {"21", "22", "23", "24", "25", "26", "27", "28", "29"};
        String[] sudeste = {"31", "32", "33", "35"};
        String[] sul = {"41", "42", "43"};
        String[] centro_oeste = {"50", "51", "52", "53"};
        int[][] guardaRegioes = new int[5][3];
        TipoNo no;

        for (int i = 0; i < norte.length; i++) {
            no = arv.Pesquisa(norte[i] + lastDate);
            guardaRegioes[0][0] += Integer.parseInt(no.dados.casosAcumulados);
            guardaRegioes[0][1] += Integer.parseInt(no.dados.obitosAcumulados);
            guardaRegioes[0][2] += arv.Consultas(norte[i] + lastDate);
            arv.contadorPesquisa = 0;
        }

        for (int i = 0; i < nordeste.length; i++) {
            no = arv.Pesquisa(nordeste[i] + lastDate);
            guardaRegioes[1][0] += Integer.parseInt(no.dados.casosAcumulados);
            guardaRegioes[1][1] += Integer.parseInt(no.dados.obitosAcumulados);
            guardaRegioes[1][2] += arv.Consultas(nordeste[i] + lastDate);
            arv.contadorPesquisa = 0;

        }

        for (int i = 0; i < sudeste.length; i++) {
            no = arv.Pesquisa(sudeste[i] + lastDate);
            guardaRegioes[2][0] += Integer.parseInt(no.dados.casosAcumulados);
            guardaRegioes[2][1] += Integer.parseInt(no.dados.obitosAcumulados);
            guardaRegioes[2][2] += arv.Consultas(sudeste[i] + lastDate);
            arv.contadorPesquisa = 0;
        }

        for (int i = 0; i < sul.length; i++) {
            no = arv.Pesquisa(sul[i] + lastDate);
            guardaRegioes[3][0] += Integer.parseInt(no.dados.casosAcumulados);
            guardaRegioes[3][1] += Integer.parseInt(no.dados.obitosAcumulados);
            guardaRegioes[3][2] += arv.Consultas(sul[i] + lastDate);
            arv.contadorPesquisa = 0;
        }

        for (int i = 0; i < centro_oeste.length; i++) {
            no = arv.Pesquisa(centro_oeste[i] + lastDate);
            guardaRegioes[4][0] += Integer.parseInt(no.dados.casosAcumulados);
            guardaRegioes[4][1] += Integer.parseInt(no.dados.obitosAcumulados);
            guardaRegioes[4][2] += arv.Consultas(centro_oeste[i] + lastDate);
            arv.contadorPesquisa = 0;
        }

        return guardaRegioes;
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

        String linhaTemp2 = linhaTemp[0].split("_")[5];
        String[] meses = {"jan", "fev", "mar", "abr", "mai", "jun", "jul", "ago", "set", "out", "nov", "dez"};
        String ultimaData;
        ultimaData = linhaTemp2.substring(5, 9) + '-';

        for (int i = 0; i < meses.length; i++) {
            if (meses[i].equalsIgnoreCase(linhaTemp2.substring(2, 5))) {
                if (i + 1 < 10)
                    ultimaData += "0" + (i + 1) + '-';
                else
                    ultimaData += (i + 1) + '-';
                break;
            }
        }

        ultimaData += linhaTemp2.substring(0, 2);
        return ultimaData;
    }

}
