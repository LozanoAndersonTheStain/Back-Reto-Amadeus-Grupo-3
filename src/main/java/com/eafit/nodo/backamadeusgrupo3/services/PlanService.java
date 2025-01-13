package com.eafit.nodo.backamadeusgrupo3.services;

import com.eafit.nodo.backamadeusgrupo3.contracts.request.PlanRequest;
import com.eafit.nodo.backamadeusgrupo3.contracts.responses.DestinationInfoResponse;
import com.eafit.nodo.backamadeusgrupo3.contracts.responses.PlanResponse;
import com.eafit.nodo.backamadeusgrupo3.entities.DestinationInfoEntity;
import com.eafit.nodo.backamadeusgrupo3.entities.PlanEntity;
import com.eafit.nodo.backamadeusgrupo3.exeptions.plan.PlanAlreadyExistsException;
import com.eafit.nodo.backamadeusgrupo3.exeptions.plan.PlanDestinationNotFoundException;
import com.eafit.nodo.backamadeusgrupo3.mappers.implementation.DestinationInfoMapper;
import com.eafit.nodo.backamadeusgrupo3.mappers.interfaces.FlightOptionMapper;
import com.eafit.nodo.backamadeusgrupo3.mappers.interfaces.HotelOptionMapper;
import com.eafit.nodo.backamadeusgrupo3.mappers.interfaces.PlanMapper;
import com.eafit.nodo.backamadeusgrupo3.repositories.DestinationInfoRepository;
import com.eafit.nodo.backamadeusgrupo3.repositories.PlanRepository;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Slf4j
@Service
public class PlanService {

    private final PlanRepository planRepository;
    private final PlanMapper planMapper;
    private final FlightOptionMapper flightOptionMapper;
    private final HotelOptionMapper hotelOptionMapper;
    private final DestinationInfoRepository destinationInfoRepository;
    private final EmailService emailService;

    public PlanService(PlanRepository planRepository, PlanMapper planMapper, FlightOptionMapper flightOptionMapper, HotelOptionMapper hotelOptionMapper, DestinationInfoRepository destinationInfoRepository, EmailService emailService) {
        this.planRepository = planRepository;
        this.planMapper = planMapper;
        this.flightOptionMapper = flightOptionMapper;
        this.hotelOptionMapper = hotelOptionMapper;
        this.destinationInfoRepository = destinationInfoRepository;
        this.emailService = emailService;
    }

    public List<PlanResponse> getPlansByDestination(String destinationName) {
        List<PlanEntity> plans = planRepository.findByDestinationName(destinationName);
        if (plans.isEmpty()) {
            throw new PlanDestinationNotFoundException("No plans found for destination: " + destinationName);
        }
        return plans.stream()
                .map(planMapper::toPlanResponse)
                .collect(Collectors.toList());
    }

    public PlanResponse createPlan(PlanRequest planRequest) {
        try {
            if (planRepository.existsByName(planRequest.getName())) {
                throw new PlanAlreadyExistsException("Plan with name " + planRequest.getName() + " already exists");
            }
            DestinationInfoEntity destination = destinationInfoRepository.findByNombreDestino(planRequest.getDestinationName())
                    .orElseThrow(() -> new PlanDestinationNotFoundException("Destination not found: " + planRequest.getDestinationName()));

            PlanEntity planEntity = planMapper.toPlanEntity(planRequest);
            planEntity.setDestination(destination);

            PlanEntity savedPlan = planRepository.save(planEntity);
            return planMapper.toPlanResponse(savedPlan);
        } catch (PlanAlreadyExistsException e) {
            log.error("Plan already exists: {}", planRequest.getName(), e);
            throw e;
        } catch (PlanDestinationNotFoundException e) {
            log.error("Destination not found: {}", planRequest.getDestinationName(), e);
            throw e;
        } catch (Exception e) {
            log.error("An error occurred while creating the plan", e);
            throw new RuntimeException("Error creating plan", e);
        }
    }

    @Transactional
    public List<PlanResponse> createPlans(List<PlanRequest> planRequests) {
        log.info("Creating multiple plans");
        List<PlanResponse> createdPlans = new ArrayList<>();
        try {
            for (PlanRequest planRequest : planRequests) {
                if (planRepository.existsByName(planRequest.getName())) {
                    log.error("Plan with name {} already exists", planRequest.getName());
                    throw new PlanAlreadyExistsException("Plan with name " + planRequest.getName() + " already exists");
                }
                PlanResponse createdPlan = createPlan(planRequest);
                createdPlans.add(createdPlan);
            }
            log.info("Multiple plans created successfully");
            return createdPlans;
        } catch (PlanAlreadyExistsException e) {
            log.error("Plan already exists", e);
            throw e;
        } catch (PlanDestinationNotFoundException e) {
            log.error("Destination not found", e);
            throw e;
        } catch (IllegalArgumentException e) {
            log.error("Invalid argument provided", e);
            throw e;
        } catch (Exception e) {
            log.error("An error occurred while creating multiple plans", e);
            throw new RuntimeException("Error creating multiple plans", e);
        }
    }

    public Page<PlanResponse> getPagedPlansByDestination(String destinationName, Pageable pageable) {
        try {
            Page<PlanEntity> plans = planRepository.getPagedPlansByDestination(destinationName, pageable);
            if (plans.isEmpty()) {
                throw new PlanDestinationNotFoundException("No plans found for destination: " + destinationName);
            }
            return plans.map(planMapper::toPlanResponse);
        } catch (PlanDestinationNotFoundException e) {
            log.error("No plans found for destination: {}", destinationName, e);
            throw e;
        } catch (Exception e) {
            log.error("An error occurred while retrieving paged plans by destination", e);
            throw new RuntimeException("Error retrieving paged plans by destination", e);
        }
    }

    public PlanResponse getPlanById(Long id) {
        try {
            PlanEntity plan = planRepository.findById(id)
                    .orElseThrow(() -> new PlanDestinationNotFoundException("Plan not found with id: " + id));
            return planMapper.toPlanResponse(plan);
        } catch (PlanDestinationNotFoundException e) {
            log.error("Plan not found with id: {}", id, e);
            throw e;
        } catch (Exception e) {
            log.error("An error occurred while retrieving plan by ID", e);
            throw new RuntimeException("Error retrieving plan by ID", e);
        }
    }

    public List<PlanResponse> getAllPlans() {
        try {
            List<PlanEntity> plans = planRepository.findAll();
            if (plans.isEmpty()) {
                throw new PlanDestinationNotFoundException("No plans found");
            }
            return plans.stream()
                    .map(planMapper::toPlanResponse)
                    .collect(Collectors.toList());
        } catch (PlanDestinationNotFoundException e) {
            log.error("No plans found", e);
            throw e;
        } catch (Exception e) {
            log.error("An error occurred while retrieving all plans", e);
            throw new RuntimeException("Error retrieving all plans", e);
        }
    }

    public PlanResponse updatePlan(Long id, PlanRequest planRequest) {
        try {
            PlanEntity planEntity = planRepository.findById(id)
                    .orElseThrow(() -> new PlanDestinationNotFoundException("Plan not found with id: " + id));

            planEntity.setName(planRequest.getName());
            planEntity.setDescription(planRequest.getDescription());
            planEntity.setDestinationName(planRequest.getDestinationName());
            planEntity.setImageUrl(planRequest.getImageUrl());
            planEntity.setFlightOptions(planRequest.getFlightOptions().stream()
                    .map(flightOptionMapper::toFlightOption)
                    .collect(Collectors.toList()));
            planEntity.setHotelOptions(planRequest.getHotelOptions().stream()
                    .map(hotelOptionMapper::toHotelOption)
                    .collect(Collectors.toList()));

            PlanEntity updatedPlan = planRepository.save(planEntity);
            return planMapper.toPlanResponse(updatedPlan);
        } catch (PlanDestinationNotFoundException e) {
            log.error("Plan not found with id: {}", id, e);
            throw e;
        } catch (Exception e) {
            log.error("An error occurred while updating the plan", e);
            throw new RuntimeException("Error updating plan", e);
        }
    }

    public void deletePlan(Long id) {
        try {
            PlanEntity plan = planRepository.findById(id)
                    .orElseThrow(() -> new PlanDestinationNotFoundException("Plan not found with id: " + id));
            planRepository.delete(plan);
        } catch (PlanDestinationNotFoundException e) {
            log.error("Plan not found with id: {}", id, e);
            throw e;
        } catch (Exception e) {
            log.error("An error occurred while deleting the plan", e);
            throw new RuntimeException("Error deleting plan", e);
        }
    }

    public void sendDestinationInfoByEmail(String destinationName, String email, Map<String, Object> plan) {
        try {
            DestinationInfoEntity destination = destinationInfoRepository.findByNombreDestino(destinationName)
                    .orElseThrow(() -> new PlanDestinationNotFoundException("Destination not found: " + destinationName));
            DestinationInfoResponse destinationInfo = DestinationInfoMapper.toResponse(destination);

            String subject = "Información del destino y plan";
            StringBuilder text = new StringBuilder("Información del destino:\n\n" +
                    "Nombre: " + destinationInfo.getNombreDestino() + "\n" +
                    "País: " + destinationInfo.getPais() + "\n" +
                    "Idioma: " + destinationInfo.getIdioma() + "\n" +
                    "Lugar Imperdible: " + destinationInfo.getLugarImperdible() + "\n" +
                    "Comida Típica: " + destinationInfo.getComidaTipica() + "\n" +
                    "Continente: " + destinationInfo.getContinente() + "\n" +
                    "Imagen: " + destinationInfo.getImg() + "\n\n" +
                    "Plan:\n" +
                    "Nombre: " + plan.get("name") + "\n" +
                    "Descripción: " + plan.get("description") + "\n\n" +
                    "Opciones de vuelo:\n");

            List<Map<String, String>> flightOptions = (List<Map<String, String>>) plan.get("flightOptions");
            for (Map<String, String> flightOption : flightOptions) {
                text.append("  - Nombre: ").append(flightOption.get("name")).append("\n")
                        .append("    Descripción: ").append(flightOption.get("description")).append("\n")
                        .append("    URL de imagen: ").append(flightOption.get("imageUrl")).append("\n")
                        .append("    URL: ").append(flightOption.get("url")).append("\n\n");
            }

            text.append("Opciones de hospedaje:\n");
            List<Map<String, String>> hotelOptions = (List<Map<String, String>>) plan.get("hotelOptions");
            for (Map<String, String> hotelOption : hotelOptions) {
                text.append("  - Nombre: ").append(hotelOption.get("name")).append("\n")
                        .append("    Descripción: ").append(hotelOption.get("description")).append("\n")
                        .append("    URL de imagen: ").append(hotelOption.get("imageUrl")).append("\n")
                        .append("    URL: ").append(hotelOption.get("url")).append("\n\n");
            }

            emailService.sendEmail(email, subject, text.toString());
        } catch (PlanDestinationNotFoundException e) {
            log.error("Destination not found: {}", destinationName, e);
            throw e;
        } catch (ClassCastException e) {
            log.error("Invalid data format in plan options", e);
            throw new IllegalArgumentException("Invalid data format in plan options", e);
        } catch (Exception e) {
            log.error("An error occurred while sending destination info by email", e);
            throw new RuntimeException("Error sending destination info by email", e);
        }
    }
}