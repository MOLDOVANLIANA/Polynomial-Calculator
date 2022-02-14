package Models;

public class MonomInt extends Monom {

	int coeficient;
	public MonomInt(Integer coeficient, int grad) {
		super(grad);
		this.coeficient = coeficient;
	}

	@Override
	public String GetString(boolean primul) {
		String coeficientString= "";
		if(coeficient==0)
		{
			return coeficientString;
		}
		
		String prefix = GetPrefix(primul);
		
		coeficientString= prefix +Integer.toString(coeficient)+"x^"+Integer.toString(grad);

		return coeficientString;
	}

	@Override
	public Monom Adunare(Monom Celalalt) {
		int sumaCoficient=coeficient+((MonomInt)Celalalt).coeficient;
		MonomInt rez=new MonomInt(sumaCoficient, grad);
		return rez;
	}

	@Override
	public Monom Scadere(Monom Celalalt) {
		int difCoeficient=coeficient-((MonomInt)Celalalt).coeficient;
		MonomInt rez=new MonomInt(difCoeficient, grad);
		return rez;
	}

	@Override
	public Monom Inmultire(Monom Celalalt) {
		int inmultireCoeficienti=coeficient *((MonomInt)Celalalt).coeficient;
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
		int termenInmultire=coeficient *grad;
		int gradRez = grad;
		if(gradRez!=0)
			gradRez--;
		MonomInt rez=new MonomInt (termenInmultire, gradRez);
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
		
		return coeficient;
	}
	public boolean Comparare(Monom Celalalt)
	{
		MonomInt CelalaltInt = (MonomInt)Celalalt;
		if(coeficient==CelalaltInt.coeficient && grad==CelalaltInt.GetGrad())
		{
			return true;
		}
		return false;
	}
	
}
