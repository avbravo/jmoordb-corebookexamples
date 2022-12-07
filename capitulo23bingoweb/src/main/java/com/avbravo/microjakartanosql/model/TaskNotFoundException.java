package com.avbravo.microjakartanosql.model;

public class TaskNotFoundException extends RuntimeException {

	public TaskNotFoundException(Long postId) {
		super(String.format("post id:%s not found!", postId));
	}

}
