package analizadores;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.LinkedList;

public class ClassLexico
{
	private ClassSintactico objs;
	private String com = "";

	public LinkedList<String> LeerCodigo(File archivo)
	{
		LinkedList<String> list = new LinkedList<String>();
		objs = new ClassSintactico();
		String resultado = "";
		int i = 1;

		try
		{
			Reader lector = new BufferedReader(new FileReader(archivo));
			Lexer lexer = new Lexer(lector);

			while (true)
			{
				Tokens tokens = lexer.yylex();

				if (tokens == null)
					return list;

				switch (tokens)
				{
					case ERROR:
						resultado = "Error lexico en la linea " + i + ": el simbolo no esta definido en el lenguaje";
						list.add(resultado);
						return null;

					case id:
						list.add(tokens + " ");
						IdentidicarID(tokens + "");
					break;

					case Reservada:
						list.add(lexer.lexeme + " ");
						IdentidicarID(lexer.lexeme);
					break;

					case Numero_Entero:
					case Numero_Flotante:
						list.add(lexer.lexeme + " ");
						IdentidicarID("num");
					break;

					case Litcad:
					case Litcar:
						list.add(tokens + " ");
						IdentidicarID(tokens + "");
					break;

					case Salto:
						i++;
						list.add("\n");
					break;

					case Agrupacion:
					case Aritmetico:
					case Logico:
					case Relacional:
					case Asignacion:
					case Punto_coma:
					case Dos_puntos:
					case Coma:
						list.add(lexer.lexeme + " ");
						IdentidicarID(lexer.lexeme);
					break;

					case Menor_que:
					case Mayor_que:
					case Igual:
					case Diferente_de:
						list.add(lexer.lexeme + " ");
						IdentidicarID(tokens + "");
					break;

				}
			}

		} catch (FileNotFoundException e1)
		{
			e1.printStackTrace();
		} catch (IOException e1)
		{
			e1.printStackTrace();
		}

		return list;
	}

	public void IdentidicarID(String comp)
	{
		boolean ban = false;

		// IDENTIFICA EL TIPO DE ID
		if (comp.equals("procedimiento") || comp.equals("funcion"))
			com = comp;

		if (com.equals("procedimiento") && comp.equals("id"))
		{
			comp = "idp";
			objs.Pila(comp);
			com = "";
			ban = true;
		}
		if (com.equals("funcion") && comp.equals("id"))
		{
			comp = "idf";
			objs.Pila(comp);
			com = "";
			ban = true;
		}

		if (comp.equals("endPrograma"))
		{
			objs.Pila(comp);
			objs.Pila("$");
			ban = true;
		}

		if (comp.equals("endFuncion"))
		{
			objs.Pila(comp);
			ban = true;
		}	
		
		if (!ban)
			objs.Pila(comp);
	}
	
	
	
	public void mostrarsint() {
		objs.MostrarSintactico();
	}

}
