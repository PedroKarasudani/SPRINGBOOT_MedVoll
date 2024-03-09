package med.voll.api.Service.validations;

import jakarta.validation.ValidationException;
import med.voll.api.dto.consultation.ScheduleDataConsultation;
import med.voll.api.repository.PatientRepository;

public class validatorPatientActive {
  
  private PatientRepository patientRepository;

  public void validation(ScheduleDataConsultation data){
    var patientIsActive = patientRepository.findActiveById(data.idPatient());
    if (!patientIsActive) {
      throw new ValidationException("Consulta nao pode ser agendada com o patiente excluido");
    }
  }
}
