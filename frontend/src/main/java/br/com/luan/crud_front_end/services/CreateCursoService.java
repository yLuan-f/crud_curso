package br.com.luan.crud_front_end.services;

import br.com.luan.crud_front_end.DTO.CursoDto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CreateCursoService {

    @Value("${host.api.crud.cursos}")
    private String hostApiCrudCurso;

    public String execute(CursoDto cursoDto) {
        RestTemplate rt = new RestTemplate();

        HttpEntity<CursoDto> cursoDtoHttpEntity = new HttpEntity<>(cursoDto);

        var url = hostApiCrudCurso.concat("/curso/create");

        return rt.postForObject(url, cursoDtoHttpEntity,String.class);
    }
}
