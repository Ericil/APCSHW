public class WordGrid{
    private char[][] data;
    private int rowcounter, colcounter;
    private String s = ".";
    
    /**Initialize the grid to the size specified and fill all of the positions
     *with spaces.
     *@param row is the starting height of the WordGrid
     *@param col is the starting width of the WordGrid
     */
    public WordGrid(int rows, int cols){
        data = new char[rows][cols];
	rowcounter = rows;
	colcounter = cols;
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
    //rowdirec: 1 is to theright, -1 is to the left, 0 is no movement in that direction
    //coldirect: 1 is down, -1 is up, 0 is no movement in that direction
    public boolean helping(String word, int row, int col, int rowdirec, int coldirec){
	if ((rowadd <= (rowcounter - row)) && (coladd <= (colcounter - col))){
	    int counter = 0;
	    int rows = 0;
	    int cols = 0;
	    if (rowdirect == 1){
		rows = word.length();
	    }else if (rowdirect == -1){
		rows = word.length();
		int reversecounter = word.length - 1;
		String newword = "";
		while (reversecounter >= 0){
		    newword = newword + word.charAt(reversecounter);
		    reversecounter = reversecounter - 1;
		}
		word = newword;
	    }
	    boolean cookies = false;
	    while ((counter < word.length() - 1) && cookies == false){
		if ((data[row + (rowadd - rows)][col + (coladd - cols)] == s.charAt(0)) || (data[row + (rowadd - rows)][col + (coladd - cols)] == word.charAt(counter))){
		    counter = counter + 1;
		    if (rows != 0){
			rows = rows - 1;
		    }
		    if (cols != 0){
			cols = cols - 1;
		    }
		}else{
		    cookies = true;
		}
	    }
	    if (cookies == true){
		return false;
	    }
	    counter = 0;
	    rows = rowadd;
	    cols = coladd;
	    while (counter < word.length() - 1){
		data[row + (rowadd - rows)][col + (coladd - cols)] = word.charAt(counter);
		if (rows != 0){
		    rows = rows - 1;
		}
		if (cols != 0){
		    cols = cols - 1;
		}
		counter = counter + 1;
	    }
	    return true;
	}
	return false;
    }
	
    /**Attempts to add a given word to the specified position of the WordGrid.
     *The word is added from left to right, must fit on the WordGrid, and must
     *have a corresponding letter to match any letters that it overlaps.
     *
     *@param word is any text to be added to the word grid.
     *@param row is the vertical locaiton of where you want the word to start.
     *@param col is the horizontal location of where you want the word to start.
     *@return true when the word is added successfully. When the word doesn't fit,
     *or there are overlapping letters that do not match, then false is returned.
     */
    public boolean addWordHorizontal(String word,int row, int col){
	return helping(word, row, col, 0, word.length());
    }
    /**Attempts to add a given word to the specified position of the WordGrid.
     *The word is added from top to bottom, must fit on the WordGrid, and must
     *have a corresponding letter to match any letters that it overlaps.
     *
     *@param word is any text to be added to the word grid.
     *@param row is the vertical locaiton of where you want the word to start.
     *@param col is the horizontal location of where you want the word to start.
     *@return true when the word is added successfully. When the word doesn't fit,
     *or there are overlapping letters that do not match, then false is returned.
     */
    public boolean addWordVertical(String word, int row, int col){
	return helping(word, row, col, word.length(), 0);
    }
    /**Attempts to add a given word to the specified position of the WordGrid.
     *The word is added from left to right,top to bottom, must fit on the WordGrid, and must
     *have a corresponding letter to match any letters that it overlaps.
     *
     *@param word is any text to be added to the word grid.
     *@param row is the vertical locaiton of where you want the word to start.
     *@param col is the horizontal location of where you want the word to start.
     *@return true when the word is added successfully. When the word doesn't fit,
     *or there are overlapping letters that do not match, then false is returned.
     */
    public boolean addWordDiagonal(String word, int row, int col){
	return helping(word, row, col, word.length(), word.length());
    }
    public static void main(String[]args){
	WordGrid tester = new WordGrid(10, 10);
	System.out.println(tester);
	tester.clear();
	System.out.println(tester);
	System.out.println(tester.addWordHorizontal("cookies", 6, 3));
	System.out.println(tester);
	System.out.println(tester.addWordVertical("cookies", 1, 8));
	System.out.println(tester);
	System.out.println(tester.addWordDiagonal("cookies", 0, 0));
	System.out.println(tester);
	
	
    }
}
