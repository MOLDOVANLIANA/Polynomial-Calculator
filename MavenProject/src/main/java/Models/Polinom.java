package Models;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Polinom {
	List <Monom> list;
	
	
	public Polinom(String Regex)
	{
		List<Monom> Termeni = new ArrayList<Monom>();
		
		Pattern pattern = Pattern.compile("([+-]?[^-+]+)");
		Matcher matcher = pattern.matcher(Regex);
		
		while (matcher.find()) {
			String Element = matcher.group(1);
			if(Element.contains("x^"))
			{
				String Valori[] = Element.split("x\\^");
				int Coeficient = GetCoeficient(Valori[0]);
				
				int Grad = Integer.parseInt(Valori[1]);
				Monom Termen = new MonomInt(Coeficient, Grad);
				Termeni.add(Termen);
			}
			else
			{
				int Grad=0;
				if(Element.contains("x"))
				{
					Element=Element.replace("x", "");
					Grad=1;
				}
				int Coeficient = GetCoeficient(Element);
				Monom Termen = new MonomInt(Coeficient, Grad);
				Termeni.add(Termen);
			}
			
		}
		List<Monom> ActualList=new ArrayList<Monom>();
		Initialize(ActualList, Termeni.get(0).grad);
		for(int i=0;i<Termeni.size();i++)
		{
			ActualList.set(Termeni.get(i).GetGrad(), Termeni.get(i));
		}
		list=ActualList;
		
	}
	
	private int GetCoeficient(String S)
	{
		int Coeficient = 0;
    
			if(S.compareTo("")==0|| S.contains("+"))
			{
				Coeficient=1;
				String Modified = S.replace("+", "");
				if(Modified.length()>0)
				{
					Coeficient = Integer.parseInt(Modified);
				}
			}
			else if(S.contains("-"))
			{
				Coeficient=-1;
				String Modified = S.replace("-", "");
				if(Modified.length()>0)
				{
					Coeficient = -Integer.parseInt(Modified);
				}
			}
			else
			{
				Coeficient = Integer.parseInt(S);
			}
		
		
		return Coeficient;
	}
	static Polinom GetPolinomFromDouble(List<MonomDouble> DoubleList)
	{
		List<Monom> a=new ArrayList<Monom>();
		InitializeDouble(a, DoubleList.get(DoubleList.size()-1).grad);
		for(int i=0;i<DoubleList.size();i++)
		{
			a.set(DoubleList.get(i).GetGrad(), DoubleList.get(i));
		}
		return new Polinom(a);
	}
	public Polinom(List<Monom> c)
	{
		List<Monom> a=new ArrayList<Monom>();
		Initialize(a, c.get(c.size()-1).grad);
		for(int i=0;i<c.size();i++)
		{
			a.set(c.get(i).GetGrad(), c.get(i));
		}
		list=a;
	}
	Polinom(MonomInt c)
	{
		List<Monom> a=new ArrayList<Monom>();
		Initialize(a, c.grad);
		a.set(c.GetGrad(), c);
		list=a;
	}
	Polinom(MonomDouble c)
	{
		List<Monom> a=new ArrayList<Monom>();
		InitializeDouble(a, c.grad);
		a.set(c.GetGrad(), c);
		list=a;
	}
	
	public List<Monom> GetList()
	{
		return list;
	}
	public boolean PolinoameEgale(Polinom a)
	{
		int i=0;
		for(Monom m: list)
		{
			if (!(list.get(i).Comparare(a.list.get(i))))
			{
				return false;
			}
			i++;
		}
		return true;
	}
	public int GetGrad()
	{
		int poz = 0;
		
		for(int i=list.size()-1;i>0;i--)
		{
			if(!list.get(i).EsteZero())
			{
				poz=i;
				break;
			}
		}
		
		return poz;
	}
	static public void Initialize(List<Monom>b,int size)
	{
		for(int i=0;i<=size;i++)
		{
			b.add(new MonomInt(0,i));
		}
	}
	static public void InitializeDouble(List<Monom>b,int size)
	{
		for(int i=0;i<=size;i++)
		{
			b.add(new MonomDouble(0.0,i));
		}
	}
	
	public String GetString()
	{
		String Text = "";
		for(int i=GetGrad();i>=0;i--)
		{		
				Text += list.get(i).GetString(i==GetGrad());
		}
		return Text;
	}
	public Polinom Adunare(Polinom a)
	{
		Polinom PMic;
		Polinom PMare;
		
		if(GetGrad()<a.GetGrad())
		{
			PMic=this;
			PMare=a;
		}
		else
			if(GetGrad()>a.GetGrad())
			{
				PMic=a;
				PMare=this;

			}
			else
			{
				PMic=a;
				PMare=this;
			}
		List<Monom> suma=new ArrayList<>();
		int i=0;
		for(Monom m:list)
		{
			Monom nr1=PMare.list.get(i);
			Monom nr2;
			if(i>PMic.GetGrad())
				nr2=new MonomInt(0,i);
			else
				nr2=PMic.list.get(i);
			Monom rezultat= nr1.Adunare(nr2);
			suma.add(rezultat);
			i++;
			
		}
		Polinom rezAdunare= new Polinom (suma);
		return rezAdunare;
	}
	
	public void AdunareTermen(MonomDouble M)
	{
		for(int i=list.size()-1;i<M.GetGrad();i++)
			list.add(new MonomDouble(0.0,0));

		list.set(M.GetGrad(), M.Adunare(list.get(M.GetGrad())));
	}
	public Polinom Scadere(Polinom a)
	{
		Polinom PMic;
		Polinom PMare;
		
		if(GetGrad()<a.GetGrad())
		{
			PMic=this;
			PMare=a;
		}
		else
			if(GetGrad()>a.GetGrad())
			{
				PMic=a;
				PMare=this;

			}
			else
			{
				PMic=a;
				PMare=this;
			}
		int size = PMare.GetGrad();
		
		List<Monom> diferenta=new ArrayList<>();
		for(int i=0;i<=size;i++)
		{
			Monom NrThis;
			Monom NrA;
			
			if(i>GetGrad())
			{
				NrThis = new MonomInt(0,i);
			}
			else
			{
				NrThis = list.get(i);
			}
			if(i>a.GetGrad())
			{
				NrA = new MonomInt(0,i);
			}
			else
			{
				NrA = a.list.get(i);
			}

			Monom rezultat= NrThis.Scadere(NrA);
			diferenta.add(rezultat);		
		}
		Polinom rezAdunare= new Polinom (diferenta);
		return rezAdunare;	
	}
	
	public Polinom Inmultire(Polinom a)
	{
		List<Monom> listRezultat=new ArrayList<>();
		Initialize(listRezultat,GetGrad()+a.GetGrad());
		
		for(Monom t : list)
		{
			for(int j=0;j<=a.GetGrad();j++)
			{
				Monom r=t.Inmultire(a.list.get(j));
				int gradrez=r.grad;
				Monom termenExistent=listRezultat.get(gradrez);
				Monom i2= r.Adunare(termenExistent);
				listRezultat.set(gradrez, i2);
			}
		}
		Polinom rezInmultire=new Polinom(listRezultat);
		return rezInmultire;
	}
	public Polinom Integrare()
	{
		List<MonomDouble> listRezultat=new ArrayList<>();
		int i=0;
		for(Monom m: list)
		{
			listRezultat.add(new MonomDouble(0.0,i));
			i++;
		}
		i=0;
		for(Monom m:list)
		{
			listRezultat.set(i, list.get(i).Integrare());
			i++;
		}
		
		Polinom rezIntegrare=Polinom.GetPolinomFromDouble(listRezultat);
		return rezIntegrare;
	}
	public Polinom Derivare()
	{
		List<Monom> listRezultat=new ArrayList<>();
		Initialize(listRezultat, GetGrad());
		int i=0;
		for(Monom m: list)
		{
			Monom Rez = list.get(i).Derivare();
//			System.out.println(Rez.coeficient);
//			System.out.println(Rez.grad);
			listRezultat.set(i, Rez);
			i++;
		}
		
		Polinom rezIntegrare=new Polinom(listRezultat);
		return rezIntegrare;
	}
	
	
	public RezultatImpartire Impartire(Polinom Celalalt)
	{
		
		if(this.GetGrad()<Celalalt.GetGrad())
		{
			System.out.println("Impartire imposibila");
			return null;
		}
		List<Monom> ListaCopie = new ArrayList<>();
		
		for(Monom M : list)
		{					
			MonomInt MonomCurent = (MonomInt)M;
			MonomInt MonomNou= new MonomInt(MonomCurent.coeficient,M.grad);			
			ListaCopie.add(MonomNou);
		}	
		
		Polinom RestOperatii = new Polinom(ListaCopie);
		Polinom CatOperatie=new Polinom(new MonomDouble (0.0,0));
		boolean ImpartireTerminata = false;
		MonomInt TermenImpartitor= (MonomInt) Celalalt.list.get(Celalalt.GetGrad());
		while(!ImpartireTerminata)
		{
			MonomInt TermenImpartit=(MonomInt) RestOperatii.list.get(RestOperatii.GetGrad());
			MonomDouble CatImpartire=TermenImpartit.Impartire(TermenImpartitor);	
			Polinom PolinomCatImpartire = new Polinom(CatImpartire);	
			
			CatOperatie.AdunareTermen(CatImpartire);
			
			Polinom RezInmultire = PolinomCatImpartire.Inmultire(Celalalt);
			RestOperatii = RestOperatii.Scadere(RezInmultire);
			
			ImpartireTerminata = RestOperatii.GetGrad()<Celalalt.GetGrad();			
		}
		
		return new RezultatImpartire(CatOperatie, RestOperatii);	
		
	}
	
}

