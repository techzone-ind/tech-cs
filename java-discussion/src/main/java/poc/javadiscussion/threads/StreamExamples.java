package poc.javadiscussion.threads;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * This class is Java 11 stream feature with examples
 * @author Animesh Sinha
 *
 */
public class StreamExamples {
	
	public static void main(String[] args) {
		System.out.println("Java 8 Stream examples");

		//
		System.out.println("1. Given a sentence \"Java 8 stream is very easy language\", find the word that has the highest length");
		String str1 = "Java 8 stream is very easy language";
		String resultStr1= Arrays.stream(str1.split(" ")).max(Comparator.comparing(String::length)).get();
		System.out.println("Answer is "+resultStr1);
		//Remove duplicates from the string and return in the same order
		System.out.println("2. Remove duplicates from the string and return in the same order");
		String str2 = "aabcdfgggghh";
		String resultStr2 = Arrays.stream(str2.split("")).distinct().collect(Collectors.joining());
		System.out.println("Answer is "+resultStr2);
		//Find the word that has the second highest length
		System.out.println("3. Find the word that has the second highest length");
		String resultStr3= Arrays.stream(str1.split(" ")).sorted(Comparator.comparing(String::length).reversed()).skip(1)
				.findFirst().get();
		System.out.println("Answer is "+resultStr3);

		System.out.println("4. In a given sentence, find the occurrence of each word");
		Arrays.stream(str1.split(" ")).collect(Collectors.groupingBy(x->x,Collectors.counting()))
		.entrySet().stream().map(m -> m.getKey()+" "+m.getValue()).forEach(System.out::println);

		System.out.println("5. In a given sentence, find the words with a specified number of vowels");
		Arrays.stream(str1.split(" ")).filter(w -> w.replaceAll("[^AEIOUaeiou]", "").length() == 2)
		.forEach(System.out::println);

		System.out.println("6. Divide given integer list into lists of even and odd numbers");
		int[] intArr = {1,2,3,4,5,6,7,8};
		List<List<Integer>> result = Arrays.stream(intArr).boxed().collect(Collectors.groupingBy(x->x%2==0,Collectors.toList()))
				.entrySet().stream().map(m -> m.getValue()).collect(Collectors.toList());
		System.out.println(result);

		System.out.println("7. In a give word, find the occurrence of each character ");
		String str3 = "aaaabbbbcccddddeeeeff";
		String result3 = Arrays.stream(str3.split("")).collect(Collectors.groupingBy(x->x,Collectors.counting()))
				.entrySet().stream().map(m -> m.getKey()+""+m.getValue()).collect(Collectors.joining());

		System.out.println(result3);

		System.out.println("8. in a given int array, find the sum of unique elements");
		int[] intArr1 = {1,1,6,7,8,1,7,8,7};
		int result4 = Arrays.stream(intArr1).distinct().sum();
		System.out.println(result4);

		System.out.println("9. In a given string, find the first non-repeated character");
		String str4 = "Hello World";
		String result5 = Arrays.stream(str4.split(""))
				.collect(Collectors.groupingBy(x->x,LinkedHashMap::new,Collectors.counting()))
				.entrySet().stream().filter(m->m.getValue() == 1).map(m ->m.getKey()).findFirst().get();

		System.out.println(result5);

		System.out.println("10. In a given list of strings, create a list that contains only integers");
		String[] strArr = {"abcd","1234","xxyy","456"};
		List<Integer> ans = Arrays.stream(strArr).filter(s -> s.matches("[0-9]+")).map(Integer::valueOf)
				.collect(Collectors.toList());

		System.out.println(ans);

		System.out.println("11. In a geven int array, find the products of the first two elements in an array.");
		int[] arr = {6,5,6,9,2,4};
		int ans2 = Arrays.stream(arr).limit(2).reduce(1,(a,b) -> a*b);
		System.out.println(ans2);

		System.out.println("12. In a given int array, multiply alternative numbers.");
		int[] intArry2 =  {1,5,4,7,2,9,2};
		int result_12 = IntStream.range(0, intArry2.length).filter(i -> i % 2 ==0)
				.map(x -> intArry2[x]).reduce(1,(a,b)-> a*b);
		System.out.println(result_12);

		System.out.println("13. In a given int array, move all zero’s to beginning of array ");
		int[] intArr3 = {5,0,1,0,8,0};

		List<Integer> result_13 = Stream.concat(Arrays.stream(intArr3).filter(e -> e == 0).boxed(), Arrays.stream(intArr3).filter(e -> e != 0).boxed())
				.collect(Collectors.toList());
		System.out.println(result_13);
		System.out.println("14. In a given array of integers, return true if it contains distinct values");
		int[] intArr4 = {1,1,2,4,5,5,6};
		//int[] intArr4 = {1,2,4,5,6};
		boolean result_14 = Arrays.stream(intArr4).boxed().distinct().collect(Collectors.toList()).size() == intArr4.length;
		System.out.println(result_14);

		System.out.println("Fibonacci Sequence");
		List<Integer> fib = Stream.iterate(new int[] {0,1}, f-> new int[]{f[1],f[0]+f[1]}).limit(10)
				.map(f->f[0]).collect(Collectors.toList());
		System.out.println(fib);


	}

}