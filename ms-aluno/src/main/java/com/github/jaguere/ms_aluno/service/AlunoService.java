package com.github.jaguere.ms_aluno.service;

import com.github.jaguere.ms_aluno.dto.AlunoDTO;
import com.github.jaguere.ms_aluno.model.Aluno;
import com.github.jaguere.ms_aluno.model.Status;
import com.github.jaguere.ms_aluno.repository.AlunoRepository;
import com.github.jaguere.ms_aluno.service.exception.ResourceNotFoundException;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AlunoService {

    @Autowired
    private AlunoRepository repository;

    @Autowired
    private final ModelMapper mapper;

    @Transactional(readOnly = true)
    public AlunoDTO findbyId(Long id){
        Aluno aluno = repository.findById(id).orElseThrow( () -> new ResourceNotFoundException("Recurso não encontrado"));
        return mapper.map(aluno,AlunoDTO.class);
    }
    @Transactional(readOnly = true)
    public List<AlunoDTO> findAll(){
        List<Aluno> lista = repository.findAll();
        return lista.stream().map(aluno -> mapper.map(aluno, AlunoDTO.class))
                .collect(Collectors.toList());
    }
    @Transactional
    public AlunoDTO insert(AlunoDTO dto){
        Aluno entity = mapper.map(dto, Aluno.class);
        entity.setStatus(Status.MATRICULADO);
        Aluno finalEntity = repository.save(entity);

        return mapper.map(entity,AlunoDTO.class);
    }

    @Transactional
    public void delete(Long id){
        if(repository.existsById(id)){
            repository.deleteById(id);
        }
        else {
            throw new ResourceNotFoundException("Recurso não encontrado");
        }
    }
    @Transactional
    public AlunoDTO update(Long id, AlunoDTO dto){
        Aluno entity = repository.getReferenceById(id);
        mapper.map(dto, entity);
        Aluno finalEntity = repository.save(entity);
        return mapper.map(finalEntity, AlunoDTO.class);
    }


}
