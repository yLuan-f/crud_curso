package br.com.luan.crud_front_end.services;

import br.com.luan.crud_front_end.DTO.CursoDto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.UUID;

@Service
public class EditCursoService {

    @Value("${host.api.crud.cursos}")
    private String hostApiCrudCursos;

    public String execute(UUID id, CursoDto cursoDto) {
        RestTemplate rt = new RestTemplate();

        HttpEntity<CursoDto> cursoDtoHttpEntity = new HttpEntity<>(cursoDto);

        var url = hostApiCrudCursos.concat("/curso/details/edit/" + id);

        return rt.exchange(url, HttpMethod.PUT, cursoDtoHttpEntity, String.class).getBody();
    }

}
