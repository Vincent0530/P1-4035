package experimentalClasses;

import java.util.ArrayList;
import java.util.Map;

import interfaces.IntersectionFinder;
import interfaces.MySet;
import mySetImplementations.Set1;
import mySetImplementations.Set2;
import setIntersectionFinders.P1P2IntersectionFinder;
import setUnionFinder.UnionFinder;

public class StrategiesTimeCollection<E> 
extends ArrayList<Map.Entry<Integer, Float>> { 
    private IntersectionFinder<Integer> strategy;    // the strategy
    private float sum;  
    private boolean p1Happens = false;
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
    	UnionFinder<Integer> unionFinder = new UnionFinder<Integer>();
    	MySet<Integer>[] setArray;
    	
    	
    	if ((!p1Happens && (strategy instanceof P1P2IntersectionFinder))){
    		setArray = unionFinder.findUnionSet1(dataset);
    		p1Happens = true;
    	}
    	else
    		setArray = unionFinder.findUnionSet2(dataset);
    	
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