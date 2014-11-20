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

    /**Set all values in the WordGrid to spaces ' '*/
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
	if (word.length() <= (colcounter - col)){
	    int counter = 0;
	    while (counter < word.length() - 1){
		if ((data[row][col + counter] == s.charAt(0)) || (data[row][col + counter] == word.charAt(counter))){
		    data[row][col + counter] = word.charAt(counter);
		    counter = counter + 1;
		}else{
		    return false;
		}
	    }
	    return true;
	}
	return false;
    }

    //vertical + diagonal should be implemented as well.
    public static void main(String[]args){
	WordGrid tester = new WordGrid(10, 10);
	System.out.println(tester);
	tester.clear();
	System.out.println(tester);
	System.out.println(tester.addWordHorizontal("cookies", 3, 0));
	System.out.println(tester);
	
	
    }
}
