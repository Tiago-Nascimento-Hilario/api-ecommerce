package br.com.tiago.api_e_commerce.controller;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.tiago.api_e_commerce.dto.UsuarioDTO;
import jakarta.annotation.PostConstruct;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {
    // Lista temporária
    public  static List<UsuarioDTO> usuario = new  ArrayList<>();

    @PostConstruct
    public void insereUsuarioaLista(){
        UsuarioDTO usuarioDTO1 = new UsuarioDTO();
        usuarioDTO1.setNome("Aline Vieira");
        usuarioDTO1.setCpf("1");
        usuarioDTO1.setEndereco("Rua matriz 23");
        usuarioDTO1.setEmail("aline@aline");
        usuarioDTO1.setTelefone("2222222");
        usuarioDTO1.setDataCadastro(LocalDateTime.now());

        
        UsuarioDTO usuarioDTO2 = new UsuarioDTO();
        usuarioDTO2.setNome("Antônio Silva");
        usuarioDTO2.setCpf("2");
        usuarioDTO2.setEndereco("Rua cardoso de moraes 3");
        usuarioDTO2.setEmail("antonio@antonio");
        usuarioDTO2.setTelefone("33333333");
        usuarioDTO2.setDataCadastro(LocalDateTime.now());


        usuario.add(usuarioDTO1);
        usuario.add(usuarioDTO2);
    }

    @GetMapping()
    public List<UsuarioDTO> listaUsuarios(){
        return usuario;
    }

    @GetMapping("/{cpf}")
    public UsuarioDTO filtraUsuario(@PathVariable String cpf){
        return usuario.stream()
        .filter(usuarioDto -> usuarioDto.getCpf()
        .equals(cpf))
        .findFirst()
        .orElseThrow(() -> new RuntimeException("CPF NÃO ENCOTRADO"));
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public UsuarioDTO insereUsuario(@RequestBody @Validated UsuarioDTO usuarioDTO){
        usuarioDTO.setDataCadastro(LocalDateTime.now());
        usuario.add(usuarioDTO);
        return  usuarioDTO;
    }

    @DeleteMapping("/{cpf}")
    public boolean removeUsuario(@PathVariable String cpf){
        return usuario.removeIf(usuarioDto -> usuarioDto.getCpf().equals(cpf));
    }

}
