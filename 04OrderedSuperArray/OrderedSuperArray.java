public class OrderedSuperArray extends SuperArray{
    String[] data;
    public void add(String element){
	int counter = size();
	int counter2 = 0;
	System.out.println(counter);
	while(counter > 0 && element.compareTo(get(counter2)) < 0){
	    counter = counter - 1;
	    counter2 = counter2 + 1;
	}
	super.add(counter, element);
    }
    public void add(int index, String element){
	add(element);
    }
    public String set(){
	return "a";
    }
    //start with one element, insert the next
    //public insertionSort()
    public static void main(String[]args){
	OrderedSuperArray test = new OrderedSuperArray();
	System.out.println(test.toString());
	System.out.println(test.size());
	test.add("cookie");
	System.out.println(test.toString());
	test.add("apple");
	System.out.println(test.toString());
	test.add("rawr");
	System.out.println(test.toString());
	
    }
}
