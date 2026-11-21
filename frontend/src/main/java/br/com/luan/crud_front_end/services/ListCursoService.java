package br.com.luan.crud_front_end.services;

import br.com.luan.crud_front_end.DTO.CursoDto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class ListCursoService {

    @Value("${host.api.crud.cursos}")
    private String hostApiCrudCurso;

    public List<CursoDto> execute(String token) {
        RestTemplate rt = new RestTemplate();

        ParameterizedTypeReference <List<CursoDto>> typeReference = new ParameterizedTypeReference<List<CursoDto>>() {};

        String url = hostApiCrudCurso.concat("/curso/list");

        return rt.exchange(url, HttpMethod.GET, null, typeReference).getBody();
    }

}
