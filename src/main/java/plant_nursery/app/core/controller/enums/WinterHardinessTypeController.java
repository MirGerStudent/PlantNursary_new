
package plant_nursery.app.core.controller.enums;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import plant_nursery.app.core.model.enums.WinterHardinessType;
import plant_nursery.app.core.service.enums.WinterHardinessTypeService;
import plant_nursery.app.exceptions.ElementNotFoundException;

import java.util.List;

@RestController
@RequestMapping(value = "/enums/winterHardinessType")
@RequiredArgsConstructor
@Tag(name = "Winter hardiness type Controller", description = "API for managing Winter hardiness types")
public class WinterHardinessTypeController {

    private final WinterHardinessTypeService winterHardinessTypeService;

    @GetMapping
    @Operation(summary = "Get all winter hardiness types.", description = "Returns a list of all winter hardiness types.")
    public List<WinterHardinessType> getAllWinterHardinessTypes() {
        return winterHardinessTypeService.getAllWinterHardinessTypes();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get winter hardiness type by id.", description = "Return a winter hardiness type.")
    public WinterHardinessType getWinterHardinessTypeById(Long id) {
        return winterHardinessTypeService.getWinterHardinessTypeById(id).orElseThrow(() -> new ElementNotFoundException(id));
    }

    @PutMapping
    @Operation(summary = "Add winter hardiness type.", description = "Return a winter hardiness type that was added.")
    public WinterHardinessType addWinterHardinessType(@RequestBody String winterHardinessTypeName) {
        return winterHardinessTypeService.addWinterHardinessType(new WinterHardinessType(0L, winterHardinessTypeName));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Edit winter hardiness type by id.", description = "Return a winter hardiness type that was changed.")
    public WinterHardinessType editWinterHardinessType(@PathVariable Long id, @RequestBody WinterHardinessType winterHardinessType) {
        winterHardinessTypeService.getWinterHardinessTypeById(id).orElseThrow(() -> new ElementNotFoundException(id));
        return winterHardinessTypeService.updateWinterHardinessType(id, winterHardinessType);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Edit winter hardiness type by id.", description = "Return a winter hardiness type that was deleted.")
    public Long deleteWinterHardinessType(@PathVariable Long id) {
        winterHardinessTypeService.getWinterHardinessTypeById(id).orElseThrow(() -> new ElementNotFoundException(id));
        winterHardinessTypeService.deleteWinterHardinessType(id);
        return id;
    }
}

