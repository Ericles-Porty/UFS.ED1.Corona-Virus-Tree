import java.io.IOException;

public class App {

	private static int idArvoreBB = 0;
	private static int idArvoreAVL = 1;

	public static String[] path = {
			System.getProperty("user.dir") + "\\BigData\\HIST_PAINEL_COVIDBR_2020_Parte1_07jul2021.csv",
			System.getProperty("user.dir") + "\\BigData\\HIST_PAINEL_COVIDBR_2020_Parte2_07jul2021.csv",
			System.getProperty("user.dir") + "\\BigData\\HIST_PAINEL_COVIDBR_2021_Parte1_07jul2021.csv",
			System.getProperty("user.dir") + "\\BigData\\HIST_PAINEL_COVIDBR_2021_Parte2_07jul2021.csv" };

	public static void main(String[] args) throws IOException {

		int coluna = 17, linha = 0, quantidadeDeLinhas = 0;

		for (int i = 0; i < 4; i++) {
			quantidadeDeLinhas = LerArquivo.contaLinhas(path[i], quantidadeDeLinhas, coluna);
		}

		String[][] matriz = new String[quantidadeDeLinhas][coluna];
		for (int i = 0; i < 4; i++) {
			linha = LerArquivo.readFile(path[i], linha, matriz, coluna);
		}
		LerArquivo.QuickSort(matriz, 0, linha - 1);

		Arvore[] Floresta = new Arvore[2];
		Floresta[idArvoreBB] = new ArvoreBB();
		Floresta[idArvoreAVL] = new ArvoreAVL();

		System.out.print("\n\n ======== INSERCAO BINARIA ========\n");
		Floresta[idArvoreBB].raiz = null;
		((ArvoreBB) Floresta[idArvoreBB]).InserirBIN(matriz, 0, linha - 1);

		// String chave = JOptionPane.showInputDialog("Digite codmun ou coduf seguido da data (aaaa-mm-dd)");

		No no = Floresta[idArvoreBB].Pesquisa("3145202021-01-20");
		if (no == null)
			System.out.println("NOT FOUND THIS LEAF");

	}
}
