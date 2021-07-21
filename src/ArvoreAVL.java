public final class ArvoreAVL extends Arvore {

    private int altura;
    private TipoNo p;

    public ArvoreAVL() {
        raiz = null;
    }

    @Override
    public void Insere(Info dados) {
        raiz = Insere(raiz, dados, null);
        Avl(p);
    }

    @Override
    public TipoNo Insere(TipoNo no, Info dados, TipoNo pai) {
        if (no == null) {
            no = new TipoNo(dados, pai);
            this.p = no;
        } else {
            pai = no;
            if (dados.chave.compareToIgnoreCase(no.dados.chave) < 0)
                no.filhoEsq = Insere(no.filhoEsq, dados, pai);
            else if (dados.chave.compareToIgnoreCase(no.dados.chave) > 0)
                no.filhoDir = Insere(no.filhoDir, dados, pai);
        }
        return no;
    }


    public void InserirAVL(String[][] matriz, int i, int j) {
        for (i = 0; i < j; i++) {
            dados = new Info(matriz[i][REGIAO], matriz[i][ESTADO], matriz[i][MUNICIPIO], matriz[i][CODUF], matriz[i][CODMUN], matriz[i][DATA], matriz[i][CASOSACUMULADO], matriz[i][CASOSNOVOS], matriz[i][OBITOSACUMULADO], matriz[i][OBITOSNOVOS]);
            Insere(dados);
        }
    }


    public void Avl(TipoNo no) {
        if (no != null) {
            no.fatorBalanceamento = Balanco(no);
            if (no.fatorBalanceamento < 2) {
                Avl(no.pai);
            } else {

                if (no.alturaEsq >= no.alturaDir)
                    if (no.filhoEsq.alturaEsq >= no.filhoEsq.alturaDir) {
                        RotacaoDireita(no);
                    } else {
                        RotacaoEsquerda(no.filhoEsq);
                        RotacaoDireita(no);
                    }

                if (no.alturaDir >= no.alturaEsq)
                    if (no.filhoDir.alturaDir >= no.filhoDir.alturaEsq) {
                        RotacaoEsquerda(no);
                    } else {
                        RotacaoDireita(no.filhoDir);
                        RotacaoEsquerda(no);
                    }
            }
        }
    }

    public int Balanco(TipoNo no) {
        altura = 0;
        BalanceamentoPreOrdem(no.filhoEsq, 0);
        no.alturaEsq = altura;
        altura = 0;
        BalanceamentoPreOrdem(no.filhoDir, 0);
        no.alturaDir = altura;
        return Math.abs(no.alturaEsq - no.alturaDir);
    }

    public void BalanceamentoPreOrdem(TipoNo no, int v) {
        if (no != null) {
            v++;
            BalanceamentoPreOrdem(no.filhoEsq, v);
            BalanceamentoPreOrdem(no.filhoDir, v);
        } else if (v > altura)
            altura = v;
    }

    public void RotacaoDireita(TipoNo no) {
        TipoNo apu = no.filhoEsq;
        no.filhoEsq = apu.filhoDir;
        if (apu.filhoDir != null)
            apu.filhoDir.pai = no;
        apu.pai = no.pai;
        apu.filhoDir = no;
        no.pai = apu;
        no.fatorBalanceamento = 0;
        if (apu.pai == null)
            this.raiz = apu;
        else {
            if (apu.dados.chave.compareToIgnoreCase(apu.pai.dados.chave) < 0)
                apu.pai.filhoEsq = apu;
            else
                apu.pai.filhoDir = apu;
        }
    }

    public void RotacaoEsquerda(TipoNo no) {
        TipoNo apu = no.filhoDir;
        no.filhoDir = apu.filhoEsq;
        if (apu.filhoEsq != null)
            apu.filhoEsq.pai = no;
        apu.pai = no.pai;
        apu.filhoEsq = no;
        no.pai = apu;
        no.fatorBalanceamento = 0;
        if (apu.pai == null)
            this.raiz = apu;
        else {
            if (apu.dados.chave.compareToIgnoreCase(apu.pai.dados.chave) < 0)
                apu.pai.filhoEsq = apu;
            else
                apu.pai.filhoDir = apu;
        }
    }

    protected void InserirBIN(String[][] matriz, int i, int j) {
    }
}
