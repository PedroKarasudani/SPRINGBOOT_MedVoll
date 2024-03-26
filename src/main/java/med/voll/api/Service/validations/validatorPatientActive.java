package med.voll.api.Service.validations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import med.voll.api.dto.consultation.ScheduleDataConsultation;
import med.voll.api.model.ExceptionValidation;
import med.voll.api.repository.PatientRepository;

@Component
public class validatorPatientActive implements validatorSchedulingConsultation{
  
  @Autowired
  private PatientRepository patientRepository;

  public void validation(ScheduleDataConsultation data) {
    var patientIsActive = patientRepository.findActiveById(data.idPatient());
    if (!patientIsActive) {
      throw new ExceptionValidation("Consulta nao pode ser agendada com o patiente excluido");
    }
  }
}
