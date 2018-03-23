package p1MainClasses;

import java.io.FileNotFoundException;

import experimentalClasses.ExperimentController;
import experimentalClasses.StrategiesTimeCollection;
import setIntersectionFinders.P1P2IntersectionFinder;
import setIntersectionFinders.P3IntersectionFinder;
import setIntersectionFinders.P4IntersectionFinder;

public class Part2Main {
	private static int[] parms = {10, 50, 1000, 50000, 1000, 200};
	public static void main(String[] args) throws FileNotFoundException, CloneNotSupportedException{
		if (args.length > 6)
			System.out.println("Unexpected number of parameters. Must me <= 6.");
		for (int i=0; i<args.length; i++)
			parms[i] = Integer.parseInt(args[i]); 
		
		// Parm1: initial size
		// Parm2: final size to consider
		// Parm3: incremental steps (size)
		// Parm4: trials per size
		ExperimentController ec = new ExperimentController(parms[0], parms[1], parms[2], parms[3], parms[4], parms[5]); 
		
		/**/	
		ec.addStrategy(new StrategiesTimeCollection<Integer>(new P1P2IntersectionFinder<Integer>("P1")));
		ec.addStrategy(new StrategiesTimeCollection<Integer>(new P1P2IntersectionFinder<Integer>("P2")));
		ec.addStrategy(new StrategiesTimeCollection<Integer>(new P3IntersectionFinder<Integer>("P3")));
		ec.addStrategy(new StrategiesTimeCollection<Integer>(new P4IntersectionFinder<Integer>("P4")));
		/**/

		ec.run();    // run the experiments on all the strategies added to the controller object (ec)
		
		// save the results for each strategy....
		try {
			ec.saveResults();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
		
	
}
