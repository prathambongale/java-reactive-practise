package com.learning.java.reactive.sec02assignment;

import java.time.Duration;
import java.util.concurrent.atomic.AtomicInteger;

import com.learning.java.reactive.courseutil.Util;

import reactor.core.publisher.Flux;

public class StockPricePublisher {
	
	public static Flux<Integer> getPrice() {
		AtomicInteger atomicInteger = new AtomicInteger(100);
		return Flux.interval(Duration.ofSeconds(1))
					.map(i -> atomicInteger.getAndAccumulate(Util.faker().random().nextInt(-5, 5), Integer::sum));
	}

}
