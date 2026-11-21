package br.com.luan.crud_front_end.services;

import br.com.luan.crud_front_end.DTO.CursoDto;
import br.com.luan.crud_front_end.DTO.PatchCursoDto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.client.JdkClientHttpRequestFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.UUID;

@Service
public class DeleteCursoService {

    @Value("${host.api.crud.cursos}")
    private String hostApiCrudCursos;

    public void execute(UUID id) {
        RestTemplate rt = new RestTemplate();

        var url = hostApiCrudCursos.concat("/curso/delete/" + id);

        rt.delete(url);
    }
}
