import java.util.*;
public class ArrayListMethods{
    public static void collapseDuplicates(ArrayList<Integer> L){
	int counter = 0;
	while (counter < L.size() - 1){
	    if (L.get(counter) == L.get(counter)){
		L.remove(counter + 1);
	    }
	    counter = counter + 1;
	}
    }
    public static void randomize(ArrayList<Integer> L){
	Random r = new Random();
	int counter = 0;
	int place;
	while (counter < L.size()){
	    int position = r.nextInt(L.size());
	    place = L.get(position);
	    L.set(position, L.get(counter));
	    L.set(counter, place);
	    counter = counter + 1;
	}
    }
    public static void main(String[]args){
	ArrayList<Integer> test = new ArrayList<Integer>();
	ArrayList<Integer> test2 = new ArrayList<Integer>();
	test.add(1);
	test.add(1);
	test.add(9);
	test.add(1);
	test.add(2);
	test.add(3);
	collapseDuplicates(test);
	System.out.println(test);
	test2.add(1);
	test2.add(2);
	test2.add(3);
	test2.add(4);
	test2.add(5);
	test2.add(6);
	test2.add(7);
	test2.add(8);
	test2.add(9);
	test2.add(0);
	System.out.println(test2);
	randomize(test2);
	System.out.println(test2);
    }
}
	
