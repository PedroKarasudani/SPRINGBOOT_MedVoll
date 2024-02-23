package med.voll.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import med.voll.api.model.Consultation;

public interface ConsultationRepository extends JpaRepository<Consultation,Long>{
  
}