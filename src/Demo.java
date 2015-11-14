public class Demo {

	private static final String MY_WORD = "ivan";
	private static final int MY_WORD_LENGTH = 4;
	
	public static void main(String[] args) {
		
		char[][] word = 
			{
					{'i','v','a','n'},
					{'e','v','n','h'},
					{'i','n','a','v'},
					{'m','v','v','n'},
					{'q','r','i','t'}
			};
		
		int br = checkRowsLeftToRight(word)+checkRowsRightToLeft(word)+checkColDownward(word)+
				checkColUpward(word)+mainDiagonalLeftToRight(word)+mainDiagonalRightToLeft(word)+
				secondDiagonalLeftToRight(word)+secondDiagonalRightToLeft(word);
		
		System.out.println(MY_WORD+" occurs "+br+" times ");
		
	}
	
	static int checkRowsLeftToRight(char[][] word)
	{
		// Checking rows :
		int myWordTemp = 0;
		int br=0;
		int rowBr = 0;
		int i=0;
		int j=0;
				for(i=0;i<word.length;i++){
					for(j=0;j<word[i].length;j++){
						if(word[i][j] == MY_WORD.charAt(myWordTemp)){
							br++;
							myWordTemp++;
							if(myWordTemp == MY_WORD_LENGTH)
							{
								myWordTemp = 0;
							}
						}
						else if(word[i][j] == MY_WORD.charAt(0)){
							br=0;
							myWordTemp=0;
							br++;
							myWordTemp++;
							if(myWordTemp == MY_WORD_LENGTH)
							{
								myWordTemp = 0;
							}
						}
						else
						{
							myWordTemp=0;
							br=0;
						}
						if(br==MY_WORD_LENGTH){
							rowBr++;
							br=0;
							myWordTemp=0;
						}
					}
					br=0;
				}
		
		return rowBr;
	}
	
	static int checkRowsRightToLeft(char[][] word)
	{
		// Checking rows :
				int myWordTemp = 0;
				int br=0;
				int rowBr = 0;
						for(int i=0;i<word.length;i++){
							for(int j=word[i].length-1;j>=0;j--){
								if(word[i][j] == MY_WORD.charAt(myWordTemp)){
									br++;
									myWordTemp++;
									if(myWordTemp == MY_WORD_LENGTH)
									{
										myWordTemp = 0;
									}
								}
								else if(word[i][j] == MY_WORD.charAt(0)){
									myWordTemp=0;
									br=0;
									br++;
									myWordTemp++;
									if(myWordTemp == MY_WORD_LENGTH)
									{
										myWordTemp = 0;
									}
								}
								else
								{
									br=0;
									myWordTemp=0;
								}
								if(br==MY_WORD_LENGTH){
									rowBr++;
									br=0;
									myWordTemp=0;
								}
								
							}
    						br=0;
							myWordTemp=0;
						}
				
				return rowBr;
	}
	
	static int checkColDownward(char[][] word)
	{
		int myWordTemp = 0;
		int br = 0;
		int colBrDown = 0;
			for(int j=0;j<word[0].length;j++){
				for(int i=0;i<word.length;i++){
				if(word[i][j] == MY_WORD.charAt(myWordTemp)){
					br++;
					myWordTemp++;
					if(myWordTemp == MY_WORD_LENGTH)
					{
						myWordTemp = 0;
					}
				}
				else if(word[i][j] == MY_WORD.charAt(0)){
					
					br=0;
					myWordTemp=0;
					br++;
					myWordTemp++;
					if(myWordTemp == MY_WORD_LENGTH)
					{
						myWordTemp = 0;
					}
				}
				else
				{
					myWordTemp=0;
					br=0;
				}
				if(br==MY_WORD_LENGTH){
					colBrDown++;
					br=0;
					myWordTemp=0;
				}
				
				
			}
			br=0;
		}
			return colBrDown;
	}
	
	static int checkColUpward(char[][] word)
	{
		int myWordTemp=0;
		int br=0;
		int colBrUp = 0;
			for(int j=0;j<word[0].length;j++){
				for(int i=4;i>0;i--){
				if(word[i][j] == MY_WORD.charAt(myWordTemp)){
					br++;
					myWordTemp++;
					if(myWordTemp == MY_WORD_LENGTH)
					{
						myWordTemp = 0;
					}
				}
				else if(word[i][j] == MY_WORD.charAt(0)){
					br=0;
					myWordTemp=0;
					br++;
					myWordTemp++;
					if(myWordTemp == MY_WORD_LENGTH)
					{
						myWordTemp = 0;
					}
				}
				else
				{
					myWordTemp=0;
					br=0;
				}
				if(br==MY_WORD_LENGTH){
					colBrUp++;
					br=0;
					myWordTemp=0;
				}
				
			}
			br=0;
		}
			return colBrUp;		
	}
	

	static int mainDiagonalLeftToRight(char[][] word){
		
		int numOfRows=0;
		int col=0;
		int br=0;
		int myWordTemp=0;
		int diagonalBr=0;
		
		// elements under the main diagonal
		
		for(int k=0;k<word.length;k++){
			for(int row=numOfRows;row<word.length;row++){
				try{
					if(word[row][col] == MY_WORD.charAt(myWordTemp)){
						br++;
						myWordTemp++;
						if(myWordTemp == MY_WORD_LENGTH)
						{
							myWordTemp = 0;
						}

					}
					else if(word[row][col] == MY_WORD.charAt(0)){
						br=0;
						myWordTemp=0;
						br++;
						myWordTemp++;
						if(myWordTemp == MY_WORD_LENGTH)
						{
							myWordTemp = 0;
						}
					}
					else
					{
						myWordTemp=0;
						br=0;
					}
					if(br==MY_WORD_LENGTH){
						diagonalBr++;
						br=0;
						myWordTemp=0;
					}
					}
					catch(Exception e){
					}
					col++;
					
			}
			numOfRows++;
			col=0;
			br=0;
			myWordTemp=0;
		}
		
		// elements above the main diagonal
		
		col=1;
		int colsAboveDiagonal = 1;
		numOfRows=0;
		for(int k=0;k<word.length;k++)
		{
			for(int row=numOfRows;row<word.length;row++){
				try{
					if(word[row][col] == MY_WORD.charAt(myWordTemp)){
						br++;
						myWordTemp++;
						if(myWordTemp == MY_WORD_LENGTH)
						{
							myWordTemp = 0;
						}

					}
					else if(word[row][col] == MY_WORD.charAt(0)){
						br=0;
						myWordTemp=0;
						br++;
						myWordTemp++;
						if(myWordTemp == MY_WORD_LENGTH)
						{
							myWordTemp = 0;
						}
					}
					else
					{
						myWordTemp=0;
						br=0;
					}
					if(br==MY_WORD_LENGTH){
						diagonalBr++;
						br=0;
						myWordTemp=0;
					}
							}
					catch(Exception e){
					}
					col++;
					
			}
			numOfRows=0;
			col = ++colsAboveDiagonal;
			br=0;
		}
		
		return diagonalBr;
		
	}
	
	static int mainDiagonalRightToLeft(char[][] word){
		int numOfRows=word.length-1;
		int col=word[0].length-1;
		int br=0;
		int myWordTemp=0;
		int diagonalBr=0;
		
		// elements above the main diagonal
		
		for(int k=0;k<word.length;k++){
			for(int row=numOfRows;row>=0;row--){
				try{
					if(word[row][col] == MY_WORD.charAt(myWordTemp)){
						br++;
						myWordTemp++;
						if(myWordTemp == MY_WORD_LENGTH)
						{
							myWordTemp = 0;
						}

					}
					else if(word[row][col] == MY_WORD.charAt(0)){
						br=0;
						myWordTemp=0;
						br++;
						myWordTemp++;
						if(myWordTemp == MY_WORD_LENGTH)
						{
							myWordTemp = 0;
						}
					}
					else
					{
						myWordTemp=0;
						br=0;
					}
					if(br==MY_WORD_LENGTH){
						diagonalBr++;
						br=0;
						myWordTemp=0;
					}
					}
					catch(Exception e){
					}
				
					col--;
					
			}
			numOfRows--;
			col=word[0].length-1;
			br=0;
			myWordTemp=0;
		}
		
		// elements under the main diagonal
		
		int numOfCols = word[0].length-2;
		col=numOfCols;
		numOfRows=word.length-1;
		myWordTemp=0;
		
		for(int k=0;k<word.length;k++)
		{
			for(int row=numOfRows;row>=0;row--){
				try{
					if(word[row][col] == MY_WORD.charAt(myWordTemp)){
						br++;
						myWordTemp++;
						if(myWordTemp == MY_WORD_LENGTH)
						{
							myWordTemp = 0;
						}

					}
					else if(word[row][col] == MY_WORD.charAt(0)){
						br=0;
						myWordTemp=0;
						br++;
						myWordTemp++;
						if(myWordTemp == MY_WORD_LENGTH)
						{
							myWordTemp = 0;
						}
					}
					else
					{
						myWordTemp=0;
						br=0;
					}
					if(br==MY_WORD_LENGTH){
						diagonalBr++;
						br=0;
						myWordTemp=0;
					}
							}
					catch(Exception e){
					}
					col--;
					
			}
			numOfRows=word.length-1;
			col=--numOfCols;
			br=0;
		}
		
		return diagonalBr;
	}
	
	static int secondDiagonalLeftToRight(char[][] word)
	{
		int numOfRows=word.length-1;
		int col=0;
		int br=0;
		int myWordTemp=0;
		int diagonalBr=0;
		
		// elements above diagonal
		
		for(int k=0;k<word.length;k++){
			for(int row=numOfRows;row>=0;row--){
				try{
					if(word[row][col] == MY_WORD.charAt(myWordTemp)){
						br++;
						myWordTemp++;
						if(myWordTemp == MY_WORD_LENGTH)
						{
							myWordTemp = 0;
						}

					}
					else if(word[row][col] == MY_WORD.charAt(0)){
						br=0;
						myWordTemp=0;
						br++;
						myWordTemp++;
						if(myWordTemp == MY_WORD_LENGTH)
						{
							myWordTemp = 0;
						}
					}
					else
					{
						myWordTemp=0;
						br=0;
					}
					if(br==MY_WORD_LENGTH){
						diagonalBr++;
						br=0;
						myWordTemp=0;
					}
					
					}
					catch(Exception e){
					}
				
					col++;
					
			}
			numOfRows--;
			col=0;
			br=0;
			myWordTemp=0;
		}
		
		//elemetns under diagonal
		
		int numOfCols = 1;
		col=numOfCols;
		numOfRows=word.length-1;
		myWordTemp=0;
		
		for(int k=0;k<word.length;k++)
		{
			for(int row=numOfRows;row>=0;row--){
				try{
			
					if(word[row][col] == MY_WORD.charAt(myWordTemp)){
						br++;
						myWordTemp++;
						if(myWordTemp == MY_WORD_LENGTH)
						{
							myWordTemp = 0;
						}

					}
					else if(word[row][col] == MY_WORD.charAt(0)){
						br=0;
						myWordTemp=0;
						br++;
						myWordTemp++;
						if(myWordTemp == MY_WORD_LENGTH)
						{
							myWordTemp = 0;
						}
					}
					else
					{
						myWordTemp=0;
						br=0;
					}
					if(br==MY_WORD_LENGTH){
						diagonalBr++;
						br=0;
						myWordTemp=0;
					}
				
				}
					catch(Exception e){
					}
					col++;
					
			}
			numOfRows=word.length-1;
			col=++numOfCols;
			br=0;
			
		}
		
		
		return diagonalBr;
	}
	
static int secondDiagonalRightToLeft(char[][] word){
		
		int numOfRows=0;
		int col=word[0].length-1;
		int br=0;
		int myWordTemp=0;
		int diagonalBr=0;
		
		//Elements under diagonal
		
		for(int k=0;k<word.length;k++){
			for(int row=numOfRows;row<word.length;row++){
				try{
					if(word[row][col] == MY_WORD.charAt(myWordTemp)){
						br++;
						myWordTemp++;
						if(myWordTemp == MY_WORD_LENGTH)
						{
							myWordTemp = 0;
						}

					}
					else if(word[row][col] == MY_WORD.charAt(0)){
						br=0;
						myWordTemp=0;
						br++;
						myWordTemp++;
						if(myWordTemp == MY_WORD_LENGTH)
						{
							myWordTemp = 0;
						}
					}
					else
					{
						myWordTemp=0;
						br=0;
					}
					if(br==MY_WORD_LENGTH){
						diagonalBr++;
						br=0;
						myWordTemp=0;
					}
					}
					catch(Exception e){
					}
					col--;
					
			}
			numOfRows++;
			col=word[0].length-1;
			br=0;
			myWordTemp=0;
		}
			
		// Elements above diagonal
		int numOfCols = word[0].length-2;
		col=numOfCols;
		numOfRows=0;
		
		for(int k=0;k<word.length;k++)
		{
			for(int row=numOfRows;row<word.length;row++){
				try{
					if(word[row][col] == MY_WORD.charAt(myWordTemp)){
						br++;
						myWordTemp++;
						if(myWordTemp == MY_WORD_LENGTH)
						{
							myWordTemp = 0;
						}

					}
					else if(word[row][col] == MY_WORD.charAt(0)){
						br=0;
						myWordTemp=0;
						br++;
						myWordTemp++;
						if(myWordTemp == MY_WORD_LENGTH)
						{
							myWordTemp = 0;
						}
					}
					else
					{
						myWordTemp=0;
						br=0;
					}
					if(br==MY_WORD_LENGTH){
						diagonalBr++;
						br=0;
						myWordTemp=0;
					}
		
							}
					catch(Exception e){
					}
					col--;
					
			}
			br=0;
			numOfRows=0;
			col = --numOfCols;
		}
		
		return diagonalBr;
		
	}
	
	
}