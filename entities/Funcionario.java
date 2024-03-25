package entities;

import java.util.Objects;

import entities.enums.TipoDeDocumento;

public class Funcionario {
	
	private String nome;
	private String numeroDocumento;
	private TipoDeDocumento documento;
	
	public Funcionario(String nome, TipoDeDocumento documento, String numeroDocumento) {
		super();
		this.nome = nome;
		this.numeroDocumento = numeroDocumento;
		this.documento = documento;
	}

	public String getNome() {
		return nome;
	}

	public String getNumeroDocumento() {
		return numeroDocumento;
	}

	public TipoDeDocumento getDocumento() {
		return documento;
	}

	@Override
	public int hashCode() {
		return Objects.hash(documento, nome, numeroDocumento);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Funcionario other = (Funcionario) obj;
		return documento == other.documento && Objects.equals(nome, other.nome)
				&& Objects.equals(numeroDocumento, other.numeroDocumento);
	}
	
	
}
