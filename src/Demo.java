//Извеждам проверката за думата в отделна, функция. По този начин намалявам повторението на код 
//и спестявам над 100 реда.

public class Demo {

	private static final String MY_WORD = "ivan";
	private static String myWord = "";
	
	public static void main(String[] args) {
		
		char[][] word = 
			{
					{'i','v','a','n'},
					{'e','v','n','h'},
					{'i','n','a','v'},
					{'m','v','v','n'},
					{'q','r','i','t'}
			};
		int br=0;
		br = checkRowsLeftToRight(word) + checkRowsRightToLeft(word) + checkColDownward(word) +
				checkColUpward(word) + mainDiagonalLeftToRight(word) + mainDiagonalRightToLeft(word)+
				secondDiagonalLeftToRight(word)+secondDiagonalRightToLeft(word);
		
		System.out.println(MY_WORD+" occurs "+br+" times !");
		
	}
		
	   static int function(char[][] word,int br,int row,int col){
		    try{
				myWord+=word[row][col];
				}
				catch (Exception e) {
				}
			if(myWord.contains(MY_WORD)){
				br++;
				myWord="";
			}
			return br;
	   }
	 
	   static int checkRowsLeftToRight(char[][] word)
		{
			int rowsBr=0;
				for(int i=0;i<word.length;i++)
				{
					for(int j=0;j<word[i].length;j++)
					{
					  rowsBr=	function(word,rowsBr,i,j);
					
					}	
					myWord="";
             }
				return rowsBr;
     }
		static int checkRowsRightToLeft(char[][] word)
		{
			int rowsBr=0;
			myWord="";
			for(int i=0;i<word.length;i++){
				for(int j=word[i].length-1;j>=0;j--){
					rowsBr=	function(word,rowsBr,i,j);
				}
				myWord="";
			}
			return rowsBr;
		}
		static int checkColDownward(char[][] word)
		{
			    int colBr=0;
			    myWord="";
				for(int j=0;j<word[0].length;j++)
				{
					for(int i=0;i<word.length;i++)
					{
						colBr=	function(word,colBr,i,j);
					}
					myWord="";
					}
				return colBr;
		}
		
		static int checkColUpward(char[][] word)
		{
			    int colBr=0;
			    myWord="";
				for(int j=0;j<word[0].length;j++){
					for(int i=word.length-1;i>0;i--){
						colBr=	function(word,colBr,i,j);
					}
					myWord="";
				}
				return colBr;
		}
		
		static int mainDiagonalLeftToRight(char[][] word){
			
			int br=0;
			int col =0;
			int numOfRows = 0;
			
			// main diagonal and under main diagonal
			
			for(int k=0;k<word.length;k++){
				for(int row=numOfRows;row<word.length;row++){
					br=	function(word,br,row,col);
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
							br=	function(word,br,row,col);
						col++;
				}
					col=++colNum;	
					myWord="";
				}
							
			return br;
		}
		
		static int mainDiagonalRightToLeft(char[][] word){
			
			int br=0;
			int numOfRows=word.length-1;
			int col=word[0].length-1;
			int rowNum = numOfRows;
			
			// main diagonal and above main diagonal
			
			for(int k=0;k<word.length;k++){
				for(int row=numOfRows;row>=0;row--){
					br=	function(word,br,row,col);
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
					br=	function(word,br,row,col);
						col--;
				}
					col=--colNum;		
					myWord="";
				}
							
			return br;
		}
		
		static int secondDiagonalLeftToRight(char[][] word)
		{
			int numOfRows=word.length-1;
			int col=0;
			int br=0;
		    int rowsNum = numOfRows;
			
			// elements above diagonal
			
			for(int k=0;k<word.length;k++){
				for(int row=numOfRows;row>=0;row--){
					br=	function(word,br,row,col);
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
					br=	function(word,br,row,col);
						col++;
				}
				col=++numOfCols;
				myWord="";
			}	
			return br;
		}
		
		static int secondDiagonalRightToLeft(char[][] word){
			
			int numOfRows=0;
			int col=word[0].length-1;
			int br=0;
		
			//Elements under diagonal
			
			for(int k=0;k<word.length;k++){
				for(int row=numOfRows;row<word.length;row++){
					br=	function(word,br,row,col);
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
					br=	function(word,br,row,col);
						col--;
				}
				col=--numOfCols;
				myWord="";
			}
			
			return br;
		}
}
