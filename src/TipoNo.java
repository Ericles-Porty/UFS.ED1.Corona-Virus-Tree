public class TipoNo {
    TipoNo pai;
    TipoNo filhoEsq;
    TipoNo filhoDir;
    Info dados;
    int fatorBalanceamento = 0;
	int alturaEsq = 0;
	int alturaDir = 0;

    public TipoNo(Info dados, TipoNo pai) {
        this.dados = dados;
        this.filhoEsq = null;
        this.filhoDir = null;
        this.pai = pai;
    }
}
