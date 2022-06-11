package com.learning.java.reactive;

import reactor.core.publisher.Mono;

public class Lec02MonoJust {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Mono<Integer> mono = Mono.just(1);
		
		System.out.println(mono);
		
		mono.subscribe(i -> System.out.println("Received: " + i));
		
		/**
		 * Rule 1:
		 * Nothing happens until you subscribe
		 * 
		 * */
	}

}
