package com.piatakha.io;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.FileAttribute;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class NioDemo {
	
	public static void main(String[] args) throws IOException {
		String pathToDirectory = "testDirectory" + File.separator + "tesSubDirectory";
		Path path = Paths.get(pathToDirectory);
		
		Files.createDirectories(path);
		
		hm2();
	}
	
	private static void hm() throws IOException {
		Path start = Paths.get("");
		int maxDepth = 4;
		try (Stream<Path> stream = Files.find(start, maxDepth, (path, attr) ->
		        String.valueOf(path).endsWith(".js"))) {
		    String joined = stream
		        .sorted()
		        .map(String::valueOf)
		        .collect(Collectors.joining("; "));
		    System.out.println("Found: " + joined);
		}
	}
	
	private static void hm2() throws IOException {
		Path start = Paths.get("");
		int maxDepth = 3;
		try (Stream<Path> stream = Files.find(start, maxDepth, (path, attr) -> {
			return String.valueOf(path).endsWith(".java");
		})) 
		{
		    String joined = stream
		        .sorted()
		        .map(String::valueOf)
		        .collect(Collectors.joining("; "));
		    System.out.println("Found: " + joined);
		}
	}

}
