package tn.esprit.spring.service;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import tn.esprit.spring.entity.Facture;
import tn.esprit.spring.repository.FactureRepository;

@Service
@Slf4j
public class FactureServiceImpl implements FactureService{
	@Autowired
	FactureRepository factureRepository;
	@Override
	public List<Facture> retrieveAllFactures() {
		List<Facture> factures = (List<Facture>) factureRepository.findAll();
		
		return factures;
	}
	
	 @Scheduled(cron = "0 0 0 1 * *")
	 public void calculRevenuDuMois(){
		 Date date = new Date();
		 LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		 int month = localDate.getMonthValue();
		 int year =  localDate.getYear();
		 LocalDate premierJour;
		 LocalDate dernierJour;
		 ZoneId z = ZoneId.systemDefault();
		 float revenu = 0;
		 
		 if (month != 1)
		 {
			 premierJour = LocalDate.of(year, month-1, 1);
			 dernierJour = LocalDate.of(year, month-1, 31);
		 }
		 else //si le mois est janvier
		 {
			 premierJour = LocalDate.of(year-1, 12, 1);
			 dernierJour = LocalDate.of(year-1, 12, 31);
		 }
		 //convertir LocalDate to Date
		 Date d1 = Date.from(premierJour.atStartOfDay(z).toInstant());
		 Date d2 = Date.from(dernierJour.atStartOfDay(z).toInstant());
		 
		 List<Facture> factures = (List<Facture>) factureRepository.findAll();
		 for (Facture f : factures )
		 {
			 if ( f.getDateFacture().after(d1) && f.getDateFacture().before(d2))
			 {
			 	revenu += f.getMontantFacture();
			 }
		 }
		 log.info("Revenu de mois : " + month + " = " + revenu + " DT");
		}
	 
	 @Scheduled(cron = "0 0 0 1 1 *")
	 public void calculRevenuAnnuel(){
		 Date date = new Date();
		 LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		 int year =  localDate.getYear();
		 LocalDate premierJour;
		 LocalDate dernierJour;
		 ZoneId z = ZoneId.systemDefault();
		 float revenu = 0;
		 premierJour = LocalDate.of(year-1, 1, 1);
		 dernierJour = LocalDate.of(year-1, 12, 31);
		 //convertir LocalDate to Date
		 Date d1 = Date.from(premierJour.atStartOfDay(z).toInstant());
		 Date d2 = Date.from(dernierJour.atStartOfDay(z).toInstant());
		 
		 List<Facture> factures = (List<Facture>) factureRepository.findAll();
		 for (Facture f : factures )
		 {
			 if ( f.getDateFacture().after(d1) && f.getDateFacture().before(d2))
			 {
			 	revenu += f.getMontantFacture();
			 }
		 }
		 log.info("Revenu de l Année : " + year + " = " + revenu + " DT");
		}
	 
	 
	@Override
	public void cancelFacture(Long id) {
		//if(factureRepository.findById(id).get().getActive()){
		//	factureRepository.findById(id).get().setActive(false);
		//}
		Facture facture = factureRepository.findById(id).orElse(null);
		facture.setActive(false);
		factureRepository.save(facture);
		
	}

	@Override
	public Facture retrieveFacture(Long id) {
		Facture facture = factureRepository.findById(id).get();
		return facture;
	}

	@Override
	public void deleteFacture(Long id) {
		factureRepository.deleteById(id);
	}

}
