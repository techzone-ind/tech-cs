# Java basics and fundamentals
# Java 8 streams examples

>Count letter in a string

       String str = "aaabbaacdddaaeefg" ;
				//output = "a7b2c1d2f2f1g1"
		
		Map<String,Long> res = Arrays.stream(str.split("")).collect(Collectors.groupingBy(x->x,Collectors.counting()));
		res.entrySet().stream().forEach(c -> {
			System.out.print(c.getKey()+""+c.getValue());
		});
		System.out.println("");
		String chString = res.entrySet().stream().map(x -> x.getKey()+""+x.getValue())
        .collect(Collectors.joining());
		System.out.println(chString);
		String result2 = res.entrySet().stream().map(x -> x.getKey()+""+x.getValue()).reduce((x,y) -> x+""+y)
		        .orElse("");
		System.out.println(result2);
		System.out.println("-------");

> Multiply first two number in array

       int[] arr = {6,5,6,9,2,4};
		int ans = Arrays.stream(arr).limit(2).reduce(1,(a,b) -> a*b);
		System.out.println(ans);

>1. Given a sentence "Java 8 stream is very easy language", find the word that has the highest length
>2. Remove duplicates from the string and return in the same order
>3. Find the word that has the second highest length
>4. In a given sentence, find the occurrence of each word
>5. In a given sentence, find the words with a specified number of vowels
>6. Divide given integer list into lists of even and odd numbers
>7. In a give word, find the occurrence of each character 
>8. in a given int array, find the sum of unique elements
>9. In a given string, find the first non-repeated character
>10. In a given list of strings, create a list that contains only integers
>11. In a geven int array, find the products of the first two elements in an array.
>12. In a given int array, multiply alternative numbers.
>13. In a given int array, move all zero’s to beginning of array 
>14. In a given array of integers, return true if it contains distinct values

# Java 8 problems and solutions

> Producer Consumer problem using java threads
