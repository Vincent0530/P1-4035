package experimentalClasses;

import java.util.ArrayList;
import java.util.Map;

import interfaces.IntersectionFinder;
//sdfsdf
public class StrategiesTimeCollection<E> 
extends ArrayList<Map.Entry<Integer, Float>> { 
    private IntersectionFinder<Integer> strategy;    // the strategy
    private float sum;   
    // variable to accumulate the sum of times that different
    // executions for the same time take. It is eventually used
    // to determine the average execution time for a particular 
    // size.....
    
    public StrategiesTimeCollection(IntersectionFinder<Integer> strategy) { 
        this.strategy = strategy; 
    } 
    
    public String getStrategyName() { 
        return strategy.getName(); 
    }
    
    public void runTrial(Integer[][][] dataset) { 
    	//strategy.(dataset);
    }
    
    public void resetSum() { 
    	sum = 0.0f; 
    }
    
    public void incSum(float t) { 
    	sum += t; 
    }
    
    public float getSum() { 
    	return sum; 
    }
    
}