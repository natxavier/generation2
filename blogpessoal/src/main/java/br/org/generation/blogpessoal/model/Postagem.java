package br.org.generation.blogpessoal.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity  //Anotação que indica que esta classe irá gerar uma tabela no banco de dados
@Table(name = "tb_postagens") //Nome da Tabela
public class Postagem {

	@Id //Chave primária
	@GeneratedValue(strategy = GenerationType.IDENTITY)  //Auto incremento
	private long id;
	
	@NotNull(message = "O atributo título é obrigatório")  //Não ser nulo(obriga o usuario a dar valor ao atributo)
	@Size(min = 5,max = 100,message = "O atributo título deve conter no mínimo 5 e no maximo 100 caracteres")  //Define o tamanho máximo e mínimo de caracteres.
	private String titulo;
	
	@NotNull(message = "O atributo texto é obrigatório")  //Não ser nulo(obriga o usuario a dar valor ao atributo)
	@Size(min = 10,max = 1000,message = "O atributo texto deve conter no mínimo 10 e no maximo 1000 caracteres") 
	private String texto;
	
	@Temporal(TemporalType.TIMESTAMP)  //indicando que a data e a hora serão recebidas do sistema
	private Date data = new java.sql.Date(System.currentTimeMillis());  //grava a hora com milisegundos

	//get -->serve para ler dados do atributo
	public long getId() {
		return id;
	}

	//set --> serve para alterar os dados do atributo
	public void setId(long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}
	
	
}

