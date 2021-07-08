public class Arvore {
    public No T;

    public Arvore() {
        T = null;
    }

    public No raiz() {
        return T;
    }

    public void insere(Info dados) {
        T = insere(T, dados, null);
    }


    public No insere(No T, Info dados, No pai) {
        if (T == null) {
            T = new No(dados, pai);
        } else {
            pai = T;
            if (dados.codigoMunicipio.chave < T.dados.codigoMunicipio.chave) {
                T.filhoEsq = insere(T.filhoEsq, dados, pai);
            } else if (dados.codigoMunicipio.chave > T.dados.codigoMunicipio.chave) {
                T.filhoDir = insere(T.filhoDir, dados, pai);
            }
        }
        return T;
    }


    /*public void Remove(No T, Info X) {
        if (T == null)
            System.out.print(" Elemento não encontrado \n");
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
            System.out.print(T.dados + " ");//implementar o dados.
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
}
