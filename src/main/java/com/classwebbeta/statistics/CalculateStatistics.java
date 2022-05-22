package com.classwebbeta.statistics;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import com.classwebbeta.student.Student;
import org.apache.commons.math3.stat.descriptive.DescriptiveStatistics;

public class CalculateStatistics {

    // Calculate the Descriptive Statistics of a course
    public List<Statistics> calculateStatistics(List<Student> students){

        // New object of DescriptiveStatistics
        DescriptiveStatistics descriptiveStatistics = new DescriptiveStatistics();

        // To count how many students gave exam and how many succeed in the exam of a course
        int count = 0;
        int success = 0;

        // List with all the statistics
        List<Statistics> allStats = new ArrayList<Statistics>();

        // Check if a course has no students
        if (students.isEmpty()){
            // New constructor
            Statistics statistics = new Statistics(0, 0, 0, 0, 0, 0, 0, 0, 0, 0);

            // Add the statistics in list
            allStats.add(statistics);

            return allStats;
        }

        // For each student get final grade
        for (int i = 0; i<students.size(); i++){
            // If final grade is not empty the add value to descriptiveStatistics
            if (!students.get(i).getFinalGrade().equals("-")){
                count++;
                descriptiveStatistics.addValue(Double.parseDouble(students.get(i).getFinalGrade()));
                // If final grade >= 5 increase success value
                if (Double.parseDouble(students.get(i).getFinalGrade()) >= 5.0){
                    success++;
                }
            }
        }

        // Statistics to calculate
        double min = descriptiveStatistics.getMin();
        double max = descriptiveStatistics.getMax();
        double mean = descriptiveStatistics.getMean();
        double standardDeviation = descriptiveStatistics.getStandardDeviation();
        double variance = descriptiveStatistics.getVariance();
        double percentiles = descriptiveStatistics.getPercentile(50);
        double skewness = descriptiveStatistics.getSkewness();
        double kurtosis = descriptiveStatistics.getKurtosis();
        double median = descriptiveStatistics.getPercentile(50);
        double successD = success;
        double countD = count;
        double successRateD = (successD/countD)*100;
        // Success rate percentage
        int successRate = (int)successRateD;

        // Format numbers to 2 decimal digits
        DecimalFormat df = new DecimalFormat("#.##");
        String sd = df.format(standardDeviation).toString();
        sd = sd.replace(",", ".");
        standardDeviation = Double.parseDouble(sd);

        // New Statistics object
        Statistics statistics = new Statistics(min, max, mean, standardDeviation, variance, percentiles, skewness, kurtosis, median, successRate);

        // Add statistics in list
        allStats.add(statistics);

        return allStats;
    }
    
}
