//capturar el universo del automata (abcd)
//Capturar la cantidad de estados q1, q2, q3
// pedir la cantidad y cuales son los estados de aceptacion q2 y/o q3
//crear tabla de trnasicion

package AFD;

import LibreriaDatos.*;

public class Principal
{

	public static void main(String[] args)
	{
		Datos d = new Datos();
		CapDatos Datos = new CapDatos();
		boolean ban = true;

		do
		{
			Datos.CapAlfabeto();
			Datos.CapEstados();

			int tabla[][] = Datos.CapTablaTras();

			for (int i = 0; i < tabla.length; i++)
			{
				for (int j = 0; j < tabla[i].length; j++)
					System.out.print(tabla[i][j] + " ");
				System.out.println();
			}
			Menu menu = new Menu("", new String[] { "validar cadena", "generar nuevo automata" });
			int op;
			do
				switch (op = menu.Opcion())
				{
					case 1:
						Datos.Generar();
					break;

					case 2:
						char op2 = d.Caracter("Quieres regresar a ingresar un nuevo automata (S/N)? ");

						if (op2 == 's' || op2 == 'S')
						{
							ban = true;
							op = 3;
						}
						if (op2 == 'n' || op2 == 'N')
						{
							ban = false;
							op = 3;
						}
				}
			while (op != menu.Salir());
			System.out.println();
		} while (ban);

	}
}