package edu.eci.arsw.primefinder;

import edu.eci.arsw.math.MathUtilities;
import java.math.BigInteger;
import java.util.LinkedList;
import java.util.List;

public class PrimeFinder extends Thread{
        
	private static BigInteger a, b;
        private static PrimesResultSet prss;
	
        
	public static void findPrimes(BigInteger _a, BigInteger _b, PrimesResultSet prs){
            
                a = _a;
                b = _b;
                prss = prs;
                //BigInteger a=_a;
                //BigInteger b=_b;

                MathUtilities mt=new MathUtilities();
                
                int itCount=0;
            
                BigInteger i=a;
                while (i.compareTo(b)<=0){
                    itCount++;
                    if (mt.isPrime(i)){
                        prss.addPrime(i);
                    }

                    i=i.add(BigInteger.ONE);
                }
                
	}
	
	
	@Override
        public void run(){
            /*while(running){
                synchronized(pausarHilo){
                    while(pausarHilo.get()){
                        try{
                            pausarHilo.wait();
                        }catch(InterruptedException e){
                            e.printStackTrace();
                        }
                    }
                }
            }*/
            findPrimes(a, b, prss);
        }
	
	
}
