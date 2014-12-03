import java.util.*;
public class Driver{
    public static void main(String[]args){
	Random r = new Random();
	if (args.length > 1 && args.length < 5){
	    WordGrid tester;
	    if (args.length <= 3){
	        tester = new WordGrid(Integer.parseInt(args[0]), Integer.parseInt(args[1]));
		if (args.length == 3){
		    tester.setSeed(Long.parseLong(args[2]));
		}else{
		    tester.setSeed(r.nextInt());
		}
		tester.loadWordsFromFile("text.txt", false);
	    }else{
	        tester = new WordGrid(Integer.parseInt(args[0]), Integer.parseInt(args[1]));
		tester.setSeed(Long.parseLong(args[2]));
		if(Integer.parseInt(args[3]) == 1){
		    tester.loadWordsFromFile("text.txt", true);
		}else{
		    tester.loadWordsFromFile("text.txt", false);
		}
	    }
	    System.out.println("The words in the puzzle:");
	    System.out.println(tester.wordsInPuzzle());
	    System.out.println();
	    System.out.println(tester);
	}else{
	    System.out.println("Please use the following format:");
	    System.out.println("java Driver <rows> <cols> [<seed> [<use 1 for answers>]]");
	}
    }
}
