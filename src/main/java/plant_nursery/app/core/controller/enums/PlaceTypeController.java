
package plant_nursery.app.core.controller.enums;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import plant_nursery.app.core.model.enums.PlaceType;
import plant_nursery.app.core.service.enums.PlaceTypeService;
import plant_nursery.app.exceptions.ElementNotFoundException;

import java.util.List;

@RestController
@RequestMapping(value = "/enums/placeType")
@RequiredArgsConstructor
@Tag(name = "Place type Controller", description = "API for managing Place types")
public class PlaceTypeController {

    private final PlaceTypeService placeTypeService;

    @GetMapping
    @Operation(summary = "Get all place types.", description = "Returns a list of all place types.")
    public List<PlaceType> getAllPlaceTypes() {
        return placeTypeService.getAllPlaceTypes();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get place type by id.", description = "Return a place type.")
    public PlaceType getPlaceTypeById(Long id) {
        return placeTypeService.getPlaceTypeById(id).orElseThrow(() -> new ElementNotFoundException(id));
    }

    @PutMapping
    @Operation(summary = "Add place type.", description = "Return a place type that was added.")
    public PlaceType addPlaceType(@RequestBody String placeTypeName) {
        return placeTypeService.addPlaceType(new PlaceType(0L, placeTypeName));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Edit place type by id.", description = "Return a place type that was changed.")
    public PlaceType editPlaceType(@PathVariable Long id, @RequestBody PlaceType placeType) {
        placeTypeService.getPlaceTypeById(id).orElseThrow(() -> new ElementNotFoundException(id));
        return placeTypeService.updatePlaceType(id, placeType);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Edit place type by id.", description = "Return a place type that was deleted.")
    public Long deletePlaceType(@PathVariable Long id) {
        placeTypeService.getPlaceTypeById(id).orElseThrow(() -> new ElementNotFoundException(id));
        placeTypeService.deletePlaceType(id);
        return id;
    }
}

