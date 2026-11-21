package br.com.luan.crud_front_end.services;

import br.com.luan.crud_front_end.DTO.PatchCursoDto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.client.JdkClientHttpRequestFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.UUID;

@Service
public class StatusCursoService {

    @Value("${host.api.crud.cursos}")
    private String hostApiCrudCursos;

    public String execute(UUID id, PatchCursoDto patchCursoDto) {
        RestTemplate rt = new RestTemplate(new JdkClientHttpRequestFactory());

        HttpEntity<PatchCursoDto> patchCursoDtoHttpEntity = new HttpEntity<>(patchCursoDto);

        var url = hostApiCrudCursos.concat("/curso/status/" + id);

        return rt.exchange(url, HttpMethod.PATCH, patchCursoDtoHttpEntity, String.class).getBody();
    }
}

