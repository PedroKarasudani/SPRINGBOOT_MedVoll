package med.voll.api.Service.validations;

import java.time.DayOfWeek;

import jakarta.validation.ValidationException;
import med.voll.api.dto.consultation.ScheduleDataConsultation;

public class validatorClinicOpeningHours {

  public void validation(ScheduleDataConsultation data){
    var dateConsultation = data.date();

    var sunday = dateConsultation.getDayOfWeek().equals(DayOfWeek.SUNDAY);
    var beforeOpeningClinic = dateConsultation.getHour() < 7;
    var afterClosedClinic = dateConsultation.getHour() > 18;

    if (sunday || beforeOpeningClinic || afterClosedClinic) {
      throw new ValidationException("Consulta fora do horario de funcionamento!");
    }

    
  }
}
