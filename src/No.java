public class No {
    No pai;
    No filhoEsq;
    No filhoDir;
    Info dados;

    public No() {
        this.filhoEsq = null;
        this.filhoDir = null;
    }

    public No(Info dados, No pai) {
        this.dados = null;
        this.filhoEsq = null;
        this.filhoDir = null;
        this.pai = pai;
    }
}
