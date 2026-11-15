package br.com.luan.crud_curso.curso.controllers;

import br.com.luan.crud_curso.curso.CursoEntity;
import br.com.luan.crud_curso.curso.CursoRepository;
import br.com.luan.crud_curso.curso.DTO.PatchCursoDTO;
import br.com.luan.crud_curso.curso.DTO.UpdateCursoDTO;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/curso")
public class CursoController {

    @Autowired
    private CursoRepository cursoRepository;

    @PostMapping("/create")
    public ResponseEntity<Object> createCurso(@Valid @RequestBody CursoEntity cursoEntity) {
        try {
            CursoEntity novoCurso = cursoRepository.save(cursoEntity);
            return ResponseEntity.ok(novoCurso);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/list")
    public ResponseEntity<List<CursoEntity>> listCursos(@RequestParam(required = false) String category, @RequestParam(required = false) String name) {

        List<CursoEntity> cursos;

        if (category != null && name != null) {
            cursos = cursoRepository.findByCategoryIgnoreCaseAndNameContainingIgnoreCase(category, name);
        } else if (category != null) {
            cursos = cursoRepository.findByCategoryIgnoreCase(category);
        } else if (name != null) {
            cursos = cursoRepository.findByNameContainingIgnoreCase(name);
        } else {
            cursos = cursoRepository.findAll();
        }

        return ResponseEntity.ok(cursos);
    }

    @GetMapping("/detalhes/{id}")
    public ResponseEntity<CursoEntity> getCurso (@PathVariable UUID id) {
        Optional<CursoEntity> cursoOptional = cursoRepository.findById(id);

        if (cursoOptional.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(cursoOptional.get());
    }

    @PutMapping("/{id}")
    public ResponseEntity<CursoEntity> updateCurso(@PathVariable UUID id, @RequestBody UpdateCursoDTO dto) {

        Optional<CursoEntity> cursoOptional = cursoRepository.findById(id);

        if (cursoOptional.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        CursoEntity curso = cursoOptional.get();


        if (dto.getName() != null) {
            curso.setName(dto.getName());
        }

        if (dto.getCategory() != null) {
            curso.setCategory(dto.getCategory());
        }

        CursoEntity cursoAtualizado = cursoRepository.save(curso);
        return ResponseEntity.ok(cursoAtualizado);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Map<String, String>> deleteCurso(@PathVariable UUID id) {
        if (cursoRepository.existsById(id)) {
            cursoRepository.deleteById(id);
            return ResponseEntity.ok(Map.of("mensagem", "Curso excluido com sucesso"));
        } else {
            System.out.println("Curso com ID " + id + " nao encontrado.");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Map.of("mensagem", "Curso nao encontrado"));
        }
    }

    @PatchMapping("/status/{id}")
    public ResponseEntity<CursoEntity> statusCurso(@PathVariable UUID id, @RequestBody PatchCursoDTO dto) {
        Optional<CursoEntity> cursoOptional = cursoRepository.findById(id);

        if (cursoOptional.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        CursoEntity curso = cursoOptional.get();
        curso.setActive(dto.isActive());
        cursoRepository.save(curso);
        
        return ResponseEntity.ok(curso);
    }
}
