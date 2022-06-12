package com.learning.java.reactive.mono;

import com.learning.java.reactive.courseutil.Util;

import reactor.core.publisher.Mono;

public class Lec04MonoEmptyOrError {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		userRepository(3).subscribe(
					Util.onNext(),
					Util.onError(),
					Util.onComplete()
				);
	}
	
	// Publisher method
	private static Mono<String> userRepository(int userId) {
		
		if (userId ==1) {
			return Mono.just(Util.faker().name().firstName()); // Better ways available then just
		} else if (userId == 2) {
			return Mono.empty();
		} else {
			return Mono.error(new RuntimeException("Not in the allowed range"));
		}
	}

}
