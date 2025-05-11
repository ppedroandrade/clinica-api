package controller;

public class UsuarioController package controller;

import model.Usuario;
import org.springframework.web.bind.annotation.*;
import service.UsuarioService;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @PostMapping
    public Usuario criar(@RequestBody Usuario usuario) {
        return usuarioService.salvar(usuario);
    }

    @GetMapping
    public List<Usuario> listar() {
        return usuarioService.listarTodos();
    }

    @GetMapping("/{id}")
    public Usuario buscarPorId(@PathVariable Long id) {
        return usuarioService.buscarPorId(id);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        usuarioService.deletar(id);
    }
}{
}
