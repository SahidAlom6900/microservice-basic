package com.te.rating.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.te.rating.model.Rating;
import com.te.rating.model.UserRating;

@RestController
@RequestMapping("/rating-data")
public class RatingDataController {
	@GetMapping("/{movieId}")
	public Rating getRating(@PathVariable("movieId") String movieId) {
		return new Rating(movieId, 4);
	}

	@GetMapping("/users/{userId}")
	public UserRating getAllRating(@PathVariable("userId") String userId) {
		List<Rating> ratings = Arrays.asList(new Rating("100", 3),new Rating("200", 3), new Rating("300", 5), new Rating("400", 5));
		return new UserRating(ratings);
	}
}
