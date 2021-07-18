import java.io.IOException;

public class App {

    private final static int idArvoreBB = 0;
    private final static int idArvoreAVL = 1;

    public static String[] path = {
            System.getProperty("user.dir") + "\\BigData\\HIST_PAINEL_COVIDBR_2020_Parte1_07jul2021.csv",
            System.getProperty("user.dir") + "\\BigData\\HIST_PAINEL_COVIDBR_2020_Parte2_07jul2021.csv",
            System.getProperty("user.dir") + "\\BigData\\HIST_PAINEL_COVIDBR_2021_Parte1_07jul2021.csv",
            System.getProperty("user.dir") + "\\BigData\\HIST_PAINEL_COVIDBR_2021_Parte2_07jul2021.csv"};

    public static void main(String[] args) throws IOException {

        int quantidadeDeColunas = 17, quantidadeDeLinhas = 0;

        for (int i = 0; i < 4; i++) {
            quantidadeDeLinhas = Arquivo.ContaLinhas(path[i], quantidadeDeLinhas);
        }

        String[][] matriz = new String[quantidadeDeLinhas][quantidadeDeColunas];

        int indiceLinha = 0;
        for (int i = 0; i < 4; i++) {
            indiceLinha = Arquivo.PreencheMatriz(path[i], matriz, indiceLinha, quantidadeDeColunas);
        }

        Arquivo.QuickSort(matriz, 0, quantidadeDeLinhas - 1);

        Arvore[] Floresta = new Arvore[2];
        Floresta[idArvoreBB] = new ArvoreBB();
        Floresta[idArvoreAVL] = new ArvoreAVL();

        System.out.print("\n\n ======== INSERCAO BINARIA ========\n");
        Floresta[idArvoreBB].raiz = null;
        ((ArvoreBB) Floresta[idArvoreBB]).InserirBIN(matriz, 0, quantidadeDeLinhas - 1);

        // String chave = JOptionPane.showInputDialog("Digite codmun ou coduf seguido da data (aaaa-mm-dd)");

        TipoNo no = Floresta[idArvoreBB].Pesquisa("3145202021-01-20");
        if (no == null)
            System.out.println("NOT FOUND THIS LEAF");

    }
}
