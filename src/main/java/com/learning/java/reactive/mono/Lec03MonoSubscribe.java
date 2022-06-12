package com.learning.java.reactive.mono;

import com.learning.java.reactive.courseutil.Util;

import reactor.core.publisher.Mono;

public class Lec03MonoSubscribe {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		// publisher
		Mono<String> mono = Mono.just("ball");
		
		// 1 
		// mono.subscribe();
		
		// 2
		/*
		 * mono.subscribe( item -> System.out.println(item), err ->
		 * System.out.println(err.getMessage()), () -> System.out.println("Completed")
		 * );
		 */
		
		// 3
		Mono<Integer> monoInteger = Mono.just("ball").map(String::length).map(l -> l/0);
		
		// onError getting called
		/*
		 * monoInteger.subscribe( item -> System.out.println(item) );
		 */
		
		// Error handling
		/*
		 * monoInteger.subscribe( item -> System.out.println(item), err ->
		 * System.out.println(err.getMessage()) );
		 */
		
		// 4 - declaring all methods in Util
		mono.subscribe( 
				Util.onNext(), 
				Util.onError(), 
				Util.onComplete() );
		 
	}

}
