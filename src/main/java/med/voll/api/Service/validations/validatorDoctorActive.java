package med.voll.api.Service.validations;

import jakarta.validation.ValidationException;
import med.voll.api.dto.consultation.ScheduleDataConsultation;
import med.voll.api.repository.DoctorRepository;

public class validatorDoctorActive {
  
  private DoctorRepository doctorRepository;

  public void validation(ScheduleDataConsultation data){
    //escolha do medico opcional
    if (data.idDoctor() == null){
      return;
    }

    var doctorIsActive = doctorRepository.findActiveById(data.idDoctor());
    if (!doctorIsActive) {
      throw new ValidationException("Consulta nao pode ser agendada com o medico excluido");
    }
  }
}
