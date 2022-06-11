package com.learning.java.reactive;

import com.learning.java.reactive.courseutil.Util;

import reactor.core.publisher.Mono;

public class Lec03MonoSubscribe {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		// publisher
		Mono<String> mono = Mono.just("ball");
		
		// 1 
		// mono.subscribe();
		
		mono.subscribe(
				Util.onNext(),
				Util.onError(),
				Util.onComplete()
				);
	}

}
