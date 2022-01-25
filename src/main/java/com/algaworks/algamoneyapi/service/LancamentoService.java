package com.algaworks.algamoneyapi.service;

import com.algaworks.algamoneyapi.model.Lancamento;
import com.algaworks.algamoneyapi.model.Pessoa;
import com.algaworks.algamoneyapi.repository.LancamentoRepository;
import com.algaworks.algamoneyapi.repository.PessoaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.server.ResponseStatusException;

@Service
@RequiredArgsConstructor
public class LancamentoService {

    private final LancamentoRepository lancamentoRepository;
    private final PessoaRepository pessoaRepository;

    public ResponseEntity<Lancamento> salvar(Lancamento lancamento) {
        Pessoa pessoa = pessoaRepository.getById(lancamento.getPessoa().getCodigo());
        if (pessoa == null || pessoa.isInativo()){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Pessoa nula ou invalida");
        }
        return new ResponseEntity<>(lancamentoRepository.save(lancamento), HttpStatus.CREATED);
    }

    public ResponseEntity<Void> deletar(Long codigo) {
        Lancamento lancamento = lancamentoRepository.getById(codigo);
        if(lancamento == null){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Lancamento nulo");
        }
        lancamentoRepository.deleteById(codigo);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
