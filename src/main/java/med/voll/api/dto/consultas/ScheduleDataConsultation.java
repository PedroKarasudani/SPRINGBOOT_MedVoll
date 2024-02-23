package med.voll.api.dto.consultas;

import java.time.LocalDateTime;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;

public record ScheduleDataConsultation(
  Long idDoctor,

  @NotNull
  Long idPatient,

  @NotNull
  @Future
  LocalDateTime date
) {
}
