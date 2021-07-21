public class Info {
    public String chave;

    private final String regiao;
    private final String estado;
    private final String municipio;
    private final String coduf;
    private final String codmun;
    private final String data;
    public final String casosAcumulados;
    private final String casosNovos;
    public final String obitosAcumulados;
    private final String obitosNovos;

    public Info(String regiao, String estado, String municipio, String coduf, String codmun, String data, String casosAcumulados, String casosNovos, String obitosAcumulados, String obitosNovos) {
        if (codmun.equals("")) {
            this.chave = coduf + data;
        } else
            this.chave = codmun + data;
        this.regiao = regiao;
        this.estado = estado;
        this.municipio = municipio;
        this.coduf = coduf;
        this.codmun = codmun;
        this.data = data;
        this.casosAcumulados = casosAcumulados;
        this.casosNovos = casosNovos;
        this.obitosAcumulados = obitosAcumulados;
        this.obitosNovos = obitosNovos;
    }

    public String toString() {
        return "Info{" +
                "\nchave='" + chave + '\'' +
                "\nregiao='" + regiao + '\'' +
                "\nestado='" + estado + '\'' +
                "\nmunicipio='" + municipio + '\'' +
                "\ncoduf='" + coduf + '\'' +
                "\ncodmun='" + codmun + '\'' +
                "\ndata='" + data + '\'' +
                "\ncasoAcumulado='" + casosAcumulados + '\'' +
                "\ncasosNovos='" + casosNovos + '\'' +
                "\nobitosAcumulados='" + obitosAcumulados + '\'' +
                "\nobitosNovos='" + obitosNovos + '\'' +
                "\n}";
    }
}