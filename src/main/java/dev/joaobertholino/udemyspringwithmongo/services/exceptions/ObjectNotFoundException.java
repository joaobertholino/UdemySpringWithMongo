package dev.joaobertholino.udemyspringwithmongo.services.exceptions;

public class ObjectNotFoundException extends RuntimeException {
	public ObjectNotFoundException(String id) {
		super("Object not found! Id: " + id);
	}
}
