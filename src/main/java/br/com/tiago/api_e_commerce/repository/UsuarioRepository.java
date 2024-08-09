package br.com.tiago.api_e_commerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.tiago.api_e_commerce.model.Usuario;


import java.util.List;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
   List<Usuario> findByCpf(String cpf);
   List<Usuario> findByNome(String nome);

}
