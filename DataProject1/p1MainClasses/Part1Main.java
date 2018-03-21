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

public class Part1Main {
	public static void main(String[] args) throws FileNotFoundException{
		
		DataReader reader = new DataReader();
		Integer[][][] filesInfo = (Integer[][][]) reader.readDataFiles();
		
		MySet<Integer>[] setArray = new MySet [reader.getM()] ;//Debo cambiar este valor
		Set2<Integer> unionSet; 
		
		for(int j=0; j<filesInfo[0].length; j++){
			unionSet = new Set2<Integer>();
			for(int i=0; i<filesInfo.length;i++){
				for(int k=0; k<filesInfo[i][j].length;k++){	
					unionSet.add(filesInfo[i][j][k]);
				}	
			}	
			setArray[j] = unionSet;
		}
		
		P1P2IntersectionFinder finder = new P1P2IntersectionFinder("P2");
		P3IntersectionFinder finder3 = new P3IntersectionFinder("P3");
		
		Set2<Integer> intersection = (Set2<Integer>)(finder3.intersectSets(setArray));
		
		for(int i=0; i<reader.getM(); i++)
			System.out.println(setArray[i]);
		System.out.println(intersection);
		System.out.println();
		
		
		
	}
	
}
