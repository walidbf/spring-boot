package tn.esprit.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import tn.esprit.spring.entity.DetailProduit;

public interface DetailProduitRepository extends JpaRepository<DetailProduit,Long> {

}
