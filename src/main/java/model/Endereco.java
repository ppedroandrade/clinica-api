package model;

import jakarta.persistence.Embeddable;
import lombok.Data;

@Embeddable
@Data
public class Endereco {

    private String estado;
    private String cidade;
    private String rua;
    private String numero;
    private String cep;
}