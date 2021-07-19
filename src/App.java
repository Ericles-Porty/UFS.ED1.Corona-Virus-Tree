import java.io.IOException;
import javax.swing.JOptionPane;


public class App {

    private final static int idArvoreBB = 0;
    private final static int idArvoreAVL = 1;

    public static String[] path = {
            System.getProperty("user.dir") + "\\BigData\\HIST_PAINEL_COVIDBR_2020_Parte1_07jul2021.csv",
            System.getProperty("user.dir") + "\\BigData\\HIST_PAINEL_COVIDBR_2020_Parte2_07jul2021.csv",
            System.getProperty("user.dir") + "\\BigData\\HIST_PAINEL_COVIDBR_2021_Parte1_07jul2021.csv",
            System.getProperty("user.dir") + "\\BigData\\HIST_PAINEL_COVIDBR_2021_Parte2_07jul2021.csv"};

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
        System.out.println("Inserindo na arvore de busca binaria...");
        Floresta[idArvoreBB].raiz = null;
        Floresta[idArvoreBB].InserirBIN(matriz, 0, indiceLinha - 1);


        System.out.print("========INSERINDO AVL========\n");
        Floresta[idArvoreAVL].raiz = null;
        System.out.println("Inserindo na arvore de busca binaria...");


        Floresta[idArvoreAVL].InserirAVL(matriz, 0, indiceLinha - 1);
        matriz = null;  //  joguem essas 2 linhas para baixo depois de jogarem a matriz na arvore
        System.gc();    //  ela ta apagando a matriz pra limpar memoria

        //System.out.println("Digite a chave...");
        //String chave = JOptionPane.showInputDialog("Digite codmun ou coduf seguido da data (aaaa-mm-dd)");


        //TipoNo no = Floresta[idArvoreBB].Pesquisa(chave+lastDate); //Codigo uf + data

        String tipoArvore;
        TipoNo no;

        String chave;


        do {
            do {
                tipoArvore = JOptionPane.showInputDialog("Digite o tipo de árvore que quer consultar? (1) ABB | (2) AVL");
            } while (tipoArvore.equals('1') || tipoArvore.equals('2'));
            System.out.println("Digite a chave...");
            chave = JOptionPane.showInputDialog("Digite codmun ou coduf seguido da data (aaaa-mm-dd)");

            if (tipoArvore.equals('1')) {
                no = Floresta[idArvoreBB].Pesquisa(chave + lastDate); //Codigo mun + data
                if (no == null)
                    System.out.println("NOT FOUND THIS LEAF");
            } else if (tipoArvore.equals('2')) {
                no = Floresta[idArvoreAVL].Pesquisa(chave + lastDate); //Codigo mun + data
                if (no == null)
                    System.out.println("NOT FOUND THIS LEAF");
            }

            //if (no == null)
            //  System.out.println("NOT FOUND THIS LEAF");

        } while (!chave.equals('0'));
    }
}