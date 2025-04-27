package controller;

import model.Consulta;
import org.springframework.web.bind.annotation.*;
import service.ConsultaService;

import java.util.List;

@RestController
@RequestMapping("/consultas")
public class ConsultaController {

    private final ConsultaService consultaService;

    public ConsultaController(ConsultaService consultaService) {
        this.consultaService = consultaService;
    }

    @PostMapping
    public Consulta criar(@RequestBody Consulta consulta) {
        return consultaService.salvar(consulta);
    }

    @GetMapping
    public List<Consulta> listar() {
        return consultaService.listarTodas();
    }

    @GetMapping("/{id}")
    public Consulta buscarPorId(@PathVariable Long id) {
        return consultaService.buscarPorId(id);
    }

    @PutMapping("/{id}")
    public Consulta atualizar(@PathVariable Long id, @RequestBody Consulta consulta) {
        return consultaService.atualizar(id, consulta);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        consultaService.deletar(id);
    }
}