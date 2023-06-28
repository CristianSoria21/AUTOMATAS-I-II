package automata_pila;

//a^n b^2n | n>=0

//(a,$)	(a,a)	(b,a)	($,$)
//q0 | Q0,0"  "Q0,0"  "Q1,2"  "Q2,2" 
//q1 | ""		 ""		"Q0,1" 

//0 = apilar
//1 = desapilar
//2 = sin cambio

import java.util.Stack;

public class automata_pila2
{
	String cadena, convinaciones[] = { "a$", "aa", "ba", "$$" },
			tablaT[][] = { { "00", "00", "12", "22" }, { "", "", "01", "" } };

	Stack<Character> pila = new Stack<Character>();

	public Boolean Cadena(String cadena)
	{
		boolean ban = true;

		// cadena = cadena.toLowerCase();
		/*
		 * for (int i = 0; i < cadena.length(); i++) if (cadena.charAt(i) != 'a' &&
		 * cadena.charAt(i) != 'b') return ban = false;
		 */

		this.cadena = cadena + "$";
		return ban;
	}

	public void Almacenar_Pila()
	{

		boolean ban = false;
		int estado = 0, accion = 0;
		String conv;

		pila.clear();
		pila.push('$');
		int pos = 0;
		String entrada = "";
		for (int x = 0; x < cadena.length(); x++)
		{
			conv = cadena.charAt(x) + "" + pila.peek();
			for (int y = 0; y < convinaciones.length; y++)
				if (conv.equals(convinaciones[y]))
				{
					pos = y;
					break;
				} else
				{
					pos = -1;
				}
			if (pos != -1)
			{
				entrada = tablaT[estado][pos];
				if (entrada != "")
				{
					accion = Integer.parseInt(entrada.charAt(1) + "");
					estado = Integer.parseInt(entrada.charAt(0) + "");

					if (accion == 0)
						pila.push(cadena.charAt(x));
					else if (accion == 1)
						pila.pop();
				}

			} else
			{
				System.out.println("CADENA NO VALIDA (solo acepta a's y b's)");
				return;
			}

		}

		if (estado == 2)
			System.out.println("LA CADENA ES ACEPTATA");
		else
			System.out.println("LA CADENA NO ES ACEPTADA");
	}

}
