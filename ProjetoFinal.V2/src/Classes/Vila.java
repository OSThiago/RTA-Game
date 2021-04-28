package Classes;



import java.util.ArrayList;
import java.util.List;

import tela.Principal;

public class Vila {
	//Atributos
	private Principal principal;
	private Prefeitura prefeitura;
	private List<Aldeao>aldeoes = new ArrayList<Aldeao>();
	private List<Fazenda>fazendas = new ArrayList<Fazenda>();
	private List<Mina>minas = new ArrayList<Mina>();
	private Templo templo;
	private Maravilha maravilha;
	
	
	//Construtores
	public Vila(Principal principal) {
		this.principal = principal;
		this.prefeitura = new Prefeitura(this.principal,this);
		this.maravilha = new Maravilha(this, this.principal);
	}
	
	//Metodos
	
	
	
	/****************** lista aldeoes *************************/
	public int gerarIdAldeao() {
		//System.out.println("Novo id Aldeao:" + this.aldeoes.size() );
		return this.aldeoes.size();
	}
	
	public void addAldeoes(Aldeao aldeao) {
		this.aldeoes.add(aldeao);
	}
	
	public Aldeao getAldeao(int id) {
		return this.aldeoes.get(id);
	}
	
	public List<Aldeao> getListaAldeos() {
		return this.aldeoes;
	}
	
	/****************** lista fazendas *************************/
	public void addFazenda(Fazenda fazenda) {
		this.fazendas.add(fazenda);
	}
	
	public Fazenda getFazenda(int id) {
		return this.fazendas.get(id);
	}
	
	public int gerarIdFazenda() {
		return this.fazendas.size();
	}
	
	public List<Fazenda> getListaFazendas() {
		return this.fazendas;
	}
	
	/****************** lista Mina *************************/
	public void addMina(Mina mina) {
		this.minas.add(mina);
	}
	
	public Mina getMina(int id) {
		return this.minas.get(id);
	}
	
	public int gerarIdMina() {
		return this.minas.size();
	}
	
	public List<Mina> getListaMinas() {
		return this.minas;
	}
	
	/****************** templo *************************/
	public void setTemplo(Templo t){
		this.templo = t;
	}
	
	public Templo getTemplo(){
		return this.templo;
	}
	
	/****************** maravilha *************************/
	public void setMaravilha(Maravilha m){
		this.maravilha = m;
	}
	
	public Maravilha getMaravilha(){
		return this.maravilha;
	}
	
	/****************** prefeitura *************************/
	public Prefeitura getPrefeitura() {
		return this.prefeitura;
	}
	
	
	public boolean verificaEPaga(int comida, int ouro, int oferenda) {
		if(this.prefeitura.getComida() >= comida && this.prefeitura.getOuro() >= ouro && this.prefeitura.getOferenda() >= oferenda) {
			this.prefeitura.retirarComida(comida);
			this.prefeitura.retirarOuro(ouro);
			this.prefeitura.retirarOferenda(oferenda);
			this.principal.mostrarComida(this.prefeitura.getComida());
			this.principal.mostrarOuro(this.prefeitura.getOuro());
			this.principal.mostrarOferendaFe(this.prefeitura.getOferenda());
			return true;
		}
		return false;
	}
	
}
