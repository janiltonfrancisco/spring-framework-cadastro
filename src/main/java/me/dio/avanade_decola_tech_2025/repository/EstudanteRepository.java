package me.dio.avanade_decola_tech_2025.repository;

import me.dio.avanade_decola_tech_2025.domain.Estudante;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EstudanteRepository extends JpaRepository<Estudante, Long> {
    // Métodos personalizados podem ser adicionados aqui
    Estudante findByMatricula(String matricula);
}
