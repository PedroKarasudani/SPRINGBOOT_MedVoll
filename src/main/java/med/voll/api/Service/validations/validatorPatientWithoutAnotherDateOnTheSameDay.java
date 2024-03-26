package med.voll.api.Service.validations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import med.voll.api.dto.consultation.ScheduleDataConsultation;
import med.voll.api.model.ExceptionValidation;
import med.voll.api.repository.ConsultationRepository;

@Component
public class validatorPatientWithoutAnotherDateOnTheSameDay implements validatorSchedulingConsultation{

  @Autowired
  private ConsultationRepository consultationRepository;

  public void validation(ScheduleDataConsultation data){
      var firstTime = data.date().withHour(7);
      var lastTime = data.date().withHour(18);
      var patientItHasConsultation = consultationRepository.existsByPatientIdAndDateBetween(data.idPatient(),firstTime,lastTime);
      if (patientItHasConsultation) {
        throw new ExceptionValidation("Paciente ja possui uma consulta agendada nesse dia");
      }
  }
}
