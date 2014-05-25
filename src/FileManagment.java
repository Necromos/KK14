import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;


public class FileManagment {
	
	public void addNewDayToDocument(String filename, String results){
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
			writer.println("@ATTRIBUTE papierosy {'true', 'false'}");
			writer.println("@ATTRIBUTE sport {'true', 'false'}");
			writer.println("@ATTRIBUTE sleeptime8h {'true', 'false'}");
			writer.println("@ATTRIBUTE regularfoodtime {'true', 'false'}");
			writer.println("@ATTRIBUTE coffe {'true', 'false'}");
			writer.println("@ATTRIBUTE drugs {'true', 'false'}");
			writer.println("@ATTRIBUTE friendmeet {'true', 'false'}");
			writer.println("@ATTRIBUTE class {'1', '2', '3', '4', '5'}");
			
			writer.println("");
			writer.println("@DATA");
			writer.println("");
			writer.close();
		}catch(IOException e){
			
		}
	}
	 
}
