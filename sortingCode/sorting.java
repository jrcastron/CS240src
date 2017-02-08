package sortingCode;

public abstract class sorting {
	
	int countMoveI;
	int countCompareI;
	int countMoveR;
	int countCompareR;
	
	public sorting(){
		countMoveI = 0;
		countCompareI = 0;
		countMoveR = 0;
		countCompareR = 0;
	}
	
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
