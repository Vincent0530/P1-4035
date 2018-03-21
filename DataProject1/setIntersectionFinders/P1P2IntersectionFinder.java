package setIntersectionFinders;



import java.util.Iterator;

import interfaces.MySet;
import mySetImplementations.Set1;
import mySetImplementations.Set2;

public class P1P2IntersectionFinder<E> extends AbstractIntersectionFinder<E> {

	public P1P2IntersectionFinder(String name) {
		super(name);
		
	}

	@Override
	public MySet<E> intersectSets(MySet<E>[] t) {
		//MySet<E>[] unionSet = t;
		MySet<E> intersectionSet = t[0];
		
		for(int j=1; j<t.length; j++){
			MySet<E> set = t[j];
			Iterator<E> iterator = intersectionSet.iterator();
			while(iterator.hasNext()){
				E etc = iterator.next();
				if(!(set.contains(etc)))
					iterator.remove();
			}
		}
		return intersectionSet;
	}

	
}
