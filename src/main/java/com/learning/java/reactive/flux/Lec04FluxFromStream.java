package com.learning.java.reactive.flux;

import java.util.List;
import java.util.stream.Stream;

import com.learning.java.reactive.courseutil.Util;

import reactor.core.publisher.Flux;

public class Lec04FluxFromStream {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> list = List.of(1, 2, 3, 4, 5);
		Stream<Integer> stream = list.stream();
		
		/*
		 * stream.forEach(System.out::println); // stream will be closed after this execution 
		 * stream.forEach(System.out::println); // Error: stream has already been operated upon or closed. Stream can only be use once.
		 */		
		
		
		// Flux<Integer> integerFlux = Flux.fromStream(stream);
		
		// To avoid stream issue try using supplier of stream 
		Flux<Integer> integerFlux = Flux.fromStream(() -> list.stream());
		
		integerFlux.subscribe(
				Util.onNext(), 
				Util.onError(), 
				Util.onComplete(
			));
		
		// Below will also hit error: "stream has already been operated upon or closed"
		integerFlux.subscribe(
				Util.onNext(), 
				Util.onError(), 
				Util.onComplete(
			));
	}

}
