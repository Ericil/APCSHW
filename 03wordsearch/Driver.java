public class Driver{
    public static void main(String[]args){
	WordGrid tester = new WordGrid(20, 20);
	tester.loadWordsFromFile("text.txt", false);
    }
}
