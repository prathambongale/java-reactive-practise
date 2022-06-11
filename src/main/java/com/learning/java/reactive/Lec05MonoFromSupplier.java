package com.learning.java.reactive;

import java.util.concurrent.Callable;

import com.learning.java.reactive.courseutil.Util;

import reactor.core.publisher.Mono;

public class Lec05MonoFromSupplier {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// Use just method only when you have data already
		//Mono<String> mono = Mono.just(getName());
		
		Mono<String> mono = Mono.fromSupplier(() -> getName());
		
		mono.subscribe(
				Util.onNext()
				);
		
		Callable<String> stringCallable = () -> getName();
		Mono
			.fromCallable(stringCallable)
			.subscribe(
					Util.onNext()
					);
	}
	
	private static String getName() {
		System.out.println("Generating name..");
		return Util.faker().name().fullName();
	}

}
