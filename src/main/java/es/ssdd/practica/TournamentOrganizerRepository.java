package es.ssdd.practica;

import es.ssdd.practica.TournamentOrganizer.TournamentOrganizer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TournamentOrganizerRepository extends JpaRepository<TournamentOrganizer, Long> {
}
