
package plant_nursery.app.core.controller.enums;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import plant_nursery.app.core.model.enums.PlantType;
import plant_nursery.app.core.service.enums.PlantTypeService;
import plant_nursery.app.exceptions.ElementNotFoundException;

import java.util.List;

@RestController
@RequestMapping(value = "/enums/plantType")
@RequiredArgsConstructor
@Tag(name = "Plant type Controller", description = "API for managing Plant types")
public class PlantTypeController {

    private final PlantTypeService plantTypeService;

    @GetMapping
    @Operation(summary = "Get all plant types.", description = "Returns a list of all plant types.")
    public List<PlantType> getAllPlantTypes() {
        return plantTypeService.getAllPlantTypes();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get plant type by id.", description = "Return a plant type.")
    public PlantType getPlantTypeById(Long id) {
        return plantTypeService.getPlantTypeById(id).orElseThrow(() -> new ElementNotFoundException(id));
    }

    @PutMapping
    @Operation(summary = "Add plant type.", description = "Return a plant type that was added.")
    public PlantType addPlantType(@RequestBody String plantTypeName) {
        return plantTypeService.addPlantType(new PlantType(0L, plantTypeName));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Edit plant type by id.", description = "Return a plant type that was changed.")
    public PlantType editPlantType(@PathVariable Long id, @RequestBody PlantType plantType) {
        plantTypeService.getPlantTypeById(id).orElseThrow(() -> new ElementNotFoundException(id));
        return plantTypeService.updatePlantType(id, plantType);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Edit plant type by id.", description = "Return a plant type that was deleted.")
    public Long deletePlantType(@PathVariable Long id) {
        plantTypeService.getPlantTypeById(id).orElseThrow(() -> new ElementNotFoundException(id));
        plantTypeService.deletePlantType(id);
        return id;
    }
}

