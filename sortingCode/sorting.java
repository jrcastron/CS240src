package sortingCode;

public abstract class sorting {
	
	int countMoveI = 0;
	int countCompareI = 0;
	int countMoveR = 0;
	int countCompareR = 0;
	
	public int getCountMoveR(){
		return countMoveR;
	}
	
	public int getCountCompareR(){
		return countCompareR;
	}
	
	public int getCountMoveI(){
		return countMoveI;
	}
	
	public int getCountCompareI(){
		return countCompareI;
	}

}
