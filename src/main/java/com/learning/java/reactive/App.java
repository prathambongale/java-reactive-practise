package com.learning.java.reactive;

import java.util.stream.Stream;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Stream<Integer> stream = Stream.of(1)
        		.map(i -> {
        			try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO: handle exception
						e.printStackTrace();
					}
        			return i * 2;
        		});
        
        stream.forEach(System.out::println);
    }
}
