package br.com.luan.crud_curso.curso.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateCursoDTO {
    private String name;
    private String category;
}
