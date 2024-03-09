package med.voll.api.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import jakarta.validation.constraints.NotNull;
import med.voll.api.model.Patient;

public interface PatientRepository extends JpaRepository<Patient, Long> {

    Page<Patient> findAllByActiveTrue(Pageable pagination);


    @Query("""
        SELECT p.active FROM Patient p
        WHERE
        p.id = :idPatient
    """)
    Boolean findActiveById(Long idPatient);

}
