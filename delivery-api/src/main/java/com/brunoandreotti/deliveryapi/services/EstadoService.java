package com.brunoandreotti.deliveryapi.services;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import com.brunoandreotti.deliveryapi.domain.dtos.estado.EstadoRequestDTO;
import com.brunoandreotti.deliveryapi.domain.dtos.estado.EstadoResponseDTO;
import com.brunoandreotti.deliveryapi.domain.models.Estado;
import com.brunoandreotti.deliveryapi.domain.repositories.EstadoRepository;
import com.brunoandreotti.deliveryapi.exceptions.EntidadeExistenteException;
import com.brunoandreotti.deliveryapi.exceptions.EntidadeNaoEncontradaException;
import com.brunoandreotti.deliveryapi.utils.ConstantStrings;

@Service
public class EstadoService {

  private EstadoRepository estadoRepository;

  public EstadoService(EstadoRepository estadoRepository) {
    this.estadoRepository = estadoRepository;
  }

  public List<EstadoResponseDTO> findAll() {
    return estadoRepository.findAll().stream().map(EstadoResponseDTO::new).toList();
  }

  public EstadoResponseDTO findById(Long id) {
    Optional<Estado> estado = estadoRepository.findById(id);

    if (estado.isEmpty()) {
      throw new EntidadeNaoEncontradaException(String.format(ConstantStrings.NOT_FOUND_ID_ERR, id));
    }

    return new EstadoResponseDTO(estado.get());
  }

  public EstadoResponseDTO create(EstadoRequestDTO estadoData) {

    boolean estadoAlreadyExists = estadoRepository.existsByNome(estadoData.getNome());

    if (estadoAlreadyExists) {
      throw new EntidadeExistenteException(
          String.format(ConstantStrings.EXISTING_ENTITY, estadoData.getNome()));
    }

    Estado newEstado = new Estado();

    BeanUtils.copyProperties(estadoData, newEstado);

    Estado savedEstado = estadoRepository.save(newEstado);

    return new EstadoResponseDTO(savedEstado);
  }

}
