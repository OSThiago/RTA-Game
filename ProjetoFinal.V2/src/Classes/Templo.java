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
		System.out.println("Transportou 2 unidades de oferendas de f�");
		
	}
	
	public void receberSacrificio(){	
			
			this.vila.getPrefeitura().receberOferenda(100);
			this.principal.mostrarOferendaFe(this.vila.getPrefeitura().getOferenda());
			System.out.println("O seacificio gerou 100 oferendas!");
		
	}
	
	//Evolu��es
	public void escolheEvolucao(String qual){
		if(qual.equals("Nuvem de gafanhotos")){
			//Colocar pre�o
			evoluirNuvem();
		}
		
		if(qual.equals("Morte dos primog�nitos")){
			//Colocar pre�o
			evoluirMorte();
		}
		
		if(qual.equals("Chuva de pedras")){
			//Colocar pre�o
			evoluirChuva();
		}
	}
	
	public void evoluirNuvem(){
		//colocar a dura��o da constru��o
		this.evolucoes.add("NUVEM_GAFANHOTOS");
		this.principal.mostrarAtaques(this.evolucoes);
	}
	
	public void evoluirMorte(){
		//colocar a dura��o da constru��o
		this.evolucoes.add("MORTE_PRIMOGENITOS");
		this.principal.mostrarAtaques(this.evolucoes);
	}
	
	public void evoluirChuva(){
		//colocar a dura��o da constru��o
		this.evolucoes.add("CHUVA_PEDRAS");
		this.principal.mostrarAtaques(this.evolucoes);
	}
	
}
