package setUnionFinder;

import interfaces.MySet;
import mySetImplementations.Set1;
import mySetImplementations.Set2;

public class UnionFinder<E> {
	
	
	public MySet<E>[] findUnionSet1(E[][][] filesInfo){
		
		MySet<E>[] setArray = new MySet [filesInfo[0].length];
		MySet<E> unionSet; 
		
		for(int j=0; j<filesInfo[0].length; j++){
			unionSet = new Set1();
			for(int i=0; i<filesInfo.length;i++){
				for(int k=0; k<filesInfo[i][j].length;k++){	
					unionSet.add(filesInfo[i][j][k]);
				}	
			}	
			setArray[j] = unionSet;
		}
		return setArray;
	}	
	
	public MySet<E>[] findUnionSet2(E[][][] filesInfo){
		
		MySet<E>[] setArray = new MySet [filesInfo[0].length];
		MySet<E> unionSet; 
		
		for(int j=0; j<filesInfo[0].length; j++){
			unionSet = new Set2();
			for(int i=0; i<filesInfo.length;i++){
				for(int k=0; k<filesInfo[i][j].length;k++){	
					unionSet.add(filesInfo[i][j][k]);
				}	
			}	
			setArray[j] = unionSet;
		}
		return setArray;
	}	
}
