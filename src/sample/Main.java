package sample;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EnglishTranslator eng = new EnglishTranslator();
		
		eng.getMap().put("dictionary", "Словник");
		eng.getMap().put("java", "Джава");
		eng.getMap().put("glory", "Слава");
		eng.getMap().put("putin", "Хуйло");
		eng.getMap().put("translate", "Переклад");
		
		File file_in = new File("english_in.txt");
		try {
			eng.translater(file_in);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println();
		
		File file_out = new File("ukrainian_out.txt");
		
		try {
			eng.saveTranslatedText(file_out);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		File file_dict = new File("save_dictionary.txt");
		try {
			eng.addToDictionary(file_dict);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
