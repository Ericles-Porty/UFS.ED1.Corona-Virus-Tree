public class Info {
    public String chaveMunData;
    public String chaveUF;
    public String chave;

    public String regiao;
    public String estado;
    public String municipio;
    public String coduf;
    public String codmun;
    public String codRegiaoSaude;
    public String nomeRegiaoSaude;
    public String data;
    public String semanaEpi;
    public String populacaoTcu2019;
    public String casoAcumulado;
    public String casosNovos;
    public String obitosAcumulado;
    public String obitosNovos;
    public String recuperaDoNovos;
    public String emcompanhamemtoNovos;
    public String interior;

    public Info(String regiao, String estado, String municipio, String coduf, String codmun, String codRegiaoSaude, String nomeRegiaoSaude, String data, String semanaEpi, String populacaoTcu2019, String casoAcumulado, String casosNovos, String obitosAcumulado, String obitosNovos, String recuperaDoNovos, String emcompanhamemtoNovos, String interior) {
        if(codmun == null)
        	return;
    	if(codmun.equals(null)) {
        	this.chave = coduf+data;
        } else
        	this.chave = codmun+data;
        this.chaveMunData = codmun+data;
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

	@Override
	public String toString() {
		return "Info [regiao=" + regiao + ", estado=" + estado + ", municipio=" + municipio + ", coduf=" + coduf
				+ ", codmun=" + codmun + ", codRegiaoSaude=" + codRegiaoSaude + ", nomeRegiaoSaude=" + nomeRegiaoSaude
				+ ", data=" + data + ", semanaEpi=" + semanaEpi + ", populacaoTcu2019=" + populacaoTcu2019
				+ ", casoAcumulado=" + casoAcumulado + ", casosNovos=" + casosNovos + ", obitosAcumulado="
				+ obitosAcumulado + ", obitosNovos=" + obitosNovos + ", recuperaDoNovos=" + recuperaDoNovos
				+ ", emcompanhamemtoNovos=" + emcompanhamemtoNovos + ", interior=" + interior + "]";
	}
    
    
}
