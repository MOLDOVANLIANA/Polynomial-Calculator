package Models;

import java.text.DecimalFormat;

public class MonomDouble extends Monom{
	double coeficient;
	public MonomDouble(Double coeficient, int grad) {
		super(grad);
		this.coeficient = coeficient;
	}

	@Override
	public String GetString(boolean primul) {
		
		String prefix = GetPrefix(primul);
		String coeficientString= "";
		if(coeficient==0)
		{
			return coeficientString;
		}
		DecimalFormat Df2 = new DecimalFormat("#.##");
		coeficientString= prefix +Df2.format(coeficient)+"x^"+Integer.toString(grad);
		
		return coeficientString;
	}

	@Override
	public Monom Adunare(Monom Celalalt) {
		double sumaCoficient=coeficient+((MonomDouble)Celalalt).coeficient;
		MonomDouble rez=new MonomDouble(sumaCoficient, grad);
		return rez;
	}
	@Override
	public Monom Scadere(Monom Celalalt) {
		double difCoeficient=coeficient-((MonomInt)Celalalt).coeficient;
		MonomDouble rez=new MonomDouble(difCoeficient, grad);
		return rez;
	}

	@Override
	public Monom Inmultire(Monom Celalalt) {
		int inmultireCoeficienti=(int)(coeficient *((MonomInt)Celalalt).coeficient);
		int gradrez= grad +Celalalt.grad;
		MonomInt rez=new MonomInt(inmultireCoeficienti,gradrez);
		return rez;
	}

	@Override
	public MonomDouble Integrare() {
		int numitor=grad+1;
		MonomDouble rez=new MonomDouble(((double)coeficient/numitor), numitor);
		return rez;
	}

	@Override
	public Monom Derivare() {
		double termenInmultire=coeficient *grad;
		int gradRez = grad;
		if(gradRez!=0)
			gradRez--;
		MonomDouble rez=new MonomDouble (termenInmultire, gradRez);
		return rez;
	}

	@Override
	public boolean EsteZero() {
		return coeficient == 0;
	}

	@Override
	public MonomDouble Impartire(Monom Celalalt)
	{
		if(grad<Celalalt.grad)
		{
		System.out.println("Nu se poate impartire dintre grad mai mic si mai mare");
		return null;
		}
		
		int gradRez  = grad- Celalalt.grad;
		double CoeficientRez = (double)coeficient/((MonomInt)Celalalt).coeficient;
		
		MonomDouble MonomRez = new MonomDouble(CoeficientRez, gradRez);
		
		return MonomRez;
	}

	@Override
	public int GetValueAsInt() {
		return (int)coeficient;
	}

	@Override
	public boolean Comparare(Monom Celalalt)
	{
		MonomDouble CelalaltDouble = (MonomDouble)Celalalt;
		double epsilon = 0.01d;
		if(Math.abs(coeficient - CelalaltDouble.coeficient) < epsilon && grad==CelalaltDouble.GetGrad())
		{
			return true;
		}
		return false;
	}
}
