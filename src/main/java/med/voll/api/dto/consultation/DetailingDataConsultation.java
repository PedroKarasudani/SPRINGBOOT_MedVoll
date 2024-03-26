package med.voll.api.dto.consultation;

import java.time.LocalDateTime;

import med.voll.api.model.Consultation;

public record DetailingDataConsultation(Long id, Long idDoctor, Long idPatient, LocalDateTime date) {

  public DetailingDataConsultation(Consultation consultation) {
    this(consultation.getId(), consultation.getDoctor().getId(), consultation.getPatient().getId(), consultation.getDate());
  }
}
