package med.voll.api.Service.validations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import med.voll.api.dto.consultation.ScheduleDataConsultation;
import med.voll.api.model.ExceptionValidation;
import med.voll.api.repository.DoctorRepository;

@Component
public class validatorDoctorActive implements validatorSchedulingConsultation{
  
  @Autowired
  private DoctorRepository doctorRepository;

  public void validation(ScheduleDataConsultation data){
    //escolha do medico opcional
    if (data.idDoctor() == null){
      return;
    }

    var doctorIsActive = doctorRepository.findActiveById(data.idDoctor());
    if (!doctorIsActive) {
      throw new ExceptionValidation("Consulta nao pode ser agendada com o medico excluido");
    }
  }
}
