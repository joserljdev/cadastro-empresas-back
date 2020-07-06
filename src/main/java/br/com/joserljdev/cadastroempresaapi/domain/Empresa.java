package br.com.joserljdev.cadastroempresaapi.domain;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.br.CNPJ;

@Entity
public class Empresa {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull(message = "*CNPJ é obrigatório")
	@CNPJ(message = "CNPJ inválido")
	private String cnpj;

	@NotNull(message = "*Tipo é obrigatório")
	@Enumerated(EnumType.STRING)
	private Tipo tipo;

	@NotBlank(message = "*Nome é obrigatório")
	@Size(max = 50, message = "O nome deve conter no máximo 50 caracteres")
	private String nome;

	@NotBlank(message = "*Razão Social é obrigatória")
	@Size(max = 40, message = "A razão social deve conter no máximo 40 caracteres")
	private String razaoSocial;

	@NotBlank(message = "*Contato é obrigatório")
	@Size(max = 40, message = "O contato deve conter no máximo 40 caracteres")
	private String contato;

	@NotEmpty(message = "*E-mail é obrigatório")
	@Size(max = 40, message = "O e-mail deve conter no máximo 40 caracteres")
	@Email(message = "E-mail inválido")
	private String email;

	@NotBlank(message = "*CEP é obrigatório")
	@Size(max = 8, message = "O CEP deve conter 8")
	private String cep;

	@NotBlank(message = "*Estado é obrigatório")
	@Size(max = 40, message = "O estado deve conter no máximo 40 caracteres")
	private String estado;

	@NotBlank(message = "*Bairro é obrigatório")
	@Size(max = 40, message = "O bairro deve conter no máximo 40 caracteres")
	private String bairro;

	@NotBlank(message = "*Cidade é obrigatória")
	@Size(max = 40, message = "A cidade deve conter no máximo 40 caracteres")
	private String cidade;

	@NotBlank(message = "*Logradouro é obrigatório")
	@Size(max = 40, message = "O logradouro deve conter no máximo 40 caracteres")
	private String logradouro;
	
	@Size(max = 40, message = "O complemento deve conter no máximo 40 caracteres")
	private String complemento;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public Tipo getTipo() {
		return tipo;
	}

	public void setTipo(Tipo statusTipo) {
		this.tipo = statusTipo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getRazaoSocial() {
		return razaoSocial;
	}

	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}

	public String getContato() {
		return contato;
	}

	public void setContato(String contato) {
		this.contato = contato;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Empresa other = (Empresa) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}