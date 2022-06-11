package com.learning.java.reactive;

import java.util.Iterator;

import com.github.javafaker.Faker;

public class FakerDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// Faker is use to create dummy data
		for (int i = 0; i < 10; i++ ) {
			System.out.println(Faker.instance().name().firstName());
			
		}
	}

}
