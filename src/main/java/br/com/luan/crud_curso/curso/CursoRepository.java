package br.com.luan.crud_curso.curso;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface CursoRepository extends JpaRepository <CursoEntity, UUID> {
    List<CursoEntity> findByCategoryIgnoreCase (String category);
    List<CursoEntity> findByNameContainingIgnoreCase (String name);
    List<CursoEntity> findByCategoryIgnoreCaseAndNameContainingIgnoreCase (String category, String name);
}
