package com.learning.java.reactive.flux;

import com.learning.java.reactive.courseutil.Util;

import reactor.core.publisher.Flux;

public class Lec05FluxRange {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// Can be used as for loop
		// range(start, end)
		Flux.range(-5, 10).subscribe(Util.onNext()); // will print -5 to 4 that is 10 values
		
		// Print name 10 times 
		Flux.range(1, 10)
			.log()
			.map(s -> Util.faker().name().fullName())
			.log()
			.subscribe(
					Util.onNext(), 
					Util.onError(), 
					Util.onComplete()
			);
	}

}
