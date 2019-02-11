package com.ds.lru;

import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class LRUCacheDQ {

    // store keys of cache
   private Deque<Integer> dq;

    // store references of key in cache
   private Set<Integer> set;

    //maximum capacity of cache
   private int csize;

    public LRUCacheDQ(int size)
    {
        dq = new LinkedList<>();
        set = new HashSet<>();
        csize = size;
    }

    /* Refers key x with in the LRU cache */
    public void refer(int x)
    {
        if(! set.contains(x))
        {
            if (dq.size() == csize)
            {
                int last = dq.removeLast();
                set.remove(last);
            }
        }
        else
        {
            dq.remove(x);
        }
        dq.push(x);
        set.add(x);
    }

    // display contents of cache
    public void display()
    {
        for( int x : dq)
            System.out.print(x+" ");
    }

    public static void main(String[] args) {
        LRUCacheDQ ca = new LRUCacheDQ(4);

        ca.refer(1);
        ca.refer(2);
        ca.refer(3);
        ca.refer(1);
        ca.refer(4);
        ca.refer(5);
        ca.display();
    }
}

