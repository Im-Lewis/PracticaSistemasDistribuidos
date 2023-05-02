package es.ssdd.practica.Tournament;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TournamentsRepository extends JpaRepository<Tournament, Long> {
}
