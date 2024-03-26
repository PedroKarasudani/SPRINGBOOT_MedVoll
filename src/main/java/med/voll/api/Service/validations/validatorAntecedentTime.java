package med.voll.api.Service.validations;

import java.time.Duration;
import java.time.LocalDateTime;

import org.springframework.stereotype.Component;

import med.voll.api.dto.consultation.ScheduleDataConsultation;
import med.voll.api.model.ExceptionValidation;

@Component
public class validatorAntecedentTime implements validatorSchedulingConsultation {
  
    public void validation(ScheduleDataConsultation data){
      var dateConsultation = data.date();
      var now = LocalDateTime.now();
      var difference = Duration.between(now, dateConsultation).toMinutes();

      if (difference < 30) {
        throw new ExceptionValidation("Consulta deve ser agendada com antecedencia minima de 30 minutos.");
      }
    }
}
