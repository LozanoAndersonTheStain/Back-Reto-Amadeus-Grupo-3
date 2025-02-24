package com.eafit.nodo.backamadeusgrupo3.controllers;

import com.eafit.nodo.backamadeusgrupo3.contracts.request.DestinationRequest;
import com.eafit.nodo.backamadeusgrupo3.contracts.responses.DestinationInfoResponse;
import com.eafit.nodo.backamadeusgrupo3.contracts.responses.DestinationResponse;
import com.eafit.nodo.backamadeusgrupo3.entities.DestinationInfoEntity;
import com.eafit.nodo.backamadeusgrupo3.exeptions.destination.DestinationAlreadyExistsException;
import com.eafit.nodo.backamadeusgrupo3.exeptions.destination.DestinationNotFoundException;
import com.eafit.nodo.backamadeusgrupo3.services.DestinationService;
import lombok.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/destination")
@RequiredArgsConstructor
public class DestinationController {

    private final DestinationService destinationService;

    @GetMapping("/listDestinations")
    public ResponseEntity<?> listarDestinations() {
        log.info("Listing destinations");
        try {
            List<DestinationInfoResponse> destinations = destinationService.getAllDestinations();
            if (destinations.isEmpty()) {
                log.error("No destinations found");
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
            log.info("Destinations found");
            return new ResponseEntity<>(destinations, HttpStatus.OK);
        } catch (DestinationNotFoundException e) {
            log.error("No destinations found", e);
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            log.error("An error occurred while listing destinations", e);
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/getAllPagedDestinations")
    public ResponseEntity<?> getAllPagedDestinations(
            @RequestParam String continent,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        try {
            Page<DestinationInfoResponse> destinations = destinationService.getAllPagedDestinations(continent, page, size);
            return new ResponseEntity<>(destinations, HttpStatus.OK);
        } catch (DestinationNotFoundException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/sedDestination")
    public DestinationResponse sendDestination(@RequestBody DestinationRequest destinationRequest) {
        log.info("Sending destination");
        return destinationService.sendDestination(
                destinationRequest.getDestino(),
                destinationRequest.getClimatica(),
                destinationRequest.getActividad(),
                destinationRequest.getAlojamiento(),
                destinationRequest.getViaje(),
                destinationRequest.getEdad()
        );
    }

    @PostMapping("/loadDestination")
    public ResponseEntity<?> create(@RequestBody DestinationInfoEntity destination) {
        try {
            log.info("Creating destination");
            DestinationInfoResponse destinationCreated = destinationService.create(destination);
            log.info("Destination created");
            return new ResponseEntity<>(destinationCreated, HttpStatus.OK);
        } catch (DestinationAlreadyExistsException e) {
            log.error("Destination already exists");
            return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
        }
    }

    @PostMapping("/loadMultipleDestinations")
    public ResponseEntity<?> createMultiple(@RequestBody List<DestinationInfoEntity> destinations) {
        try {
            log.info("Creating multiple destinations");
            List<DestinationInfoEntity> destinationCreated = destinationService.createMultiple(destinations);
            log.info("Multiple destinations created");
            return new ResponseEntity<>(destinationCreated, HttpStatus.OK);
        } catch (DestinationAlreadyExistsException e) {
            log.error("Destination already exists ");
            return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
        }
    }

    @GetMapping("/getByName")
    public ResponseEntity<?> getByName(@RequestParam String destination1, @RequestParam String destination2) {
        try {
            log.info("Searching by name");
            List<DestinationInfoResponse> destinations = destinationService.getByName(destination1, destination2);
            log.info("Two Destinations found");
            return new ResponseEntity<>(destinations, HttpStatus.OK);
        } catch (DestinationNotFoundException e) {
            log.error("No destinations found by name");
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NO_CONTENT);
        }
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<?> searchById(@PathVariable Long id) {
        log.info("Searching by id");
        try {
            DestinationInfoResponse destination = destinationService.getDestinationById(id);
            log.info("Destination found by id");
            return new ResponseEntity<>(destination, HttpStatus.OK);
        } catch (DestinationNotFoundException e) {
            log.error("Destination not found by id");
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody DestinationInfoEntity destination) {
        log.info("Updating destination");
        try {
            DestinationInfoResponse destinationUpdated = destinationService.update(id, destination);
            log.info("Destination updated");
            return new ResponseEntity<>(destinationUpdated, HttpStatus.OK);
        } catch (DestinationNotFoundException e) {
            log.error("Destination not found by id to update");
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        log.info("Deleting destination");
        try {
            DestinationInfoResponse destination = destinationService.delete(id);
            log.info("Destination deleted");
            return new ResponseEntity<>(destination, HttpStatus.OK);
        } catch (DestinationNotFoundException e) {
            log.error("Destination not found by id to delete");
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }
}