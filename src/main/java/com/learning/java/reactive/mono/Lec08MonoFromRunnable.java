package com.learning.java.reactive.mono;

import com.learning.java.reactive.courseutil.Util;

import reactor.core.publisher.Mono;

public class Lec08MonoFromRunnable {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// Creating Mono using Runnable
		// Use - Sometimes there will be time consuming application and we will like to be notified once it is completed. That is when it will useful.
		Runnable runnable = () -> System.out.println("");
		
		Mono
			.fromRunnable(timeComsumingProcess())
			.subscribe(
					Util.onNext(),
					Util.onError(),
					() -> {
						System.out.println("process is done. Sending emails...");
					});
	}
	
	private static Runnable timeComsumingProcess() {
		return () -> {
			Util.sleepSecond(3);
			System.out.println("Operation Completed");
		};
	}

}
