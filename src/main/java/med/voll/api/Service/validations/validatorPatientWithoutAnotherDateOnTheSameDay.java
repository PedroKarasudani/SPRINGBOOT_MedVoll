package med.voll.api.Service.validations;

import jakarta.validation.ValidationException;
import med.voll.api.dto.consultation.ScheduleDataConsultation;
import med.voll.api.repository.ConsultationRepository;

public class validatorPatientWithoutAnotherDateOnTheSameDay {

    private ConsultationRepository consultationRepository;

    public void validation(ScheduleDataConsultation data){
      var firstTime = data.date().withHour(7);
      var lastTime = data.date().withHour(18);
      var patientItHasConsultation = consultationRepository.existsByPatientIdAndDateBetween(data.idPatient(),firstTime,lastTime);
      if (patientItHasConsultation) {
        throw new ValidationException("Paciente ja possui uma consulta agendada nesse dia");
      }
    }
}
