package automata_pila;

import java.util.Stack;

//a^n b^2n | n>=0

//		(a,$)	(a,a)	(b,a)	($,$)
//	q0 | Q0,0"  "Q0,0"  "Q1,2"  "Q2,2" 
//	q1 | ""		 ""		"Q0,1" 

//0 = apilar
// 1 = desapilar
// 2 = sin cambio

public class automata_pila
{
	String cadena;
	Stack<Character> pila = new Stack<Character>();

	public Boolean Cadena(String cadena)
	{
		boolean ban = true;
		cadena = cadena.toLowerCase();
		for (int i = 0; i < cadena.length(); i++)
			if (cadena.charAt(i) != 'a' && cadena.charAt(i) != 'b')
				return ban = false;

		this.cadena = cadena + "$";
		return ban;
	}

	public Boolean Almacenar_Pila()
	{
		boolean ban = false;
		int estado = 0, op = 0;
		char entrada, cima = '$';
		pila.push('$');

		for (int i = 0; i < cadena.length(); i++)
		{
			entrada = cadena.charAt(i);

			if (estado == 0)
			{
				// valida que es la entrada y la cima de la pila
				if (entrada == 'a' && (cima == '$' || cima == 'a'))
				{
					estado = 0;
					op = 0;

				} else if (entrada == 'b' && cima == 'a')
				{
					estado = 1;
					op = 2;
				} else if (entrada == '$' && cima == '$')
				{
					estado = 2;
					op = 2;

				}

				// 0 = apilar
				// 1 = desapilar
				// 2 = sin cambio
				if (op == 0)
				{
					pila.push('a');

				}
			} else if (estado == 1)
			{
				// valida que es la entrada y la cima de la pila
				if (entrada == 'b' && cima == 'a')
				{
					estado = 0;
					op = 1;

				}

				if (op == 1)
				{
					pila.pop();

				}
			}
			if (estado == 2)
				ban = true;

			cima = pila.peek();
		}

		return ban;
	}

}
