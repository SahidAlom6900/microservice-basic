package com.te.catalog.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.te.catalog.model.CatalogItem;
import com.te.catalog.model.Movie;
import com.te.catalog.model.UserRating;

@RestController
@RequestMapping("/catalog")
public class MovieCatalogController {
	@Autowired
	private RestTemplate restTemplate;

	@GetMapping("/{userId}")
	public List<CatalogItem> movieList(@PathVariable("userId") String userId) {
	UserRating userRating = restTemplate.getForObject("http://rating-data-service/rating-data/users/" + userId, UserRating.class);
		return userRating.getUserRating().stream().map(rating -> {
			Movie movie = restTemplate.getForObject("http://movie-info-service/movie/" + rating.getMovieId(), Movie.class);
			return new CatalogItem(movie.getName(), movie.getDesc(), rating.getRating());
		}).collect(Collectors.toList());
	}
}
