package service;

import model.Consulta;
import org.springframework.stereotype.Service;
import repository.ConsultaRepository;

import java.util.List;

@Service
public class ConsultaService {

    private final ConsultaRepository consultaRepository;

    public ConsultaService(ConsultaRepository consultaRepository) {
        this.consultaRepository = consultaRepository;
    }

    public Consulta salvar(Consulta consulta) {
        return consultaRepository.save(consulta);
    }

    public List<Consulta> listarTodas() {
        return consultaRepository.findAll();
    }

    public Consulta buscarPorId(Long id) {
        return consultaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Consulta não encontrada"));
    }

    public Consulta atualizar(Long id, Consulta consultaAtualizada) {
        Consulta consulta = buscarPorId(id);
        consulta.setDataHora(consultaAtualizada.getDataHora());
        consulta.setPaciente(consultaAtualizada.getPaciente());
        return consultaRepository.save(consulta);
    }

    public void deletar(Long id) {
        consultaRepository.deleteById(id);
    }
}