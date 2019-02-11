package com.collections.sorting;

import java.util.*;

public class SortKeyValueInHashMap {

    static Map<Integer,String> map = new HashMap<>();

    // Function to sort map by Key
    public static void sortbykey()
    {
       /* List<Integer> sortedKeys = new ArrayList<Integer>(map.keySet());
        Collections.sort(sortedKeys);

        for(int key : sortedKeys)
        {
            System.out.println(key +" "+map.get(key));
        }*/
             //OR

       /* Map<Integer,String> treeMap = new TreeMap<Integer, String>(map);

        for(Map.Entry<Integer,String> entry : treeMap.entrySet())
        {
            System.out.println(entry.getKey() +" "+entry.getValue());
        }
*/
                    //OR
        Map<Integer,String> treeMap1 = new TreeMap<>((Comparator<Integer>) (o1, o2) ->  o1.compareTo(o2));

        treeMap1.putAll(map);
        for(Map.Entry<Integer,String> entry : treeMap1.entrySet())
        {
            System.out.println(entry.getKey() +" "+entry.getValue());
        }
    }

    // Function to sort map by Key
    public static void sortbyValue()
    {
        //1. Create a list from elements of HashMap
        List<Map.Entry<Integer,String>> list = new LinkedList<>(map.entrySet());

        //2. Sort the list -- >Sory via Value
        //Collections.sort(list, (Map.Entry<Integer,String> o1,Map.Entry<Integer,String> o2) -> (o1.getKey().compareTo(o2.getKey())));

        //2. Sort the list -- >Sory via Key
        Collections.sort(list, (Map.Entry<Integer,String> o1,Map.Entry<Integer,String> o2) -> (o1.getValue().compareTo(o2.getValue())));

        
        //3. Put data from sorted list to map
        Map<Integer,String> temp = new LinkedHashMap<Integer,String>();

        for(Map.Entry<Integer,String> entry : list)
        {
            temp.put(entry.getKey(), entry.getValue());
        }

        //4. Printing the data from map
        for(Map.Entry<Integer,String> entry : temp.entrySet())
        {
            System.out.println(entry.getKey()+" "+entry.getValue());
        }
    }

    public static void main (String[] args) throws java.lang.Exception
    {

        map.put(3,"ishant");
        map.put( 1,"rahul");
        map.put( 2,"aditya");
        map.put( 4,"gautam");

       // sortbykey();
        sortbyValue();
    }
}