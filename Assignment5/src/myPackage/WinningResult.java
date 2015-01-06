package myPackage;

public class WinningResult {
	
    double mean;
    double sd;
    
    public WinningResult() {
        mean = 0.0;
        sd = 0.0;	
    }
    
    public double getMean(){
    	return mean;
    }
    
    public void setMean(double m){
    	this.mean = m;
    }
    
    public double getSd(){
    	return sd;
    }
    
    public void setSd(double s){
    	this.sd = s;
    } 
  
}
