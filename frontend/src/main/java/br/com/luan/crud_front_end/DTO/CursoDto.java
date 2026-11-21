package br.com.luan.crud_front_end.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@NoArgsConstructor
public class CursoDto {

    private UUID id;
    private String name;
    private String category;
    private String teacher;
    private Boolean active;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
