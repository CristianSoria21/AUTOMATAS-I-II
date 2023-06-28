package automata_pila;

import java.util.ArrayDeque;

import LibreriaDatos.Datos;

public class prueba
{

	private Datos obd = new Datos();
	private String cad, valores[] = { "a$", "b$", "c$", "ab", "ac", "ba", "bc", "ca", "cb", "m$", "ma", "mb", "mc",
			"am", "bm", "cm", "aa", "bb", "cc", "$a", "$b", "$c", "$$" };;// wmw-1
	private int x;
	private ArrayDeque<Character> pila = new ArrayDeque<Character>();

	private String matriz[][] = {
			{ "00", "00", "00", "00", "00", "00", "00", "00", "00", "12", "12", "12", "12", "!2", "!2", "!2", "00",
					"00", "00", "!2", "!2", "!2", "!2" }, // linea o estado 0
			{ "!2", "!2", "!2", "!2", "!2", "!2", "!2", "!2", "!2", "!2", "12", "12", "12", "11", "11", "11", "11",
					"11", "11", "11", "11", "11", "22" }// linea o estado 1
	};

	public void Lectura()
	{
		boolean ban = false;
		;
		do
		{
			if (ban)
				obd.Println("No debe estar vacia");
			cad = obd.Cadena("Dame la cadena a validar");
		} while (ban = cad.isBlank());
		cad += "$";
	}

	private void Tabla()
	{
		pila.clear();
		pila.push('$');
		x = 0;
		int y, ind = 0;// se ocupa dejar del tipo entero para controlar la posicion de la matriz
		char accion = ' ';
		String form;

		for (x = 0; x < cad.length(); x++)
		{
			form = cad.charAt(x) + "" + pila.getFirst();
			for (y = 0; y < valores.length && !valores[y].contains(form); y++)
				;// este ciclo termina cuando encuentra una similitud con las combinaciones o sea
					// mayoe valores.lenght
			if (y < valores.length)// es para q no se salga del rango para evitar el try and catch
			{
				accion = matriz[ind][y].charAt(1);
				if (matriz[ind][y].charAt(0) != '!')
					ind = Integer.parseInt(matriz[ind][y].charAt(0) + "");
				else
					break;
			}
			if (accion == '0')
				pila.push(cad.charAt(x));
			else if (accion == '1' && ind == 1)
				pila.pop();
		}
		if (ind == 2 && accion == '2')
			obd.Println("Cadena aceptada");
		else
			obd.Println("No aceptada");
	}

	public static void main(String[] args)
	{
		prueba oba = new prueba();
		while (true)
		{
			oba.Lectura();
			oba.Tabla();
		}
	}
}
