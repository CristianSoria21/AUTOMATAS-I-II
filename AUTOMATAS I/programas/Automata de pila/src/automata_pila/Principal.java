package automata_pila;

import LibreriaDatos.Datos;

public class Principal
{

	public static void main(String[] args)
	{
		LibreriaDatos.Datos obd = new Datos();
		automata_pila2 automata = new automata_pila2();
		System.out.println("\t AUTOMATA DE PILA");
		System.out.println("LENGUAJE:	a^n b^2n | n>=0");

		boolean ban;

		while (true)
		{
			do
			{
				ban = automata.Cadena(obd.Cadena("\nDame la cadena para el automata:"));
				
			} while (!ban);

			System.out.println("\ncadena...	" + automata.cadena + "");

			automata.Almacenar_Pila();
			
		}
	}

}
