package med.voll.api.Service.validations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import jakarta.validation.ValidationException;
import med.voll.api.dto.consultation.ScheduleDataConsultation;
import med.voll.api.repository.ConsultationRepository;

@Component
public class validatorDoctorInConsultationAtTheSameTime implements validatorSchedulingConsultation{

  @Autowired
  private ConsultationRepository consultationRepository;

  public void validation(ScheduleDataConsultation data){
    var doctorInConsultationAtTheSameTime = consultationRepository.existsByDoctorIdAndDate(data.idDoctor(), data.date());
    if (doctorInConsultationAtTheSameTime) {
      throw new ValidationException("Medico ja possui outra consulta adendada nesse mesmo horario");
    }
  }
}

