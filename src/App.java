import java.io.IOException;
import javax.swing.JOptionPane;

public class App {

    private final static int idArvoreBB = 0;
    private final static int idArvoreAVL = 1;

    public static String[] path = {
            System.getProperty("user.dir") + "\\BigData\\HIST_PAINEL_COVIDBR_2020_Parte1_07jul2021.csv",
            System.getProperty("user.dir") + "\\BigData\\HIST_PAINEL_COVIDBR_2020_Parte2_07jul2021.csv",
            System.getProperty("user.dir") + "\\BigData\\HIST_PAINEL_COVIDBR_2021_Parte1_07jul2021.csv",
            System.getProperty("user.dir") + "\\BigData\\HIST_PAINEL_COVIDBR_2021_Parte2_07jul2021.csv" };

    public static void main(String[] args) throws IOException {
        String lastDate = Arquivo.PegaLastDate(path[3]);
        System.out.println("Contando Linhas...");

        int quantidadeDeColunas = 10, quantidadeDeLinhas = 0;

        for (int i = 0; i < 4; i++) {
            quantidadeDeLinhas = Arquivo.ContaLinhas(path[i], quantidadeDeLinhas);
        }

        System.out.println("Preenchendo matriz...");
        String[][] matriz = new String[quantidadeDeLinhas][quantidadeDeColunas];

        int indiceLinha = 0;
        for (int i = 0; i < 4; i++) {
            indiceLinha = Arquivo.PreencheMatriz(path[i], matriz, indiceLinha, quantidadeDeColunas);
        }

        System.out.println("QuickSort...");
        Arquivo.QuickSort(matriz, 0, indiceLinha - 1);

        Arvore[] Floresta = new Arvore[2];
        Floresta[idArvoreBB] = new ArvoreBB();
        Floresta[idArvoreAVL] = new ArvoreAVL();

        System.out.print("\n\n ======== INSERCAO BINARIA ========\n");
        Floresta[idArvoreBB].raiz = null;
        System.out.println("Inserindo na arvore de busca binaria...");
        Floresta[idArvoreBB].InserirBIN(matriz, 0, indiceLinha - 1);

        System.out.print("========INSERINDO AVL========\n");
        Floresta[idArvoreAVL].raiz = null;
        System.out.println("Inserindo na arvore AVL...");
        Floresta[idArvoreAVL].InserirAVL(matriz, 0, indiceLinha);

        matriz = null; // joguem essas 2 linhas para baixo depois de jogarem a matriz na arvore
        System.gc(); // ela ta apagando a matriz pra limpar memoria

        // System.out.println("Digite a chave...");
        // String chave = JOptionPane.showInputDialog("Digite codmun ou coduf seguido da
        // data (aaaa-mm-dd)");

        // TipoNo no = Floresta[idArvoreBB].Pesquisa(chave+lastDate); //Codigo uf + data
        TipoNo no;
        // TipoNo no2;

        String chave;

        do {
            System.out.println("Digite a chave...");
            chave = JOptionPane.showInputDialog("Digite codmun ou coduf seguido da data (aaaa-mm-dd)");
            if (!chave.equals("0")) {
                System.out.println("Pesqusisa na Arvore Binaria:");
                no = Floresta[idArvoreBB].Pesquisa(chave); // Codigo mun + data
                if (no == null)
                    System.out.println("NOT FOUND THIS LEAF");
                else
                    System.out.println(no.dados);

                System.out.println("Pesqusisa na Arvore AVL:");
                no = Floresta[idArvoreAVL].Pesquisa(chave); // Codigo mun + data

                if (no == null)
                    System.out.println("NOT FOUND THIS LEAF");
                else
                    System.out.println(no.dados);

            }
        } while (!chave.equals("0"));

        int[][] regiaoBB = Arquivo.GuardaRegioes(lastDate, Floresta[idArvoreBB]);
        int[][] regiaoAVL = Arquivo.GuardaRegioes(lastDate, Floresta[idArvoreAVL]);
        int op;
        do {
            op = Integer.parseInt(
                    JOptionPane.showInputDialog("1 - Norte \n2 - Nordeste \n3 - Sudeste \n4 - Sul \n5 - Centro-Oeste"));
            switch (op) {
                case 0:
                    break;
                case 1:
                    System.out.println("Casos totais: " + regiaoBB[0][0]);
                    System.out.println("Obitos totais: " + regiaoBB[0][1]);
                    System.out.println("Numero de comparações BB: "+regiaoBB[0][2]);
                    System.out.println("Numero de comparações AVL: "+regiaoAVL[0][2]);
                    break;
                case 2:
                    System.out.println("Casos totais: " + regiaoBB[1][0]);
                    System.out.println("Obitos totais: " + regiaoBB[1][1]);
                    System.out.println("Numero de comparações BB: "+regiaoBB[1][2]);
                    System.out.println("Numero de comparações AVL: "+regiaoAVL[1][2]);
                    break;
                case 3:
                    System.out.println("Casos totais: " + regiaoBB[2][0]);
                    System.out.println("Obitos totais: " + regiaoBB[2][1]);
                    System.out.println("Numero de comparações BB: "+regiaoBB[2][2]);
                    System.out.println("Numero de comparações AVL: "+regiaoAVL[2][2]);
                    break;
                case 4:
                    System.out.println("Casos totais: " + regiaoBB[3][0]);
                    System.out.println("Obitos totais: " + regiaoBB[3][1]);
                    System.out.println("Numero de comparações BB: "+regiaoBB[3][2]);
                    System.out.println("Numero de comparações AVL: "+regiaoAVL[3][2]);
                    break;
                case 5:
                    System.out.println("Casos totais: " + regiaoBB[4][0]);
                    System.out.println("Obitos totais: " + regiaoBB[4][1]);
                    System.out.println("Numero de comparações BB: "+regiaoBB[4][2]);
                    System.out.println("Numero de comparações AVL: "+regiaoAVL[4][2]);
                    break;
                default:
                    System.out.println("Opção inválida!!!!!!!!!!!!!!!!!!!!!!!");
                    break;
            }
        } while (op != 0);

    }
}