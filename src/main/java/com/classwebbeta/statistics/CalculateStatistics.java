package com.classwebbeta.statistics;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import com.classwebbeta.student.Student;
import org.apache.commons.math3.stat.descriptive.DescriptiveStatistics;

public class CalculateStatistics {


    public List<Statistics> calculateStatistics(List<Student> students){

        DescriptiveStatistics stats = new DescriptiveStatistics();

        int count = 0;
        int success = 0;

        List<Statistics> allStats = new ArrayList<Statistics>();

        if (students.isEmpty()){
            Statistics statistics = new Statistics(0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
        
            allStats.add(statistics);

            return allStats;
        }

        for (int i = 0; i<students.size(); i++){
            if (!students.get(i).getFinalGrade().equals("-")){
                count++;
                stats.addValue(Double.parseDouble(students.get(i).getFinalGrade()));  
                if (Double.parseDouble(students.get(i).getFinalGrade()) >= 5.0){
                    success++;
                }
            }
        }

        double min = stats.getMin();
        double max = stats.getMax();
        double mean = stats.getMean();
        double standardDeviation = stats.getStandardDeviation();
        double variance = stats.getVariance();
        double percentiles = stats.getPercentile(50);
        double skewness = stats.getSkewness();
        double kurtosis = stats.getKurtosis();
        double median = stats.getPercentile(50);
        int successRate = (success/count)*100;

        DecimalFormat df = new DecimalFormat("#.##");
        String sd = df.format(standardDeviation).toString();
        sd = sd.replace(",", ".");
        standardDeviation = Double.parseDouble(sd);
        

        Statistics statistics = new Statistics(min, max, mean, standardDeviation, variance, percentiles, skewness, kurtosis, median, successRate);
        
        allStats.add(statistics);

        return allStats;
    }
    
}
