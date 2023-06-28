import java.util.Scanner;

public class Validar_Flotante
{

	public static void main(String[] args)
	{

		String espacios = (" |\n|\t");
		
		String nums = ("-?([0-9]+|(([1-9][0-9]*|0).([0-9]*[1-9]|0)))");
		

		System.out.println("10.2323w".matches(nums));

	

//		Scanner r = new Scanner(System.in);
//		System.out.println("ingresa un numero flotante");
//
//		if (Validacion(r.next()))
//		{
//			System.out.println("si es un numero flotante");
//		} else
//			System.out.println("no es un numero flotante");

	}

// valida que la cadena sea un flotante (45.4  45E-6  46646  5e+4 )
	public static boolean Validacion(String cadena)
	{
		boolean ban = cadena.matches("-?([1-9][0-9]*|0).([0-9]*[1-9]|0)([Ee][+-][1-9][0-9]*)?");

		return ban;
	}

}
