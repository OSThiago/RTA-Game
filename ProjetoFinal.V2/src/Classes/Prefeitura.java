package Classes;

import tela.Principal;

public class Prefeitura{
	//Atributos
	private Principal principal;
	private Vila vila;
	private int comida;
	private int ouro;
	private int oferendasDeFe;
	
	//Construtores
	public Prefeitura(Principal principal, Vila vila) {
		this.principal = principal;
		this.vila = vila;
		this.comida = 0;
	}
	
	//Metodos
	
	
	public void criarAldeao() {
		 
		if(this.vila.verificaEPaga(100, 0, 0)) {
			Aldeao novoAldeao = new Aldeao(this.vila,this.vila.gerarIdAldeao(), this.principal);
			this.vila.addAldeoes(novoAldeao);
			novoAldeao.start();
			
			//System.out.println("Novo aldeao criado");
			int numero = novoAldeao.getNumero();
			String funcao = novoAldeao.getFuncao();
			//System.out.println(numero +" "+funcao);

			principal.adicionarAldeao(String.valueOf(numero + 1), funcao);
			principal.mostrarAldeao(numero+1, "Sem funcao");
		}else {
			System.out.println("Não tem recurso suficiente");
		}
		
		
		
		
	}
	
	
	/************************* Comida *****************************/
	public void receberComida(int quantidade) {
		this.comida += quantidade;
	}
	
	public void retirarComida(int quantidade) {
		this.comida -= quantidade;
	}
	
	public int getComida() {
		return this.comida;
	}
	
	/************************* Ouro *****************************/
	
	public void receberOuro(int quantidade) {
		this.ouro += quantidade;
	}
	
	public void retirarOuro(int quantidade) {
		this.ouro -= quantidade;
	}
	
	public int getOuro() {
		return this.ouro;
	}
	
	/************************* Oferendas de fé *****************************/
	
	public void receberOferenda(int quantidade) {
		this.oferendasDeFe += quantidade;
	}
	
	public void retirarOferenda(int quantidade) {
		this.oferendasDeFe -= quantidade;
	}
	
	public int getOferenda() {
		return this.oferendasDeFe;
	}
	
	/************************* Evoluir *****************************/
	
	public void evoluir(String qual) {
		
		if(qual.equals("Evolução de aldeão")) {
			System.out.println("Evoluir aldeao");
			evoluirAldeao();
		}else if(qual.equals("Evolução de fazenda")) {
			System.out.println("Evoluir fazenda");
			
			
		}else if(qual.equals("Evolução de mina de ouro")) {
			System.out.println("Evoluir mina");
		}
	}
	
	private void evoluirAldeao() {
		
		boolean podeEvoluir = false;
		
		/*Primeiro verifica se todos os aldeos já são evoluidos,
		caso ja estejam evoluidos ele não paga de novo
		*/
		for (Aldeao aldeao : this.vila.getListaAldeos()) {
			if(aldeao.getNivel() == 1) {
				podeEvoluir = true;
				aldeao.evoluir();
			}
		}
		if(podeEvoluir) {
			//Colocar o pagamento
		}
	}
	
	private void evoluirFazenda() {
		
		boolean podeEvoluir = false;
		
		/*Primeiro verifica se todos os aldeos já são evoluidos,
		caso ja estejam evoluidos ele não paga de novo
		*/
		for (Fazenda fazenda: this.vila.getListaFazendas()) {
			if(fazenda.getNivel() == 1) {
				podeEvoluir = true;
				fazenda.evoluir();
			}
		}
		if(podeEvoluir) {
			//Colocar o pagamento
		}
	}
	
	private void evoluirMina() {
		
		boolean podeEvoluir = false;
		
		/*Primeiro verifica se todos os aldeos já são evoluidos,
		caso ja estejam evoluidos ele não paga de novo
		*/
		for (Mina mina: this.vila.getListaMinas()) {
			if(mina.getNivel() == 1) {
				podeEvoluir = true;
				mina.evoluir();
			}
		}
		if(podeEvoluir) {
			//Colocar o pagamento
		}
	}
	
}
