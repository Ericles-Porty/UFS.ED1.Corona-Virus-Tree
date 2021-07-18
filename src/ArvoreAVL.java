public class ArvoreAVL extends Arvore{
	
	private int h;
	private No p;

	public ArvoreAVL () { 
		T = null;
	}
	@Override
	public void insere (Info dados) {
		System.out.print("Inserindo "+dados.chave+"\n");
		T = insere(T,dados,null);
		AVL(p);
	}
	@Override
	public No insere (No T, Info dados, No pai) {
		if (T == null) {
			T = new No(dados,pai);
			this.p = T;
		} else {
			pai = T;
			if (dados.chave.compareToIgnoreCase(T.dados.chave) < 0)
				T.filhoEsq = insere(T.filhoEsq,dados,pai);
			else if (dados.chave.compareToIgnoreCase(T.dados.chave) > 0)
				T.filhoDir = insere(T.filhoDir,dados,pai);
		}
		return T;
	}
	
	public void AVL(No T) {
		if (T != null) {
			T.bal = balanco(T);
			if (T.bal < 2) {
				AVL(T.pai);
			} else {

				if (T.hesq >= T.hdir) 
					if (T.filhoEsq.hesq >= T.filhoEsq.hdir) { 
						System.out.print("Rotacao simples de "+T.dados.chave+" para a direita\n");
						rotacao_direita(T);
					}
					else { 
						System.out.print("Rotacao dupla de "+T.dados.chave+" para a direita\n");
						rotacao_esquerda(T.filhoEsq);
						rotacao_direita(T);
					}

				if (T.hdir >= T.hesq) 
					if (T.filhoDir.hdir >= T.filhoDir.hesq) { 
						System.out.print("Rotacao simples de "+T.dados.chave+" para a esquerda\n");
						rotacao_esquerda(T);
					}
					else {
						System.out.print("Rotacao dupla de "+T.dados.chave+" para a esquerda\n");
						rotacao_direita(T.filhoDir);
						rotacao_esquerda(T);
					}				
			}
		}
	}

	public int balanco(No T) {
		h = 0; balpreOrdem(T.filhoEsq,0); T.hesq = h;
		h = 0; balpreOrdem(T.filhoDir,0); T.hdir = h;
		return Math.abs(T.hesq-T.hdir);
	}

	public void balpreOrdem (No T, int v) {
		if (T != null) {
			v++;
			balpreOrdem(T.filhoEsq,v);
			balpreOrdem(T.filhoDir,v);
		} else 
			if (v > h) h = v;
	}

	public void rotacao_direita(No T) {
		No apu = T.filhoEsq;
		T.filhoEsq = apu.filhoDir;
		if (apu.filhoDir != null) apu.filhoDir.pai = T; 
		apu.pai = T.pai; 
		apu.filhoDir = T; T.pai = apu; 
		T.bal = 0;
		if (apu.pai == null)
			this.T = apu;
		else {
			if (apu.dados.chave.compareToIgnoreCase(apu.pai.dados.chave) < 0) 
				apu.pai.filhoEsq = apu; 
			else
				apu.pai.filhoDir = apu; 				
		}
	}

	public void rotacao_esquerda(No T) {
		No apu = T.filhoDir;
		T.filhoDir = apu.filhoEsq;
		if (apu.filhoEsq != null) apu.filhoEsq.pai = T; 
		apu.pai = T.pai; 
		apu.filhoEsq = T; T.pai = apu; 
		T.bal = 0;
		if (apu.pai == null) 
			this.T = apu;
		else {
			if (apu.dados.chave.compareToIgnoreCase(apu.pai.dados.chave) < 0) 
				apu.pai.filhoEsq = apu; 
			else
				apu.pai.filhoDir = apu; 				
		}
	}
	
	public No getMax (No T) {
		if (T.filhoDir == null) 
		{
			if (T.filhoEsq != null) T.filhoEsq.pai = T.pai;
			if (T.dados.chave.compareToIgnoreCase(T.pai.dados.chave) < 0)
				T.pai.filhoDir = T.filhoEsq;
			else
				T.pai.filhoEsq = T.filhoEsq;

			return T;
		}
		else
			return getMax(T.filhoDir);
	}
}
