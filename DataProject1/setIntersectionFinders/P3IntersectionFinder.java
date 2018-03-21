package setIntersectionFinders;

import java.util.ArrayList;

import interfaces.MySet;
import mySetImplementations.Set2;

public class P3IntersectionFinder<E> extends AbstractIntersectionFinder {

	public P3IntersectionFinder(String name) {
		super(name);
		
	}

	@Override
	public MySet intersectSets(MySet[] t) {
		
		ArrayList<E> allElements = new ArrayList<E>();
		//MySet<E>[] unionSet = t;
		
		
		for(int j=0; j<t.length; j++){
			MySet<E> set = t[j];
			for(E x : set){
				allElements.add(x);
			}
		}
		
		allElements.sort(null); 		
		MySet<E> ti = new Set2();  // sets in P3's solution are of type Set2
		E e = allElements.get(0); 
		Integer c = 1;
		for (int i=1; i < allElements.size(); i++) {
		    if (allElements.get(i).equals(e)) 
		       c++;
		    else { 
		       if (c == t.length) 
		          ti.add(e);    // m is as in the previous discussion
		       e = allElements.get(i); 
		       c = 1; 
		    } 
		}
		if (c == t.length)
			ti.add(allElements.get(allElements.size()-1));
		return ti;

		
//		MySet<Integer>[] unionSet = t;
//		MySet<Integer> intersectionSet = unionSet[0];
//		int m = t.length;
//		for(int j=1; j<=t.length; j++){
//			for(Integer x: unionSet[j]){
//				if(intersectionSet.contains(x)){
//					
//				}
//			}
//		}
//		return null;
	}

}
