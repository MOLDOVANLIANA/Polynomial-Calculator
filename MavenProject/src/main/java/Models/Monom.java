package Models;

public abstract class Monom {
	public int grad;
	
	public Monom( int grad) {
		this.grad = grad;
	}
	
	protected String GetPrefix(boolean primul)
	{
		String prefix = "";
		
		if(GetValueAsInt()>0 && !primul)
		{
			prefix = "+";
		}
		return prefix;
	}
	
	
	public abstract int GetValueAsInt();
	public abstract boolean Comparare(Monom Celalalt);
	public abstract String GetString(boolean primul);
	public abstract Monom Adunare(Monom Celalalt);
	public abstract Monom Scadere(Monom Celalalt);
	public abstract Monom Inmultire(Monom Celalalt);
	public abstract MonomDouble Integrare();
	public abstract Monom Derivare();
	public abstract boolean EsteZero();
	public abstract MonomDouble Impartire(Monom Celalalt);
	public int GetGrad()
	{
		return grad;
	}
}

