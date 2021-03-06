package p1MainClasses;

import java.io.FileNotFoundException;
import java.util.Set;

import dataGenerator.DataGenerator;
import dataGenerator.DataReader;
import interfaces.MySet;
import mySetImplementations.Set1;
import mySetImplementations.Set2;
import setIntersectionFinders.P1P2IntersectionFinder;
import setIntersectionFinders.P3IntersectionFinder;
import setIntersectionFinders.P4IntersectionFinder;
import setUnionFinder.UnionFinder;

public class Part1Main {
	private static int parms = 0;
	
	public static void main(String[] args) throws FileNotFoundException{
		
		DataReader reader = new DataReader();
		Integer[][][] filesInfo = (Integer[][][]) reader.readDataFiles();
				
		UnionFinder<Integer> unionFinder = new UnionFinder<Integer>();
		MySet<Integer>[] set1Array = unionFinder.findUnionSet1(filesInfo); 
		MySet<Integer>[] set2Array = unionFinder.findUnionSet2(filesInfo); 
		
		if (args.length!=0)
			parms = Integer.parseInt(args[0]); 
		
		
		P1P2IntersectionFinder finder1 = new P1P2IntersectionFinder("P1");
		P1P2IntersectionFinder finder2 = new P1P2IntersectionFinder("P2");
		P3IntersectionFinder finder3 = new P3IntersectionFinder("P3");
		P4IntersectionFinder finder4 = new P4IntersectionFinder("P4");
		
		Set1<Integer> P1intersection = (Set1<Integer>)(finder1.intersectSets(set1Array));
		Set2<Integer> P2intersection = (Set2<Integer>)(finder2.intersectSets(set2Array));
		Set2<Integer> P3intersection = (Set2<Integer>)(finder3.intersectSets(set2Array));
		Set2<Integer> P4intersection = (Set2<Integer>)(finder4.intersectSets(set2Array));
		
		if(args.length == 0){
			System.out.println(finder1.getName()+P1intersection);
			System.out.println(finder2.getName()+P2intersection);
			System.out.println(finder3.getName()+P3intersection);
			System.out.println(finder4.getName()+P4intersection);
		}
		
		else if(parms == 1){
			System.out.println(finder1.getName()+P1intersection);
		}
		
		else if(parms == 2){
			System.out.println(finder2.getName()+P2intersection);
		}
		
		else if(parms == 3){
			System.out.println(finder2.getName()+P3intersection);
		}
		
		else if(parms == 4){
			System.out.println(finder4.getName()+P4intersection);
		}
	}
	
}
