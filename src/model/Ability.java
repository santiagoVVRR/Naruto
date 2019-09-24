package model;

public class Ability {

	private String name;
	private String factor;
	
	private Ability nextAbility;

	public Ability(String name, String factor) {
		
		this.name = name;
		this.factor = factor;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFactor() {
		return factor;
	}

	public void setFactor(String factor) {
		this.factor = factor;
	}

	public Ability getNextAbility() {
		return nextAbility;
	}

	public void setNextAbility(Ability nextAbility) {
		this.nextAbility = nextAbility;
	}
	
	
	
}
