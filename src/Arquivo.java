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

    public static int[][] GuardaRegioes(String lastDate, Arvore arv){

        String[] norte = {"11", "12", "13", "14", "15", "16", "17"};
        String[] nordeste = {"21", "22", "23", "24", "25", "26", "27", "28", "29"};
        String[] sudeste = {"31", "32", "33", "35"};
        String[] sul = {"41", "42", "43"};
        String[] centro_oeste = {"50", "51", "52", "53"};
        int[][] acumulRegiao = new int[5][3];
        TipoNo no;

        for (int i = 0; i < norte.length; i++) {
            no = arv.Pesquisa(norte[i]+lastDate);
            acumulRegiao[0][0] += Integer.parseInt(no.dados.casosAcumulados); 
            acumulRegiao[0][1] += Integer.parseInt(no.dados.obitosAcumulados);
            acumulRegiao[0][2] += arv.Consultas(norte[i]+lastDate);
            arv.contadorPesquisa = 0;
        }

        for (int i = 0; i < nordeste.length; i++) {
            no = arv.Pesquisa(nordeste[i]+lastDate);
            acumulRegiao[1][0] += Integer.parseInt(no.dados.casosAcumulados); 
            acumulRegiao[1][1] += Integer.parseInt(no.dados.obitosAcumulados);
            acumulRegiao[1][2] += arv.Consultas(nordeste[i]+lastDate);
            arv.contadorPesquisa = 0;

        }

        for (int i = 0; i < sudeste.length; i++) {
            no = arv.Pesquisa(sudeste[i]+lastDate);
            acumulRegiao[2][0] += Integer.parseInt(no.dados.casosAcumulados); 
            acumulRegiao[2][1] += Integer.parseInt(no.dados.obitosAcumulados);
            acumulRegiao[2][2] += arv.Consultas(sudeste[i]+lastDate);
            arv.contadorPesquisa = 0;
        }

        for (int i = 0; i < sul.length; i++) {
            no = arv.Pesquisa(sul[i]+lastDate);
            acumulRegiao[3][0] += Integer.parseInt(no.dados.casosAcumulados); 
            acumulRegiao[3][1] += Integer.parseInt(no.dados.obitosAcumulados);
            acumulRegiao[3][2] += arv.Consultas(sul[i]+lastDate);
            arv.contadorPesquisa = 0;
        }

        for (int i = 0; i < centro_oeste.length; i++) {
            no = arv.Pesquisa(centro_oeste[i]+lastDate);
            acumulRegiao[4][0] += Integer.parseInt(no.dados.casosAcumulados); 
            acumulRegiao[4][1] += Integer.parseInt(no.dados.obitosAcumulados);
            acumulRegiao[4][2] += arv.Consultas(centro_oeste[i]+lastDate);
            arv.contadorPesquisa = 0;
        }

        return acumulRegiao;
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
