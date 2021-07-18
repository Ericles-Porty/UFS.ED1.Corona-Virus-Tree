public abstract class Arvore {
    public TipoNo raiz;
    public Info dados;

    protected static int REGIAO = 0;
    protected static int ESTADO = 1;
    protected static int MUNICIPIO = 2;
    protected static int CODUF = 3;
    protected static int CODMUN = 4;
    protected static int CODREGIAOSAUDE = 5;
    protected static int NOMEREGIAOSAUDE = 6;
    protected static int DATA = 7;
    protected static int SEMANAEPI = 8;
    protected static int POPULACAOTCU2019 = 9;
    protected static int CASOSACUMULADO = 10;
    protected static int CASOSNOVOS = 11;
    protected static int OBITOSACUMULADO = 12;
    protected static int OBITOSNOVOS = 13;
    protected static int RECUPERADOSNOVOS = 14;
    protected static int EMACOMPANHAMENTONOVOS = 15;
    protected static int INTERIOR = 16;

    protected abstract void Insere(Info dados);

    protected abstract TipoNo Insere(TipoNo raiz, Info dados, TipoNo pai);

    public Arvore() {
        raiz = null;
    }


    public TipoNo Pesquisa(String dados) {
        return Pesquisa(raiz, dados);
    }

    public TipoNo Pesquisa(TipoNo no, String chave) {
        if (no == null) {
            return null;
        } else {
            if (no.dados.chave.compareToIgnoreCase(chave) == 0) {
                System.out.println(no.dados);
                return no;
            } else {
                if (chave.compareToIgnoreCase(no.dados.chave) < 0) {
                    no = Pesquisa(no.filhoEsq, chave);
                } else if (chave.compareToIgnoreCase(no.dados.chave) > 0) {
                    no = Pesquisa(no.filhoDir, chave);
                }
            }
        }
        return no;
    }
}
