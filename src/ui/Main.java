package ui;

import java.io.IOException;
import java.util.Scanner;

import model.Clan;

public class Main {

	private Clan c;
	private Scanner input;
	
	public Main() {
		c = new Clan();
		input = new Scanner(System.in);
	}
	
	public static void main(String[] args) throws IOException {
		Main m = new Main();
		m.menu();
	}
	
	public void menu() throws IOException {
		System.out.println("\n-------------------------------------------------------------------------- \n");
		System.out.println("\n<--------------------------------->MENU<---------------------------------> \n");
		System.out.println("\n-------------------------------------------------------------------------- \n");
		System.out.println("1- Sort by Character name");
		System.out.println("2- add character");
		System.out.println("3- search character");
		System.out.println("4- EXIT");
		System.out.println("\n-------------------------------------------------------------------------- \n");
		
		int op = input.nextInt();
		input.nextLine();
		
		if(op == 1) {
			op1();
		}else if(op == 2) {
			op2();
		}else if(op == 3) {
			op3();
		}else if(op == 4) {
			System.out.println("\n--------------------------------------------------------------------------- ");
			System.out.println("<----------------------THANKS----------------------->");
			System.out.println("--------------------------------------------------------------------------- ");
			System.exit(0);
		}
		
	}
	
	public void op1() throws IOException {
		c.loadCharacters("data/characters.txt", ",");
		c.sortByName();
		System.out.println(c.generateCharacterReport());
		 toContinue();
	}
	
	public void op2() throws IOException {
		System.out.println("Please type the name of the character");
		String name = input.nextLine();
		System.out.println("Please type the power");
		int power = input.nextInt();
		input.nextLine();
		System.out.println("Please type the personality");
		String pt = input.nextLine();
		System.out.println("Please type creation date (just the month) example : septiembre");
		String date = input.nextLine();
		
		c.addCharacter(name, power, pt, date);
		
		 toContinue();
	}
	
	public void op3() throws IOException {
		System.out.println("You can only search by name");
		System.out.println("please enter the name of the character you are looking for");
		String name = input.nextLine();
		model.Character ca = c.searchListCharacter(name);
		if(ca != null) {
			System.out.println(ca.toString());
		}else {
			System.out.println("the value does not exist");
		}
		
		 toContinue();
	}
	
	public void toContinue() throws IOException {
		System.out.println("\n--------------------------------------------------------------------------- ");
		System.out.println("1. MENU \n 2. EXIT");
		
		int what = input.nextInt();
		input.nextLine();
			if(what == 1){
				menu();
			}else{
				System.out.println("\n--------------------------------------------------------------------------- ");
				System.out.println("<----------------------THANKS----------------------->");
				System.out.println("--------------------------------------------------------------------------- ");
				System.exit(0);
				
			}
	}

}
