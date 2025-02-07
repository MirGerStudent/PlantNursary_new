package plant_nursery.app.core.service.enums;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import plant_nursery.app.core.model.enums.EventType;
import plant_nursery.app.core.repository.enums.EventTypeRepository;

import java.util.List;
import java.util.Optional;

@Service
public class EventTypeService {
    @Autowired
    private EventTypeRepository eventTypeRepository;

    public List<EventType> getAllEventTypes() {
        return eventTypeRepository.findAll();
    }

    public Optional<EventType> getEventTypeById(Long id) {
        return eventTypeRepository.findById(id);
    }

    public EventType addEventType(EventType eventType) {
        return eventTypeRepository.save(eventType);
    }

    public EventType updateEventType(Long id, EventType eventType) {
        EventType newEventType = eventTypeRepository.findById(id).orElseThrow(() -> new RuntimeException("EventType not found."));
        newEventType.setName(eventType.getName());
        return eventTypeRepository.save(newEventType);
    }

    public void deleteEventType(Long id) {
        eventTypeRepository.deleteById(id);
    }
}
