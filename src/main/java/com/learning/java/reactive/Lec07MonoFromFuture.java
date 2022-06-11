package com.learning.java.reactive;

import java.util.concurrent.CompletableFuture;

import com.learning.java.reactive.courseutil.Util;

import reactor.core.publisher.Mono;

public class Lec07MonoFromFuture {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//One of the ways to create Mono
		Mono.fromFuture(getName()).subscribe(Util.onNext());
		
		Util.sleepSecond(1);
	}

	private static CompletableFuture<String> getName() {
		return CompletableFuture.supplyAsync(() -> Util.faker().name().fullName());
	}
}
