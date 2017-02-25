package Lab3_InNOut;
import java.util.Random;

import List.ListVector;
import Stack.LinkedDataStack;
import Queue.ArrayQueue;
import sortingCode.QuickSort;

public class main {
	
	private static ListVector<Food> One = new ListVector<Food>();
	private static ListVector<Food> Two = new ListVector<Food>();
	private static ListVector<Food> Three = new ListVector<Food>();
	private static ListVector<Food> Four = new ListVector<Food>();
	private static ListVector<Food> Five = new ListVector<Food>();
	private static ListVector<Food> Six = new ListVector<Food>();
	private static LinkedDataStack<Bun> Bun = new LinkedDataStack<Bun>();
	private static LinkedDataStack<Patty> Patty = new LinkedDataStack<Patty>();
	private static LinkedDataStack<Lettuce> Lettuce = new LinkedDataStack<Lettuce>();
	private static LinkedDataStack<Tomato> Tomato = new LinkedDataStack<Tomato>();
	private static LinkedDataStack<Onion> Onion = new LinkedDataStack<Onion>();
	private static LinkedDataStack<Cheese> Cheese = new LinkedDataStack<Cheese>();
	private static ArrayQueue<Integer> customers = new ArrayQueue<Integer>(50);
	private static QuickSort qs = new QuickSort();
	
	private static Bun bun = new Bun();
	private static Patty patty = new Patty();
	private static Lettuce lettuce = new Lettuce();
	private static Tomato tomato = new Tomato();
	private static Onion onion = new Onion();
	private static Cheese cheese = new Cheese();
	
	private static Random r = new Random();
	
	private static int wasteBun;
	private static int wastePatty;
	private static int wasteLettuce;
	private static int wasteTomato;
	private static int wasteOnion;
	private static int wasteCheese;
	private static int countOne;
	private static int countTwo;
	private static int countThree;
	private static int countFour;
	private static int countFive;
	private static int countSix;
	
	public static void main(String args[]){
		setMenu();
		int date = 301;
		int lostCustomers = 0;
		wasteBun = 0;
		wastePatty = 0;
		wasteLettuce = 0;
		wasteTomato = 0;
		wasteOnion = 0;
		wasteCheese = 0;
		countOne = 0;
		countTwo = 0;
		countThree = 0;
		countFour = 0;
		countFive = 0;
		countSix = 0;
		shipment(date);
		for(int i = 0; i < 31; i++){
			if(date%3 == 0){
				shipment(date);
			}
			lostCustomers += getCustomers();
			lostCustomers += Order();
			lostCustomers += getCustomers();
			lostCustomers += Order();
			lostCustomers += getCustomers();
			lostCustomers += Order();
			lostCustomers += getCustomers();
			lostCustomers += Order();
			lostCustomers += getCustomers();
			lostCustomers += Order();
			lostCustomers += getCustomers();
			lostCustomers += Order();
			lostCustomers += getCustomers();
			lostCustomers += Order();
			lostCustomers += getCustomers();
			lostCustomers += Order();
			lostCustomers += getCustomers();
			lostCustomers += Order();
			lostCustomers += getCustomers();
			lostCustomers += Order();
			decExp();
			
			System.out.println("=============Day " + date + "=============");
			System.out.println("\nLost customers: " + lostCustomers);
			System.out.println("wasted buns: " + wasteBun + "\n\tpattys: " + wastePatty + "\n\tlettuce: " + wasteLettuce
					 + "\n\ttomato: " + wasteTomato + "\n\tonion: " + wasteOnion + "\n\tcheese: " + wasteCheese);
			System.out.println("number one's ordered: " + countOne + "\nnumber two's ordered " + countTwo + "\nnumber three's ordered: " + countThree 
					+ "\nnumber four's ordered: " + countFour + "\nnumber five's ordered: " + countFive + "\nnumber six's ordered: " + countSix);
			
			date++;
			wasteBun = 0;
			wastePatty = 0;
			wasteLettuce = 0;
			wasteTomato = 0;
			wasteOnion = 0;
			wasteCheese = 0;
			countOne = 0;
			countTwo = 0;
			countThree = 0;
			countFour = 0;
			countFive = 0;
			countSix = 0;
			lostCustomers = 0;
		}
	}
	
	public static void setMenu(){
		One.Add(bun);
		One.Add(patty);
		One.Add(lettuce);
		One.Add(tomato);
		One.Add(onion);
		
		Two.Add(bun);
		Two.Add(patty);
		Two.Add(lettuce);
		Two.Add(tomato);
		Two.Add(onion);
		Two.Add(cheese);
		
		Three.Add(lettuce);
		Three.Add(lettuce);
		Three.Add(onion);
		Three.Add(tomato);
		
		Four.Add(bun);
		Four.Add(patty);
		Four.Add(lettuce);
		Four.Add(tomato);
		
		Five.Add(bun);
		Five.Add(patty);
		Five.Add(lettuce);
		Five.Add(tomato);
		Five.Add(cheese);
		
		Six.Add(bun);
		Six.Add(patty);
		Six.Add(lettuce);
		Six.Add(onion);
	}
	
	public static void shipment(int date){
		
		for(int j = 0; j < r.nextInt(301) + 700; j++){
			Bun temp = new Bun();
			temp.setShipDate(date);
			Bun.push(temp);
		}
		for(int j = 0; j < r.nextInt(301) + 700; j++){
			Patty temp = new Patty();
			temp.setShipDate(date);
			Patty.push(temp);
		}
		for(int j = 0; j < r.nextInt(301) + 700; j++){
			Lettuce temp = new Lettuce();
			temp.setShipDate(date);
			Lettuce.push(temp);
		}
		for(int j = 0; j < r.nextInt(301) + 700; j++){
			Tomato temp = new Tomato();
			temp.setShipDate(date);
			Tomato.push(temp);
		}
		for(int j = 0; j < r.nextInt(301) + 700; j++){
			Onion temp = new Onion();
			temp.setShipDate(date);
			Onion.push(temp);
		}
		for(int j = 0; j < r.nextInt(301) + 700; j++){
			Cheese temp = new Cheese();
			temp.setShipDate(date);
			Cheese.push(temp);
		}
		
		int lengthB = Bun.getLength();
		Food[] tempB = new Bun[lengthB];
		for(int x = 0; x < lengthB; x++){
			tempB[x] = Bun.pop();
		}
		tempB = qs.FoodSort(tempB, 0, lengthB-1);
		for(int y = 0; y < lengthB; y++){
			Bun.push((Lab3_InNOut.Bun) tempB[y]);
		}
		int lengthP = Patty.getLength();
		Food[] tempP = new Patty[lengthP];
		for(int x = 0; x < lengthP; x++){
			tempP[x] = Patty.pop();
		}
		tempP = qs.FoodSort(tempP, 0, lengthP-1);
		for(int y = 0; y < lengthP; y++){
			Patty.push((Lab3_InNOut.Patty) tempP[y]);
		}
		int lengthL = Lettuce.getLength();
		Food[] tempL = new Lettuce[lengthL];
		for(int x = 0; x < lengthL; x++){
			tempL[x] = Lettuce.pop();
		}
		tempL = qs.FoodSort(tempL, 0, lengthL-1);
		for(int y = 0; y < lengthL; y++){
			Lettuce.push((Lab3_InNOut.Lettuce) tempL[y]);
		}
		int lengthT = Tomato.getLength();
		Food[] tempT = new Tomato[lengthT];
		for(int x = 0; x < lengthT; x++){
			tempT[x] = Tomato.pop();
		}
		tempT = qs.FoodSort(tempT, 0, lengthT-1);
		for(int y = 0; y < lengthT; y++){
			Tomato.push((Lab3_InNOut.Tomato) tempT[y]);
		}
		int lengthO = Onion.getLength();
		Food[] tempO = new Onion[lengthO];
		for(int x = 0; x < lengthO; x++){
			tempO[x] = Onion.pop();
		}
		tempO = qs.FoodSort(tempO, 0, lengthO-1);
		for(int y = 0; y < lengthO; y++){
			Onion.push((Lab3_InNOut.Onion) tempO[y]);
		}
		int lengthC = Cheese.getLength();
		Food[] tempC = new Cheese[lengthC];
		for(int x = 0; x < lengthC; x++){
			tempC[x] = Cheese.pop();
		}
		tempC = qs.FoodSort(tempC, 0, lengthC-1);
		for(int y = 0; y < lengthC; y++){
			Cheese.push((Lab3_InNOut.Cheese) tempC[y]);
		}
	}
	
	public static int getCustomers(){
		int numCustomers = r.nextInt(100) +1;
		int lost = 0;
		if(numCustomers > 50){
			lost = numCustomers - 50;
			for(int j = 0; j < 50; j++){
				customers.enqueue(r.nextInt(6) + 1);
			}
		}
		else{
			for(int j = 0; j < numCustomers; j++){
				customers.enqueue(r.nextInt(6) + 1);
			}
		}
		return lost;
	}
	
	public static void decExp(){
		
		int BL = Bun.getLength();
		int PL = Patty.getLength();
		int LL = Lettuce.getLength();
		int TL = Tomato.getLength();
		int OL = Onion.getLength();
		int CL = Cheese.getLength();
		
		Bun[] tempB = new Bun[BL];
		Patty[] tempP = new Patty[PL];
		Lettuce[] tempL = new Lettuce[LL];
		Tomato[] tempT = new Tomato[TL];
		Onion[] tempO = new Onion[OL];
		Cheese[] tempC = new Cheese[CL];
		
		for(int i = 0; i < BL; i++){
			tempB[i] = Bun.pop();
			if(tempB[i].getExp() == 0){
				tempB[i] = null;
				wasteBun++;
			}
			else{
				tempB[i].decDays();
			}
		}
		for(int j = 0; j < tempB.length; j++){
			if(tempB[j]!=null){
				Bun.push(tempB[j]);
			}
		}
		for(int i = 0; i < PL; i++){
			tempP[i] = Patty.pop();
			if(tempP[i].getExp() == 0){
				tempP[i] = null;
				wastePatty++;
			}
			else{
				tempP[i].decDays();
			}
		}
		for(int j = 0; j < tempP.length; j++){
			if(tempP[j]!=null){
				Patty.push(tempP[j]);
			}
		}
		for(int i = 0; i < LL; i++){
			tempL[i] = Lettuce.pop();
			if(tempL[i].getExp() == 0){
				tempL[i] = null;
				wasteLettuce++;
			}
			else{
				tempL[i].decDays();
			}
		}
		for(int j = 0; j < tempL.length; j++){
			if(tempL[j]!=null){
				Lettuce.push(tempL[j]);
			}
		}
		for(int i = 0; i < TL; i++){
			tempT[i] = Tomato.pop();
			if(tempT[i].getExp() == 0){
				tempT[i] = null;
				wasteTomato++;
			}
			else{
				tempT[i].decDays();
			}
		}
		for(int j = 0; j < tempT.length; j++){
			if(tempT[j]!=null){
				Tomato.push(tempT[j]);
			}
		}
		for(int i = 0; i < OL; i++){
			tempO[i] = Onion.pop();
			if(tempO[i].getExp() == 0){
				tempO[i] = null;
				wasteOnion++;
			}
			else{
				tempO[i].decDays();
			}
		}
		for(int j = 0; j < tempO.length; j++){
			if(tempO[j]!=null){
				Onion.push(tempO[j]);
			}
		}
		for(int i = 0; i < CL; i++){
			tempC[i] = Cheese.pop();
			if(tempC[i].getExp() == 0){
				tempC[i] = null;
				wasteCheese++;
			}
			else{
				tempC[i].decDays();
			}
		}
		for(int j = 0; j < tempC.length; j++){
			if(tempC[j]!=null){
				Cheese.push(tempC[j]);
			}
		}
	}
	
	public static int Order(){
		int lost = 0;
		int order;
		int length = customers.getLength();
		for(int i = 0; i < length; i++){
			order = customers.dequeue();
			switch(order){
			case 1:{
				for(int j = 0; j < One.CountEntries(); j++){
					if(One.getItem(j)==bun){
						if(!Bun.isEmpty()){
							Bun.pop();
						}
						else{
							lost++;
							break;
						}
					}
					else if(One.getItem(j)==patty){
						if(!Patty.isEmpty()){
							Patty.pop();
						}
						else{
							lost++;
							break;
						}
					}
					else if(One.getItem(j)==lettuce){
						if(!Lettuce.isEmpty()){
							Lettuce.pop();
						}
						else{
							lost++;
							break;
						}
					}
					else if(One.getItem(j)==tomato){
						if(!Tomato.isEmpty()){
							Tomato.pop();
						}
						else{
							lost++;
							break;
						}
					}
					else if(One.getItem(j)==onion){
						if(!Onion.isEmpty()){
							Onion.pop();
						}
						else{
							lost++;
							break;
						}
					}
					else if(One.getItem(j)==cheese){
						if(!Cheese.isEmpty()){
							Cheese.pop();
						}
						else{
							lost++;
							break;
						}
					}
				}
				countOne++;
				break;
			}
			case 2:{
				for(int j = 0; j < Two.CountEntries(); j++){
					if(Two.getItem(j)==bun){
						if(!Bun.isEmpty()){
							Bun.pop();
						}
						else{
							lost++;
							break;
						}
					}
					else if(Two.getItem(j)==patty){
						if(!Patty.isEmpty()){
							Patty.pop();
						}
						else{
							lost++;
							break;
						}
					}
					else if(Two.getItem(j)==lettuce){
						if(!Lettuce.isEmpty()){
							Lettuce.pop();
						}
						else{
							lost++;
							break;
						}
					}
					else if(Two.getItem(j)==tomato){
						if(!Tomato.isEmpty()){
							Tomato.pop();
						}
						else{
							lost++;
							break;
						}
					}
					else if(Two.getItem(j)==onion){
						if(!Onion.isEmpty()){
							Onion.pop();
						}
						else{
							lost++;
							break;
						}
					}
					else if(Two.getItem(j)==cheese){
						if(!Cheese.isEmpty()){
							Cheese.pop();
						}
						else{
							lost++;
							break;
						}
					}
				}
				countTwo++;
				break;
			}
			case 3:{
				for(int j = 0; j < Three.CountEntries(); j++){
					if(Three.getItem(j)==bun){
						if(!Bun.isEmpty()){
							Bun.pop();
						}
						else{
							lost++;
							break;
						}
					}
					else if(Three.getItem(j)==patty){
						if(!Patty.isEmpty()){
							Patty.pop();
						}
						else{
							lost++;
							break;
						}
					}
					else if(Three.getItem(j)==lettuce){
						if(!Lettuce.isEmpty()){
							Lettuce.pop();
						}
						else{
							lost++;
							break;
						}
					}
					else if(Three.getItem(j)==tomato){
						if(!Tomato.isEmpty()){
							Tomato.pop();
						}
						else{
							lost++;
							break;
						}
					}
					else if(Three.getItem(j)==onion){
						if(!Onion.isEmpty()){
							Onion.pop();
						}
						else{
							lost++;
							break;
						}
					}
					else if(Three.getItem(j)==cheese){
						if(!Cheese.isEmpty()){
							Cheese.pop();
						}
						else{
							lost++;
							break;
						}
					}
				}
				countThree++;
				break;
			}
			case 4:{
				for(int j = 0; j < Four.CountEntries(); j++){
					if(Four.getItem(j)==bun){
						if(!Bun.isEmpty()){
							Bun.pop();
						}
						else{
							lost++;
							break;
						}
					}
					else if(Four.getItem(j)==patty){
						if(!Patty.isEmpty()){
							Patty.pop();
						}
						else{
							lost++;
							break;
						}
					}
					else if(Four.getItem(j)==lettuce){
						if(!Lettuce.isEmpty()){
							Lettuce.pop();
						}
						else{
							lost++;
							break;
						}
					}
					else if(Four.getItem(j)==tomato){
						if(!Tomato.isEmpty()){
							Tomato.pop();
						}
						else{
							lost++;
							break;
						}
					}
					else if(Four.getItem(j)==onion){
						if(!Onion.isEmpty()){
							Onion.pop();
						}
						else{
							lost++;
							break;
						}
					}
					else if(Four.getItem(j)==cheese){
						if(!Cheese.isEmpty()){
							Cheese.pop();
						}
						else{
							lost++;
							break;
						}
					}
				}
				countFour++;
				break;
			}
			case 5:{
				for(int j = 0; j < Five.CountEntries(); j++){
					if(Five.getItem(j)==bun){
						if(!Bun.isEmpty()){
							Bun.pop();
						}
						else{
							lost++;
							break;
						}
					}
					else if(Five.getItem(j)==patty){
						if(!Patty.isEmpty()){
							Patty.pop();
						}
						else{
							lost++;
							break;
						}
					}
					else if(Five.getItem(j)==lettuce){
						if(!Lettuce.isEmpty()){
							Lettuce.pop();
						}
						else{
							lost++;
							break;
						}
					}
					else if(Five.getItem(j)==tomato){
						if(!Tomato.isEmpty()){
							Tomato.pop();
						}
						else{
							lost++;
							break;
						}
					}
					else if(Five.getItem(j)==onion){
						if(!Onion.isEmpty()){
							Onion.pop();
						}
						else{
							lost++;
							break;
						}
					}
					else if(Five.getItem(j)==cheese){
						if(!Cheese.isEmpty()){
							Cheese.pop();
						}
						else{
							lost++;
							break;
						}
					}
				}
				countFive++;
				break;
			}
			case 6:{
				for(int j = 0; j < Six.CountEntries(); j++){
					if(Six.getItem(j)==bun){
						if(!Bun.isEmpty()){
							Bun.pop();
						}
						else{
							lost++;
							break;
						}
					}
					else if(Six.getItem(j)==patty){
						if(!Patty.isEmpty()){
							Patty.pop();
						}
						else{
							lost++;
							break;
						}
					}
					else if(Six.getItem(j)==lettuce){
						if(!Lettuce.isEmpty()){
							Lettuce.pop();
						}
						else{
							lost++;
							break;
						}
					}
					else if(Six.getItem(j)==tomato){
						if(!Tomato.isEmpty()){
							Tomato.pop();
						}
						else{
							lost++;
							break;
						}
					}
					else if(Six.getItem(j)==onion){
						if(!Onion.isEmpty()){
							Onion.pop();
						}
						else{
							lost++;
							break;
						}
					}
					else if(Six.getItem(j)==cheese){
						if(!Cheese.isEmpty()){
							Cheese.pop();
						}
						else{
							lost++;
							break;
						}
					}
				}
				countSix++;
				break;
			}
			default:{
				lost++;
				break;
			}
			}
		}
		
		return lost;
	}
	
}
