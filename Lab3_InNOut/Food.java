package Lab3_InNOut;

public abstract class Food {
	
	int shipDate;
	int daysToExpire;
	
	public Food(int exp){
		daysToExpire = exp;
	}
	
	public void setShipDate( int date ){
		shipDate = date;
	}
	
	public void decDays(){
		daysToExpire --;
	}
	
	public int getExp(){
		return daysToExpire;
	}

}
