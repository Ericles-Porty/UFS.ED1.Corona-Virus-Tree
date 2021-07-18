public final class ArvoreBB extends Arvore{
	@Override
	public void Insere(Info dados) {
        raiz = Insere(raiz, dados, null);
    }

    public void InserirBIN(String[][] key, int i, int j) {
        int pos = (i + j) / 2;
        dados = new Info(key[pos][REGIAO], key[pos][ESTADO], key[pos][MUNICIPIO], key[pos][CODUF], key[pos][CODMUN], key[pos][CODREGIAOSAUDE], key[pos][NOMEREGIAOSAUDE], key[pos][DATA], key[pos][SEMANAEPI], key[pos][POPULACAOTCU2019], key[pos][CASOSACUMULADO], key[pos][CASOSNOVOS], key[pos][OBITOSACUMULADO], key[pos][OBITOSNOVOS], key[pos][RECUPERADOSNOVOS], key[pos][EMACOMPANHAMENTONOVOS], key[pos][INTERIOR]);
        Insere(dados);
        if (i < j) {
            InserirBIN(key, i, pos - 1);
            InserirBIN(key, pos + 1, j);
        }
    }
	@Override
    public No Insere(No raiz, Info dados, No pai) {
        if (raiz == null) {
            raiz = new No(dados, pai);
        } else {
            pai = raiz;
            if (dados.chave.compareToIgnoreCase(raiz.dados.chave) < 0) {
                raiz.filhoEsq = Insere(raiz.filhoEsq, dados, pai);
            } else if (dados.chave.compareToIgnoreCase(raiz.dados.chave) > 0) {
                raiz.filhoDir = Insere(raiz.filhoDir, dados, pai);
            }
        }
        return raiz;
    
	}

}
