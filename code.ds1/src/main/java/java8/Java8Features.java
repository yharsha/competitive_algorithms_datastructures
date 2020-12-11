package java8;

import java.util.Arrays;
import java.util.List;
import java.util.stream.*;

//https://www.geeksforgeeks.org/stream-in-java/
public class Java8Features {

	public static void main(String[] args) {
		
		//map
		System.out.println("Map fun for squaring");
		List<Integer> number = Arrays.asList(1,2,3,4,5,6,7,8);
		List<Integer> square = number.stream().map(p-> p * p).collect(Collectors.toList());
		System.out.println(square);
		
		//reduce: The reduce method is used to reduce the elements of a stream to a single value.
		System.out.println("reduce method");
		int even = number.stream().filter(x->x%2==0).reduce(0, (ans,i)->ans+i);
		System.out.println("Reduce fun: get sum of even elements"+even);
		
		//filter
		System.out.println("Filter fun :");
		List<String> names = Arrays.asList("Reflection","Collection","Stream");
		List<String> result = names.stream().filter(str->str.startsWith("S")).collect(Collectors.toList());
		result.stream().forEach(x->System.out.print(x+" "));
		
		//sorted
		System.out.println("Sorted fun :");
		List<String> result1 = names.stream().sorted().collect(Collectors.toList()); 
		result1.stream().forEach(x->System.out.print(x+" "));
		
		Stream<Integer> streamIterated = Stream.iterate(40, n -> n + 2).limit(20);
		Stream<Integer> streamIterated1 = Stream.iterate(1,x->x+2).filter(x-> x%5==0).limit(10);
		streamIterated.forEach(x->System.out.print(x+" "));
		streamIterated1.forEach(x->System.out.print(x+" "));
	
	}

}
