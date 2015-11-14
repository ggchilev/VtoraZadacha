import java.util.Scanner;

public class Demo {

	private static String MY_WORD = "";
	private static String myWord = "";
	static Scanner sc = new Scanner(System.in);
	private static int num = 0;
	private static String word2="";

	public static void main(String[] args) {
		
		System.out.println("Enter the word you want to search ");
		MY_WORD = sc.next();

		char[][] word = enterMatrix();
		System.out.println("Here is the matrix : ");
		showMatrix(word);

		int number = 0;
		number = checkRows(word) + checkCols(word) + mainDiagonal(word) +  secondDiagonalLeftToRight(word);
						
		System.out.println(MY_WORD + " occurs " + number + " times !");
	}

	static void showMatrix(char[][] word) {
		for (int row = 0; row < word.length; row++) {
			for (int col = 0; col < word[row].length; col++) {
				System.out.print(word[row][col] + " ");
			}
			System.out.println();
		}
	}

	static char[][] enterMatrix() {

		int rows = 0, cols = 0;
		while (rows <= 0 || cols <= 0){
			System.out.println("Please enter the number of rows of the matrix");
			rows = sc.nextInt();
			System.out.println("Please enter the number of cols of the matrix");
			cols = sc.nextInt();
			if (rows <= 0 || cols <= 0) {
				System.out.println("Enter positive numbers");
			}
		} while (rows <= 0 && cols <= 0);
		char[][] word = new char[rows][cols];
		System.out.println("Now fill in the matrix");
		for (int row = 0; row < rows; row++) {
			for (int col = 0; col < cols; col++) {
				System.out.println("Enter char for row N" + row + " and col N" + col);
				word[row][col] = sc.next().charAt(0);
			}
		}
		return word;
	}

	static int function(char[][] word, int number, int row, int col) {
		try {
			myWord += word[row][col];
			word2+=word[row][col];
		} catch (Exception e) {
		}
		if (myWord.contains(MY_WORD)) {
			number++;
			myWord = "";
		}
		return number;
	}
	
	static void checkReverse(){
		
		if(new StringBuilder(word2).reverse().toString().contains(MY_WORD)){
			num++;
		}
		word2="";
		myWord="";		
	}

	static int checkRows(char[][] word) {
		num=0;
		for (int row = 0; row < word.length; row++) {
			for (int col = 0; col < word[row].length; col++) {
				num = function(word, num, row, col);
			}
			checkReverse();
		}
		return num;
	}

	static int checkCols(char[][] word) {
		num = 0;
		myWord = "";
		for (int col = 0; col < word[0].length; col++) {
			for (int row = 0; row < word.length; row++) {
				num = function(word, num, row, col);
			}
			checkReverse();
		}
		return num;
	}

	static int mainDiagonal(char[][] word) {

		num = 0;
		int col = 0;
		int numOfRows = 0;

		// main diagonal and under main diagonal

		for (int k = 0; k < word.length; k++) {
			for (int row = numOfRows; row < word.length; row++) {
				num = function(word, num, row, col);
				col++;
			}
			checkReverse();
			col = 0;
			numOfRows++;
		}

		// above main diagonal

		myWord = "";
		col = 1;
		int colNum = col;

		for (int k = 0; k < word.length; k++) {
			for (int row = 0; row < word.length; row++) {
				num = function(word, num, row, col);
				col++;
			}
			checkReverse();
			col = ++colNum;
		}

		return num;
	}

	static int secondDiagonalLeftToRight(char[][] word) {
		int numOfRows = word.length - 1;
		int col = 0;
		num = 0;
		int rowsNum = numOfRows;

		// elements above diagonal

		for (int k = 0; k < word.length; k++) {
			for (int row = numOfRows; row >= 0; row--) {
				num = function(word, num, row, col);
				col++;
			}
			checkReverse();
			numOfRows = --rowsNum;
			col = 0;
		}

		// elements under diagonal

		int numOfCols = 1;
		col = numOfCols;
		numOfRows = word.length - 1;

		for (int k = 0; k < word.length; k++) {
			for (int row = numOfRows; row >= 0; row--) {
				num = function(word, num, row, col);
				col++;
			}
			checkReverse();
			col = ++numOfCols;
		}
		return num;
	}
}
