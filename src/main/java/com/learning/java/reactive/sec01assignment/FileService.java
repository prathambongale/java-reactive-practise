package com.learning.java.reactive.sec01assignment;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import reactor.core.publisher.Mono;

public class FileService {

	private static final Path PATH = Paths.get("src/main/resources/assignment/sec01");
	
	public static Mono<String> read(String fileName) {
		return Mono.fromSupplier(() -> readFile(fileName));
	}
	
	public static Mono<String> write(String fileName, String content) {
		return Mono.fromRunnable(() -> write(fileName, content));
	}
	
	public static Mono<Void> delete(String fileName) {
		return Mono.fromRunnable(() -> deleteFile(fileName));
	}
	
	private static String readFile(String fileName) {
		try {
			return Files.readString(PATH.resolve(fileName));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	
	private static void writeFile(String fileName, String content) {
		try {
			Files.writeString(PATH.resolve(fileName), content);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	
	private static void deleteFile(String fileName) {
		try {
			Files.delete(PATH.resolve(fileName));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
}
