package med.voll.api.dto.consultation;

import jakarta.validation.constraints.NotNull;

public record CancelDataConsultation(
  @NotNull
  Long idConsutation,

  @NotNull
  CancellationReason reason) {
  
}
