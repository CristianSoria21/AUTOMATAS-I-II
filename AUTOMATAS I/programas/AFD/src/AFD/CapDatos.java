package AFD;

import LibreriaDatos.*;

public class CapDatos
{
	private Datos d = new Datos();
	private String alfabeto;
	private int can_est, tabla[][], can_estAcep[];

	public void CapAlfabeto()
	{
		System.out.println("*CUALQUIER CARACTER AGREGADO SERA ACEPTADO POR EL ALFABETO*");
		alfabeto = d.Cadena("ingresa el alfabeto para el automata: ");

	}

	public void CapEstados()
	{
		int acp, acep;

		do
		{
			can_est = d.Entero("ingresa la cantidad de estados: ");
		} while (can_est <= 0);

		for (int i = 0; i < can_est; i++)
			System.out.print("Q" + i + " ");

		do
		{
			acep = d.Entero("Cunatos estados de aceptacion existen? ");
		} while (acep > can_est);

		can_estAcep = new int[acep];

		for (int i = 0; i < can_estAcep.length; i++)
		{

			acp = d.Entero(i + ") ingresa el estado de aceptacion: Q");

			while (acp > (can_est - 1))
			{
				System.out.println(
						"El estado de aceptacion debe estar dentro de la cantidad de estados antes ingresados");
				acp = d.Entero(i + ") ingresa el estado de aceptacion: Q");
			}

			can_estAcep[i] = acp;
		}

	}

	public int[][] CapTablaTras()
	{
		tabla = new int[can_est][alfabeto.length()];
		int valor = 0, filas, columnas;

		for (filas = 0; filas < can_est; filas++)
			for (columnas = 0; columnas < alfabeto.length(); columnas++)
			{
				do
				{
					System.out.println("Los estados van desde -1 a " + (can_est - 1) + " estados disponibles");

					valor = d.Entero("dame el estado de la posicion [" + filas + "][" + columnas + "]: ");

				} while (valor > can_est || valor <= -2);

				tabla[filas][columnas] = valor;
			}

		return tabla;

	}

	public void Generar()
	{
		int con = 0, caracter = 0;
		String cadena;
		boolean ban = false;

		cadena = d.Cadena("Dame la cadena a validar: ");

		for (int i = 0; i < cadena.length(); i++)
		{
			caracter = alfabeto.indexOf(cadena.charAt(i));
			if (caracter != -1)
			{
				con = tabla[con][caracter];
				if (con == -1)
				{
					System.out.println("cadena no valida");
				}

			} else
			{
				System.out.println("El caracter " + cadena.charAt(i) + " no existe en el alfabeto");
				return;
			}
		}

		for (int i = 0; i < can_estAcep.length; i++)
		{
			if (con == can_estAcep[i])
			{
				ban = true;
				break;
			}
		}

		if (ban)
			System.out.println("Esta cadena es aceptada");
		else
			System.out.println("cadena no valida");

	}
}
