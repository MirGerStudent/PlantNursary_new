package plant_nursery.app.core.controller.enums;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import plant_nursery.app.core.model.enums.GroundType;
import plant_nursery.app.core.service.enums.GroundTypeService;
import plant_nursery.app.exceptions.ElementNotFoundException;

import java.util.List;

@RestController
@RequestMapping("/enums/groundType")
@RequiredArgsConstructor
@Tag(name = "Ground type Controller", description = "API for managing Ground types")
public class GroundTypeController {

    private final GroundTypeService groundTypeService;

    @GetMapping
    @Operation(summary = "Get all ground types.", description = "Returns a list of all ground types.")
    public List<GroundType> getAllGroundType() {
        return groundTypeService.getAllGroundTypes();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get ground type by id.", description = "Return a ground type.")
    public GroundType getGroundTypeById(@PathVariable Long id) {
        return groundTypeService.getGroundTypeByTd(id).orElseThrow(() -> new ElementNotFoundException(id));
    }

    @PutMapping
    @Operation(summary = "Add ground type.", description = "Return a ground type that was added.")
    public GroundType addEventType(@RequestBody String groundTypeName) {
        return groundTypeService.addGroundType(new GroundType(0L, groundTypeName));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Edit ground type by id.", description = "Return a ground type that was changed.")
    public GroundType editEventType(@PathVariable Long id, @RequestBody GroundType groundType) {
        groundTypeService.getGroundTypeByTd(id).orElseThrow(() -> new ElementNotFoundException(id));
        return groundTypeService.updateGroundType(id, groundType);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Edit ground type by id.", description = "Return a ground type that was deleted.")
    public Long deleteEventType(@PathVariable Long id) {
        groundTypeService.getGroundTypeByTd(id).orElseThrow(() -> new ElementNotFoundException(id));
        groundTypeService.deleteGroundType(id);
        return id;
    }
}

