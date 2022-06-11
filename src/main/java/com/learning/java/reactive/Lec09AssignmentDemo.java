package com.learning.java.reactive;

import com.learning.java.reactive.courseutil.Util;
import com.learning.java.reactive.sec01assignment.FileService;

public class Lec09AssignmentDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
	    FileService .read("file03.txt") .subscribe( Util.onNext(), Util.onError(),Util.onComplete() );
	    
		FileService.write("file03.txt", "This is file 3").subscribe(Util.onNext(), Util.onError(), Util.onComplete());
		
		FileService.delete("file03.txt").subscribe(Util.onNext(), Util.onError(), Util.onComplete());
	}

}
