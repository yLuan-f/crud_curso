package br.com.luan.crud_front_end.controller;

import br.com.luan.crud_front_end.DTO.CursoDto;
import br.com.luan.crud_front_end.DTO.PatchCursoDto;
import br.com.luan.crud_front_end.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Controller
@RequestMapping("/curso")
public class CursoController {

    @Autowired
    private ListCursoService listCursoService;

    @Autowired
    private DetalhesCursoService detalhesCursoService;

    @Autowired
    private CreateCursoService createCursoService;

    @Autowired
    private EditCursoService editCursoService;

    @Autowired
    private StatusCursoService statusCursoService;

    @Autowired
    private DeleteCursoService deleteCursoService;

    @GetMapping("/list")
    public String curso(Model model) {
        var result = this.listCursoService.execute(null);
        model.addAttribute("cursos", result);
        return "/curso/list";
    }

    @GetMapping("/details/{id}")
    public String detalhes(@PathVariable UUID id, Model model) {
        model.addAttribute("cursos", this.detalhesCursoService.execute(id));
        return "/curso/details";
    }

    @GetMapping("/create")
    public String create(Model model) {
        CursoDto dto = new CursoDto();
        model.addAttribute("cursos", dto);
        return "/curso/create";
    }

    @PostMapping("/create")
    public String create(CursoDto cursoDto) {
        cursoDto.setActive(true);
        this.createCursoService.execute(cursoDto);
        return "redirect:/curso/list";
    }

    @GetMapping("/details/edit/{id}")
    public String edit (@PathVariable UUID id, Model model) {
        model.addAttribute("cursos", this.detalhesCursoService.execute(id));
        return "/curso/edit";
    }

    @PostMapping("/details/edit/{id}")
    public String edit(@PathVariable UUID id, CursoDto cursoDto) {
        this.editCursoService.execute(id, cursoDto);
        return "redirect:/curso/details/" + id;
    }

    @PostMapping("/details/status/{id}")
    public String edit(@PathVariable UUID id, PatchCursoDto patchCursoDto) {
        this.statusCursoService.execute(id, patchCursoDto);
        return "redirect:/curso/details/edit/" + id;
    }

    @PostMapping("/delete/{id}")
    public String delete(@PathVariable UUID id) {
        this.deleteCursoService.execute(id);
        return "redirect:/curso/list";
    }
}
