package com.learning.java.reactive.mono;

import com.learning.java.reactive.courseutil.Util;

import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

public class Lec06SupplierRefactoring {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		getName();
		getName()
			.subscribeOn(Schedulers.boundedElastic())
			.subscribe(Util.onNext());
		
		// Using block()
		// can be used for testing purposes
		/*
		 * String name = getName() .subscribeOn(Schedulers.boundedElastic()) .block();
		 * System.out.println(name);
		 */
		getName();
		
		Util.sleepSecond(4); // used to block main Thread
	}
	
	private static Mono<String> getName() {
		System.out.println("entered getName method");
		return Mono.fromSupplier(()-> {
					System.out.println("Genetrating name..");
					Util.sleepSecond(3);
					return Util.faker().name().firstName();
				}).map(String::toUpperCase);
	}

}
