package experimentalClasses;

import java.util.ArrayList;
import java.util.Map;

import interfaces.IntersectionFinder;
import interfaces.MySet;
import mySetImplementations.Set1;
import mySetImplementations.Set2;
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
    	MySet<Integer>[] setArray = new MySet [dataset[0].length];
		MySet<Integer> unionSet; 
		
		for(int j=0; j<dataset[0].length; j++){
			unionSet = new Set2();
			for(int i=0; i<dataset.length;i++){
				for(int k=0; k<dataset[i][j].length;k++){	
					unionSet.add(dataset[i][j][k]);
				}	
			}	
			setArray[j] = unionSet;
		}
    	strategy.intersectSets(setArray);
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