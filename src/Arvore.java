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
        dados = new Info(key[0][pos], key[1][pos], key[2][pos], key[3][pos], key[4][pos], key[5][pos], key[6][pos], key[7][pos], key[8][pos], key[9][pos], key[10][pos], key[11][pos], key[12][pos], key[13][pos], key[14][pos], key[15][pos], key[16][pos]);
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
            if (dados.chave.compareToIgnoreCase(T.dados.chave) > 0) {
                T.filhoEsq = insere(T.filhoEsq, dados, pai);
            } else if (dados.chave.compareToIgnoreCase(T.dados.chave) < 0) {
                T.filhoDir = insere(T.filhoDir, dados, pai);
            }
        }
        return T;
    }


    /*public void Remove(No T, Info X) {
        if (T == null)
            System.out.print(" Elemento nÃ£o encontrado \n");
        else if (X.chave == T.item.chave) {
            No P = T;
            if ((T.esq == null) && (T.dir == null)) {
                if (T.pai == null) {
                    this.T = null;
                } else if (T.item.chave > T.pai.item.chave)
                    T.pai.dir = null;
                else
                    T.pai.esq = null;
            } else if (T.esq == null) {
                if (T.pai != null) {
                    if (T.dir != null) T.dir.pai = T.pai;
                    if (T.item.chave > T.pai.item.chave)
                        T.pai.dir = T.dir;
                    else
                        T.pai.esq = T.dir;
                } else {
                    this.T = T.dir;
                    this.T.pai = null;
                }
            } else if (T.dir == null) {
                if (T.pai != null) {
                    if (T.esq != null) T.esq.pai = T.pai;
                    if (T.item.chave > T.pai.item.chave)
                        T.pai.dir = T.esq;
                    else
                        T.pai.esq = T.esq;
                } else {
                    this.T = T.esq;
                    this.T.pai = null;
                }
            } else {
                P = getMax(T.esq);
                T.dados = P.dados;
            }

        } else if (X.chave < T.item.chave)
            Remove(T.esq, X);
        else
            Remove(T.dir, X);
    }
    */
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
			if(no.dados.chave.equalsIgnoreCase(chave)) {
				System.out.println(no.dados.toString());
				return no;
			} else {
				if (chave.compareToIgnoreCase(T.dados.chave) > 0) { // Esquerda
		            no = pesquisa(no.filhoEsq, chave);
		        } else if (chave.compareToIgnoreCase(T.dados.chave) < 0) { // Direita
		        	no = pesquisa(no.filhoDir, chave);
		        }
			}
		}
		return no;
	}
}
