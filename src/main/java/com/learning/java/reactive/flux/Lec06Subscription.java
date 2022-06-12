package com.learning.java.reactive.flux;

import java.util.concurrent.atomic.AtomicReference;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import com.learning.java.reactive.courseutil.Util;

import reactor.core.publisher.Flux;

public class Lec06Subscription {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// Custom Subscriber implementation
		
		AtomicReference<Subscription> atomicReference = new AtomicReference<>();
		Flux.range(1, 20)
			.log()
			.subscribeWith(new Subscriber<Integer>() {

				@Override
				public void onSubscribe(Subscription s) {
					// TODO Auto-generated method stub
					System.out.println("Received Sub : " + s);
					atomicReference.set(s);
				}
	
				@Override
				public void onNext(Integer t) {
					// TODO Auto-generated method stub
					System.out.println("onNext : " + t);
				}
	
				@Override
				public void onError(Throwable t) {
					// TODO Auto-generated method stub
					System.out.println("onError : " + t.getMessage());
				}
	
				@Override
				public void onComplete() {
					// TODO Auto-generated method stub
					System.out.println("onComplete");
				}
		});
		
		Util.sleepSecond(3);
		atomicReference.get().request(3);
		
		Util.sleepSecond(5);
		atomicReference.get().request(3);
		
		Util.sleepSecond(5);
		System.out.println("going to cancel");
		atomicReference.get().cancel();
		
		Util.sleepSecond(3);
		atomicReference.get().request(4);
		
	}

}
