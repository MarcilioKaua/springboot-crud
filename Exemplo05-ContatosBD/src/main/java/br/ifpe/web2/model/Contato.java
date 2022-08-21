package br.ifpe.web2.model;

import java.util.Arrays;
import java.util.Date;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Contato {
	
	//Entidades
	private String nome;
	private String telefone;
	@Id
	private String email;
	private String[] apps;
	private String grupo;
	//Convertendo o formato de data para não dar erro 
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date dataNascimento;
	private String estado;
	
	//Encapsulamento 
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String[] getApps() {
		return apps;
	}
	public void setApps(String[] apps) {
		this.apps = apps;
	}
	public String getGrupo() {
		return grupo;
	}
	public void setGrupo(String grupo) {
		this.grupo = grupo;
	}
	public Date getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	
	@Override
	public int hashCode() {
		return Objects.hash(email);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Contato other = (Contato) obj;
		return Objects.equals(email, other.email);
	}
	
	@Override
	public String toString() {
		return "Contato [nome=" + nome + ", telefone=" + telefone + ", email=" + email + ", apps="
				+ Arrays.toString(apps) + ", grupo=" + grupo + ", dataNascimento=" + dataNascimento + ", estado="
				+ estado + "]";
	}
	
}
