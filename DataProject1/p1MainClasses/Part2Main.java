package p1MainClasses;

import java.io.FileNotFoundException;

import experimentalClasses.ExperimentController;
import experimentalClasses.StrategiesTimeCollection;
import setIntersectionFinders.P1P2IntersectionFinder;

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
//		ec.addStrategy(new StrategiesTimeCollection<Integer>(new SelectionSortSorter<Integer>()));
//		ec.addStrategy(new StrategiesTimeCollection<Integer>(new InsertionSortSorter<Integer>()));
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
