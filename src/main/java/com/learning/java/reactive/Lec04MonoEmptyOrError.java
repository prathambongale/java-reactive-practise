package com.learning.java.reactive;

import com.learning.java.reactive.courseutil.Util;

import reactor.core.publisher.Mono;

public class Lec04MonoEmptyOrError {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		userRepository(30).subscribe(
					Util.onNext(),
					Util.onError(),
					Util.onComplete()
				);
	}
	
	private static Mono<String> userRepository(int userId) {
		
		if (userId ==1) {
			return Mono.just(Util.faker().name().firstName());
		} else if (userId == 2) {
			return Mono.empty();
		} else {
			return Mono.error(new RuntimeException("Not in the allowed range"));
		}
	}

}
