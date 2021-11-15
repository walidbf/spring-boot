package tn.esprit.spring.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Client implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long idClient;
	private String nom;
	private String prenom;
	private Date dateNaissance;
	private String email;
	private String password;
	private CategorieClient categorieClient;
	private Profession profession;
	@OneToMany(cascade = CascadeType.ALL, mappedBy="client")
	@ToString.Exclude
	private Set<Facture> facture;
	public Client(Long idClient, String nom, String prenom, Date dateNaissance, String email, String password,
			CategorieClient categorieClient, Profession profession) {
		super();
		this.idClient = idClient;
		this.nom = nom;
		this.prenom = prenom;
		this.dateNaissance = dateNaissance;
		this.email = email;
		this.password = password;
		this.categorieClient = categorieClient;
		this.profession = profession;
	}
	public Client(Long idClient, String nom, String prenom){
		this.idClient = idClient;
		this.nom = nom;
		this.prenom = prenom;
	}

	
	
	
	

}
