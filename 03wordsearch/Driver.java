public class Driver{
    public static void main(String[]args){
	WordGrid tester = new WordGrid(50, 50);
	tester.loadWordsFromFile("text.txt", false);
	System.out.println(tester);
    }
}
