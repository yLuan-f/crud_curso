package br.com.luan.crud_front_end.services;

import br.com.luan.crud_front_end.DTO.CursoDto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.UUID;

@Service
public class DetalhesCursoService {

    @Value("${host.api.crud.cursos}")
    private String hostApiCrudCurso;

    public CursoDto execute(UUID id) {
        RestTemplate rt = new RestTemplate();
        return rt.getForObject(hostApiCrudCurso + "/curso/details/" + id, CursoDto.class);
    }
}
