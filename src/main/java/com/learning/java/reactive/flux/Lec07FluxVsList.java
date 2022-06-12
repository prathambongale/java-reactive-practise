package com.learning.java.reactive.flux;

import java.util.List;

import com.learning.java.reactive.courseutil.Util;
import com.learning.java.reactive.flux.helper.NameGenerator;

public class Lec07FluxVsList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//List<String> names = NameGenerator.getNames(5);
		//System.out.println(names);
		
		NameGenerator.getFluxNames(5)
						.subscribe(Util.onNext());
	}

}
