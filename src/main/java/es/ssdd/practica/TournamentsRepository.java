package es.ssdd.practica;

import es.ssdd.practica.Tournament.Tournament;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TournamentsRepository extends JpaRepository<Tournament, Long> {
}
