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
	clear();
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
    public boolean canplace(String word, int row, int col, int rowdirect, int coldirect){
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
    public boolean helping(String word, int row, int col, int rowdirect, int coldirect){
	int rows = 0;
	int cols = 0;
	int counter = 0;
	if (canplace(word, row, col, rowdirect, coldirect)){
	    while (counter < word.length()){
		data[row + coldirect*counter][col + rowdirect*counter] = word.charAt(counter);
		counter = counter + 1;
	    }
	    return true;
	}else{
	    return false;
	}
		
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
	return helping(word, row, col, 0, 1);
    }
    public boolean addWordHorizontalRe(String word, int row, int col){
	return helping(word, row, col, 0, -1);
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
	return helping(word, row, col, 1, 0);
    }
    public boolean addWordVerticalRe(String word, int row, int col){
	return helping(word, row, col, -1, 0);
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
	return helping(word, row, col, 1, 1);
    }
    public boolean addWordDiagonalRe(String word, int row, int col){
	return helping(word, row, col, -1, -1);
    }
    public boolean addWordDiagonalOther(String word, int row, int col){
	return helping(word, row, col, -1, 1);
    }

}
