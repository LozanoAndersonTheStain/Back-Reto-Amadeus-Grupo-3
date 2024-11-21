package com.eafit.nodo.backamadeusgrupo3.services;

import com.eafit.nodo.backamadeusgrupo3.contracts.request.DestinationRequest;
import com.eafit.nodo.backamadeusgrupo3.contracts.responses.DestinationResponse;
import com.eafit.nodo.backamadeusgrupo3.entities.DestinationInfoEntity;
import com.eafit.nodo.backamadeusgrupo3.exeptions.destination.DestinationAlreadyExistsException;
import com.eafit.nodo.backamadeusgrupo3.exeptions.destination.DestinationNameIsRequired;
import com.eafit.nodo.backamadeusgrupo3.exeptions.destination.DestinationNotFoundException;
import com.eafit.nodo.backamadeusgrupo3.repositories.DestinationInfoRepository;
import com.eafit.nodo.backamadeusgrupo3.utils.DestinationLogic;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

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
        return destinationLogic.determineDestination(destino, climatica, actividad, alojamiento, viaje, edad);
    }

    public List<DestinationInfoEntity> getAllDestinations() {
        List<DestinationInfoEntity> destinationInfoEntities = _destinationInfoRepository.findAll();
        if (destinationInfoEntities.isEmpty()) {
            throw new DestinationNotFoundException("No destinations found");
        }
        return destinationInfoEntities;
    }

    public DestinationInfoEntity getDestinationById(Long id) {
        return _destinationInfoRepository.findById(id)
                .orElseThrow(() -> new DestinationNotFoundException("Destination with id " + id + " not found"));
    }

    public DestinationInfoEntity create(DestinationInfoEntity destinationInfoEntity) {
        if (_destinationInfoRepository.existByDestination(destinationInfoEntity.getNombreDestino())) {
            throw new DestinationAlreadyExistsException("Destination with name " + destinationInfoEntity.getNombreDestino() + " already exists");
        } else if (destinationInfoEntity.getNombreDestino() == null) {
            throw new DestinationNameIsRequired("Destination name is required");
        }
            return _destinationInfoRepository.saveAndFlush(destinationInfoEntity);
    }

    public List<DestinationInfoEntity> getByName(String destination1, String destination2) {
        if (destination1 == null || destination2 == null) {
            throw new DestinationNotFoundException("Destination name is required");
        }
        List<DestinationInfoEntity> destinations = _destinationInfoRepository.getByName(destination1, destination2);
        if (destinations.isEmpty()) {
            throw new DestinationNotFoundException("No information on destinations");
        }
        return destinations;
    }

    public DestinationInfoEntity update(Long id, DestinationInfoEntity destinationInfoEntity) {
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

        return _destinationInfoRepository.save(existingDestination);
    }

    public DestinationInfoEntity delete(Long id) {
        DestinationInfoEntity existingDestination = _destinationInfoRepository.findById(id)
                .orElseThrow(() -> new DestinationNotFoundException("Destination with id " + id + " not found"));
        _destinationInfoRepository.deleteById(id);
        return existingDestination;
    }
}
