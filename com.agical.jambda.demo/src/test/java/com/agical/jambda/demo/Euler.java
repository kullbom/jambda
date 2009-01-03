package com.agical.jambda.demo;

import org.junit.Test;

import com.agical.jambda.Tuples;
import com.agical.jambda.Functions.*;
import com.agical.jambda.Tuples.*;

import static com.agical.jambda.Sequence.*;
import static com.agical.jambda.Numeric.Integers.*;
import static org.junit.Assert.assertEquals;

public class Euler {
    /*!!
    Project Euler in jambda.
    */
    
    @Test
    public void eulerProblem2() throws Exception {
        /*!
        The problem:
        Each new term in the Fibonacci sequence is generated by adding the previous 
        two terms. By starting with 1 and 2, the first 10 terms will be:

            1, 2, 3, 5, 8, 13, 21, 34, 55, 89, ...

        Find the sum of all the even-valued terms in the sequence which do not exceed four million.
        
        A sollution in Haskell:
        module P2 where
            problem2:: Int -> Int
            problem2 y =    sum [ x | x <- takeWhile (<= y) fibonacci, mod x 2 ==0]
                where
                fibonacci = 0 : 1 : zipWith (+) fibonacci (tail fibonacci)
        
        In jambda it could be solved like this:
        */
        Iterable<Integer> fibs = map(range(
                new Fn1<Tuple2<Integer, Integer>, Tuple2<Integer, Integer>>() {
                    public Tuple2<Integer, Integer> apply(Tuple2<Integer, Integer> in) {
                        return Tuples.duo(in.getSecond(), in.getFirst() + in.getSecond());
                    }
                },
                Tuples.duo(0, 1)),
                Tuple2.<Integer, Integer>firstGetter());
        
        Integer sum = 
            sum(filter(takeWhile(fibs, greaterThen.apply(4000000)), 
                       modulo.apply(2).compose(equals.apply(0))));
        
        assertEquals(new Integer(4613732), sum);
    }
}

