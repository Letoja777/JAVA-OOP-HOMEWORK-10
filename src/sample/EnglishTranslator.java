package sample;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;


public class EnglishTranslator {
	
	private Map <String, String> map = new HashMap<> ();
	Set <String> keys = map.keySet();
	
	public void translater (File file) throws FileNotFoundException {
		String str = "";
		
		
		//Dictionary
		for (String k : keys) {
			System.out.println(k + " => " + map.get(k));
		}
		System.out.println();
		
		//File reading
		try (Scanner sc = new Scanner(file)) {
			while (sc.hasNextLine()) {
				str += sc.nextLine() + " ";
			}
		}
		
		//Separate the words for translate
		System.out.println("����� ��� ��������: " + str);
		String[] words = str.split("\\s+");
		System.out.println();

		//Search the word in dictionary to translate
		for (String word : words) {
			if (keys.contains(word)) {
				System.out.println("������� ����� " + word + " : " +  map.get(word));
			} else {
				System.out.println("C���� " + word + " �� ������� � �����������");
			}
		}
	}
	
	public void saveTranslatedText (File file) {
		
		String separator = ";";
		
		Set<Map.Entry<String, String>> translated = map.entrySet();
		
		try (PrintWriter pw = new PrintWriter(file)) {
			for (Entry<String, String> text : translated) {
				pw.println(text + separator);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

	}
	
	public void addToDictionary (File file) throws FileNotFoundException {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("������� ����� �� ����������: ");
		String key = sc.nextLine().toLowerCase();
		
		System.out.println("������� ������� �����: ");
		String value = sc.nextLine().toLowerCase();
		
		if (!keys.contains(key)) {
			map.put(key, value);
			System.out.println(keys);
			
			try (PrintWriter pw = new PrintWriter(file)) {
				for (String k : keys) {
					pw.println(k + " => " + map.get(k));
				}
			}
			
		} else {
			System.out.println("����� ����� ��� ������������ � �������!");
			return;
		}
		
	}
	
	public Map<String, String> getMap() {
		return map;
	}

	public void setMap(Map<String, String> map) {
		this.map = map;
	}

	public EnglishIn(Map<String, String> map) {
		super();
		this.map = map;
	}

	public EnglishIn() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "EnglishIn [map=" + map + "]";
	}
	
	
}
