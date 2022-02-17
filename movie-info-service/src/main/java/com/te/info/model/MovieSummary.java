package com.te.info.model;

import java.io.Serializable;

import lombok.Data;

@SuppressWarnings("serial")
@Data
public class MovieSummary implements Serializable {
	private String title;
	private String overview;
}
