import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


public class Arvore {
    public No T;
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

    public void preenche(String path, String split, int coluna) {
        String line = "";
        Info dados = new Info();
        try {

            BufferedReader br = new BufferedReader(new FileReader(path));

            while ((line = br.readLine()) != null) {

                String[] key = line.split(split);
                try {
                    dados.regiao = key[REGIAO];
                    dados.estado = key[ESTADO];
                    dados.municipio = key[MUNICIPIO];
                    dados.coduf = key[CODUF];
                    dados.codmun = key[CODMUN];
                    dados.codRegiaoSaude = key[CODREGIAOSAUDE];
                    dados.nomeRegiaoSaude = key[NOMEREGIAOSAUDE];
                    dados.data = key[DATA];
                    dados.semanaEpi = key[SEMANAEPI];
                    dados.populacaoTcu2019 = key[POPULACAOTCU2019];
                    dados.casoAcumulado = key[CASOSACUMULADO];
                    dados.casosNovos = key[CASOSNOVOS];
                    dados.obitosAcumulado = key[OBITOSACUMULADO];
                    dados.obitosNovos = key[OBITOSNOVOS];
                    dados.recuperaDoNovos = key[RECUPERADOSNOVOS];
                    dados.emcompanhamemtoNovos = key[EMACOMPANHAMENTONOVOS];
                    dados.interior = key[INTERIOR];
                    System.out.println(key[coluna]);
                } catch (ArrayIndexOutOfBoundsException e) {
                    continue;
                }
                insere(dados);
                System.out.println("inseriu");
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public No insere(No T, Info dados, No pai) {
        if (T == null) {
            T = new No(dados, pai);
        } else {
            pai = T;
            if (dados.chaveMunData.compareToIgnoreCase(T.dados.chaveMunData) > 0) {
                T.filhoEsq = insere(T.filhoEsq, dados, pai);
            } else if (dados.chaveMunData.compareToIgnoreCase(T.dados.chaveMunData) < 0) {
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
