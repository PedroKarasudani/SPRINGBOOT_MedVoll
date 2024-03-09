package med.voll.api.repository;

import java.time.LocalDateTime;

import org.springframework.data.jpa.repository.JpaRepository;

import med.voll.api.model.Consultation;

public interface ConsultationRepository extends JpaRepository<Consultation,Long>{

  Boolean existsByDoctorIdAndDate(Long idDoctor, LocalDateTime date);

  Boolean existsByPatientIdAndDateBetween(Long idPatient, LocalDateTime firstTime, LocalDateTime lastTime);
  
}