package med.voll.api.Service.validations;

import java.time.LocalDateTime;

import jakarta.validation.ValidationException;
import med.voll.api.dto.consultation.ScheduleDataConsultation;
import med.voll.api.repository.ConsultationRepository;

public class validatorDoctorInConsultationAtTheSameTime {

  private ConsultationRepository consultationRepository;

  public void validation(ScheduleDataConsultation data){
    var doctorInConsultationAtTheSameTime = consultationRepository.existsByDoctorIdAndDate(data.idDoctor(), data.date());
    if (doctorInConsultationAtTheSameTime) {
      throw new ValidationException("Medico ja possui outra consulta adendada nesse mesmo horario");
    }
  }
}

