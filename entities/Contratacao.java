package entities;

import java.util.Date;
import java.util.Objects;
import java.util.Date;

import entities.enums.Cargo;
import entities.enums.Status;

public class Contratacao{
	
	private Date datal;
	private Cargo cargo;
	private Status status;
	private Funcionario funcionario;
	private Projeto projeto;
	
	public Contratacao(Date datal, Cargo cargo, Funcionario funcionario, Projeto projeto) {
		this.datal = datal;
		this.cargo = cargo;
		this.status = Status.PENDENTE;
		this.funcionario = funcionario;
		projeto.adicionarContratacao(this);
	}

	public Date getDatal() {
		return datal;
	}

	public Cargo getCargo() {
		return cargo;
	}

	public Status getStatus() {
		return status;
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public Projeto getProjeto() {
		return projeto;
	}

	
	@Override
	public int hashCode() {
		return Objects.hash(cargo, datal, funcionario, projeto, status);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Contratacao other = (Contratacao) obj;
		return cargo == other.cargo && Objects.equals(datal, other.datal)
				&& Objects.equals(funcionario, other.funcionario) && Objects.equals(projeto, other.projeto)
				&& status == other.status;
	}

	@Override
	public String toString() {
		return "Contratacao [datal=" + datal + ", cargo=" + cargo + ", status=" + status + ", funcionario="
				+ funcionario + ", projeto=" + projeto + "]";
	}
	
	public void pendente() {
		if(this.status == Status.CONTRATADO || this.status == Status.DEMITIDO) {
			this.status = Status.PENDENTE;
		}
	}
	
	public void contratar() {
		if(this.status == Status.PENDENTE) {
			this.status = Status.CONTRATADO;
		}
	}
	
	public void demitir() {
		if(this.status == Status.CONTRATADO) {
			this.status = Status.DEMITIDO;
			projeto.removerContratacao(this);
		}
	}

}
