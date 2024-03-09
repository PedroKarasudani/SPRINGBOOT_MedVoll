package med.voll.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import med.voll.api.Service.ScheduleConsultations;
import med.voll.api.dto.consultation.CancelDataConsultation;
import med.voll.api.dto.consultation.DetailingDataConsultation;
import med.voll.api.dto.consultation.ScheduleDataConsultation;

@RestController
@RequestMapping("consultations")
public class ConsultationsController {

  @Autowired
  private ScheduleConsultations schedule;

  @PostMapping
  @Transactional
  public ResponseEntity schedule (@RequestBody @Valid ScheduleDataConsultation data){

    schedule.toSchedule(data);
    return ResponseEntity.ok(new DetailingDataConsultation(null, null,null, null));
  }

  @DeleteMapping
  @Transactional
  public ResponseEntity cancel(@RequestBody @Valid CancelDataConsultation data){
    schedule.cancel(data);
    return ResponseEntity.noContent().build();
  }
}
