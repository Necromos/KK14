import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;


public class FileManagment {
	
	FileManagment () {}
	
	public void addNewDayToDocument(String filename, String results){
		File f = new File(filename+".arff");
		if (filename == "test" || !f.exists() && !f.isDirectory()){
			createNewDataDocument(filename);
		}
		if (filename == "test")
			results += ",1";
		try {
			PrintWriter writer = new PrintWriter(new FileWriter(filename+".arff", true));
			writer.println(results);
			writer.close();
		}catch(IOException e){
			
		}
	}
	
	public void createNewDataDocument(String filename){
		try {
			PrintWriter writer = new PrintWriter(filename+".arff","UTF-8");
			writer.println("@RELATION dayfeel");
			writer.println("");
			writer.println("@ATTRIBUTE sleeptime8h {true, false}");
			writer.println("@ATTRIBUTE regularfoodtime {true, false}");
			writer.println("@ATTRIBUTE funfriends {true, false}");
			writer.println("@ATTRIBUTE alkohol {true, false}");
			writer.println("@ATTRIBUTE cigarets {true, false}");
			writer.println("@ATTRIBUTE sweets {true, false}");
			writer.println("@ATTRIBUTE playcomputer {true, false}");
			writer.println("@ATTRIBUTE playoutside {true, false}");
			writer.println("@ATTRIBUTE class {1, 2, 3, 4, 5}");
			
			writer.println("");
			writer.println("@DATA");
			writer.println("");
			writer.close();
		}catch(IOException e){
			
		}
	}
	 
}
