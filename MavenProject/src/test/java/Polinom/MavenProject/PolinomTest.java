package Polinom.MavenProject;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import Models.Monom;
import Models.MonomDouble;
import Models.MonomInt;
import Models.Polinom;

public class PolinomTest {
	@Test
     public void TestAdunare()
     {
    	 Polinom P1 = new Polinom("x^2+1");
    	 Polinom P2=new Polinom ("x^1");
    	 Polinom Rez=P1.Adunare(P2);
    	 
    	 assertTrue(Rez.GetGrad()==2);
    }
	@Test
	  public void TestScadere()
	     {
	    	 Polinom P1 =new Polinom("x^2+x^1+1");
	    	 Polinom P2=new Polinom ("x^1+3");
	    	 Polinom Rez=P1.Scadere(P2);
	    	 
	    	 Polinom Comparare= new Polinom("x^2-2");
	    	 assertTrue(Rez.PolinoameEgale(Comparare));
	    }
	@Test
	  public void TestInmultire()
	     {
	    	 Polinom P1 =new Polinom("x^2+x^1+1");
	    	 Polinom P2=new Polinom ("x^1+3");
	    	 Polinom Rez=P1.Inmultire(P2);
	    	 
	    	 Polinom Comparare1= new Polinom("x^3+4x^2+4x+3");
	    	 assertTrue(Rez.PolinoameEgale(Comparare1));
	    }
	@Test
	  public void TestDerivare()
	     {
	    	 Polinom P1 =new Polinom("x^2+x^1+1");
	    	 Polinom Rez=P1.Derivare();
	    	 
	    	 Polinom Comparare1= new Polinom("2x^1+1");
	    	 assertTrue(Rez.PolinoameEgale(Comparare1));
	    }
	@Test
	public void TestIntegrare()
	{
		 Polinom P1 =new Polinom("x^2+x^1+1");
		 Polinom Rez=P1.Integrare();
		 
		 MonomDouble M0 = new MonomDouble(0.0,0);
		 MonomDouble M3 = new MonomDouble(0.33,3);
		 MonomDouble M2 = new MonomDouble(0.5,2); 
		 MonomDouble M1 = new MonomDouble(1.0,1); 
		 
		 boolean b0 = Rez.GetList().get(0).Comparare(M0);
		 boolean b1 = Rez.GetList().get(1).Comparare(M1);
		 boolean b2= Rez.GetList().get(2).Comparare(M2);
		 boolean b3= Rez.GetList().get(3).Comparare(M3);
    	 assertTrue(b0&&b1&&b2&&b3);
	}
		
		
	
	
	
}
