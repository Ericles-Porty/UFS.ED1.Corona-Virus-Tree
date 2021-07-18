import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


public class Arvore {
    public No T;
    public Info dados;
    public static int REGIAO = 0;
    public static int ESTADO = 1;
    public static int MUNICIPIO = 2;
    public static int CODUF = 3;
    public static int CODMUN = 4;
    public static int CODREGIAOSAUDE = 5;
    public static int NOMEREGIAOSAUDE = 6;
    public static int DATA = 7;
    public static int SEMANAEPI = 8;
    public static int POPULACAOTCU2019 = 9;
    public static int CASOSACUMULADO = 10;
    public static int CASOSNOVOS = 11;
    public static int OBITOSACUMULADO = 12;
    public static int OBITOSNOVOS = 13;
    public static int RECUPERADOSNOVOS = 14;
    public static int EMACOMPANHAMENTONOVOS = 15;
    public static int INTERIOR = 16;


    public Arvore() {
        T = null;
    }

    public No raiz() {
        return T;
    }

    public void insere(Info dados) {
        T = insere(T, dados, null);
    }
    
    public void inserirBIN(String[][] key, int i, int j) {
        int pos = (i + j) / 2;
        dados = new Info(key[pos][0], key[pos][1], key[pos][2], key[pos][3], key[pos][4], key[pos][5], key[pos][6], key[pos][7], key[pos][8], key[pos][9], key[pos][10], key[pos][11], key[pos][12], key[pos][13], key[pos][14], key[pos][15], key[pos][16]);
        insere(dados);
        if (i < j) {
            inserirBIN(key, i, pos - 1);
            inserirBIN(key, pos + 1, j);
        }
    }

    public No insere(No T, Info dados, No pai) {
        if (T == null) {
            T = new No(dados, pai);
        } else {
            pai = T;
            if (dados.chave.compareToIgnoreCase(T.dados.chave) < 0) {
                T.filhoEsq = insere(T.filhoEsq, dados, pai);
            } else if (dados.chave.compareToIgnoreCase(T.dados.chave) > 0) {
                T.filhoDir = insere(T.filhoDir, dados, pai);
            }
        }
        return T;
    }

    public void emOrdem(No T) {
        if (T != null) {
            emOrdem(T.filhoEsq);
            System.out.print(T.dados + " ");
            emOrdem(T.filhoDir);
        }
    }

    public void preOrdem(No T) {
        if (T != null) {
            System.out.print(T.dados + " ");
            preOrdem(T.filhoEsq);
            preOrdem(T.filhoDir);
        }
    }

    public void posOrdem(No T) {
        if (T != null) {
            posOrdem(T.filhoEsq);
            posOrdem(T.filhoDir);
            System.out.print(T.dados + " ");
        }
    }
    
    public No pesquisa(String dados) {
    	return pesquisa(T, dados);
    }

	public No pesquisa(No no, String chave) {
		if(no == null) {
			return no;
		}
		else {
			if(no.dados.chave.compareToIgnoreCase(chave) == 0) {
				System.out.println(no.dados.toString());
				return no;
			} else {
				if (chave.compareToIgnoreCase(no.dados.chave) < 0) { // Esquerda
		            no = pesquisa(no.filhoEsq, chave);
		        } else if (chave.compareToIgnoreCase(no.dados.chave) > 0) { // Direita
		        	no = pesquisa(no.filhoDir, chave);
		        }
			}
		}
		return no;
	}
}
