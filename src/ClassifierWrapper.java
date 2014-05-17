import java.io.BufferedReader;
import java.io.FileReader;

import weka.classifiers.evaluation.*;
import weka.classifiers.trees.j48.*;
import weka.core.*;

public class ClassifierWrapper {
	
	ClassifierWrapper (){
		
	}
	
	public void analyzeData(String location){
		BufferedReader bReader = new BufferedReader(new FileReader(location));
		Instances train = new Instances(bReader);
	}
}
