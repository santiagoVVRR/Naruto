package model;

public class Character implements Comparable<Character>{

	private String name;
	private int power;
	private String personality;
	private String creationDate;
	
	
	private Ability first;
	
	private Character nextCharacter;
	private Character prevCharacter;
	
	
	public Character(String name, int power, String personality, String creationDate) {
		
		this.name = name;
		this.personality = personality;
		this.creationDate = creationDate;
		this.power = power;
		this.first = first;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getPersonality() {
		return personality;
	}


	public void setPersonality(String personality) {
		this.personality = personality;
	}


	public String getCreationDate() {
		return creationDate;
	}


	public void setCreationDate(String creationDate) {
		this.creationDate = creationDate;
	}


	public int getPower() {
		return power;
	}


	public void setPower(int power) {
		this.power = power;
	}


	public Ability getFirst() {
		return first;
	}


	public void setFirst(Ability first) {
		this.first = first;
	}


	public Character getNextCharacter() {
		return nextCharacter;
	}


	public void setNextCharacter(Character nextCharacter) {
		this.nextCharacter = nextCharacter;
	}


	public Character getPrevCharacter() {
		return prevCharacter;
	}


	public void setPrevCharacter(Character prevCharacter) {
		this.prevCharacter = prevCharacter;
	}


	@Override
	public int compareTo(Character c) {
		int comp;
		if(name.compareTo(c.name)<0) {
			comp = -1;
		}else if(name.compareTo(c.name)>0) {
			comp = 1;
		}else {
			comp = 0;
		}
		return comp;
	}


	@Override
	public String toString() {
		return "Character [name=" + name + ", power=" + power + ", personality=" + personality + ", creationDate="
				+ creationDate + "]";
	}

	
	
	
	
	
}
