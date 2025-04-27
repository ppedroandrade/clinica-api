package service;

import org.springframework.stereotype.Service;

import model.Paciente;
import org.springframework.stereotype.Service;
import repository.PacienteRepository;

import java.util.List;

@Service
public class PacienteService {

    private final PacienteRepository pacienteRepository;

    public PacienteService(PacienteRepository pacienteRepository) {
        this.pacienteRepository = pacienteRepository;
    }

    public Paciente salvar(Paciente paciente) {
        return pacienteRepository.save(paciente);
    }

    public List<Paciente> listarTodos() {
        return pacienteRepository.findAll();
    }

    public Paciente buscarPorId(Long id) {
        return pacienteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Paciente não encontrado"));
    }

    public Paciente atualizar(Long id, Paciente pacienteAtualizado) {
        Paciente paciente = buscarPorId(id);
        paciente.setNome(pacienteAtualizado.getNome());
        paciente.setCpf(pacienteAtualizado.getCpf());
        paciente.setEmail(pacienteAtualizado.getEmail());
        paciente.setTelefone(pacienteAtualizado.getTelefone());
        paciente.setEndereco(pacienteAtualizado.getEndereco());
        return pacienteRepository.save(paciente);
    }

    public void deletar(Long id) {
        pacienteRepository.deleteById(id);
    }
}