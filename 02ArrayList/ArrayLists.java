import java.util.*;
public class ArrayLists{
    public static void collapseDuplicates(ArrayList<Integer> L){
	int counter = 0;
	while (counter < L.size() - 1){
	    if (L.get(counter) == L.get(counter)){
		L.remove(counter + 1);
	    }
	    counter = counter + 1;
	}
    }   
    public static void main(String[]args){
	ArrayList<Integer> test = new ArrayList<Integer>();
	test.add(1);
	test.add(1);
	test.add(9);
	test.add(1);
	test.add(2);
	test.add(3);
	collapseDuplicates(test);
	System.out.println(test);
	
    }
}
	
