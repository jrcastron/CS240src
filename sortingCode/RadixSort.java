package sortingCode;

public class RadixSort extends sorting{
	
	public int[] iterativeSort(int[] Array){
		int[][] b = new int[10][Array.length];
		b = Bucket(Array, b, 10, 1);
		Array = MoveNums(Array, b);
		for(int i = 0; i < 10; i++){
			for(int j = 0; j < 10; j++){
				b[i][j] = 0;
			}
		}
		b = Bucket(Array, b, 100, 10);
		Array = MoveNums(Array, b);		
		for(int i = 0; i < 10; i++){
			for(int j = 0; j < 10; j++){
				b[i][j] = 0;
			}
		}
		b = Bucket(Array, b, 1000, 100);
		Array = MoveNums(Array, b);
		for(int i = 0; i < 10; i++){
			for(int j = 0; j < 10; j++){
				b[i][j] = 0;
			}
		}
		return Array;
	}
	
	public int[] recursiveSort(int[] Array, int num){
		if(num==10000){
			return Array;
		}
		int[][] b = new int[10][Array.length];
		for(int i = 0; i < 10; i++){
			for(int j = 0; j < 10; j++){
				b[i][j] = 0;
			}
		}
		b = Bucket(Array, b, num*10, num);
		Array = MoveNums(Array, b);
		Array = recursiveSort(Array, num*10);
		return Array;
	}

	
	public int[][] Bucket(int[] Array, int[][] b, int mod, int div){
		for(int i = 0; i < Array.length; i++){
			countMoveI++;
			countMoveR++;
			countCompareI++;
			countCompareR++;
			switch((Array[i]%mod)/div){
			case 0: {b[0][i] = Array[i];
			break;
			}
			case 1:{ b[1][i] = Array[i];
			break;
			}
			case 2: {b[2][i] = Array[i];
			break;
			}
			case 3:{ b[3][i] = Array[i];
			break;
			}
			case 4: {b[4][i] = Array[i];
			break;
			}
			case 5:{ b[5][i] = Array[i];
			break;
			}
			case 6: {b[6][i] = Array[i];
			break;
			}
			case 7:{ b[7][i] = Array[i];
			break;
			}
			case 8:{ b[8][i] = Array[i];
			break;
			}
			case 9: {b[9][i] = Array[i];
			break;
			}
			default: b[0][i] = Array[i];
			}
		}
		return b;
	}
	
	public int[] MoveNums(int[] Array, int[][] b){
		int i = 0;
		int k = 0;
		while((i < 10)&&(k<10)){
			for(int j = 0; j < Array.length; j++){
				if(i<10){
				if(b[k][j] != 0){
					Array[i] = b[k][j];
					i++;
					countMoveI++;
					countMoveR++;
				}
				}
			}
			k++;
		}
		return Array;
	}
	

}
