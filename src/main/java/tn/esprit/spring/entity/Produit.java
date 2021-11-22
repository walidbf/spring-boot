package tn.esprit.spring.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

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
public class Produit implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long idProduit;
	@NonNull private String codeProduit;
	@NonNull private String libelleProduit;
	@NonNull private float prixUnitaire;
	@ManyToMany(cascade = CascadeType.ALL) 
	@ToString.Exclude
	private Set<Fournisseur> produitsfor;
	@ManyToOne
	@ToString.Exclude
	Rayon rayon;
	@ManyToOne
	@ToString.Exclude
	Stock stock;
	@OneToOne
	@ToString.Exclude
	private DetailProduit detailProduit;
	@OneToMany(cascade = CascadeType.ALL, mappedBy="produit")
	@ToString.Exclude
	private Set<DetailFacture> detailFacture;
}
