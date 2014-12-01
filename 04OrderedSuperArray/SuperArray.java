public class SuperArray{
    String[] data;
    int storage;
    
    public SuperArray(){
	this(10);
    }
    public SuperArray(int a){
	data = new String[a];
    }
    public String toString(){
	String printing = "";
        int counter = data.length;
	while (counter != 0){
	    printing = printing + data[data.length - counter] + " ";
	    counter = counter - 1;
	}
	return printing;
    }
    public int size(){
	int counter = data.length;
	int thesize = 0;
	while (counter != 0){
	    if (data[data.length - counter] != null){
		thesize = thesize + 1;
	    }
	    counter = counter - 1;
	}
	storage = thesize;
	return thesize;
    }
    public void resize(int newCapacity){
	String[] data2 = new String[newCapacity];
	int counter = 0;
	while (counter != data.length && newCapacity != 0){
	    data2[counter] = data[counter];
	    counter = counter + 1;
	    newCapacity = newCapacity - 1;
	}
	data = data2;
    }
    public void add(String e){
        if (size() == data.length){
	    resize(data.length + 1);
	    data[data.length - 1] = e;
	}else{
	    int counter = data.length - 1;
	    boolean temp = false;
	    while (temp == false){
		if (data[counter] == null){
		    data[counter] = e;
		    temp = true;
		}else{
		    counter = counter - 1;
		}
	    }
	}
    }
    public void add(int index, String o){
	if (size() == data.length){
	    if (index >= data.length){
		resize(index + 1);

	    }else{
	    resize(data.length + 1);
	    }
	    int counter = data.length - 1;
	    while (counter >= index){
		data[counter] = data[counter - 1];
		counter = counter - 1;
	    }
	    data[index] = o;
	}else{
	    int counter = data.length - 1;
	    boolean trigger = false;
	    while ((counter >= index) && (trigger == false)){
		if (data[counter] == null){
		    trigger = true;
		}
		counter = counter - 1;
	    }
	    if (trigger == false){
		resize(data.length + 1);
		counter = data.length - 1;
		while (counter >= index){
		    data[counter] = data[counter - 1];
		    counter = counter - 1;
		}
		data[index] = o;
	    }else{
		counter = data.length - 1;
		while (counter >= index){
		    if (data[counter] == null){
			data[counter] = data[counter - 1];
		    }
		    counter = counter - 1;
		}
		data[index] = o;
	    }
	   
	}
    }
    public void clear(){
	String[] data2 =  new String[data.length];
	data = data2;
    }
    public String get(int index){
	if ((index < 0) || (index >= size())){
	    throw new IndexOutOfBoundsException();
	}else{
	    return data[index];
	}
    }
    public String set(int index, String o){
	if ((index < 0) || (index >= size())){
	    throw new IndexOutOfBoundsException();
	}else{
	    String replacing = data[index];
	    data[index] = o;
	    return replacing;
	}
    }
    public String remove(int index){
	if ((index < 0) || (index >= size())){
	    throw new IndexOutOfBoundsException();
	}else{
	    String replacing = data[index];
	    int counter = index;
	    while (counter < data.length - 1){
		data[counter] = data[counter + 1];
		counter = counter + 1;
	    }
	    return replacing;
	}
    }
    
		
	
    public static void main(String[]args){
	SuperArray test = new SuperArray(4);
	try{
	    test.data[0] = "a";
	    test.data[1] = "b";
	    test.resize(3);
	    test.data[2] = "c";
	    test.add("d");
	    System.out.println(test.toString());
	    System.out.println("Should return 1, 2, 3, 4");
	    System.out.println(test.size());
	    System.out.println("Should return 4");
	    test.add(5, "e");
	    System.out.println(test.toString());
	    System.out.println("Should return 1, 2, 3, 4, null, 5");
	    test.clear();
	    System.out.println(test.toString());
	    System.out.println("Should return all nulls");
	    System.out.println(test.size());
	    System.out.println("Should return 0");
	    test.get(2);
	    System.out.println("Should return out of bounds");
	    test.set(2, "notnull");
	    System.out.println("Should return out of bounds");
	    System.out.println(test.toString());
	    System.out.println("Should return all nulls");
	    System.out.println(test.size());
	    System.out.println("Should return 0");
	    test.data[0] = "a";
	    test.data[1] = "b";
	    test.data[2] = "c";
	    test.data[3] = "d";
	    test.remove(2);
 	    System.out.println(test.toString());
	    System.out.println("Should return 0, 1, 3, null, null, null");
	}
	catch(IndexOutOfBoundsException e){
	    System.out.println("Failure to run code");
	    e.printStackTrace();
	}
    }
}
