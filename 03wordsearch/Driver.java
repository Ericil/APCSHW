public class Driver{
    public static void main(String[]args){
	WordGrid tester = new WordGrid(20, 20);
	System.out.println(tester);
	System.out.println(tester);
	System.out.println(tester.addWordHorizontal("cookies", 6, 3));
	System.out.println(tester);
	System.out.println(tester.addWordVertical("cookies", 1, 8));
	System.out.println(tester);
	System.out.println(tester.addWordDiagonal("cookies", 1, 3));
	System.out.println(tester);
	System.out.println(tester.addWordHorizontalRe("cookies", 9, 9));
	System.out.println(tester);
	System.out.println(tester.addWordVerticalRe("cookies", 19, 0));
	System.out.println(tester);
	System.out.println(tester.addWordDiagonalRe("cookies", 19, 19));
	System.out.println(tester);
	System.out.println(tester.addWordDiagonalOther("cookies", 13, 13));
	System.out.println(tester);
	
    }
}
