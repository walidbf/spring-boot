 package tn.esprit.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entity.Client;


@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {
	//@Query("SELECT c Client c WHERE c.dateNaissance BETWEEN :d1 AND :d2")
	//List<Client> findByDateNaissances(@Param ("d1") Date d1,@Param("d2")Date d2);
}
