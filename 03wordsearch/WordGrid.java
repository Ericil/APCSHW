import java.io.*;
import java.util.*;

public class WordGrid{
    private char[][] data;
    private int rowcounter, colcounter, rowdirect, coldirect;
    private String s = ".";
    private Random r = new Random();
    private ArrayList<String> words = new ArrayList<String>();
    private ArrayList<String> actualwords = new ArrayList<String>();
    
    /**Initialize the grid to the size specified and fill all of the positions
     *with spaces.
     *@param row is the starting height of the WordGrid
     *@param col is the starting width of the WordGrid
     */
    public WordGrid(int rows, int cols){
        data = new char[rows][cols];
	rowcounter = rows;
	colcounter = cols;
	clear();
	setSeed(0);
    }

    /**Set all values in the WordGrid to spaces '.'
     */
    private void clear(){
	int counter = 0;
	while (counter < rowcounter){
	    int counter2 = 0;
	    while (counter2 < colcounter){
		data[counter][counter2] = s.charAt(0);
		counter2 = counter2 + 1;
	    }
	    counter = counter + 1;
	}
    }
    public void setSeed(long theSeed){
	r.setSeed(theSeed);
    }
    public void loadWordsFromFile(String fileName, boolean fillRandomLetters){
	try{
	    File thefile = new File(fileName);
	    Scanner run = new Scanner(thefile);
	    while(run.hasNextLine()){
		placing(run.next());
	    }
	}catch (FileNotFoundException meh){
	    System.out.println("File not found");
	}
	if (fillRandomLetters == false){
	    thespaces();
	}
	wordsInPuzzle();
    }
    public String wordsInPuzzle(){
	String printing = "";
	int counter = actualwords.size() - 1;
	int counter2 = 0;
	while (counter >= 0){
	    printing = printing + actualwords.get(counter);
	    if (counter2 != 3){
		printing = printing + "\t";
		counter2 = counter2 + 1;
	    }else{
		printing = printing + "\n";
		counter2 = 0;
	    }
	    counter = counter - 1;
	}
	return printing;
    }
	    
    /**The proper formatting for a WordGrid is created in the toString.
     *@return a String with each character separated by spaces, and each row
     *separated by newlines.
     */
    public String toString(){
	String printing = "";
	int counter = 0;
	while(counter < rowcounter){
	    int counter2 = 0;
	    while (counter2 < colcounter){
		if (counter2 == rowcounter - 1){
		    printing = printing + data[counter][counter2] + "\n";
		}else{
		printing = printing + data[counter][counter2];
		}
		counter2 = counter2 + 1;
	    }
	    counter = counter + 1;
	}
	return printing;
    }
    private boolean canplace(String word, int row, int col){
	if (rowdirect == 0 && coldirect == 0 ||
	    row < 0 || col < 0 ||
	    col + rowdirect*word.length() >= data[0].length || col + rowdirect*word.length() < 0 ||
	    row + coldirect*word.length() >= data[0].length || row + coldirect*word.length() < 0){
	    return false;
	}
	int counter = 0;
	while (counter < word.length()){
	    if(data[row + (coldirect * counter)][col + (rowdirect * counter)] != '.' &&  data[row + (coldirect * counter)][col + (rowdirect * counter)] != word.charAt(counter)){
		return false;
	    }
	    counter = counter + 1;
	}
	return true;
    }
    //rowdirec: 1 is to the right, -1 is to the left, 0 is no movement in that direction
    //coldirect: 1 is down, -1 is up, 0 is no movement in that direction
    public boolean helping(String word, int row, int col){
	int rows = 0;
	int cols = 0;
	int counter = 0;
	if (canplace(word, row, col)){
	    while (counter < word.length()){
		data[row + coldirect*counter][col + rowdirect*counter] = word.charAt(counter);
		counter = counter + 1;
	    }
	    return true;
	}else{
	    return false;
	}
	
    }
    public void placing(String word){
	int counter = 100;
	int thing1, thing2;
	boolean placed = false;
	while (counter != 0 && placed == false){
	    thing1 = r.nextInt(rowcounter);
	    thing2 = r.nextInt(colcounter);
	    coldirect = r.nextInt(3) - 1;
	    rowdirect = r.nextInt(3) - 1;
	    if (coldirect == 0 && rowdirect == 0){
	    }else{
		if (helping(word, thing1, thing2)){
		    helping(word, thing1, thing2);
		    actualwords.add(word);
		    placed = true;
		}
		counter = counter - 1;
	    }
	}
    }
    public void thespaces(){
	int counter = 0;
	while (counter < rowcounter){
	    int counter2 = 0;
	    while (counter2 < colcounter){
		if (data[counter][counter2] == '.'){
		    data[counter][counter2] = (char)('a' + (int)(r.nextInt(26)));
		}
		counter2 = counter2 + 1;
	    }
	    counter = counter + 1;
	}
    }
    


}
