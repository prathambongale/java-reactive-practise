package com.learning.java.reactive;

import java.util.Iterator;

import com.github.javafaker.Faker;

public class FakerDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		for (int i = 0; i < 10; i++ ) {
			Faker.instance().name().firstName();
			
		}
	}

}
