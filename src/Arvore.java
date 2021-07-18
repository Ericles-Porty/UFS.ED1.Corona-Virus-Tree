import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


public abstract class Arvore {
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
    public abstract void insere(Info dados);
    public abstract No insere(No T, Info dados, No pai);

    public Arvore() {
        T = null;
    }

    public No raiz() {
        return T;
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
