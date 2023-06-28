package analizadores;

import java.io.File;

public class GenerarLexer
{
	

	public static void main(String[] args)
	{
		String ruta = "C:/Users/cris_/eclipse-workspace/ANALIZADOR LEXICO Y SINTACTICO/src/analizadores/Lexer.flex";
		generarLexer(ruta);
	}

	public static void generarLexer(String ruta)
	{
		File archivo = new File(ruta);
		JFlex.Main.generate(archivo);
	}
}
