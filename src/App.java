import java.io.IOException;

public class App {

    public static String[] path = {System.getProperty("user.dir") + "\\BigData\\HIST_PAINEL_COVIDBR_2020_Parte1_07jul2021.csv",
    System.getProperty("user.dir") + "\\BigData\\HIST_PAINEL_COVIDBR_2020_Parte2_07jul2021.csv",
    System.getProperty("user.dir") + "\\BigData\\HIST_PAINEL_COVIDBR_2021_Parte1_07jul2021.csv",
    System.getProperty("user.dir") + "\\BigData\\HIST_PAINEL_COVIDBR_2021_Parte2_07jul2021.csv"};
    
    public static void main(String[] args) throws IOException {

    	int coluna = 17, linha = 0, contLinhas = 0;
    	
    	for(int i = 0; i < 4; i++) {
    		contLinhas = LerArquivo.qtdLinhas(path[i], contLinhas, coluna);
    		//System.out.println(contLinhas);
    	}
    	
    	String[][] key = new String[coluna][contLinhas]; 
    	for (int i = 0; i < 4; i++) {
    		linha = LerArquivo.readFile(path[i], linha, key, coluna);
    		//System.out.println("L:"+linha);
		}
    	
    	//System.out.println(key[0][2591232]);
    	//System.out.println(key[0][2591233]);
    	
    	Arvore T1 = new Arvore();
    	
    	System.out.print("\n\n ======== INSERCÃO BINÁRIA ========\n");
        T1.T = null;
        T1.inserirBIN(key, 0, linha-4);
        System.out.println(T1.dados.codmun+T1.dados.data);
        System.out.println(T1.T.filhoDir.dados.codmun+T1.T.filhoDir.dados.data);
        System.out.println(T1.T.filhoEsq.dados.codmun+T1.T.filhoEsq.dados.data);
        //T1.mostraArvore();
        
        // String chave = JOptionPane.showInputDialog("Digite codmun ou coduf seguido da data (aaaa-mm-dd)");
        // T1.pesquisa(T1.T, "5300102021-07-04");
        
        No no = T1.pesquisa("3126752020-05-03");
        if(no == null)
        	System.out.println("Not");
    	
    }
}
