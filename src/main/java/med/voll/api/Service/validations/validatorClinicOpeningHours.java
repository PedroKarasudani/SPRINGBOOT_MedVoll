package med.voll.api.Service.validations;

import java.time.DayOfWeek;

import org.springframework.stereotype.Component;

import med.voll.api.dto.consultation.ScheduleDataConsultation;
import med.voll.api.model.ExceptionValidation;

@Component
public class validatorClinicOpeningHours implements validatorSchedulingConsultation{

  
  public void validation(ScheduleDataConsultation data){
    var dateConsultation = data.date();

    var sunday = dateConsultation.getDayOfWeek().equals(DayOfWeek.SUNDAY);
    var beforeOpeningClinic = dateConsultation.getHour() < 7;
    var afterClosedClinic = dateConsultation.getHour() > 18;

    if (sunday || beforeOpeningClinic || afterClosedClinic) {
      throw new ExceptionValidation("Consulta fora do horario de funcionamento!");
    }

    
  }
}
