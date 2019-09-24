package model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class Clan {

	private String name;
	
	private int sizeOfTheList;
	
	private Character first;
	
	public Clan() {
		
	}

	public Clan(String name, int sizeOfTheList) {
		
		this.name = name;
		this.sizeOfTheList = sizeOfTheList;
		this.first = first;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSizeOfTheList() {
		return sizeOfTheList;
	}

	public void setSizeOfTheList(int sizeOfTheList) {
		this.sizeOfTheList = sizeOfTheList;
	}

	public Character getFirst() {
		return first;
	}

	public void setFirst(Character first) {
		this.first = first;
	}
	
	public void sortByName() {
		
		if(first.getNextCharacter() != null && first.getName().compareTo(first.getNextCharacter().getName())>0) {
			Character tem = first;
			first = first.getNextCharacter();
			tem.setNextCharacter(first.getNextCharacter());
			first.getNextCharacter().setPrevCharacter(tem);
			first.setNextCharacter(tem);
			tem.setPrevCharacter(first);
			first.setPrevCharacter(null);
		}
		Character current = first.getNextCharacter();
		Character tem;
		
		while(current.getNextCharacter() != null) {
			while(current.getNextCharacter() != null && current.getName().compareTo(current.getNextCharacter().getName())>0) {
				tem = current.getNextCharacter();
				if(tem.getNextCharacter() != null) {
					tem.getNextCharacter().setPrevCharacter(current);
					current.setNextCharacter(tem.getNextCharacter());
				}else {
					current.setNextCharacter(null);
				}
				current.getPrevCharacter().setNextCharacter(tem);
				tem.setPrevCharacter(current.getPrevCharacter());
				current.setPrevCharacter(tem);
				tem.setNextCharacter(current);
			}
			if(current.getNextCharacter() != null && current.getName().compareTo(current.getNextCharacter().getName()) <= 0) {
				current = current.getNextCharacter();
			}
		}
			
	}
	
	public void addCharacter(String name, int power, String personality, String creationDate) {
		
		Character newCharacter = new Character(name,power,personality,creationDate);
		if(first == null) {
			first = newCharacter;
		}else {
			Character current = first;
			while(current.getNextCharacter() != null) {
				current = current.getNextCharacter();
			}
			current.setNextCharacter(newCharacter);
			current.getNextCharacter().setPrevCharacter(current);
		}
				
	}
	
	public Character searchListCharacter(String n) {
		Character match = first;
		Character current = first;
		while(current != null) {
			if(current.getName().equals(n)) {
				match = current;
			}
			current = current.getNextCharacter();
		}
		return match;
	}
	
	public int sizeOfCharacterList() {
		int s = 0;
		Character current = first;
		while(current != null) {
			s++;
			current = current.getNextCharacter();
		}
		return s;
	}
	
	public void loadCharacters(String path, String sep) throws IOException {
		File f = new File(path);
		FileReader fr = new FileReader(f.getAbsolutePath());
		BufferedReader br = new BufferedReader(fr);
		
		String line = br.readLine();
		while(line != null) {
			String[] p = line.split(sep);
			
			String n = p[0];
			int po = Integer.parseInt(p[1]);
			String per = p[2];
			String c = p[3];
			
			addCharacter(n, po, per, c);
			line = br.readLine();
		}
		br.close();
		fr.close();
	}
	
	public String CharacterInString() {
		String list = "";
		Character current = first;
		while(current != null) {
			list += current.toString();
			current = current.getNextCharacter();
		}
		return list;
	}
	
	public String generateCharacterReport() {
		Character current = first;
		String msg = "The characters are:\n";
		msg += "NAME\tPOWER\tPERSONALITY\tCREATION DATE\n";
		while(current != null) {
			msg += current.getName()+"\t"+current.getPower()+"\t"+current.getPersonality()+"\t"+current.getCreationDate()+"\n";
			current = current.getNextCharacter();
		}
		return msg;
	}
	
	public void printReport(String path) throws IOException {
		PrintWriter pw = new PrintWriter(new File(path));
		
		String rep = generateCharacterReport();
		pw.print(rep);
		
		pw.close();
	}
	
}