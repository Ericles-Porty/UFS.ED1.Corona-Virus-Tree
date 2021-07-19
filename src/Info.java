public class Info {
    public String chave;

    private final String regiao;
    private final String estado;
    private final String municipio;
    private final String coduf;
    private final String codmun;
    private final String data;
    private final String casoAcumulado;
    private final String casosNovos;
    private final String obitosAcumulado;
    private final String obitosNovos;

    public Info(String regiao, String estado, String municipio, String coduf, String codmun, String data, String casoAcumulado, String casosNovos, String obitosAcumulado, String obitosNovos) {
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
        this.casoAcumulado = casoAcumulado;
        this.casosNovos = casosNovos;
        this.obitosAcumulado = obitosAcumulado;
        this.obitosNovos = obitosNovos;
    }

    public String toString() {
        return "Info{\n" +
                "\nchave='" + chave + '\'' +
                "\nregiao='" + regiao + '\'' +
                "\nestado='" + estado + '\'' +
                "\nmunicipio='" + municipio + '\'' +
                "\ncoduf='" + coduf + '\'' +
                "\ncodmun='" + codmun + '\'' +
                "\ndata='" + data + '\'' +
                "\ncasoAcumulado='" + casoAcumulado + '\'' +
                "\ncasosNovos='" + casosNovos + '\'' +
                "\nobitosAcumulado='" + obitosAcumulado + '\'' +
                "\nobitosNovos='" + obitosNovos + '\'' +
                "\n}";
    }
}