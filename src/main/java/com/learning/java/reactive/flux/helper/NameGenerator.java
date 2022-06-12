package com.learning.java.reactive.flux.helper;

import java.util.ArrayList;
import java.util.List;

import com.learning.java.reactive.courseutil.Util;

import reactor.core.publisher.Flux;

public class NameGenerator {
	
	public static List<String> getNames(int count){
		List<String> list = new ArrayList<>(count);
		for(int i = 0; i < count; i++) {
			list.add(getName());
		}
		return list;
	}
	
	public static Flux<String> getFluxNames(int count){
		return Flux.range(0, count)
					.map(i -> getName());
	}
	
	private static String getName() {
		Util.sleepSecond(1);
		return Util.faker().name().fullName();
	}
}
