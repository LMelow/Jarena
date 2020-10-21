/*
 * referências em classe Agente.java.
 * Leonardo Rebonatto <leo.comikevizk@gmail.com>
 * (Pegar infos com ___get___ e configurar com ____set____)
 *  getDirecao() getInimigoJuntoComigo() getEquipe()
 * Funções disponiveis:
 * setDirecao(1-2-3-4-5-geraDirecaoAleatoria());
 * public static final int DIREITA					= 1;
 * public static final int ESQUERDA					= 2;
 * public static final int CIMA						= 3;
 * public static final int BAIXO					= 4;
 * public static final int NENHUMA_DIRECAO			= 5;
  
● boolean podeMoverPara(int direcao)
● boolean gastaEnergia(int quanto)
● boolean isParado()
● void para()
● int geraDirecaoAleatoria()
● boolean podeDividir()
● void setDirecao(int direcao)
● boolean divide()
● void morre()
● void enviaMensagem(String msg)	
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
		//##se parou de receber energia setar direção de onde encontrou o cogumelo##
		System.out.println(getEnergia);
		if (getEnergia() < 800){
			setDirecao(DIREITA);

		}
		

		if(!podeMoverPara(getDirecao())) {
			// Como não conseguimos nos mover, vamos escolher uma direção
			// nova.
			setDirecao(geraDirecaoAleatoria());
		
		}
		
		// Se o agente conseguie se dividir (tem energia) e se o total de energia
		// do agente é maior que 400, nos dividimos. O agente filho terá a metade
		// da nossa energia atual.
		if(podeDividir() && getEnergia() >= 1001) {
			divide();//Divisão compromete minha força, mas ajuda a aumentar o poder da equipe

		}
	}
	
	public void recebeuEnergia() {
		// Invocado sempre que o agente recebe energia.
		para();
		
	
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
