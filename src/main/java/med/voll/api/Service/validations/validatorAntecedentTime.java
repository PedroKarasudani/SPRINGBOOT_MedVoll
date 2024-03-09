package med.voll.api.Service.validations;

import java.time.Duration;
import java.time.LocalDateTime;

import jakarta.validation.ValidationException;
import med.voll.api.dto.consultation.ScheduleDataConsultation;

public class validatorAntecedentTime {
  
    public void validation(ScheduleDataConsultation data){
      var dateConsultation = data.date();
      var now = LocalDateTime.now();
      var difference = Duration.between(now, dateConsultation).toMinutes();

      if (difference < 30) {
        throw new ValidationException("Consulta deve ser agendada com antecedencia minima de 30 minutos.");
      }
    }
}
