package Classes;

import java.util.ArrayList;
import java.util.List;
import tela.Principal;

public class Templo {
	//Atributos
	private Principal principal;
	private Vila vila;
	private List<String> evolucoes;
	
	//Construtor
	public Templo(Vila vila, Principal principal){
		this.vila = vila;
		this.principal = principal;
		this.evolucoes = new ArrayList<String>();
	}
	
	//Metodos
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
	public void escolheEvolucao(String qual){
		if(qual.equals("Nuvem de gafanhotos")){
			//Colocar preço
			evoluirNuvem();
		}
		
		if(qual.equals("Morte dos primogênitos")){
			//Colocar preço
			evoluirMorte();
		}
		
		if(qual.equals("Chuva de pedras")){
			//Colocar preço
			evoluirChuva();
		}
	}
	
	public void evoluirNuvem(){
		//colocar a duração da construção
		this.evolucoes.add("NUVEM_GAFANHOTOS");
		this.principal.mostrarAtaques(this.evolucoes);
	}
	
	public void evoluirMorte(){
		//colocar a duração da construção
		this.evolucoes.add("MORTE_PRIMOGENITOS");
		this.principal.mostrarAtaques(this.evolucoes);
	}
	
	public void evoluirChuva(){
		//colocar a duração da construção
		this.evolucoes.add("CHUVA_PEDRAS");
		this.principal.mostrarAtaques(this.evolucoes);
	}
	
}
