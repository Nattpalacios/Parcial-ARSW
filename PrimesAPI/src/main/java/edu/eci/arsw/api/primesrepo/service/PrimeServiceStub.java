package edu.eci.arsw.api.primesrepo.service;

import edu.eci.arsw.api.primesrepo.model.FoundPrime;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Santiago Carrillo
 * 2/22/18.
 */
@Service
public class PrimeServiceStub implements PrimeService
{
    @Override
    public void addFoundPrime( FoundPrime foundPrime )
    {
        //TODO
    }

    @Override
    public List<FoundPrime> getFoundPrimes()
    {
        //TODO
        return null;
    }

    @Override
    public FoundPrime getPrime( String prime )
    {
        //TODO
        return null;
    }
}
