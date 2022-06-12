package com.learning.java.reactive.flux;

import java.util.Arrays;
import java.util.List;

import com.learning.java.reactive.courseutil.Util;

import reactor.core.publisher.Flux;

public class Lec03FluxFromArrayOrList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// Passing list to Flux
		List<String> strings = Arrays.asList("a", "b", "C");
		
		Flux.fromIterable(strings)
			.subscribe(Util.onNext());
		
		// Passing array to Flux
		Integer[] arr = {2, 5, 7, 8};
		Flux.fromArray(arr)
			.subscribe(Util.onNext());
	}

}
