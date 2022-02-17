package com.te.catalog.model;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@SuppressWarnings("serial")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CatalogItem implements Serializable {
	private String name;
	private String desc;
	private int rating;
}
