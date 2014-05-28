import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import weka.classifiers.Classifier;
import weka.classifiers.Evaluation;
import weka.classifiers.evaluation.NominalPrediction;
import weka.classifiers.rules.DecisionTable;
import weka.classifiers.rules.PART;
import weka.classifiers.trees.DecisionStump;
import weka.classifiers.trees.J48;
import weka.core.FastVector;
import weka.core.Instances;

public class ClassifierWrapper {
	
	ClassifierWrapper() {}
	
	public static BufferedReader readDataFile(String filename) {
		BufferedReader inputReader = null;
 
		try {
			inputReader = new BufferedReader(new FileReader(filename));
		} catch (FileNotFoundException ex) {
			System.err.println("File not found: " + filename);
		}
 
		return inputReader;
	}
 
	public static Evaluation classify(Classifier model,
			Instances trainingSet, Instances testingSet) throws Exception {
		Evaluation evaluation = new Evaluation(trainingSet);
 
		model.buildClassifier(trainingSet);
		evaluation.evaluateModel(model, testingSet);
 
		return evaluation;
	}
 
	public static double calculateAccuracy(FastVector predictions) {
		double correct = 0;
 
		for (int i = 0; i < predictions.size(); i++) {
			System.out.println(predictions.elementAt(i));
			NominalPrediction np = (NominalPrediction) predictions.elementAt(i);
			System.out.println(np.predicted() + " " + np.actual());
			if (np.predicted() == np.actual()) {
				correct++;
			}
		}
 
		return 100 * correct / predictions.size();
	}
 
	public static Instances[][] crossValidationSplit(Instances data, int numberOfFolds) {
		Instances[][] split = new Instances[2][numberOfFolds];
 
		for (int i = 0; i < numberOfFolds; i++) {
			split[0][i] = data.trainCV(numberOfFolds, i);
			split[1][i] = data.testCV(numberOfFolds, i);
		}
 
		return split;
	}
 
	public double start(String filename) throws Exception {
		BufferedReader datafile = readDataFile(filename+".arff");
		
		Instances data = new Instances(datafile);
		data.setClassIndex(data.numAttributes() - 1);
		BufferedReader testFile = readDataFile("test.arff");
		Instances test = new Instances(testFile);
		test.setClassIndex(test.numAttributes() - 1);

		Classifier[] models = { 
				new J48(),
				new PART(), 
				new DecisionTable(),
				new DecisionStump()
		};

		double sum = 0.0;
		for (int j = 0; j < models.length; j++) {
			FastVector predictions = new FastVector();
 
			Evaluation validation = classify(models[j], data, test);
			predictions.appendElements(validation.predictions());
 
			NominalPrediction np = (NominalPrediction) predictions.elementAt(0);
			sum += np.predicted()+1;
		}
		return sum/4;
 
	}
}
