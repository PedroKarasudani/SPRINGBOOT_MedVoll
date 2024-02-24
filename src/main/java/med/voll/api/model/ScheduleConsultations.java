package med.voll.api.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import med.voll.api.dto.consultas.ScheduleDataConsultation;
import med.voll.api.repository.ConsultationRepository;
import med.voll.api.repository.DoctorRepository;
import med.voll.api.repository.PatientRepository;

@Service
public class ScheduleConsultations {

  @Autowired
  private ConsultationRepository consultationRepository;

  @Autowired
  private DoctorRepository doctorRepository;

  @Autowired
  private PatientRepository patientRepository;

  public void toSchedule(ScheduleDataConsultation data){
    if (!patientRepository.existsById(data.idPatient())) {
      throw new ExceptionValidation("Id paciente informado não existe!");
    }
    if (data.idDoctor()!=null && !doctorRepository.existsById(data.idDoctor())) {
      throw new ExceptionValidation("Id doctor informado não existe!");
    }

    var doctor = chooseDoctor(data);
    var patient = patientRepository.getReferenceById(data.idPatient());
    
    var consultation = new Consultation(null, doctor, patient, data.date());
    consultationRepository.save(consultation);
  }

  private Doctor chooseDoctor(ScheduleDataConsultation data) {
    if(data.idDoctor() != null){
      return doctorRepository.getReferenceById(data.idDoctor());
    }
  }
}
