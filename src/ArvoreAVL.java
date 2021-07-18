public final class ArvoreAVL extends Arvore  {

	private int altura;
	private No p;

	public ArvoreAVL() {
		raiz = null;
	}

	@Override
	public void Insere(Info dados) {
		System.out.print("Inserindo " + dados.chave + "\n");
		raiz = Insere(raiz, dados, null);
		Avl(p);
	}

	@Override
	public No Insere(No raiz, Info dados, No pai) {
		if (raiz == null) {
			raiz = new No(dados, pai);
			this.p = raiz;
		} else {
			pai = raiz;
			if (dados.chave.compareToIgnoreCase(raiz.dados.chave) < 0)
				raiz.filhoEsq = Insere(raiz.filhoEsq, dados, pai);
			else if (dados.chave.compareToIgnoreCase(raiz.dados.chave) > 0)
				raiz.filhoDir = Insere(raiz.filhoDir, dados, pai);
		}
		return raiz;
	}

	public void Avl(No raiz) {
		if (raiz != null) {
			raiz.bal = balanco(raiz);
			if (raiz.bal < 2) {
				Avl(raiz.pai);
			} else {

				if (raiz.hesq >= raiz.hdir)
					if (raiz.filhoEsq.hesq >= raiz.filhoEsq.hdir) {
						System.out.print("Rotacao simples de " + raiz.dados.chave + " para a direita\n");
						rotacao_direita(raiz);
					} else {
						System.out.print("Rotacao dupla de " + raiz.dados.chave + " para a direita\n");
						rotacao_esquerda(raiz.filhoEsq);
						rotacao_direita(raiz);
					}

				if (raiz.hdir >= raiz.hesq)
					if (raiz.filhoDir.hdir >= raiz.filhoDir.hesq) {
						System.out.print("Rotacao simples de " + raiz.dados.chave + " para a esquerda\n");
						rotacao_esquerda(raiz);
					} else {
						System.out.print("Rotacao dupla de " + raiz.dados.chave + " para a esquerda\n");
						rotacao_direita(raiz.filhoDir);
						rotacao_esquerda(raiz);
					}
			}
		}
	}

	public int balanco(No raiz) {
		altura = 0;
		balpreOrdem(raiz.filhoEsq, 0);
		raiz.hesq = altura;
		altura = 0;
		balpreOrdem(raiz.filhoDir, 0);
		raiz.hdir = altura;
		return Math.abs(raiz.hesq - raiz.hdir);
	}

	public void balpreOrdem(No raiz, int v) {
		if (raiz != null) {
			v++;
			balpreOrdem(raiz.filhoEsq, v);
			balpreOrdem(raiz.filhoDir, v);
		} else if (v > altura)
			altura = v;
	}

	public void rotacao_direita(No raiz) {
		No apu = raiz.filhoEsq;
		raiz.filhoEsq = apu.filhoDir;
		if (apu.filhoDir != null)
			apu.filhoDir.pai = raiz;
		apu.pai = raiz.pai;
		apu.filhoDir = raiz;
		raiz.pai = apu;
		raiz.bal = 0;
		if (apu.pai == null)
			this.raiz = apu;
		else {
			if (apu.dados.chave.compareToIgnoreCase(apu.pai.dados.chave) < 0)
				apu.pai.filhoEsq = apu;
			else
				apu.pai.filhoDir = apu;
		}
	}

	public void rotacao_esquerda(No raiz) {
		No apu = raiz.filhoDir;
		raiz.filhoDir = apu.filhoEsq;
		if (apu.filhoEsq != null)
			apu.filhoEsq.pai = raiz;
		apu.pai = raiz.pai;
		apu.filhoEsq = raiz;
		raiz.pai = apu;
		raiz.bal = 0;
		if (apu.pai == null)
			this.raiz = apu;
		else {
			if (apu.dados.chave.compareToIgnoreCase(apu.pai.dados.chave) < 0)
				apu.pai.filhoEsq = apu;
			else
				apu.pai.filhoDir = apu;
		}
	}

	public No getMax(No raiz) {
		if (raiz.filhoDir == null) {
			if (raiz.filhoEsq != null)
				raiz.filhoEsq.pai = raiz.pai;
			if (raiz.dados.chave.compareToIgnoreCase(raiz.pai.dados.chave) < 0)
				raiz.pai.filhoDir = raiz.filhoEsq;
			else
				raiz.pai.filhoEsq = raiz.filhoEsq;

			return raiz;
		} else
			return getMax(raiz.filhoDir);
	}
}
