package entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Projeto {

	private String nome;
	private Date dt_inicio;
	private Date dt_termino;
	private List<Contratacao> listaContratacao = new ArrayList<>();
	
	public Projeto(String nome, Date dt_inicio, Date dt_termino) {
		this.nome = nome;
		this.dt_inicio = dt_inicio;
		this.dt_termino = dt_termino;
	}
	
	public boolean adicionarContratacao(Contratacao contratacao) {
		
		if(contratacao != null && !listaContratacao.contains(contratacao)) {
			this.listaContratacao.add(contratacao);
			return true;
		}
		
		return false;
	}
	
	public boolean removerContratacao(Contratacao contratacao) {
		
		if(contratacao != null && listaContratacao.size() > 0 && listaContratacao.contains(contratacao)){
			this.listaContratacao.remove(contratacao);
			return true;
		}
		return false;
	}
	
	public void listarContratacoes() {
		
		if(listaContratacao.isEmpty()) {
			System.out.println();
			System.out.println("Projeto: " + this.nome + " não está vinculado em nenhuma contratação!");
		} else {
			System.out.println("***Contratações***");
			System.out.println("Projeto:");
			System.out.println("\t" + this.nome);
			System.out.println("Funcionarios(s):");
			for(Contratacao c : listaContratacao) {
				System.out.println("\t" + c.getFuncionario().getNome()
						+ "[Status: " + c.getStatus() + "]");
			}
		}
	}
	
}
