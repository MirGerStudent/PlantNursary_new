package plant_nursery.app.core.controller.entity;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import plant_nursery.app.core.model.entity.Plant;
import plant_nursery.app.core.service.entity.PlantService;
import plant_nursery.app.exceptions.ElementNotFoundException;

import java.util.List;

@RestController
@RequestMapping("/api/plants")
@Tag(name = "Plant Management System")
public class PlantController {

    @Autowired
    private PlantService plantService;

    @GetMapping
    @Operation(summary = "Get all plants")
    public List<Plant> getAllPlants() {
        return plantService.getAllPlants();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get plant by ID")
    public Plant getPlantById(@PathVariable Long id) {
        return plantService.getPlantById(id).orElseThrow(() -> new ElementNotFoundException(id));
    }

    @PostMapping
    @Operation(summary = "Save a plant")
    public Plant addPlant(@RequestBody Plant plant) {
        return plantService.addPlant(plant);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update a plant")
    public Plant updatePlant(@PathVariable Long id, @RequestBody Plant plantDetails) {
        plantService.getPlantById(id).orElseThrow(() -> new ElementNotFoundException(id));
        return plantService.updatePlant(id, plantDetails);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete a plant")
    public void deletePlant(@PathVariable Long id) {
        plantService.getPlantById(id).orElseThrow(() -> new ElementNotFoundException(id));
        plantService.deletePlant(id);
    }
}