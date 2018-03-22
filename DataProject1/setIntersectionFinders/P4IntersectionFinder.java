package setIntersectionFinders;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import interfaces.MySet;
import mySetImplementations.Set2;

public class P4IntersectionFinder<E> extends AbstractIntersectionFinder<E> {

	public P4IntersectionFinder(String name) {
		super(name);
		
	}

	@Override
	public MySet<E> intersectSets(MySet<E>[] t) {
		
		ArrayList<E> allElements = new ArrayList<E>();
		for(int j=0; j<t.length; j++){
			MySet<E> set = t[j];
			for(E x : set){
				allElements.add(x);
			}
		}
		
		HashMap<E, Integer> map = new HashMap<>(); 
		for (E e : allElements) { 
		     Integer c = map.getOrDefault(e, 0); 
		     map.put(e, c+1); 
		}
		MySet<E> ti = new Set2<>(); 
		for (Map.Entry<E, Integer> entry : map.entrySet())
		     if (entry.getValue() == t.length) 
		        ti.add(entry.getKey());

		return ti;
	}

}
