package com.learning.java.reactive.flux;

import java.time.LocalDateTime;
import java.util.concurrent.CountDownLatch;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import com.learning.java.reactive.sec02assignment.StockPricePublisher;

public class Lec10StockPriceAssignment {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		CountDownLatch latch =  new CountDownLatch(1);
		
		StockPricePublisher.getPrice()
							.subscribeWith(new Subscriber<Integer>() {

								private Subscription subscription;
								
								@Override
								public void onSubscribe(Subscription s) {
									// TODO Auto-generated method stub
									this.subscription = s;
									subscription.request(Long.MAX_VALUE);
								}

								@Override
								public void onNext(Integer price) {
									// TODO Auto-generated method stub
									System.out.println(LocalDateTime.now() +  " : Price : " + price);
									
									if (price > 110 || price < 90) {
										this.subscription.cancel();
										latch.countDown();
									}
								}

								@Override
								public void onError(Throwable t) {
									// TODO Auto-generated method stub
									latch.countDown();
								}

								@Override
								public void onComplete() {
									// TODO Auto-generated method stub
									latch.countDown();
								}
								
							});
		latch.await();
	}

}
