package models;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;

import play.db.jpa.Model;

@Entity
public class Produto extends Model {
	public String nome;
	public String desc;
	public int valor;
	
}
