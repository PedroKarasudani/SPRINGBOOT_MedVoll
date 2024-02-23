package med.voll.api.dto.consultas;

import java.time.LocalDateTime;

public record DetailingDataConsultation(Long id, Long idDoctor, Long idPatient, LocalDateTime date) {
}
