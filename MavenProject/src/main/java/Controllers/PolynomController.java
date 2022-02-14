package Controllers;

import Models.Polinom;
import Models.RezultatImpartire;
import Views.Interface;

public class PolynomController {

	Interface View;

	public PolynomController(Interface View) {
		this.View = View;
	}

	private boolean IsStringValid(String P) {
		if (P.compareTo("") != 0) {
			return true;
		}
		return false;
	}

	public void OnAdunare(String Polynom1, String Polynom2) {
		if (IsStringValid(Polynom1) && IsStringValid(Polynom2)) {
			Polinom P1 = new Polinom(Polynom1);
			Polinom P2 = new Polinom(Polynom2);

			Polinom Rez = P1.Adunare(P2);
			View.Afisare(Rez.GetString());
		} else
			View.Afisare("Nu s-au introdus datele!");
	}

	public void OnScadere(String Polynom1, String Polynom2) {
		if (IsStringValid(Polynom1) && IsStringValid(Polynom2)) {
			Polinom P1 = new Polinom(Polynom1);
			Polinom P2 = new Polinom(Polynom2);

			Polinom Rez = P1.Scadere(P2);
			View.Afisare(Rez.GetString());
		} else
			View.Afisare("Nu s-au introdus datele!");
	}

	public void OnInmultire(String Polynom1, String Polynom2) {
		if (IsStringValid(Polynom1) && IsStringValid(Polynom2)) {
			Polinom P1 = new Polinom(Polynom1);
			Polinom P2 = new Polinom(Polynom2);

			Polinom Rez = P1.Inmultire(P2);
			View.Afisare(Rez.GetString());
		} else
			View.Afisare("Nu s-au introdus datele!");
	}

	public void OnImpartire(String Polynom1, String Polynom2) {
		if (IsStringValid(Polynom1) && IsStringValid(Polynom2)) {
			Polinom P1 = new Polinom(Polynom1);
			Polinom P2 = new Polinom(Polynom2);

			RezultatImpartire Rez = P1.Impartire(P2);
			if (Rez == null) {
				View.Afisare("Grade incompatibile");
			} else {
				View.Afisare(Rez.GetString());
			}
		} else
			View.Afisare("Nu s-au introdus datele!");

	}

	public void OnDerivare(String Polynom) {
		if (IsStringValid(Polynom)) {
			Polinom P = new Polinom(Polynom);
			Polinom Rez = P.Derivare();

			View.Afisare(Rez.GetString());
		} else
			View.Afisare("Nu s-au introdus datele!");
	}

	public void OnIntegrare(String Polynom) {
		if (IsStringValid(Polynom)) {
			Polinom P = new Polinom(Polynom);
			Polinom Rez = P.Integrare();

			View.Afisare(Rez.GetString());
		} else
			View.Afisare("Nu s-au introdus datele!");

	}
}
