public class ArvoreBB extends Arvore{
	@Override
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
	@Override
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

}
