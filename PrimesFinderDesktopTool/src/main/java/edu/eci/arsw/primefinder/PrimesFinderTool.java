package edu.eci.arsw.primefinder;

import edu.eci.arsw.mouseutils.MouseMovementMonitor;
import java.io.IOException;
import java.math.BigInteger;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;

public class PrimesFinderTool {

	public static void main(String[] args) {
		            
            int maxPrim=1000;
            
            PrimesResultSet prs=new PrimesResultSet("john");
            
            //PrimeFinder.findPrimes(new BigInteger("1"), new BigInteger("10000"), prs);
            
            PrimeFinder finder1 = new PrimeFinder();
            finder1.findPrimes(new BigInteger("1"), new BigInteger("2500"), prs);
            PrimeFinder finder2 = new PrimeFinder();
            finder2.findPrimes(new BigInteger("2501"), new BigInteger("5000"), prs);
            PrimeFinder finder3 = new PrimeFinder();
            finder3.findPrimes(new BigInteger("5001"), new BigInteger("7500"), prs);
            PrimeFinder finder4 = new PrimeFinder();
            finder4.findPrimes(new BigInteger("7501"), new BigInteger("10000"), prs);
            finder1.start();
            finder2.start();
            finder3.start();
            finder4.start();
            
            System.out.println("Prime numbers found:");
            
            System.out.println(prs.getPrimes());
            
            
            while(true){
                try {
                    //check every 10ms if the idle status (10 seconds without mouse
                    //activity) was reached. 
                    Thread.sleep(10);
                    if (MouseMovementMonitor.getInstance().getTimeSinceLastMouseMovement()>10000){
                        finder1.wait();
                        finder2.wait();
                        finder3.wait();
                        finder4.wait();
                        System.out.println("Idle CPU ");
                    }
                    else{
                        finder1.notifyAll();
                        finder2.notifyAll();
                        finder3.notifyAll();
                        finder4.notifyAll();
                        System.out.println("User working again!");
                    }
                } catch (InterruptedException ex) {
                    Logger.getLogger(PrimesFinderTool.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
                        
            
            
            
            
	}
	
}


