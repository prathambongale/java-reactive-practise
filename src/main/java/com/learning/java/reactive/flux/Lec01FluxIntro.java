package com.learning.java.reactive.flux;

import com.learning.java.reactive.courseutil.Util;

import reactor.core.publisher.Flux;

public class Lec01FluxIntro {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Flux<Object> flux = Flux.just(1, 2, 3, 4, "a", Util.FAKER.name().fullName());
		
		flux.subscribe(
				Util.onNext(),
				Util.onError(),
				Util.onComplete()
				);
		
	}

}
