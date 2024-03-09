package med.voll.api.repository;

import java.time.LocalDateTime;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import med.voll.api.dto.doctor.Specialty;
import med.voll.api.model.Doctor;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {

    Page<Doctor> findAllByActiveTrue(Pageable pagination);


    @Query("""
            SELECT d FROM Doctor d
            WHERE
            d.active = 1
            AND
            d.specialty = :specialty
            AND
            d.id not in(
                SELECT c.doctor.id FROM Consultation c
                WHERE
                c.date = :date
            )
            ORDER BY RAND()
            LIMIT 1
            """)
    Doctor chooseRandomDoctorInDate(Specialty specialty, LocalDateTime date);

}