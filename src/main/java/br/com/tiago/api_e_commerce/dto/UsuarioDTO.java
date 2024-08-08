package br.com.tiago.api_e_commerce.dto;


import java.time.LocalDateTime;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioDTO {
    
    @NotBlank(message = "Nome é obrigatório")
    private String nome;

    @NotBlank(message = "Cpf é obrigatŕio")
    private String cpf;
    
    private String endereco;
    private String email;
    private String telefone;
    private LocalDateTime dataCadastro;
}
