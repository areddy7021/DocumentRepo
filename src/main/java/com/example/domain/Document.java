package com.example.domain;

/**
 * Project Document
 *
 */
public class Document {
	
	private final String id;
	private final String name;

	public Document(final String id, final String name) {
		this.id = id;
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

}
