package plant_nursery.app.core.controller.enums;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import plant_nursery.app.core.model.enums.EventType;
import plant_nursery.app.core.service.enums.EventTypeService;
import plant_nursery.app.exceptions.ElementNotFoundException;

import java.util.List;

@RestController
@RequestMapping(value = "/enums/eventType")
@RequiredArgsConstructor
@Tag(name = "Event type Controller", description = "API for managing Event types")
public class EventTypeController {

    private final EventTypeService eventTypeService;

    @GetMapping
    @Operation(summary = "Get all event types.", description = "Returns a list of all event types.")
    public List<EventType> getAllEventTypes() {
        return eventTypeService.getAllEventTypes();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get event type by id.", description = "Return an event type.")
    public EventType getEventTypeById(Long id) {
        return eventTypeService.getEventTypeById(id).orElseThrow(() -> new ElementNotFoundException(id));
    }

    @PutMapping
    @Operation(summary = "Add event type.", description = "Return an event type that was added.")
    public EventType addEventType(@RequestBody String eventTypeName) {
        return eventTypeService.addEventType(new EventType(0L, eventTypeName));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Edit event type by id.", description = "Return an event type that was changed.")
    public EventType editEventType(@PathVariable Long id, @RequestBody EventType eventType) {
        eventTypeService.getEventTypeById(id).orElseThrow(() -> new ElementNotFoundException(id));
        return eventTypeService.updateEventType(id, eventType);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Edit event type by id.", description = "Return an event type that was deleted.")
    public Long deleteEventType(@PathVariable Long id) {
        eventTypeService.getEventTypeById(id).orElseThrow(() -> new ElementNotFoundException(id));
        eventTypeService.deleteEventType(id);
        return id;
    }
}
