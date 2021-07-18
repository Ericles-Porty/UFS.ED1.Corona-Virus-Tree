public class No {
    No pai;
    No filhoEsq;
    No filhoDir;
    Info dados;
    int bal = 0; 
	int hesq = 0; 
	int hdir = 0;

    public No() {
        this.filhoEsq = null;
        this.filhoDir = null;
    }

    public No(Info dados, No pai) {
        this.dados = dados;
        this.filhoEsq = null;
        this.filhoDir = null;
        this.pai = pai;
    }
}
