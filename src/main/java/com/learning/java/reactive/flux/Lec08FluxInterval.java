package com.learning.java.reactive.flux;

import java.time.Duration;

import com.learning.java.reactive.courseutil.Util;

import reactor.core.publisher.Flux;

public class Lec08FluxInterval {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Flux.interval(Duration.ofSeconds(1))
			.subscribe(Util.onNext());
		
		Util.sleepSecond(5);
	}

}
