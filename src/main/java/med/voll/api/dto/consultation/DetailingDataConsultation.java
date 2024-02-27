package med.voll.api.dto.consultation;

import java.time.LocalDateTime;

public record DetailingDataConsultation(Long id, Long idDoctor, Long idPatient, LocalDateTime date) {
}
