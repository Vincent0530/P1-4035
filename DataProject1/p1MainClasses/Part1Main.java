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

public class Part1Main {
	public static void main(String[] args) throws FileNotFoundException{
		
		DataReader reader = new DataReader();
		Integer[][][] filesInfo = (Integer[][][]) reader.readDataFiles();
		
		MySet<Integer>[] setArray = new MySet [reader.getM()];
		MySet<Integer> unionSet; 
		
		for(int j=0; j<filesInfo[0].length; j++){
			unionSet = new Set1();
			for(int i=0; i<filesInfo.length;i++){
				for(int k=0; k<filesInfo[i][j].length;k++){	
					unionSet.add(filesInfo[i][j][k]);
				}	
			}	
			setArray[j] = unionSet;
		}
		//Hola
		P1P2IntersectionFinder finder1 = new P1P2IntersectionFinder("P1");
		P1P2IntersectionFinder finder2 = new P1P2IntersectionFinder("P2");
		P3IntersectionFinder finder3 = new P3IntersectionFinder("P3");
		P4IntersectionFinder finder4 = new P4IntersectionFinder("P4");
		
		Set2<Integer> intersection = (Set2<Integer>)(finder4.intersectSets(setArray));
		
		for(int i=0; i<reader.getM(); i++)
			System.out.println(setArray[i]);
		
		System.out.println(finder1.getName()+intersection);
		//System.out.println(finder2.getName()+intersection);
		System.out.println(finder3.getName()+intersection);
		System.out.println(finder4.getName()+intersection);
		System.out.println();
		
	}
	
	private static MySet<Integer>[] unionSetCreator(MySet<Integer> unionSet) throws FileNotFoundException{
		DataReader reader = new DataReader();
		Integer[][][] filesInfo = (Integer[][][]) reader.readDataFiles();
		MySet<Integer>[] setArray = new MySet [reader.getM()];
		if(unionSet instanceof Set1){
			for(int j=0; j<filesInfo[0].length; j++){
				unionSet = new Set1();
				for(int i=0; i<filesInfo.length;i++){
					for(int k=0; k<filesInfo[i][j].length;k++){	
						unionSet.add(filesInfo[i][j][k]);
					}	
				}	
				setArray[j] = unionSet;
			}
		}
		else{
			for(int j=0; j<filesInfo[0].length; j++){
				unionSet = new Set2();
				for(int i=0; i<filesInfo.length;i++){
					for(int k=0; k<filesInfo[i][j].length;k++){	
						unionSet.add(filesInfo[i][j][k]);
					}	
				}	
				setArray[j] = unionSet;
			}
		}
		return setArray;
	}
	
}
