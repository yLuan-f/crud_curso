package br.com.luan.crud_curso.curso;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "curso")
@Data
public class CursoEntity {

    @Id
    @GeneratedValue (strategy = GenerationType.UUID)
    private UUID id;

    @NotNull
    @NotBlank (message = "Name is required")
    private String name;

    @NotNull
    @NotBlank (message = "Teacher is required")
    private String teacher;

    @NotNull
    @NotBlank (message = "Category is required")
    private String category;

    private boolean active = true;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;
}
