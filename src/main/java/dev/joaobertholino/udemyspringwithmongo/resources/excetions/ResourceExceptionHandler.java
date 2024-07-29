package dev.joaobertholino.udemyspringwithmongo.resources.excetions;

import dev.joaobertholino.udemyspringwithmongo.services.exceptions.ObjectNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.Instant;

@ControllerAdvice
public class ResourceExceptionHandler {

	@ExceptionHandler(ObjectNotFoundException.class)
	public ResponseEntity<StandardError> ObjectNotFound(ObjectNotFoundException exception, HttpServletRequest request) {
		String message = "Object not found!";
		HttpStatus status = HttpStatus.NOT_FOUND;
		StandardError standardError = new StandardError(Instant.now(), status.value(), exception.getMessage(), message, request.getRequestURI());
		return ResponseEntity.status(status).body(standardError);
	}
}
