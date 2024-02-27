package med.voll.api.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.validation.Valid;
import jakarta.validation.ValidationException;
import med.voll.api.dto.consultation.CancelDataConsultation;
import med.voll.api.dto.consultation.ScheduleDataConsultation;
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
    
    var consultation = new Consultation(null, doctor, patient, data.date(), null);
    consultationRepository.save(consultation);
  }

  private Doctor chooseDoctor(ScheduleDataConsultation data) {
    if(data.idDoctor() != null){
      return doctorRepository.getReferenceById(data.idDoctor());
    }

    if(data.specialty() == null){
      throw new ExceptionValidation("Especialidade é obrigatoria quando medico não é escolhido!"); 
    }

    return doctorRepository.chooseRandomDoctorInDate(data.specialty(), data.date());
  }

  public void cancel(@Valid CancelDataConsultation data) {
    if (!consultationRepository.existsById(data.idConsutation())){
      throw new ValidationException("Id da consulta informado não existe!");
    }
    var consultation = consultationRepository.getReferenceById(data.idConsutation());
    consultation.cancel(data.reason());
  }
}
