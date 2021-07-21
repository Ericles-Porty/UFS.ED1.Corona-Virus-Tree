public final class ArvoreBB extends Arvore {
    @Override
    public void Insere(Info dados) {
        raiz = Insere(raiz, dados, null);
    }

    @Override
    public TipoNo Insere(TipoNo tipoNo, Info dados, TipoNo pai) {
        if (tipoNo == null) {
            tipoNo = new TipoNo(dados, pai);
        } else {
            pai = tipoNo;
            if (dados.chave.compareToIgnoreCase(tipoNo.dados.chave) < 0) {
                tipoNo.filhoEsq = Insere(tipoNo.filhoEsq, dados, pai);
            } else if (dados.chave.compareToIgnoreCase(tipoNo.dados.chave) > 0) {
                tipoNo.filhoDir = Insere(tipoNo.filhoDir, dados, pai);
            }
        }
        return tipoNo;
    }

    public void InserirBIN(String[][] matriz, int i, int j) {
        int posicaoLinha = (i + j) / 2;
        dados = new Info(matriz[posicaoLinha][REGIAO], matriz[posicaoLinha][ESTADO], matriz[posicaoLinha][MUNICIPIO], matriz[posicaoLinha][CODUF], matriz[posicaoLinha][CODMUN], matriz[posicaoLinha][DATA], matriz[posicaoLinha][CASOSACUMULADO], matriz[posicaoLinha][CASOSNOVOS], matriz[posicaoLinha][OBITOSACUMULADO], matriz[posicaoLinha][OBITOSNOVOS]);
        Insere(dados);
        if (i < j) {
            InserirBIN(matriz, i, posicaoLinha - 1);
            InserirBIN(matriz, posicaoLinha + 1, j);
        }
    }

    public void InserirAVL(String[][] matriz, int i, int j) {
    }
}
