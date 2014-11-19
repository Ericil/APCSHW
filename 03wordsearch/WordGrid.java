public class WordGrid{
    private char[][]data;
    private int rowcounter, colcounter;
    
    /**Initialize the grid to the size specified and fill all of the positions
     *with spaces.
     *@param row is the starting height of the WordGrid
     *@param col is the starting width of the WordGrid
     */
    public WorldGrid(int rows, int cols){
	data = data[rows][cols];
	rowcounter = rows;
	colcounter = cols;
    }

    /**Set all values in the WordGrid to spaces ' '*/
    private void clear(){
	int counter = rowcounter;
	while (counter != 0){
	    int counter2 = colcounter;
	    while (counter2 != 0){
		data[counter][counter2] = " ";
		counter2 = counter2 - 1;
	    }
	    counter1 = counter1 - 1;
	}
    }

    /**The proper formatting for a WordGrid is created in the toString.
     *@return a String with each character separated by spaces, and each row
     *separated by newlines.
     */
    public String toString(){
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
    }

    //vertical + diagonal should be implemented as well.
    
}
