package Models;

public class RezultatImpartire {
	Polinom Cat;
	Polinom Rest;
	
	public RezultatImpartire(Polinom Cat, Polinom Rest)
	{
		this.Cat=Cat;
		this.Rest=Rest;
	}
	
	public String GetString()
	{
		String textRest="0";
		if(Rest.GetString().compareTo("")!=0)
		{
			textRest=Rest.GetString();
		}
		return "Cat: " + Cat.GetString() + " Rest: "+ textRest;
		
	}
	
}
