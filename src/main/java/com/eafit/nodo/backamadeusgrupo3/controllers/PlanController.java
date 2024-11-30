package com.eafit.nodo.backamadeusgrupo3.controllers;

import com.eafit.nodo.backamadeusgrupo3.contracts.request.PlanRequest;
import com.eafit.nodo.backamadeusgrupo3.contracts.responses.PlanResponse;
import com.eafit.nodo.backamadeusgrupo3.exeptions.plan.PlanAlreadyExistsException;
import com.eafit.nodo.backamadeusgrupo3.exeptions.plan.PlanDestinationNotFoundException;
import com.eafit.nodo.backamadeusgrupo3.repositories.PlanRepository;
import com.eafit.nodo.backamadeusgrupo3.services.PlanService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/plans")
@RequiredArgsConstructor
public class PlanController {
    private final PlanService planService;
    private final PlanRepository planRepository;

    @GetMapping("/getPlansByDestination")
    public ResponseEntity<?> getPlansByDestination(@RequestParam String destinationName) {
        log.info("Retrieving plans for destination: {}", destinationName);
        try {
            List<PlanResponse> plans = planService.getPlansByDestination(destinationName);
            log.info("Plans retrieved for destination: {}", destinationName);
            return ResponseEntity.ok(plans);
        } catch (PlanDestinationNotFoundException e) {
            log.error("No plans found for destination: {}", destinationName, e);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            log.error("An error occurred while retrieving plans by destination", e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/getPlanById")
    public ResponseEntity<PlanResponse> getPlanById(@RequestParam Long id) {
        log.info("Retrieving plan by id: {}", id);
        try {
            PlanResponse plan = planService.getPlanById(id);
            log.info("Plan retrieved by id: {}", id);
            return new ResponseEntity<>(plan, HttpStatus.OK);
        } catch (PlanDestinationNotFoundException e) {
            log.error("Plan not found with id: {}", id, e);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (IllegalArgumentException e) {
            log.error("Invalid id: {}", id, e);
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            log.error("An error occurred while retrieving plan by id: {}", id, e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/getAllPlans")
    public ResponseEntity<List<PlanResponse>> getAllPlans() {
        log.info("Retrieving all plans");
        try {
            List<PlanResponse> plans = planService.getAllPlans();
            log.info("All plans retrieved successfully");
            return new ResponseEntity<>(plans, HttpStatus.OK);
        } catch (PlanDestinationNotFoundException e) {
            log.error("No plans found", e);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (IllegalArgumentException e) {
            log.error("Invalid argument provided", e);
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            log.error("An error occurred while retrieving all plans", e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/getPagedPlansByDestination")
    public ResponseEntity<?> getPagedPlansByDestination(
            @RequestParam String destination,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        try {
            Pageable pageable = PageRequest.of(page, size, Sort.by("name").ascending());
            Page<PlanResponse> plans = planService.getPagedPlansByDestination(destination, pageable);
            if (plans.isEmpty()) {
                log.error("No plans found for destination: {}", destination);
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
            log.info("Plans found for destination: {}", destination);
            return new ResponseEntity<>(plans, HttpStatus.OK);
        } catch (PlanDestinationNotFoundException e) {
            log.error("No plans found for destination: {}", destination, e);
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            log.error("An error occurred while retrieving paged plans by destination", e);
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/createPlan")
    public ResponseEntity<PlanResponse> createPlan(@RequestBody PlanRequest planRequest) {
        log.info("Creating plan with name: {}", planRequest.getName());
        try {
            if (planRepository.existsByName(planRequest.getName())) {
                log.error("Plan with name {} already exists", planRequest.getName());
                return new ResponseEntity<>(HttpStatus.CONFLICT);
            }
            PlanResponse createdPlan = planService.createPlan(planRequest);
            log.info("Plan created with name: {}", planRequest.getName());
            return new ResponseEntity<>(createdPlan, HttpStatus.CREATED);
        } catch (PlanDestinationNotFoundException e) {
            log.error("Destination not found for plan with name: {}", planRequest.getName(), e);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (IllegalArgumentException e) {
            log.error("Invalid argument provided for plan with name: {}", planRequest.getName(), e);
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            log.error("An error occurred while creating the plan with name: {}", planRequest.getName(), e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/createMultiplePlans")
    public ResponseEntity<List<PlanResponse>> createPlans(@Valid @RequestBody List<PlanRequest> planRequests) {
        log.info("Creating multiple plans");
        try {
            List<PlanResponse> createdPlans = planService.createPlans(planRequests);
            log.info("Multiple plans created successfully");
            return new ResponseEntity<>(createdPlans, HttpStatus.CREATED);
        } catch (PlanAlreadyExistsException e) {
            log.error("Plan already exists", e);
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        } catch (PlanDestinationNotFoundException e) {
            log.error("Destination not found", e);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (IllegalArgumentException e) {
            log.error("Invalid argument provided", e);
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            log.error("An error occurred while creating multiple plans", e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/updatePlan/{id}")
    public ResponseEntity<PlanResponse> updatePlan(@PathVariable Long id, @RequestBody PlanRequest planRequest) {
        log.info("Updating plan with id: {}", id);
        try {
            PlanResponse updatedPlan = planService.updatePlan(id, planRequest);
            log.info("Plan updated with id: {}", id);
            return new ResponseEntity<>(updatedPlan, HttpStatus.OK);
        } catch (PlanDestinationNotFoundException e) {
            log.error("Plan not found with id: {}", id, e);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (IllegalArgumentException e) {
            log.error("Invalid argument provided for plan with id: {}", id, e);
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            log.error("An error occurred while updating the plan with id: {}", id, e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/deletePlan/{id}")
    public ResponseEntity<Void> deletePlan(@PathVariable Long id) {
        log.info("Deleting plan with id: {}", id);
        try {
            planService.deletePlan(id);
            log.info("Plan deleted with id: {}", id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (PlanDestinationNotFoundException e) {
            log.error("Plan not found with id: {}", id, e);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (IllegalArgumentException e) {
            log.error("Invalid id: {}", id, e);
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            log.error("An error occurred while deleting the plan with id: {}", id, e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}