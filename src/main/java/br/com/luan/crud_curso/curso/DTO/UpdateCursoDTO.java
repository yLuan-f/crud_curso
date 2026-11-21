package br.com.luan.crud_curso.curso.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateCursoDTO {
    private String name;
    private String category;
    private String teacher;
}
