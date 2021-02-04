package br.com.somenteparaestudosetestes.rest;

import br.com.somenteparaestudosetestes.exception.UsuarioCadastradoException;
import br.com.somenteparaestudosetestes.model.Usuario;
import br.com.somenteparaestudosetestes.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/usuarios")
@RequiredArgsConstructor
public class UsuarioController {

    private final UsuarioService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void salvar(@RequestBody @Valid Usuario usuario){
        try {
            usuario.setPassword(new BCryptPasswordEncoder().encode(usuario.getPassword()));
            service.salvar(usuario);
        } catch (UsuarioCadastradoException e){
            throw new ResponseStatusException( HttpStatus.BAD_REQUEST, e.getMessage() );
        }
    }

}
