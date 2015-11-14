import java.util.Scanner;

public class Demo {

	private static String MY_WORD = "";
	private static String myWord = "";
	static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		
		System.out.println("Enter the word you want to search ");
		MY_WORD = sc.next();
		
		char[][] word = enterMatrix();
		System.out.println("Here is the matrix : ");
		showMatrix(word);
		
		int number=0;
		number = checkRowsLeftToRight(word) + checkRowsRightToLeft(word) + checkColDownward(word) +
				checkColUpward(word) + mainDiagonalLeftToRight(word) + mainDiagonalRightToLeft(word)+
				secondDiagonalLeftToRight(word)+secondDiagonalRightToLeft(word);
		
		System.out.println(MY_WORD+" occurs "+number+" times !");		
	}
	
	 static void showMatrix(char[][] word){
		 for(int row=0;row<word.length;row++){
			 for(int col=0;col<word[row].length;col++){
				 System.out.print(word[row][col]+" ");
			 }
			 System.out.println();
		 }
		 }
	
	  static char[][] enterMatrix(){
		 
		  int rows=0,cols=0;
		  do
		  {
		  System.out.println("Please enter the number of rows of the matrix");
		  rows = sc.nextInt();
		  System.out.println("Please enter the number of cols of the matrix");
		  cols = sc.nextInt();
		  if(rows<=0 || cols<=0){
			  System.out.println("Enter positive numbers");
		  }
		  }while(rows<=0 && cols<=0);
		  char[][] word = new char[rows][cols];
		  System.out.println("Now fill in the matrix");
		  for(int row=0;row<rows;row++){
			  for(int col=0;col<cols;col++){
				  System.out.println("Enter char for row N"+row+" and col N"+col);
				  word[row][col]=sc.next().charAt(0);
			  }
		  }
		    return word;
	  }
		
	   static int function(char[][] word,int number,int row,int col){
		    try{
				myWord+=word[row][col];
				}
				catch (Exception e) {
				}
			if(myWord.contains(MY_WORD)){
				number++;
				myWord="";
			}
			return number;
	   }
	 
	   static int checkRowsLeftToRight(char[][] word)
		{
			int rowsNum=0;
				for(int row=0;row<word.length;row++)
				{
					for(int col=0;col<word[row].length;col++)
					{
					  rowsNum=	function(word,rowsNum,row,col);
					
					}	
					myWord="";
             }
				return rowsNum;
     }
		static int checkRowsRightToLeft(char[][] word)
		{
			int rowsNum=0;
			myWord="";
			for(int row=0;row<word.length;row++){
				for(int col=word[row].length-1;col>=0;col--){
					rowsNum=	function(word,rowsNum,row,col);
				}
				myWord="";
			}
			return rowsNum;
		}
		static int checkColDownward(char[][] word)
		{
			    int colNum=0;
			    myWord="";
				for(int col=0;col<word[0].length;col++)
				{
					for(int row=0;row<word.length;row++)
					{
						colNum=	function(word,colNum,row,col);
					}
					myWord="";
					}
				return colNum;
		}
		
		static int checkColUpward(char[][] word)
		{
			    int colNum=0;
			    myWord="";
				for(int col=0;col<word[0].length;col++){
					for(int row=word.length-1;row>0;row--){
						colNum=	function(word,colNum,row,col);
					}
					myWord="";
				}
				return colNum;
		}
		
		static int mainDiagonalLeftToRight(char[][] word){
			
			int num=0;
			int col =0;
			int numOfRows = 0;
			
			// main diagonal and under main diagonal
			
			for(int k=0;k<word.length;k++){
				for(int row=numOfRows;row<word.length;row++){
					num = function(word,num,row,col);
					col++;
			}
				myWord="";
				col=0;				
				numOfRows++;
			}
			
			// above main diagonal 
			
			myWord="";
			col = 1;
			int colNum = col;
			
				for(int k=0;k<word.length;k++)
				{
					for(int row=0;row<word.length;row++){
							num=	function(word,num,row,col);
						col++;
				}
					col=++colNum;	
					myWord="";
				}
							
			return num;
		}
		
		static int mainDiagonalRightToLeft(char[][] word){
			
			int num=0;
			int numOfRows=word.length-1;
			int col=word[0].length-1;
			int rowNum = numOfRows;
			
			// main diagonal and above main diagonal
			
			for(int k=0;k<word.length;k++){
				for(int row=numOfRows;row>=0;row--){
					num=	function(word,num,row,col);
					col--;
			}
				myWord="";
				numOfRows=--rowNum;
				col=word[0].length-1;
			}

			
			// under main diagonal 
			
			myWord="";
			col = word[0].length-2;
			int colNum = col;
			numOfRows = word.length-1;
			for(int k=0;k<word.length;k++)
			{
				for(int row=numOfRows;row>=0;row--){
					num = function(word,num,row,col);
						col--;
				}
					col=--colNum;		
					myWord="";
				}
							
			return num;
		}
		
		static int secondDiagonalLeftToRight(char[][] word)
		{
			int numOfRows=word.length-1;
			int col=0;
			int num=0;
		    int rowsNum = numOfRows;
			
			// elements above diagonal
			
			for(int k=0;k<word.length;k++){
				for(int row=numOfRows;row>=0;row--){
					num = function(word,num,row,col);
						col++;
										}
				numOfRows=--rowsNum;
             col=0;
             myWord="";
			}
			
			// elements under diagonal
						
			int numOfCols = 1;
			col=numOfCols;
			numOfRows=word.length-1;
						
			for(int k=0;k<word.length;k++)
			{
				for(int row=numOfRows;row>=0;row--){
					num=function(word,num,row,col);
						col++;
				}
				col=++numOfCols;
				myWord="";
			}	
			return num;
		}
		
		static int secondDiagonalRightToLeft(char[][] word){
			
			int numOfRows=0;
			int col=word[0].length-1;
			int num=0;
		
			//Elements under diagonal
			
			for(int k=0;k<word.length;k++){
				for(int row=numOfRows;row<word.length;row++){
					num = function(word,num,row,col);
						col--;
				}
				numOfRows++;
				myWord="";
				col=word[0].length-1;
			}
			
			// Elements above diagonal
			
			int numOfCols = word[0].length-2;
			col=numOfCols;
			numOfRows=0;
			
			for(int k=0;k<word.length;k++)
			{
				for(int row=numOfRows;row<word.length;row++){
					num = function(word,num,row,col);
						col--;
				}
				col=--numOfCols;
				myWord="";
			}
			
			return num;
		}
}
