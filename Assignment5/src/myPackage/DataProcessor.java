package myPackage;

public class DataProcessor {

	
	public WinningResult computeMeanAndSD(double[] numbers){
		WinningResult bean = new WinningResult();
		
    	double mean;
    	double total=0.0;
    	for (int i=0; i<numbers.length; i++){
    		total = total + numbers[i];
    	}
    	mean = total/numbers.length;
    	
    	double sd = 0;
    	for (int i = 0; i < numbers.length; i++)
    	{
    	    sd += ((numbers[i] - mean)*(numbers[i] - mean)) / numbers.length;
    	}
    	double standardDeviation = Math.sqrt(sd);
    	
    	bean.mean = mean;
    	bean.sd = standardDeviation;
    	return bean;
    }


}
