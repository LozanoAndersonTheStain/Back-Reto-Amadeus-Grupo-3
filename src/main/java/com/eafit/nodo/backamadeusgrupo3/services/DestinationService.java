package com.eafit.nodo.backamadeusgrupo3.services;

import com.eafit.nodo.backamadeusgrupo3.contracts.responses.DestinationInfoResponse;
import com.eafit.nodo.backamadeusgrupo3.contracts.responses.DestinationResponse;
import com.eafit.nodo.backamadeusgrupo3.entities.DestinationInfoEntity;
import com.eafit.nodo.backamadeusgrupo3.exeptions.destination.DestinationAlreadyExistsException;
import com.eafit.nodo.backamadeusgrupo3.exeptions.destination.DestinationNameIsRequired;
import com.eafit.nodo.backamadeusgrupo3.exeptions.destination.DestinationNotFoundException;
import com.eafit.nodo.backamadeusgrupo3.mappers.implementation.DestinationInfoMapper;
import com.eafit.nodo.backamadeusgrupo3.repositories.DestinationInfoRepository;
import com.eafit.nodo.backamadeusgrupo3.utils.DestinationLogic;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class DestinationService {

    private final DestinationInfoRepository _destinationInfoRepository;
    public final DestinationLogic destinationLogic;

    public DestinationService(DestinationInfoRepository destinationInfoRepository) {
        this._destinationInfoRepository = destinationInfoRepository;
        this.destinationLogic = new DestinationLogic();
    }

    public DestinationResponse sendDestination(String destino, String climatica, String actividad, String alojamiento, String viaje, String edad) {
        StringBuilder missingParams = new StringBuilder();

        if (destino == null) missingParams.append("destino, ");
        if (climatica == null) missingParams.append("climatica, ");
        if (actividad == null) missingParams.append("actividad, ");
        if (alojamiento == null) missingParams.append("alojamiento, ");
        if (viaje == null) missingParams.append("viaje, ");
        if (edad == null) missingParams.append("edad, ");

        if (missingParams.length() > 0) {
            // Remove the trailing comma and space
            missingParams.setLength(missingParams.length() - 2);
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Missing required parameters: " + missingParams.toString());
        }

        try {
            return destinationLogic.determineDestination(destino, climatica, actividad, alojamiento, viaje, edad);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Error determining destination", e);
        }
    }

    public List<DestinationInfoResponse> getAllDestinations() {
        List<DestinationInfoEntity> destinationInfoEntities = _destinationInfoRepository.findAll();
        if (destinationInfoEntities.isEmpty()) {
            throw new DestinationNotFoundException("No destinations found");
        }
        return destinationInfoEntities.stream()
                .map(DestinationInfoMapper::toResponse)
                .collect(Collectors.toList());
    }

    public Page<DestinationInfoResponse> getAllPagedDestinations(String continent, int page, int size) {
        Pageable pageable = PageRequest.of(page, size, Sort.by("nombreDestino").ascending());
        Page<DestinationInfoEntity> destinationInfoEntities = _destinationInfoRepository.findByContinente(continent, pageable);
        if (destinationInfoEntities.isEmpty()) {
            throw new DestinationNotFoundException("No destinations found in " + continent);
        }
        return destinationInfoEntities.map(DestinationInfoMapper::toResponse);
    }

    public DestinationInfoResponse getDestinationById(Long id) {
        DestinationInfoEntity entity = _destinationInfoRepository.findById(id)
                .orElseThrow(() -> new DestinationNotFoundException("Destination with id " + id + " not found"));
        return DestinationInfoMapper.toResponse(entity);
    }

    public DestinationInfoResponse create(DestinationInfoEntity destinationInfoEntity) {
        if (_destinationInfoRepository.existByDestination(destinationInfoEntity.getNombreDestino())) {
            throw new DestinationAlreadyExistsException("Destination with name " + destinationInfoEntity.getNombreDestino() + " already exists");
        } else if (destinationInfoEntity.getNombreDestino() == null) {
            throw new DestinationNameIsRequired("Destination name is required");
        }
        DestinationInfoEntity savedEntity = _destinationInfoRepository.saveAndFlush(destinationInfoEntity);
        return DestinationInfoMapper.toResponse(savedEntity);
    }

    public List<DestinationInfoEntity> createMultiple(List<DestinationInfoEntity> destinationInfoEntities) {
        return _destinationInfoRepository.saveAll(destinationInfoEntities);
    }

    public List<DestinationInfoResponse> getByName(String destination1, String destination2) {
        if (destination1 == null || destination2 == null) {
            throw new DestinationNotFoundException("Destination name is required");
        }
        List<DestinationInfoEntity> destinations = _destinationInfoRepository.getByName(destination1, destination2);
        if (destinations.isEmpty()) {
            throw new DestinationNotFoundException("No information on destinations");
        }
        return destinations.stream().map(DestinationInfoMapper::toResponse).collect(Collectors.toList());
    }

    public DestinationInfoResponse update(Long id, DestinationInfoEntity destinationInfoEntity) {
        if (destinationInfoEntity == null) {
            throw new DestinationNameIsRequired("Destination body is required");
        } else if (destinationInfoEntity.getNombreDestino().isEmpty() && destinationInfoEntity.getPais().isEmpty() && destinationInfoEntity.getIdioma().isEmpty() && destinationInfoEntity.getLugarImperdible().isEmpty() && destinationInfoEntity.getComidaTipica().isEmpty() && destinationInfoEntity.getImg().isEmpty() && destinationInfoEntity.getContinente().isEmpty()) {
            throw new DestinationNameIsRequired("Destination properties are required" + destinationInfoEntity);
        }
        DestinationInfoEntity existingDestination = _destinationInfoRepository.findById(id)
                .orElseThrow(() -> new DestinationNotFoundException("Destination with id " + id + " not found"));
        existingDestination.setNombreDestino(destinationInfoEntity.getNombreDestino());
        existingDestination.setPais(destinationInfoEntity.getPais());
        existingDestination.setIdioma(destinationInfoEntity.getIdioma());
        existingDestination.setLugarImperdible(destinationInfoEntity.getLugarImperdible());
        existingDestination.setComidaTipica(destinationInfoEntity.getComidaTipica());
        existingDestination.setImg(destinationInfoEntity.getImg());
        existingDestination.setContinente(destinationInfoEntity.getContinente());

        DestinationInfoEntity updatedEntity = _destinationInfoRepository.save(existingDestination);
        return DestinationInfoMapper.toResponse(updatedEntity);
    }

    public DestinationInfoResponse delete(Long id) {
        DestinationInfoEntity existingDestination = _destinationInfoRepository.findById(id)
                .orElseThrow(() -> new DestinationNotFoundException("Destination with id " + id + " not found"));
        _destinationInfoRepository.deleteById(id);
        return DestinationInfoMapper.toResponse(existingDestination);
    }
}