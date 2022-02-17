package com.te.catalog.model;
import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@SuppressWarnings("serial")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Movie implements Serializable {
	private String movieId;
	private String name;
	private String desc;
}
