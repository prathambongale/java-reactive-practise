package com.learning.java.reactive;

import java.util.concurrent.Callable;
import java.util.function.Supplier;

import com.learning.java.reactive.courseutil.Util;

import reactor.core.publisher.Mono;

public class Lec05MonoFromSupplier {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// Use just method only when you have data already
		//Mono<String> mono = Mono.just(getName());
		
		// Using fromSupplier method
		//Mono<String> mono = Mono.fromSupplier(() -> getName());
		
		// Using Supplier
		Supplier<String> stringSupplier = () -> getName();
		Mono<String> mono = Mono.fromSupplier(stringSupplier);
		
		mono.subscribe(
				Util.onNext()
				);
		
		// Using callable
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
