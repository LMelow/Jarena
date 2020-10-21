/*
 * referências em classe Agente.java.
 * Leonardo Rebonatto <leo.comikevizk@gmail.com>
*/

package br.uffs.cc.jarena;

public class Detergente extends Agente
{
	public Detergente(Integer x, Integer y, Integer energia) {
		super(x, y, energia);
		setDirecao(BAIXO);
	}
	
	public void pensa() {
		// Se não conseguimos nos mover para a direção atual, quer dizer
		// que chegamos no final do mapa ou existe algo bloqueando nosso
		// caminho.
		if(!podeMoverPara(getDirecao())) {
			// Como não conseguimos nos mover, vamos escolher uma direção
			// nova.
			setDirecao(geraDirecaoAleatoria());
		
		}
		
		// Se o agente conseguie se dividir (tem energia) e se o total de energia
		// do agente é maior que 400, nos dividimos. O agente filho terá a metade
		// da nossa energia atual.
		if(podeDividir() && getEnergia() >= 800) {
			//divide()
		}
	}
	
	public void recebeuEnergia() {
		// Invocado sempre que o agente recebe energia.
		setDirecao(NENHUMA_DIRECAO);
	}
	
	public void tomouDano(int energiaRestanteInimigo) {
		// Invocado quando o agente está na mesma posição que um agente inimigo
		// e eles estão batalhando (ambos tomam dano).
		if (energiaRestanteInimigo>=400){
			setDirecao(geraDirecaoAleatoria());
		}else{
			setDirecao(5);	
		}

	}
	
	public void ganhouCombate() {
		// Invocado se estamos batalhando e nosso inimigo morreu.
	}
	
	public void recebeuMensagem(String msg) {
		// Invocado sempre que um agente aliado próximo envia uma mensagem.
	}
	
	public String getEquipe() {
		// O nome da equipe do agente é:
		return "Detergente";
	}
}
