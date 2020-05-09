/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conditional_probability;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Benson
 */
public class Conditional_Probability {

    static void getProbability() throws FileNotFoundException {

        ArrayList<String> results = new ArrayList<>();
        ArrayList<String> test_result = new ArrayList<>();
        ArrayList<String> has_cancer = new ArrayList<>();
        int falseNegative = 0;
        int falsePositive = 0;
        int trueNegative = 0;
        int truePositive = 0;
        int total = 0;

        String line;

        //location of the text file
        BufferedReader reader = new BufferedReader(new FileReader("D:\\Documents\\NetBeansProjects\\Conditional_Probability\\src\\conditional_probability\\cancer_test_data.txt"));

        //reads the text file
        try {
            while ((line = reader.readLine()) != null) {
                total++; // will just count the total number of all the patients.

                //splits the data with comma and store in an array.
                String[] temp = line.split(",");
                for (String get : temp) {
                    results.add(get);
                }

            }

        } catch (IOException ex) {
            System.out.println("File not found");
        }

        //store again in 2 different array to separte the test result and has cancer
        for (int x = 0; x < results.size(); x++) {
            if (x % 2 == 0) {
                test_result.add(results.get(x));
            } else {
                has_cancer.add(results.get(x));
            }
        }

        //get the count of the result
        for (int x = 0; x < test_result.size(); x++) {
            if (test_result.get(x).equals("Negative") && has_cancer.get(x).equals("False")) {
                falseNegative++;
            } else if (test_result.get(x).equals("Positive") && has_cancer.get(x).equals("False")) {
                falsePositive++;
            } else if (test_result.get(x).equals("Negative") && has_cancer.get(x).equals("True")) {
                trueNegative++;
            } else if (test_result.get(x).equals("Positive") && has_cancer.get(x).equals("True")) {
                truePositive++;
            }
        }
        
        System.out.println("Submitted by: Arias, Ronald Benson U.");
        System.out.println("");

        //print the number of results
        System.out.println(" __________________________________________ ");
        System.out.println("| has_cancer | test_result | patient_count |");
        System.out.println("|__________________________________________|");
        System.out.println("|    False   |   Negative  |       " + falseNegative + "      |");
        System.out.println("|    False   |   Positive  |       " + falsePositive + "      |");
        System.out.println("|    True    |   Negative  |       " + trueNegative + "      |");
        System.out.println("|    True    |   Positive  |       " + truePositive + "      |");
        System.out.println("|__________________________________________|");

        System.out.println("");

        //calculate the probability
        double probOfTruePositive = (((double) truePositive / total) * 100);
        double probOfFalsePositive = (((double) falsePositive / total) * 100);
        double probOfTrueNegative = (((double) trueNegative / total) * 100);
        double probOfFalseNegative = (((double) falseNegative / total) * 100);

        //print the result of probability
        System.out.println("P(patients tested‘POSITIVE’| has cancer) =  " + String.format("%.0f%%", probOfTruePositive));
        System.out.println("P(patients tested ‘POSITIVE’| does not have cancer) = " + String.format("%.0f%%", probOfFalsePositive));
        System.out.println("P(patients tested ‘NEGATIVE’| has cancer) = " + String.format("%.0f%%", probOfTrueNegative));
        System.out.println("P(patients tested ‘NEGATIVE’| does not have cancer) = " + String.format("%.0f%%", probOfFalseNegative));

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException {
        getProbability();
    }

}
