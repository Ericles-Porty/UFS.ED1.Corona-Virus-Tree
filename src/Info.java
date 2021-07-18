public class Info {
    public String chave;

    private final String regiao;
    private final String estado;
    private final String municipio;
    private final String coduf;
    private final String codmun;
    private final String codRegiaoSaude;
    private final String nomeRegiaoSaude;
    private final String data;
    private final String semanaEpi;
    private final String populacaoTcu2019;
    private final String casoAcumulado;
    private final String casosNovos;
    private final String obitosAcumulado;
    private final String obitosNovos;
    private final String recuperaDoNovos;
    private final String emcompanhamemtoNovos;
    private final String interior;

    public Info(String regiao, String estado, String municipio, String coduf, String codmun, String codRegiaoSaude, String nomeRegiaoSaude, String data, String semanaEpi, String populacaoTcu2019, String casoAcumulado, String casosNovos, String obitosAcumulado, String obitosNovos, String recuperaDoNovos, String emcompanhamemtoNovos, String interior) {
        if (codmun.equals("")) {
            this.chave = coduf + data;
        } else
            this.chave = codmun + data;
        this.regiao = regiao;
        this.estado = estado;
        this.municipio = municipio;
        this.coduf = coduf;
        this.codmun = codmun;
        this.codRegiaoSaude = codRegiaoSaude;
        this.nomeRegiaoSaude = nomeRegiaoSaude;
        this.data = data;
        this.semanaEpi = semanaEpi;
        this.populacaoTcu2019 = populacaoTcu2019;
        this.casoAcumulado = casoAcumulado;
        this.casosNovos = casosNovos;
        this.obitosAcumulado = obitosAcumulado;
        this.obitosNovos = obitosNovos;
        this.recuperaDoNovos = recuperaDoNovos;
        this.emcompanhamemtoNovos = emcompanhamemtoNovos;
        this.interior = interior;
    }

    public String toString() {
        return "Info [regiao=" + regiao + ", estado=" + estado + ", municipio=" + municipio + ", coduf=" + coduf
                + ", codmun=" + codmun + ", codRegiaoSaude=" + codRegiaoSaude + ", nomeRegiaoSaude=" + nomeRegiaoSaude
                + ", data=" + data + ", semanaEpi=" + semanaEpi + ", populacaoTcu2019=" + populacaoTcu2019
                + ", casoAcumulado=" + casoAcumulado + ", casosNovos=" + casosNovos + ", obitosAcumulado="
                + obitosAcumulado + ", obitosNovos=" + obitosNovos + ", recuperaDoNovos=" + recuperaDoNovos
                + ", emcompanhamemtoNovos=" + emcompanhamemtoNovos + ", interior=" + interior + "]";
    }


}