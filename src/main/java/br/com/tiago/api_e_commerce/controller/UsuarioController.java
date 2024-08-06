package br.com.tiago.api_e_commerce.controller;

import br.com.tiago.api_e_commerce.dto.UsuarioDTO;
import jakarta.annotation.PostConstruct;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {
    // Lista temporária
    public  static List<UsuarioDTO> usuario = new  ArrayList<>();

    @PostConstruct
    public void insereUsuarioaLista(){
        UsuarioDTO usuarioDTO1 = new UsuarioDTO();
        usuarioDTO1.setNome("Aline Vieira");
        usuarioDTO1.setCpf("123");
        usuarioDTO1.setEndereco("Rua matriz 23");
        usuarioDTO1.setEmail("aline@aline");
        usuarioDTO1.setTelefone("2222222");
        usuarioDTO1.setDataCadastro(LocalDateTime.now());

        usuario.add(usuarioDTO1);
    }

    @GetMapping()
    public List<UsuarioDTO> listaUsuarios(){
        return usuario;
    }


}
