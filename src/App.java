import java.io.IOException;

import javax.swing.JOptionPane;

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
    	
    	String[][] key = new String[contLinhas][coluna]; 
    	for (int i = 0; i < 4; i++) {
    		linha = LerArquivo.readFile(path[i], linha, key, coluna);
    		//System.out.println("L:"+linha);
		}
    	//System.out.println("Ordene");
    	LerArquivo.qSort(key, 0, linha-1);
    	
    	/*for (int i = 20000; i < 40000; i++) {
			System.out.println(key[i][3]);
		}*/

    	//System.out.println(key[800000][3]);
   
    	Arvore T1 = new Arvore();
    	
    	System.out.print("\n\n ======== INSERCÃO BINÁRIA ========\n");
        T1.T = null;
        T1.inserirBIN(key, 0, linha-1);
        /*System.out.println("Raiz: "+ T1.T.dados.chave);
        System.out.println("F. Dir: "+T1.T.filhoDir.dados.chave);
        System.out.println("F. E: "+T1.T.filhoEsq.dados.chave);
        System.out.println("F. E. D: "+T1.T.filhoEsq.filhoDir.dados.chave);
        System.out.println(T1.T.filhoDir.filhoEsq.dados.chave);
        System.out.println(T1.T.filhoDir.filhoEsq.filhoDir.dados.chave);*/
        //System.out.println(T1.T.filhoEsq.dados.codmun+T1.T.filhoEsq.dados.data);
        //T1.mostraArvore();
        
        // String chave = JOptionPane.showInputDialog("Digite codmun ou coduf seguido da data (aaaa-mm-dd)");
        // T1.pesquisa(T1.T, "5300102021-07-04"); // 3126752020-05-03
        
        No no = T1.pesquisa("322020-08-26");
        if(no == null)
        	System.out.println("Not FOUND");

    }
}
