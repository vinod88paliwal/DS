package com.oops.collectionsbehaviour;

import java.util.TreeSet;

public class SetComparisonLogic implements Comparable<SetComparisonLogic>{

	String field1;
	String field2;

	public String toString(){
	    return field1+" "+field2;
	}

	SetComparisonLogic(String field1,String field2){
	    this.field1= field1;
	    this.field2= field2;
	}
	
	@Override
	public int compareTo(SetComparisonLogic o) {
		return this.field1.compareToIgnoreCase(o.field1);
	}
	
   @Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((field1 == null) ? 0 : field1.hashCode());
		result = prime * result + ((field2 == null) ? 0 : field2.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SetComparisonLogic other = (SetComparisonLogic) obj;
		if (field1 == null) {
			if (other.field1 != null)
				return false;
		} else if (!field1.equals(other.field1))
			return false;
		if (field2 == null) {
			if (other.field2 != null)
				return false;
		} else if (!field2.equals(other.field2))
			return false;
		return true;
	}

public static void main(String[] args) {
	
	   TreeSet<SetComparisonLogic> set = new TreeSet<SetComparisonLogic>();
	    set.add(new SetComparisonLogic("A", "A"));
	    set.add(new SetComparisonLogic("A", "B"));
	    set.add(new SetComparisonLogic("A", "C"));
	    set.add(new SetComparisonLogic("B", "A"));
	    set.add(new SetComparisonLogic("B", "B"));
	    set.add(new SetComparisonLogic("B", "C"));
	    set.add(new SetComparisonLogic("C", "A"));
	    set.add(new SetComparisonLogic("C", "B"));
	    set.add(new SetComparisonLogic("C", "C"));
	    set.add(new SetComparisonLogic("A", "A"));

	     for(SetComparisonLogic logic : set)
	    	 System.out.println(logic);
	    
		
		  System.out.println(set.remove(new SetComparisonLogic("A", "A")));
		  System.out.println(set.remove(new SetComparisonLogic("A", "B")));
		  System.out.println(set.remove(new SetComparisonLogic("A", "C")));
		  System.out.println(set.remove(new SetComparisonLogic("B", "A")));
		  System.out.println(set.remove(new SetComparisonLogic("B", "B")));
		  System.out.println(set.remove(new SetComparisonLogic("B", "C")));
		  System.out.println(set.remove(new SetComparisonLogic("C", "A")));
		  System.out.println(set.remove(new SetComparisonLogic("C", "B")));
		  System.out.println(set.remove(new SetComparisonLogic("C", "C")));
		 
}	

}
