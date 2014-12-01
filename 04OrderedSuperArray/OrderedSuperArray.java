public class OrderedSuperArray extends SuperArray{
    public void add(String element){
	int counter = size();
	int counter2 = 0;
	if (counter > 0){
	    while (counter > 0){
		if (element.compareTo(size[counter2]) < 0){
		    super(0, element);
		}
		counter = counter - 1;
		counter2 = counter2 + 1;
	    }
	}
    }
    public void add(int index, String element){
	this(element);
    }
    public String set(){
    }
    public static void main(String[]args){
	OrderedSuperArray test = new OrderedSuperArray(4);
	try{
	    test.add("cookie");
 	}
	catch(IndexOutOfBoundsException e){
	    System.out.println("Failure to run code");
	    e.printStackTrace();
	}
    }
}
