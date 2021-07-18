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

        int quantidadeDeColunas = 17, quantidadeDeLinhas = 0;

        for (int i = 0; i < 4; i++) {
            quantidadeDeLinhas = Arquivo.ContaLinhas(path[i], quantidadeDeLinhas);
        }

        String[][] matriz = new String[quantidadeDeLinhas][quantidadeDeColunas];

        int indiceLinha = 0;
        for (int i = 0; i < 4; i++) {
            indiceLinha = Arquivo.PreencheMatriz(path[i], matriz, indiceLinha, quantidadeDeColunas);
        }

        Arquivo.QuickSort(matriz, 0, indiceLinha - 1);
        

        Arvore[] Floresta = new Arvore[2];
        Floresta[idArvoreBB] = new ArvoreBB();
        Floresta[idArvoreAVL] = new ArvoreAVL();

        System.out.print("\n\n ======== INSERCAO BINARIA ========\n");
        Floresta[idArvoreBB].raiz = null;
        ((ArvoreBB) Floresta[idArvoreBB]).InserirBIN(matriz, 0, indiceLinha - 1);


         String chave = JOptionPane.showInputDialog("Digite codmun ou coduf seguido da data (aaaa-mm-dd)");

        ArvoreAVL T1 = new ArvoreAVL();
            System.out.print("========INSERINDO AVL========\n");

        System.out.print("Inserindo a chave 37\n");

        Info item1 = new Info("Itabaiana", "Sergipe", "Itabaiana", "25", "2222u", "Itabaiana", "Itabaiana", "2021-07-01", "Itabaiana", "Itabaiana","Itabaiana","Itabaiana","Itabaiana","Itabaiana","Itabaiana","Itabaiana","Itabaiana");
        T1.Insere(item1);
        T1.Pesquisa(item1.chave);

        System.out.print("Inserindo a chave 10\n");
        Info item2 = new Info("Itabaiana", "Sergipe", "Itabaiana", "25", "", "Itabaiana", "Itabaiana", "2021-07-11", "Itabaiana", "Itabaiana","Itabaiana","Itabaiana","Itabaiana","Itabaiana","Itabaiana","Itabaiana","Itabaiana");
        T1.Insere(item2);


        System.out.print("Inserindo a chave 30\n");
        Info item3 = new Info("Itabaiana", "Sergipe", "Itabaiana", "25", "", "Itabaiana", "Itabaiana", "2021-07-01", "Itabaiana", "Itabaiana","Itabaiana","Itabaiana","Itabaiana","Itabaiana","Itabaiana","Itabaiana","Itabaiana");
        T1.Insere(item3);


        System.out.print("Inserindo a chave 80\n");
        Info item4 = new Info("Itabaiana", "Sergipe", "Itabaiana", "25", "2222f", "Itabaiana", "Itabaiana", "2021-07-04", "Itabaiana", "Itabaiana","Itabaiana","Itabaiana","Itabaiana","Itabaiana","Itabaiana","Itabaiana","Itabaiana");
        T1.Insere(item4);



        System.out.print("Inserindo a chave 100\n");
        Info item5 = new Info("Itabaiana", "Sergipe", "Itabaiana", "25", "", "Itabaiana", "Itabaiana", "2021-07-02", "Itabaiana", "Itabaiana","Itabaiana","Itabaiana","Itabaiana","Itabaiana","Itabaiana","Itabaiana","Itabaiana");
        T1.Insere(item5);


        System.out.print("Inserindo a chave 5\n");
        Info item6 = new Info("Itabaiana", "Sergipe", "Itabaiana", "25", "", "Itabaiana", "Itabaiana", "2021-07-03", "Itabaiana", "Itabaiana","Itabaiana","Itabaiana","Itabaiana","Itabaiana","Itabaiana","Itabaiana","Itabaiana");
        T1.Insere(item6);


        System.out.print("Inserindo a chave 180\n");
        Info item7 = new Info("Itabaiana", "Sergipe", "Itabaiana", "25", "", "Itabaiana", "Itabaiana", "2021-07-04", "Itabaiana", "Itabaiana","Itabaiana","Itabaiana","Itabaiana","Itabaiana","Itabaiana","Itabaiana","Itabaiana");
        T1.Insere(item7);


        System.out.print("Inserindo a chave 90\n");
        Info item8 = new Info("Itabaiana", "Sergipe", "Itabaiana", "25", "4411b", "Itabaiana", "Itabaiana", "2021-07-06", "Itabaiana", "Itabaiana","Itabaiana","Itabaiana","Itabaiana","Itabaiana","Itabaiana","Itabaiana","Itabaiana");
        T1.Insere(item8);


        System.out.print("Inserindo a chave 35\n");
        Info item9 = new Info("Itabaiana", "Sergipe", "Itabaiana", "25", "4411b", "Itabaiana", "Itabaiana", "2021-07-07", "Itabaiana", "Itabaiana","Itabaiana","Itabaiana","Itabaiana","Itabaiana","Itabaiana","Itabaiana","Itabaiana");
        T1.Insere(item9);


        System.out.print("Inserindo a chave 85\n");
        Info item10 = new Info("Itabaiana", "Sergipe", "Itabaiana", "25", "4411b", "Itabaiana", "Itabaiana", "2021-07-08", "Itabaiana", "Itabaiana","Itabaiana","Itabaiana","Itabaiana","Itabaiana","Itabaiana","Itabaiana","Itabaiana");
        T1.Insere(item10);


        System.out.print("Inserindo a chave 8\n");
        Info item18 = new Info("Itabaiana", "Sergipe", "Itabaiana", "25", "4411b", "Itabaiana", "Itabaiana", "2021-07-09", "Itabaiana", "Itabaiana","Itabaiana","Itabaiana","Itabaiana","Itabaiana","Itabaiana","Itabaiana","Itabaiana");

        /*
        TipoNo no = Floresta[idArvoreBB].Pesquisa("3145202021-01-20");
        if (no == null)
            System.out.println("NOT FOUND THIS LEAF");
*/
    }
}