package analizadores;

import java.util.EmptyStackException;
import java.util.LinkedList;
import java.util.Stack;

public class ClassSintactico
{
	String no_terminales[]= {"prog", "dec", "sigid","modulos", "proc", "fun","tiporetorno", "list-arg","siglist","list-param","sig-param"," sentencias", "sentencia", "sigif", "L","L'", "R", "R'", "E", "E'","T","T'","F","$"};

    String terminales[]= 
   	             {    		   "id"             ,"num"          ,"("          ,")"        	  ,"litcad"          ,"litcar"           ,"+"        	  ,"-"          ,"*"          ,"/"          ,"="        	  ,"<"          ,">"          ,"<="          ,">="       	   ,"!="          ,"=="    	      ,"!"           ,"&"       	  ,"|"           ,"true"          ,"false"                 ,"if"                                    ,"while"                              ,"repeat"                	   ,"else"        	  ,"then"          ,"do"          ,"endif"          ,"endwhile"                		   ,"programa"                              ,"int"                 ,"float"                 	 ,"char"                    ,"Strig"               ,"boolean"                      ,"read"           ,"write"      	    ,","                            ,"procedimiento"                             		,"funcion"                                          ,"endProcemidiento"    		  ,"endFuncion"          ,"endPrograma"       	   ,"idp"                 	  ,"idf"         ,";"   		  ,"return"            ,"$"};
String tabla[][]= {
		           {       "saltar ",         "saltar ",      "saltar ",     "saltar ",       "saltar ",          "saltar ",       "saltar ",     "saltar ",     "saltar ",     "saltar ",     "saltar ",     "saltar ",     "saltar ",      "saltar ",     "saltar ",      "saltar ",      "saltar ",      "saltar ",     "saltar ",      "saltar ",       "saltar ",        "saltar ",              "saltar ",                                "saltar ",                           "saltar ",                  " saltar ",         "saltar ",      "saltar ",      "saltar ",          "saltar ",   "programa id ; modulos dec sentencias endPrograma ",          "saltar ",              "saltar ",                 "saltar ",                   "saltar ",               "saltar ",                   "saltar ",         "saltar ",        "saltar ",                            "saltar ",                                     "saltar ",                                               "saltar ",                  "saltar ",              "saltar ",            "saltar ",               "saltar ",        "saltar ",     "saltar ",          "sacar "},
                   {       "saltar ",         "saltar ",      "saltar ",     "saltar ",       "saltar ",          "saltar ",       "saltar ",     "saltar ",     "saltar ",     "saltar ",     "saltar ",     "saltar ",     "saltar ",      "saltar ",     "saltar ",      "saltar ",      "saltar ",      "saltar ",     "saltar ",      "saltar ",       "saltar ",        "saltar ",               "ç ",                        	        "saltar ",                           "saltar ",                   "saltar ",         "saltar ",      "saltar ",      "saltar ",          "saltar ",                         "saltar ",                        "int id sigid ; dec ",   "float id sigid ; dec ",    "char id sigid ; dec ",  "String id sigid ; dec ",  "boolean id sigid ; dec ",         "saltar ",         "saltar ",        "saltar ",                            "saltar ",                                     "saltar ",                                               "saltar ",                  "saltar ",                 "ç ",               "ç ",           	    "ç ",         	  "saltar ",      "saltar ",          "sacar "},
                   {    	   "ç ",          	"ç ",    	  "saltar ",     "saltar ",       "saltar ",          "saltar ",       "saltar ",     "saltar ",     "saltar ",     "saltar ",    "= E sigid",    "saltar ",     "saltar ",      "saltar ",     "saltar ",      "saltar ",      "saltar ",      "saltar ",     "saltar ",      "saltar ",       "saltar ",        "saltar ",              "saltar ",                                "saltar ",                           "saltar ",                   "saltar ",         "saltar ",      "saltar ",      "saltar ",          "saltar ",                         "saltar ",                             "saltar ",              "saltar ",                  "saltar ",                   "saltar ",              "saltar ",                    "saltar ",         "saltar ",       ", id sigid ",                         "saltar ",                                     "saltar ",                                               "saltar ",                  "saltar ",              "saltar ",            "saltar ",               "saltar ",        "saltar ",     "saltar ",          "sacar "},
                   {          "ç ",           "saltar ",      "saltar ",     "saltar ",       "saltar ",          "saltar ",       "saltar ",     "saltar ",     "saltar ",     "saltar ",     "saltar ",     "saltar ",     "saltar ",      "saltar ",     "saltar ",      "saltar ",      "saltar ",      "saltar ",     "saltar ",      "saltar ",       "saltar ",        "saltar ",                "ç ",                                      "ç ",                                "ç ",                     "saltar ",         "saltar ",      "saltar ",      "saltar ",          "saltar ",                         "saltar ",                                "ç ",                   "ç ",                       "ç ",                         "ç ",                  "ç ",                      "saltar ",         "saltar ",        "saltar ",                          "proc modulos ",                                "fun modulos ",                                             "ç ",                     "saltar ",              "saltar ",             "ç ",           	     "ç ",     	   	  "saltar ",     "saltar ",          "sacar "},
                   {       "saltar ",         "saltar ",      "saltar ",     "saltar ",       "saltar ",          "saltar ",       "saltar ",     "saltar ",     "saltar ",     "saltar ",     "saltar ",     "saltar ",     "saltar ",      "saltar ",     "saltar ",      "saltar ",      "saltar ",      "saltar ",     "saltar ",      "saltar ",       "saltar ",        "saltar ",              "saltar ",                                "saltar ",                           "saltar ",                   "saltar ",         "saltar ",      "saltar ",      "saltar ",          "saltar ",                         "saltar ",                             "saltar ",              "saltar ",                  "saltar ",                   "saltar ",              "saltar ",                    "saltar ",         "saltar ",        "saltar ",  "procedimiento idp ( list-arg ) dec sentencias endProcedimiento ",       "saltar ",                                               "saltar ",                  "saltar ",              "saltar ",            "saltar ",               "saltar ",        "saltar ",     "saltar ",          "sacar "},
                   {       "saltar ",         "saltar ",      "saltar ",     "saltar ",       "saltar ",          "saltar ",       "saltar ",     "saltar ",     "saltar ",     "saltar ",     "saltar ",     "saltar ",     "saltar ",      "saltar ",     "saltar ",      "saltar ",      "saltar ",      "saltar ",     "saltar ",      "saltar ",       "saltar ",        "saltar ",              "saltar ",                                "saltar ",                           "saltar ",                   "saltar ",         "saltar ",      "saltar ",      "saltar ",          "saltar ",                         "saltar ",                             "saltar ",              "saltar ",                  "saltar ",                   "saltar ",              "saltar ",                    "saltar ",         "saltar ",        "saltar ",                            "saltar ",           "funcion idf ( list-arg ) : tiporetorno dec sentencias endFuncion ",               "saltar ",                  "saltar ",              "saltar ",            "saltar ",               "saltar ",        "saltar ",     "saltar ",          "sacar "},
                   {       "saltar ",         "saltar ",      "saltar ",     "saltar ",       "saltar ",          "saltar ",       "saltar ",     "saltar ",     "saltar ",     "saltar ",     "saltar ",     "saltar ",     "saltar ",      "saltar ",     "saltar ",      "saltar ",      "saltar ",      "saltar ",     "saltar ",      "saltar ",       "saltar ",        "saltar ",              "saltar ",                                "saltar ",                           "saltar ",                   "saltar ",         "saltar ",      "saltar ",      "saltar ",          "saltar ",                         "saltar ",                               "int ",               "float ",                    "char ",                    "String ",             "boolean ",                    "saltar ",         "saltar ",        "saltar ",                            "saltar ",                                     "saltar ",                                               "saltar ",                  "saltar ",              "saltar ",            "saltar ",               "saltar ",        "saltar ",     "saltar ",          "sacar "},
                   {       "saltar ",         "saltar ",      "saltar ",       "ç ",          "saltar ",          "saltar ",       "saltar ",     "saltar ",     "saltar ",     "saltar ",     "saltar ",     "saltar ",     "saltar ",      "saltar ",     "saltar ",      "saltar ",      "saltar ",      "saltar ",     "saltar ",      "saltar ",       "saltar ",        "saltar ",              "saltar ",                                "saltar ",                           "saltar ",                   "saltar ",         "saltar ",      "saltar ",      "saltar ",          "saltar ",                         "saltar ",                         "int id siglist ",       "float id siglist ",        "char id siglist ",        "String id siglist ",    "boolean id siglist ",            "saltar ",         "saltar ",        "saltar ",                            "saltar ",                                     "saltar ",                                               "saltar ",                  "saltar ",              "saltar ",            "saltar ",               "saltar ",        "saltar ",     "saltar ",          "sacar "},
                   {       "saltar ",         "saltar ",      "saltar ",       "ç ",          "saltar ",          "saltar ",       "saltar ",     "saltar ",     "saltar ",     "saltar ",     "saltar ",     "saltar ",     "saltar ",      "saltar ",     "saltar ",      "saltar ",      "saltar ",      "saltar ",     "saltar ",      "saltar ",       "saltar ",        "saltar ",              "saltar ",                                "saltar ",                           "saltar ",                   "saltar ",         "saltar ",      "saltar ",      "saltar ",          "saltar ",                         "saltar ",                             "saltar ",               "saltar ",                 "saltar ",                   "saltar ",               "saltar ",                   "saltar ",         "saltar ",      ", list-arg ",                          "saltar ",                                     "saltar ",                                               "saltar ",                  "saltar ",              "saltar ",            "saltar ",               "saltar ",        "saltar ",     "saltar ",          "sacar "},
                   {    "L sig-param ",     "L sig-param ", "L sig-param ",    "ç ",       "L sig-param ",     "L sig-param ",     "saltar ",     "saltar ",     "saltar ",     "saltar ",     "saltar ",     "saltar ",     "saltar ",      "saltar ",     "saltar ",      "saltar ",      "saltar ",      "saltar ",     "saltar ",      "saltar ",     "L sig-param ",   "L sig-param ",           "saltar ",                                "saltar ",                           "saltar ",                   "saltar ",         "saltar ",      "saltar ",      "saltar ",          "saltar ",                         "saltar ",                             "saltar ",               "saltar ",                 "saltar ",                   "saltar ",               "saltar ",                   "saltar ",         "saltar ",         "saltar ",                           "saltar ",                                     "saltar ",                                               "saltar ",                  "saltar ",              "saltar ",            "saltar ",             "L sig-param ",     "saltar ",    "saltar ",          "sacar "},
                   {       "saltar ",         "saltar ",      "saltar ",       "ç ",          "saltar ",          "saltar ",       "saltar ",     "saltar ",     "saltar ",     "saltar ",     "saltar ",     "saltar ",     "saltar ",      "saltar ",     "saltar ",      "saltar ",      "saltar ",      "saltar ",     "saltar ",      "saltar ",       "saltar ",        "saltar ",              "saltar ",                                "saltar ",                           "saltar ",                   "saltar ",         "saltar ",      "saltar ",      "saltar ",          "saltar ",                         "saltar ",                             "saltar ",               "saltar ",                 "saltar ",                   "saltar ",               "saltar ",                   "saltar ",         "saltar ",      ",L sig-param ",                        "saltar ",                                     "saltar ",                                               "saltar ",                  "saltar ",              "saltar ",            "saltar ",               "saltar ",        "saltar ",    "saltar ",          "sacar "},
                   {"sentencia sentencias ",  "saltar ",      "saltar ",     "saltar ",       "saltar ",          "saltar ",       "saltar ",     "saltar ",     "saltar ",     "saltar ",     "saltar ",     "saltar ",     "saltar ",      "saltar ",     "saltar ",      "saltar ",      "saltar ",      "saltar ",     "saltar ",      "saltar ",       "saltar ",        "saltar ",       "sentencia sentencias ",                  "sentencia sentencias ",               "sentencia sentencias ",            "ç ",            "saltar ",      "saltar ",        "ç ",                "ç ",                           "saltar ",                             "saltar ",               "saltar ",                 "saltar ",                   "saltar ",               "saltar ",                   "saltar ",         "saltar ",         "saltar ",                           "saltar ",                                     "saltar ",                                                 "ç ",                        "ç ",                   "ç ",         "sentencia sentencias",       "saltar ",        "saltar ","sentencia sentencias ",   "ç "  },
                   {        "id = L ; ",      "saltar ",      "saltar ",     "saltar ",       "saltar ",          "saltar ",       "saltar ",     "saltar ",     "saltar ",     "saltar ",     "saltar ",     "saltar ",     "saltar ",      "saltar ",     "saltar ",      "saltar ",      "saltar ",      "saltar ",     "saltar ",      "saltar ",       "saltar ",        "saltar ",   "if L then sentencias sigif endif ",     "while L do sentencias endwhile ",        "repeat sentencias until L ; ",     "saltar ",         "saltar ",      "saltar ",        "ç ",      	     "saltar ",                         "saltar ",                             "saltar ",               "saltar ",                 "saltar ",                   "saltar ",               "saltar ",                   "saltar ", "write ( list-param ) ; ", "saltar ",                           "saltar ",                                     "saltar ",                                               "saltar ",                  "saltar ",              "saltar ",      "idp ( list-param ) ; ",       "saltar ",        "saltar ",   "return L ; ",       "sacar "},
                   {       "saltar ",         "saltar ",      "saltar ",     "saltar ",       "saltar ",          "saltar ",       "saltar ",     "saltar ",     "saltar ",     "saltar ",     "saltar ",     "saltar ",     "saltar ",      "saltar ",     "saltar ",      "saltar ",      "saltar ",      "saltar ",     "saltar ",      "saltar ",       "saltar ",        "saltar ",              "saltar ",                                "saltar ",                            "saltar ",             "else sentencias ",     "saltar ",      "saltar ",        "ç ",             "saltar ",                         "saltar ",                             "saltar ",               "saltar ",                 "saltar ",                   "saltar ",               "saltar ",                   "saltar ",         "saltar ",         "saltar ",                           "saltar ",                                     "saltar ",                                               "saltar ",                  "saltar ",                 "ç ",              "saltar ",               "saltar ",        "saltar ",    "saltar ",            "ç "  },
                   {         "R L' ",           "R L' ",        "R L' ",     "saltar ",         "R L' ",          "saltar ",       "saltar ",     "saltar ",     "saltar ",     "saltar ",     "saltar ",     "saltar ",     "saltar ",      "saltar ",     "saltar ",      "saltar ",      "saltar ",         "! L ",     "saltar ",      "saltar ",        "R L' ",           "R L' ",              "saltar ",                                "saltar ",                            "saltar ",                   "saltar ",        "saltar ",      "saltar ",      "saltar ",          "saltar ",                         "saltar ",                             "saltar ",               "saltar ",                 "saltar ",                   "saltar ",               "saltar ",                   "saltar ",         "saltar ",         "saltar ",                           "saltar ",                                     "saltar ",                                               "saltar ",                  "saltar ",              "saltar ",            "saltar ",                "R L' ",         "saltar ",    "saltar ",          "sacar "},
                   {       "saltar ",         "saltar ",      "saltar ",       "ç ",          "saltar ",          "saltar ",          "ç ",         "ç ",           "ç ",         "ç ",        "saltar ",        "ç ",          "ç ",          "ç ",           "ç ",           "ç ",          "ç",          "saltar ",     "& R L' ",      "| R L' ",        "saltar ",       "saltar ",              "saltar ",                                "saltar ",                            "saltar ",                   "saltar ",          "ç ",           "ç ",         "saltar ",          "saltar ",                         "saltar ",                             "saltar ",               "saltar ",                 "saltar ",                   "saltar ",               "saltar ",                   "saltar ",         "saltar ",         "saltar ",                           "saltar ",                                     "saltar ",                                               "saltar ",                  "saltar ",              "saltar ",            "saltar ",               "saltar ",        "saltar ",    "saltar ",            "ç "  },
                   {         "E R' ",           "E R' ",        "E R' ",     "saltar ",         "E R' ",            "E R' ",       "saltar ",     "saltar ",     "saltar ",     "saltar ",     "saltar ",     "saltar ",     "saltar ",      "saltar ",     "saltar ",      "saltar ",      "saltar ",      "saltar ",        "ç ",           "ç ",            "E R' ",         "E R' ",              "saltar ",                                "saltar ",                            "saltar ",                   "saltar ",          "ç ",           "ç ",         "saltar ",          "saltar ",                         "saltar ",                             "saltar ",               "saltar ",                 "saltar ",                   "saltar ",               "saltar ",                   "saltar ",         "saltar ",         "saltar ",                           "saltar ",                                     "saltar ",                                               "saltar ",                  "saltar ",              "saltar ",            "saltar ",                 "E R' ",        "saltar ",    "saltar ",            "ç "  },
                   {       "saltar ",         "saltar ",      "saltar ",       "ç ",          "saltar ",          "saltar ",          "ç ",         "ç ",           "ç ",         "ç ",        "saltar ",      "< E ",         "> E ",        "< = E ",      "> = E ",      "! = E ",        "==E ",        "saltar ",        "ç ",           "ç ",          "saltar ",       "saltar ",              "saltar ",                                "saltar ",                            "saltar ",                   "saltar ",          "ç ",           "ç ",         "saltar ",          "saltar ",                         "saltar ",                             "saltar ",               "saltar ",                 "saltar ",                   "saltar ",               "saltar ",                   "saltar ",         "saltar ",         "saltar ",                           "saltar ",                                     "saltar ",                                               "saltar ",                  "saltar ",              "saltar ",            "saltar ",               "saltar ",        "saltar ",    "saltar ",            "ç "  },
                   {         "T E' ",           "T E' ",        "T E' ",     "saltar ",         "T E' ",            "T E' ",       "saltar ",     "saltar ",     "saltar ",     "saltar ",     "saltar ",     "saltar ",     "saltar ",      "saltar ",     "saltar ",      "saltar ",      "saltar ",      "saltar ",     "saltar ",      "saltar ",          "T E' ",         "T E' ",              "saltar ",                                "saltar ",                            "saltar ",                   "saltar ",        "saltar ",      "saltar ",      "saltar ",          "saltar ",                         "saltar ",                             "saltar ",               "saltar ",                 "saltar ",                   "saltar ",               "saltar ",                   "saltar ",         "saltar ",         "saltar ",                           "saltar ",                                     "saltar ",                                               "saltar ",                  "saltar ",              "saltar ",            "saltar ",                 "T E' ",        "saltar ",    "saltar ",          "sacar "},
                   {       "saltar ",         "saltar ",      "saltar ",       "ç ",          "saltar ",          "saltar ",       "+ T E' ",       "-TE' ",        "ç ",          "ç ",       "saltar ",        "ç ",          "ç ",           "ç ",          "ç ",           "ç ",          "ç ",         "saltar ",       "ç ",            "ç ",          "saltar ",       "saltar ",              "saltar ",                                "saltar ",                            "saltar ",                   "saltar ",          "ç ",           "ç ",         "saltar ",          "saltar ",                         "saltar ",                             "saltar ",               "saltar ",                 "saltar ",                   "saltar ",               "saltar ",                   "saltar ",         "saltar ",         "saltar ",                           "saltar ",                                     "saltar ",                                               "saltar ",                  "saltar ",              "saltar ",            "saltar ",               "saltar ",        "saltar ",    "saltar ",            "ç "  },
                   {         "F T' ",          "F T' ",         "F T' ",     "saltar ",         "F T' ",            "F T' ",       "saltar ",     "saltar ",     "saltar ",     "saltar ",     "saltar ",     "saltar ",     "saltar ",      "saltar ",     "saltar ",      "saltar ",      "saltar ",      "saltar ",     "saltar ",      "saltar ",         "F T' ",          "F T' ",              "saltar ",                                "saltar ",                            "saltar ",                   "saltar ",        "saltar ",      "saltar ",      "saltar ",          "saltar ",                         "saltar ",                             "saltar ",               "saltar ",                 "saltar ",                   "saltar ",               "saltar ",                   "saltar ",         "saltar ",         "saltar ",                           "saltar ",                                     "saltar ",                                               "saltar ",                  "saltar ",              "saltar ",            "saltar ",                "F T' ",         "saltar ",    "saltar ",          "sacar "},
                   {       "saltar ",         "saltar ",      "saltar ",       "ç ",          "saltar ",          "saltar ",          "ç ",         "ç ",        "* F T' ",     "/ F T' ",     "saltar ",        "ç ",          "ç ",           "ç ",         "ç ",           "ç ",           "ç ",         "saltar ",       "ç ",            "ç ",          "saltar ",       "saltar ",              "saltar ",                                "saltar ",                            "saltar ",                   "saltar ",          "ç ",            "ç ",        "saltar ",          "saltar ",                         "saltar ",                             "saltar ",               "saltar ",                 "saltar ",                   "saltar ",               "saltar ",                   "saltar ",         "saltar ",         "saltar ",                           "saltar ",                                     "saltar ",                                               "saltar ",                  "saltar ",              "saltar ",            "saltar ",               "saltar ",        "saltar ",    "saltar ",            "ç "  },
                   {         "id ",           "num ",          "( L ) ",     "saltar ",       "litcad ",          "litcar ",       "saltar ",     "saltar ",     "saltar ",     "saltar ",     "saltar ",     "saltar ",     "saltar ",      "saltar ",     "saltar ",      "saltar ",      "saltar ",      "saltar ",     "saltar ",      "saltar ",        "true ",          "false ",              "saltar ",                                "saltar ",                            "saltar ",                   "saltar ",        "saltar ",      "saltar ",      "saltar ",          "saltar ",                         "saltar ",                             "saltar ",               "saltar ",                 "saltar ",                   "saltar ",               "saltar ",          "read ( list-param ) ; ",   "saltar ",         "saltar ",                           "saltar ",                                     "saltar ",                                               "saltar ",                  "saltar ",              "saltar ",            "saltar ",        "idf ( list.param ) ",   "saltar ",    "saltar ",          "sacar "},                  
                   {       "saltar ",	      "saltar ",	  "saltar ",	 "saltar ",		  "saltar ",		  "saltar ",	   "saltar ",	  "saltar ",	 "saltar ",		"saltar ",	   "saltar ",	  "saltar ",	 "saltar ",		 "saltar ",		"saltar ",		"saltar ",		"saltar ",		"saltar ",     "saltar ",	   "saltar ",		 "saltar ",		  "saltar ",		   	  "saltar ",								"saltar ",							  "saltar ",				   "saltar ",	  	 "saltar ",		 "saltar ",		 "saltar ",			 "saltar ",							"saltar ",							   "saltar ",				"saltar ",				   "saltar ",					"saltar ",			 	 "saltar ",					  "saltar ",		 "saltar ",			"saltar ",							 "saltar ",										"saltar ",												 "saltar ",					 "saltar ",				 "saltar ",			   "saltar ",				"saltar ",		  "saltar ",    "saltar ",	    "aceptar "}
};

	java.util.Stack<String> pila = new java.util.Stack<String>();
	Boolean ban = true, acep = false;
	String cont;
	int x = 0, y = 0;

	LinkedList<String> list_pila = new LinkedList<String>();
	LinkedList<String> list_entrada = new LinkedList<String>();
	LinkedList<String> list_accion = new LinkedList<String>();

	// OJO CORREGIR: CADA VEZ QUE SE MANDA A LLAMAR LA CLASE SE REINICIA LA PILA
	public ClassSintactico()
	{
		if (ban)
		{
			pila.push("$");
			pila.push("prog");
			ban = false;
			list_pila.add(pila + "");
		}
	}

	public void Pila(String token)
	{
		try
		{
			list_entrada.add(token);

			// VALIDA SI LA SIMA DE LA PILA CONCUERDA CON EL TOKEN
			if (token.equals(pila.peek()))
				if (token.equals("$")) // SI CONCUERDA CON UN "$" LA CADENA ES ACEPATA
				{

					acep = true;
					list_accion.add("ACEPTADA!");
					pila.pop();
					list_pila.add(pila + "");

				} else
					this.Concuerda();
			else
			{

				// TERMINA EL SICLO HASTA QUE EL TOKEN ENCUENTRE UNA ACCION
				// COMO QUE CONCUERDE CON EL VALOR DE LA SIMA DE LA PILA, SE GENERE UN ERROR
				// O LA ACCION SACAR DE LA PILA "Ç"
				do
				{
					BuscarNo_terminales();
					BuscarTerminales(token);

					if (tabla[x][y].equals("saltar "))
					{

						list_accion.add("Saltar -> " + token);
						list_pila.add(pila + "");
						break;

					} else if (tabla[x][y].equals("sacar ")) // COMPARA SI SE ENCUENTRA "SACAR " GENERA ERROR Y SE SACA
																// EL TOKEN DE LA SIMA DE LA PILA
					{
						list_accion.add("ERROR SINTACTICO: sacar -> " + pila.peek());
						pila.pop();
						list_pila.add(pila + "");
						this.Pila(token);

					} else if (tabla[x][y].equals("ç ")) // COMPARA SI SE ENCUENTRA UN "Ç " Y SE SACA LA SIMA DE LA PILA
					{

						list_accion.add("Ç");
						pila.pop();
						list_pila.add(pila + "");
						this.Pila(token);
						break;

					} else if (tabla[x][y].equals("aceptar ")) // COMPARA SI SE ENCUENTRA UN "ACEPTAR " Y LA CADENA ES
																// ACEPTADA
					{

						acep = true;
						list_accion.add("ACEPTADA!");
						list_pila.add(pila + "");
						break;

					} else
					{
						list_accion.add(tabla[x][y]);
						
						// SE DETERMINA QUE HAY UNA ACCION PARA APILAR
						Stack<String> pilaaux = new Stack<String>();
						String cadena = "";
						pila.pop();

						// ALMACENA LO QUE REGRESA LA TABLA EN LA PILA AUXILIAR
						for (int j = 0; j < tabla[x][y].length(); j++)
							if (tabla[x][y].charAt(j) != ' ')
								cadena += tabla[x][y].charAt(j) + "";
							else
							{
								pilaaux.push(cadena);
								cadena = "";
							}

						// SE VACIA LA PILA AUXILIAR PARA GUARDAR EN LA PILA PRINCIPAL
						do
							pila.push(pilaaux.pop());
						while (!pilaaux.isEmpty());

						list_pila.add(pila + "");
						list_entrada.add(token);

						// DETERMINA SI CONCUERDA CON LA SIMA DE LA PILA Y SI ES ASI SALE DEL SICLO
						if (token.equals(pila.peek()))
						{
							this.Concuerda();
							break;
						}
					}
				} while (acep == false && !token.equals(pila.peek()));
			}
		} catch (EmptyStackException e)
		{
			e.printStackTrace();
		}
	}

	// PENDIENTE
	public void Concuerda()
	{
		list_accion.add("CONCUERDA -> " + pila.peek());
		pila.pop();
		list_pila.add(pila + "");
	}

	// BUSCA EN LAS NO TERMINALES SI ESTA LO QUE TIENE LA SIMA DE LA PILA Y LO
	// REGRESA EN "X"
	public int BuscarNo_terminales()
	{
		for (int i = 0; i < no_terminales.length; i++)
			if (no_terminales[i].equals(pila.peek()))
			{
				x = i;
				break;
			}
		return x;
	}

	// BUSCA EN TERMINALES SI SE ENCUENTRA EL TOKEN Y REGRESA LA POSICION EN "Y"
	public int BuscarTerminales(String token)
	{
		for (int i = 0; i < terminales.length; i++)
			if (token.equals(terminales[i]))
			{
				y = i;
				break;
			}
		return y;
	}

	public void MostrarSintactico()
	{

		for (int i = 0; i < list_pila.size() - 1; i++)
		{
			System.out.println(i + ")	" + list_pila.get(i));
			System.out.println(i + ")	" + list_entrada.get(i));	
			System.out.println(i + ")	" + list_accion.get(i));
			System.out.println("-----------------------------");

		}
	}
}
