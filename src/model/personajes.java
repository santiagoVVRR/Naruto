package model;

public enum personajes {

	NARUTO("naruto", 899),
	NARUTO_SENNIN("naruto sennin", 1200),
	NARUTO_KYUBI_MODE("naruto kyubi mode", 3000),
	NARUTO_SABIO_6_CAMINOS("naruto sabio de los seis caminos", 4200),
	NARUTO_SABIO_6_CAMINOS_KURAMA("naruto sabio de los seis caminos fusionado con kurama", 14500),
	SASUKE("sasuke", 900),
	SASUKE_SUSANO("sasuke susano", 1900),
	SASUKE_SHARINGAN_ETERNO("sasuke sharingan eterno", 2300),
	KAKACHI("kakachi", 1400),
	YIRAIYA("yiraiya", 3000),
	
	private String name;
	private int power;
	
	private personajes(String name, int power) {
		this.name = name;
		this.power = power;
	}
	
	private int getValues() {
		return personajes.values().length;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPower() {
		return power;
	}

	public void setPower(int power) {
		this.power = power;
	}
	
	
	
	
}
