package com.example.domain;

/**
 * Project
 *
 */
public class Project {
	
	private final String id;
	private final String title;
	private final Document document;
	private int stockLevel;

	public Project(final String id, final String title, final Document document, int stockLevel) {
		this.id = id;
		this.title = title;
		this.document = document;
		this.stockLevel = stockLevel;
	}

	public String getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public Document getDocument() {
		return document;
	}

	public int getStockLevel() {
		return stockLevel;
	}

	public void setStockLevel(int stockLevel) {
		this.stockLevel = stockLevel;
	}
}