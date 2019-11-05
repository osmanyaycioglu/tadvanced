package com.turkcell.training.lambda;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class LambdaMain {
	public static void main2(String[] args) {
		int a = 10;
		ILambda lmd = new ILambda() {
			@Override
			public String abcd(String str) {
				return "Hello " + str + " " + a;
			}
		};
		System.out.println(lmd.abcd("osman"));
	}

	public static void main(String[] args) throws IOException {
		int a = 10;
		ILambda lmd =(s) ->
				{ 
					String lower = ILambda.lower(s);
					return "Hello " + lower + " " + a; 
				};
			
		System.out.println(lmd.cont("xyz "));
		
		String formatStr = ILambda.formatStr(d -> "merhaba " + d, "osman");
		System.out.println(formatStr);
		
		ILambda l = z -> "Test " + z;
		System.out.println(l.upper("osman"));
		
		int[] array = Stream.of("osman","ali","mehmet","veli").
				map( b -> b + " test" ).
				mapToInt(e -> e.length()).toArray();
	
		List<Integer> myIntsIntegers = new ArrayList<>();
		Stream.of("osman","ali","mehmet","veli").
				map( b -> b + " test" ).
				mapToInt(e -> e.length()).forEach(i -> myIntsIntegers.add(i));

		Stream.of("osman","ali","mehmet","veli").
		map( b -> b + " test" ).sorted().collect(Collectors.toList());
		
		Stream.of("osman","ali","mehmet","veli").skip(2).allMatch(e -> e.length() > 3);
		Stream.of("osman","ali","mehmet","veli").anyMatch(e -> e.length() > 3);
		List<String> collect = Stream.of("osman","ali","mehmet","veli","veli")
					.distinct()
					.filter(e -> e.length() > 3)
					.sorted()
					.limit(2)
					.collect(Collectors.toList());
		System.out.println(collect);

		String reduced = Stream.of("osman","ali","mehmet","veli","veli","test","ayse","orhan")
				.distinct()
				.filter(e -> e.length() > 3)
				.sorted()
				.reduce("", (t,i) -> t + " " + i );
	 System.out.println(reduced);

			Stream.of("osman","ali","mehmet","veli","veli","test","ayse","orhan")
			.flatMap (y -> {
				char[] charArray = y.toCharArray();
				Character[] c = new Character[charArray.length];
				for (int j = 0; j < c.length; j++) {
					c[j] = charArray[j];
				}
				return Stream.of(c);
			} ).distinct().forEach(System.out::println);

			Stream.of("osman","ali","mehmet","veli","veli","test","ayse","orhan")
				.flatMap (y -> Stream.of(y.toCharArray())
			 ).distinct().forEach(System.out::println);
			
			List<String> collect2 = Files.readAllLines(Paths.get("xyz.txt")).stream()
				.flatMap(x -> Stream.of(x.split(" ")))
				.distinct()
				.sorted()
				.map(d->d.replace(",", "").replace(".", "").trim())
				.collect(Collectors.toList());
			for (String string : collect2) {
				System.out.println(string);
			}
	}
}
