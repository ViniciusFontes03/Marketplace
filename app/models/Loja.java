package models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import play.db.jpa.Model;

@Entity
public class Loja extends Model {

	public String nomeProprietario;
	public int cpf;
	public String nomeLoja;
	public int cnpj;
	
	@OneToMany
	@JoinColumn(name="idLoja")
	public List<Produto> listaProdutos;
}
