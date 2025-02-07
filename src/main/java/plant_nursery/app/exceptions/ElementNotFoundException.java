package plant_nursery.app.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class ElementNotFoundException extends ResponseStatusException {
    public ElementNotFoundException(Long id) {
        super(HttpStatus.NOT_FOUND, String.format("Entity with this %d was not found!", id));
    }
}
