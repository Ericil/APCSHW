public class SuperArray{
    Object[] data;
    int storage;
    
    public SuperArray(){
	this(10);
    }
    public SuperArray(int a){
	data = new Object[a];
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
	Object[] data2 = new Object[newCapacity];
	int counter = 0;
	while (counter != data.length && newCapacity != 0){
	    data2[counter] = data[counter];
	    counter = counter + 1;
	    newCapacity = newCapacity - 1;
	}
	data = data2;
    }
    public void add(Object e){
        this(data.length, e);
    }
    public void add(int index, Object o){
	if (size() == data.length){
	    resize(data.length + 1);
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
	Object[] data2 =  new Object[data.length];
	data = data2;
    }
    public Object get(int index){
	if ((index < 0) || (index >= size())){
	    System.out.println("Error: Out of Bounds");
	    return null;
	}else{
	    return data[index];
	}
    }
    public void set(int index, Object e){
	data[index] = e;
    }
    public static void main(String[]args){
	SuperArray test = new SuperArray(4);
	test.data[0] = 1;
	test.data[1] = 2;
	test.resize(3);
	test.data[2] = 3;
	test.add(4);
	System.out.println(test.toString());
	System.out.println(test.size());
	test.clear();
	System.out.println(test.toString());
	System.out.println(test.size());
	test.get(2);
	test.set(2, "notnull");
	System.out.println(test.toString());
	System.out.println(test.size());

    }
}
