package Classes;

import java.util.ArrayList;
import java.util.List;
import tela.Principal;

public class Templo extends Thread{
	//Atributos
	private Principal principal;
	private Vila vila;
	private List<String> evolucoes;
	private AcaoTemplo acaoTemplo;
	private String qualEvolucao;
	
	//Construtor
	public Templo(Vila vila, Principal principal){
		this.vila = vila;
		this.principal = principal;
		this.evolucoes = new ArrayList<String>();
		this.acaoTemplo = AcaoTemplo.PARADO;
	}
	
	//Metodos
	
	public void run() {
		while(true) {
			switch(acaoTemplo) {
			case PARADO:
				parar();
				break;
			case EVOLUINDO:
				evolucao();
				break;
			}
		}
		
	}
	
	
	private void parar() {
		synchronized (this) {
			try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	
	public void produzirOferendaDeFe(){
		try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		this.vila.getPrefeitura().receberOferenda(2);
		this.principal.mostrarOferendaFe(this.vila.getPrefeitura().getOferenda());
		System.out.println("Transportou 2 unidades de oferendas de fé");
		
	}
	
	public void receberSacrificio(){	
			
			this.vila.getPrefeitura().receberOferenda(100);
			this.principal.mostrarOferendaFe(this.vila.getPrefeitura().getOferenda());
			System.out.println("O seacificio gerou 100 oferendas!");
		
	}
	
	//Evoluções
	public void evolucao(){
		if(this.qualEvolucao.equals("Nuvem de gafanhotos")){
			evoluirNuvem();
		}
		
		if(this.qualEvolucao.equals("Morte dos primogênitos")){
			evoluirMorte();
		}
		
		if(this.qualEvolucao.equals("Chuva de pedras")){
			evoluirChuva();
		}
		this.setAcaoTemplo(AcaoTemplo.PARADO);
	}
	
	public void evoluirNuvem(){
		int precoOferenda = 0;
		
		if(!verificaPreco(precoOferenda)) {
			return;
		}
		
		if(existeEvolucao("NUVEM_GAFANHOTOS")) {
			return;
		}
		
		try {
			this.vila.getPrefeitura().retirarOferenda(precoOferenda);
			Thread.sleep(5000);
			this.evolucoes.add("NUVEM_GAFANHOTOS");
			this.principal.mostrarAtaques(this.evolucoes);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void evoluirMorte(){
		int precoOferenda = 0;
		
		if(!verificaPreco(precoOferenda)) {
			return;
		}
		
		if(existeEvolucao("MORTE_PRIMOGENITOS")) {
			return;
		}
			
		try {
			this.vila.getPrefeitura().retirarOferenda(precoOferenda);
			Thread.sleep(5000);
			this.evolucoes.add("MORTE_PRIMOGENITOS");
			this.principal.mostrarAtaques(this.evolucoes);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void evoluirChuva(){
		int precoOferenda = 0;
		
		if(!verificaPreco(precoOferenda)) {
			return;
		}
		
		if(existeEvolucao("NUVEM_GAFANHOTOS")) {
			return;
		}
		
		try {
			this.vila.getPrefeitura().retirarOferenda(precoOferenda);
			Thread.sleep(5000);
			this.evolucoes.add("CHUVA_PEDRAS");
			this.principal.mostrarAtaques(this.evolucoes);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}		
	}
	
	
	private boolean verificaPreco(int preco) {
		if(this.vila.getPrefeitura().getOferenda() >= preco) {
			return true;
		}	
		return false;
	}
	
	private boolean existeEvolucao(String evolucao) {
		if(this.evolucoes == null){
			return false;
		}
		for (String evolucaoExistente : evolucoes) {
			if(evolucaoExistente == evolucao) {
				return true;
			}
		}
		return false;
	}
	
	public void setAcaoTemplo(AcaoTemplo acao) {
		this.acaoTemplo = acao;
		
		synchronized (this) {
			notify();
		}
		
	}
	
	public void setQualEvolucao(String evolucao) {
		this.qualEvolucao = evolucao;
	}
	
}
