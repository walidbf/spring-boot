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
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
@ToString
public class Client implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long idClient;
	@NonNull private String nom;
	@NonNull private String prenom;
	@NonNull private Date dateNaissance;
	@NonNull private String email;
	@NonNull private String password;
	@NonNull private CategorieClient categorieClient;
	@NonNull private Profession profession;
	@OneToMany(cascade = CascadeType.ALL, mappedBy="client")
	@ToString.Exclude
	private Set<Facture> facture;

	
	
	
	

}
