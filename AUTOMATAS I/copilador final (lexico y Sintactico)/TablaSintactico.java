String encabezadosRenglones[] =  { "prog", "dec", "sigid", "modulos", "proc", "fun", "tiporetorno", "list-arg", "siglist","list-param", "sig-param", "sentencias", "sentencia", "sigif", "L", "L’", "R", "R’", "E", "E’", "T", "T’",	"F", "$" };
String encabezadosColumnas[] = { "id", "num", "(", ")", "litcad", "litcar", "+", "-", "*", "/", "=", "<", ">", "meniq","mayiq", "dif", "igual", "!", "&", "|", "true", "false", "if", "while", "repeat", "else", "then", "do","endif", "endwhile", "program", "int", "float", "char", "string", "boolean", "read", "write", ",", "method","funtion", "endm", "endf", "endp", "idm", "idf", "return", "$", ";", "call", "until" };
	
	String matriz[][]= {
						//{ "id",	0				 "num", 	1		"(",	2		 	 ")", 	3		"litcad",	4		 "litcar",	5		 "+",	6		 "-", 	7		"*",	8		 "/", 	9		"=", 10			 "<",	11		 ">",	12		 "meniq",13		"mayiq",14		 "dif",	15		 "igual",	16	 "!", 17			"&", 18				 "|", 19     	 "true", 20			 "false",	21		 "if",	22								 "while", 23							"repeat",	24						 "else",25					 "then", 26		"do",	27		"endif", 28		 "endwhile", 29		 "program",		30	 							"int", 	31					"float", 32						 "char", 33						 "string",	34					 "boolean",	35						 "read", 36						 "write", 37						 ",",  38				"method",	39											"funtion",	40										 "endm", 41		 "endf", 42			 "endp", 43			 "idm",	44					 "idf", 45					"return",	46				 "$" 47			";"		48				"call" 49					"until" 50};
	/*prog 		 0*/	{ "saltar ",				 "saltar ",			 "saltar ",			 "saltar ",		 "saltar ",			 "saltar ",			 "saltar ",		 "saltar ",		 "saltar ",		 "saltar ",		 "saltar ",		 "saltar ",		 "saltar ",		 "saltar ",		 "saltar ",		 "saltar ",		 "saltar ",		 "saltar ",		 "saltar ",			 "saltar ",			 "saltar ",			 "saltar ",			 "saltar ",								 "saltar ",								 "saltar ",							 "saltar ",					 "saltar ",		"saltar ",		 "saltar ",		 "saltar ",	 "program id ; modulos dec sentencias endp ",			 "saltar ",				 	"saltar ",						 "saltar ",						 "saltar ",						 "saltar ",							 "saltar ",						 "saltar ",							 "saltar ",				 "saltar ",												 "saltar ",											 "saltar ",		 "saltar ",			 "saltar ",			 "saltar ",					 "saltar ",					 "saltar ",					 "sacar ", 		 "saltar ",				"saltar ",					"saltar "},
	/*dec  		 1*/	{ "ç ",						 "saltar ",			 "saltar ",			 "saltar ",		 "saltar ",			 "saltar ",			 "saltar ",		 "saltar ",		 "saltar ",		 "saltar ", 	 "saltar ",		 "saltar ",		 "saltar ",		 "saltar ",		 "saltar ",		 "saltar ",		 "saltar ",		 "saltar ",		 "saltar ",			 "saltar ",			 "saltar ",			 "saltar ",			 "ç ",									 "saltar ",								 "saltar ",							 "saltar ",					 "saltar ",		"saltar ",		 "saltar ",		 "saltar ",				 "saltar ",								 "int id sigid ; dec ",	 	 "float id sigid ; dec ",		 "char id sigid ; dec ",		 "string id sigid ; dec ",		 "boolean id sigid ; dec ",				 "ç ",							 "ç ",								 "saltar ",				 "saltar ",												 "saltar ",											 "ç ",			 "saltar ",			 "ç ",				 "saltar ",					 "saltar ",					 "saltar ",					 "sacar ", 		 "saltar ",				"saltar ",					"saltar " },
	/*sigid		 2*/	{ "saltar ",				 "saltar ",		  	 "saltar ",			 "saltar ",		 "saltar ",			 "saltar ",			 "saltar ",		 "saltar ",		 "saltar ", 	 "saltar ",		 "= E sigid ",	 "saltar ",		 "saltar ",		 "saltar ",		 "saltar ",		 "saltar ",		 "saltar ",		 "saltar ",		 "saltar ",			 "saltar ",			 "saltar ",			 "saltar ",			 "saltar ",								 "saltar ",								 "saltar ",							 "saltar ",					 "saltar ",		"saltar ",		 "saltar ",		 "saltar ",				 "saltar ",									 "ç ",						 "saltar ",						 "saltar ",						 "saltar ",						 "saltar ",							 "saltar ",						 "saltar ",						 ", id siglist ",			 "saltar ",												 "saltar ",											 "saltar ",		 "saltar ",			 "saltar ",			 "saltar ",					 "saltar ",					 "saltar ",					 "sacar ", 		 "ç ",					"saltar ",					"saltar " },
	/*modulos 	 3*/	{ "ç ",						 "saltar ",		 	 "saltar ",			 "saltar ",		 "saltar ",			 "saltar ",			 "saltar ",		 "saltar ",		 "saltar ",		 "saltar ",	 	 "saltar ",		 "saltar ",		 "saltar ",		 "saltar ",		 "saltar ",		 "saltar ",		 "saltar ",		 "saltar ",		 "saltar ",			 "saltar ",			 "saltar ",			 "saltar ",			 "ç ",									 "ç ",									 "ç ",								 "saltar ",					 "saltar ",		"saltar ",		 "saltar ",		 "saltar ",				 "saltar ",									 "ç ",						 "ç ",							 "ç ",							 "ç ",							 "ç ",								 "saltar ",						 "saltar ",							 "saltar ",				 "proc modulos ",										 "fun modulos ",									 "ç ",			 "saltar ",			"saltar ",			 "saltar ",					 "saltar ",					 "saltar ",					 "sacar ", 		 "saltar ",				"saltar ",					"saltar "  },
	/*proc  	 4*/	{ "saltar ",				 "saltar ",		 	 "saltar ",			 "saltar ",		 "saltar ",			 "saltar ",			 "saltar ",		 "saltar ",		 "saltar ",		 "saltar ",		 "saltar ",		 "saltar ",		 "saltar ",		 "saltar ",		 "saltar ",		 "saltar ",		 "saltar ",		 "saltar ",		 "saltar ",			 "saltar ",			 "saltar ",			 "saltar ",			 "saltar ",								 "saltar ",								 "saltar ",							 "saltar ",					 "saltar ",		"saltar ",		 "saltar ",		 "saltar ",				 "saltar ",									 "saltar ",					 "saltar ",						 "saltar ",						 "saltar ",						 "saltar ",							 "saltar ",						 "saltar ",							 "saltar ",		 "method idp ( list-arg ) dec sentencias endm ",				 "saltar ",											 "saltar ",		 "saltar ",			 "saltar ",			 "saltar ",					 "saltar ",					 "saltar ",					 "sacar ", 		 "saltar ",				"saltar ",					"saltar " },
	/*fun		 5*/	{ "saltar ",				 "saltar ",			 "saltar ",			 "saltar ",		 "saltar ",			 "saltar ",			 "saltar ",		 "saltar ",		 "saltar ",		 "saltar ",		 "saltar ",		 "saltar ",		 "saltar ",		 "saltar ",		 "saltar ",		 "saltar ",		 "saltar ",		 "saltar ",		 "saltar ",			 "saltar ",			 "saltar ",			 "saltar ",			 "saltar ",								 "saltar ",								 "saltar ",							 "saltar ",					 "saltar ",		"saltar ",		 "saltar ",		 "saltar ",				 "saltar ",									 "saltar ",					 "saltar ",						 "saltar ",						 "saltar ",						 "saltar ",							 "saltar ",						 "saltar ",							 "saltar ",				 "saltar ",								 "funtion idf ( list-arg ) : tiporetorno dec sentencias endf ",		 "saltar ",		 "saltar ",			 "saltar ",			 "saltar ",					 "saltar ",					 "saltar ",					 "sacar ", 		 "saltar ",				"saltar ",					"saltar "  }, 
	/*tipor?etorno   6*/{ "saltar ",				 "saltar ",			 "saltar ",			 "saltar ",		 "saltar ",			 "saltar ",			 "saltar ",		 "saltar ",		 "saltar ",		 "saltar ",		 "saltar ",		 "saltar ",		 "saltar ",		 "saltar ",		 "saltar ",		 "saltar ",		 "saltar ",		 "saltar ",		 "saltar ",			 "saltar ",			 "saltar ",			 "saltar ",			 "saltar ",								 "saltar ",								 "saltar ",							 "saltar ",					 "saltar ",		"saltar ",		 "saltar ",		 "saltar ",				 "saltar ",									 "int ",					 "float ",						 "char ",						 "string ",						 "boolean ",						 "saltar ",						 "saltar ",							 "saltar ",				 "saltar ",												 "saltar ", 										 "saltar ",		 "saltar ",			 "saltar ",			 "saltar ",					 "saltar ",					 "saltar ",					 "sacar ", 		 "saltar ",				"saltar ",					"saltar " },
	/*list-arg   7 */	{ "saltar ",				 "saltar ",			 "saltar ",			 "ç ",			 "saltar ",			 "saltar ",			 "saltar ",		 "saltar ",		 "saltar ",		 "saltar ",		 "saltar ",		 "saltar ",		 "saltar ",		 "saltar ",		 "saltar ",		 "saltar ",		 "saltar ",		 "saltar ",		 "saltar ",			 "saltar ",			 "saltar ",			 "saltar ",			 "saltar ",								 "saltar ",								 "saltar ",							 "saltar ",					 "saltar ",		"saltar ",		 "saltar ",		 "saltar ",				 "saltar ",								"int id siglist ",			 "float id siglist ",			 "char id siglist ",			 "string id siglist ",			 "boolean id siglist ",				 	"saltar ",						 "saltar ",							 "saltar ",				 "saltar ",												 "saltar ",											 "saltar ",		 "saltar ",			 "saltar ",			 "saltar ",					 "saltar ",					 "saltar ",					 "sacar ", 	 	 "ç ",					"saltar ",					"saltar " },
	/*siglist  		8*/	{ "saltar ",				 "saltar ",			 "saltar ",			 "ç ",			 "saltar ",			 "saltar ",			 "saltar ",		 "saltar ",		 "saltar ",		 "saltar ",		 "saltar ",		 "saltar ",		 "saltar ",		 "saltar ",		 "saltar ",		 "saltar ",		 "saltar ",		 "saltar ",		 "saltar ",			 "saltar ",			 "saltar ",			 "saltar ",			 "saltar ",								 "saltar ",								 "saltar ",							 "saltar ",					 "saltar ",		"saltar ",		 "saltar ",		 "saltar ",				 "saltar ",									 "saltar ",					 "saltar ",						 "saltar ",						 "saltar ",						 "saltar ",							 "saltar ",						 "saltar ",							 ", list-arg ",			 "saltar ",												 "saltar ",											 "saltar ",		 "saltar ",			 "saltar ",			 "saltar ",				  	 "saltar ",					 "saltar ",					 "sacar ", 		 "ç ",					"saltar ",					"saltar " },		
	/*list-param  9*/	{ "L sig-param ",			 "L sig-param ",	 "L sig-param ",	 "ç ",			 "L sig-param ",	 "L sig-param ",	 "saltar ",		 "saltar ",		 "saltar ",		 "saltar ",		 "saltar ",		 "saltar ",		 "saltar ",		 "saltar ",		 "saltar ",		 "saltar ",		 "saltar ",		 "saltar ",		 "saltar ",			 "saltar ",			 "L sig-param ",	 "L sig-param ",	 "saltar ",								 "saltar ",								 "saltar ",							 "saltar ",					 "saltar ",		"saltar ",		 "saltar ",		 "saltar ",				 "saltar ",									 "saltar ",					 "saltar ",						 "saltar ",						 "saltar ",						 "saltar ",							 "saltar ",						 "saltar ",							 "saltar ",				 "saltar ",												 "saltar ",											 "saltar ",		 "saltar ",			 "saltar ",			 "saltar ",					 "L sig-param ",			 "saltar ",					 "sacar ", 		 "saltar ",				"saltar ",					"saltar "  },
	/*sig-param  10*/	{ "saltar ",				 "saltar ",			 "saltar ",			 "ç ",			 "saltar ",			 "saltar ",			 "saltar ",		 "saltar ",		 "saltar ",		 "saltar ",		 "saltar ",		 "saltar ",		 "saltar ",		 "saltar ",		 "saltar ",		 "saltar ",		 "saltar ",		 "saltar ",		 "saltar ",			 "saltar ",			 "saltar ",			 "saltar ",			 "saltar ",								 "saltar ",								 "saltar ",							 "saltar ",					 "saltar ",		"saltar ",		 "saltar ",		 "saltar ",				 "saltar ",									 "saltar ",					 "saltar ",						 "saltar ",						 "saltar ",						 "saltar ",							 "saltar ",						 "saltar ",						 ", L sig-param ",			 "saltar ",												 "saltar ",											 "saltar ",		 "saltar ",			 "saltar ",			 "saltar ",					 "saltar ",					 "saltar ",					 "sacar ", 		 "saltar ",				"saltar ",					"saltar "  },
	/*sentencias  11*/	{ "sentencia sentencias ",	 "saltar ", 		 "saltar ",			 "saltar ",		 "saltar ",			 "saltar ",			 "saltar ",		 "saltar ",		 "saltar ",		 "saltar ",		 "saltar ",		 "saltar ",		 "saltar ",		 "saltar ",		 "saltar ",		 "saltar ",		 "saltar ",		 "saltar ",		 "saltar ",			 "saltar ",			 "saltar ",			 "saltar ",		"sentencia sentencias ",				 "sentencia sentencias ",				 "sentencia sentencias ",				 	 "ç ",					 "saltar ",		"saltar ",		 "ç ",			 "ç ",					 "saltar ",									 "saltar ",					 "saltar ",						 "saltar ",						 "saltar ",						 "saltar ",						 "F sentencias ",		 		 "sentencia sentencias ",				 "saltar ",				 "saltar ",												 "saltar ",											 "ç ",			 "ç ",				 "ç ",			 "sentencia sentencias ",	 	 "saltar ",				 "sentencia sentencias ",		 "ç ", 			 "saltar ",			"sentencia sentencias ",			"ç "  },
	/*sentencia   12*/	{ "id = L ; ",				 "saltar ", 		 "saltar ",			 "saltar ",		 "saltar ",			 "saltar ",			 "saltar ",		 "saltar ",		 "saltar ",		 "saltar ",		 "saltar ",		 "saltar ",		 "saltar ",		 "saltar ",		 "saltar ",		 "saltar ",		 "saltar ",		 "saltar ",		 "saltar ",			 "saltar ",			 "saltar ",			 "saltar ",	 "if ( L ) then sentencias sigif endif ", 	"while ( L ) do sentencias endwhile ", "repeat sentencias until ( L ) ; ", 		"saltar ",					 "saltar ",		"saltar ",		 "saltar ",		 "saltar ",				 "saltar ",									 "saltar ",					 "saltar ",						 "saltar ",						 "saltar ",						 "saltar ",							 "saltar ",					 "write ( list-param ) ; ",			 	"saltar ",				 "saltar ",												 "saltar ",											 "saltar ",		 "saltar ",			 "saltar ",		 "idp ( list-param ) ; ",		 "saltar ",					 "return L ; ",				 "sacar ", 		 "saltar ",			"call id ( L sig-param ) ; ",	"saltar "  },
	/*sigif      13*/	{ "saltar ",				 "saltar ", 			 "saltar ", 		 "saltar ",		 "saltar ",			 "saltar ",			 "saltar ",		 "saltar ",		 "saltar ",		 "saltar ",		 "saltar ",		 "saltar ",		 "saltar ",		 "saltar ",		 "saltar ",		 "saltar ",		 "saltar ",		 "saltar ",		 "saltar ",			 "saltar ",			 "saltar ",			 "saltar ",			 "saltar ",								 "saltar ",								 "saltar ", 					 "else sentencias ",			 "saltar ",		"saltar ",		 "ç ",			 "saltar ",				 "saltar ",									 "saltar ",					 "saltar ",						 "saltar ",						 "saltar ",						 "saltar ",							 "saltar ",						 "saltar ",							 "saltar ",				 "saltar ",												 "saltar ",											 "saltar ",		 "saltar ",			 "ç ",				 "saltar ",					 "saltar ",					 "saltar ",					 "ç ", 			 "saltar ",				"saltar ",					"saltar "  },
	/*L        14*/		{ "R L’ ",					 "R L’ ",			 "R L’ ",			 "ç ",			 "R L’ ",			 "R L’ ",			 "saltar ",		 "saltar ",		 "saltar ",		 "saltar ",		 "saltar ",		 "saltar ",		 "saltar ",		 "saltar ",		 "saltar ",		 "saltar ",		 "saltar ",		 "R L’ ",		 "saltar ",			 "saltar ",			 "R L’ ",			 "R L’ ",			 "saltar ",								 "saltar ",								 "saltar ",							 "saltar ",					 "saltar ",		"saltar ",		 "saltar ",		 "saltar ",				 "saltar ",									 "saltar ",					 "saltar ",						 "saltar ",						 "saltar ",						 "saltar ",							 "saltar ",						 "saltar ",							 "saltar ",				 "saltar ",												 "saltar ",											 "saltar ",		 "saltar ",			 "saltar ",			 "saltar ",					 "R L’ ",					 "saltar ",					 "ç ", 			 "saltar ",				"R L’ ",					"saltar "  },
	/*L’		15*/	{ "saltar ", 				 "saltar ",			 "saltar ",			 "ç ",			 "saltar ",			 "saltar ",			 "ç ",			 "ç ",			 "ç ",			 "ç ",			 "saltar ",		 "ç ",			 "ç ",			 "ç ",			 "ç ",			 "ç ",			 "ç ",			 "saltar ",		 "& R L’ ",			 "| R L’ ",			 "saltar ",			 "saltar ",			 "saltar ",								 "saltar ",								 "saltar ",							 "saltar ",					 "ç ",			"ç ",			 "saltar ",		 "saltar ",				 "saltar ",									 "saltar ",					 "saltar ",						 "saltar ",						 "saltar ",						 "saltar ",							 "saltar ",						 "saltar ",							 "ç ",					 "saltar ",												 "saltar ",											 "saltar ",		 "saltar ",			 "saltar ",			 "saltar ",					 "saltar ",					 "saltar ",					 "ç ", 			 "ç ",					"saltar ",					"saltar "  },
	/*R			16*/	{ "E R’ ",					 "E R’ ",			 "E R’ ",			 "saltar ",		 "E R’ ",			 "E R’ ",			 "saltar ",		 "saltar ",		 "saltar ",		 "saltar ",		 "saltar ",		 "saltar ",		 "saltar  ",	 "saltar ",		 "saltar ",		 "saltar ",		 "saltar ",		 "E R’ ",		 "ç ",				 "ç ",				 "E R’ ",			 "E R’ ",			 "saltar ",								 "saltar ",								 "saltar ",							 "saltar ",					 "ç ",			"ç ",			 "saltar ",		 "saltar ",				 "saltar ",									 "saltar ",					 "saltar ",						 "saltar ",						 "saltar ",						 "saltar ",							 "saltar ",						 "saltar ",							 "saltar ",				 "saltar ",												 "saltar ",											 "saltar ",		 "saltar ",			 "saltar ",			 "saltar ",					 "E R’ ",					 "saltar ",					 "ç ",	 		 "saltar ",				"E R’ ",					"saltar "  },
	/*R’		17*/	{ "saltar ",				 "saltar ",			 "saltar ",			 "ç ",			 "saltar ",			 "saltar ",			 "ç ",			 "ç ",			 "ç ",			 "ç ",			 "saltar ",		 "< E ",		 "> E ",		 "meniq E ",	 "mayiq E ",	 "dif E ",		 "igual E ",	 "saltar ",		 "ç ",				 "ç ",				 "saltar ",			 "saltar ",			 "saltar ",								 "saltar ",								 "saltar ",							 "saltar ",					 "ç ",			"ç ",			 "saltar ",		 "saltar ",				 "saltar ",									 "saltar ",					 "saltar ",						 "saltar ",						 "saltar ",						 "saltar ",							 "saltar ",						 "saltar ",							 "ç ",					 "saltar ",												 "saltar ",											 "saltar ",		 "saltar ",			 "saltar ",			 "saltar ",					 "saltar ",					 "saltar ",					 "ç ", 			 "ç ",					"saltar ",					"saltar "  },
	/*E			18*/	{ "T E’ ",					 "T E’ ",			 "T E’ ",			 "saltar ",		 "T E’ ",			 "T E’ ",			 "saltar ",		 "saltar ",		 "saltar ",		 "saltar ",	 	 "saltar ",		 "saltar ",		 "saltar ",		 "saltar ",		 "saltar ",		 "saltar ",		 "saltar ",		 "T E’ ",		 "saltar ",			 "saltar ",			 "T E’ ",			 "T E’ ",			 "saltar ",								 "saltar ",								 "saltar ",							 "saltar ",					 "saltar ",		"saltar ",		 "saltar ",		 "saltar ",				 "saltar ",									 "saltar ",					 "saltar ",						 "saltar ",						 "saltar ",						 "saltar ",							 "saltar ",						 "saltar ",							 "saltar ",				 "saltar ",												 "saltar ",											 "saltar ",		 "saltar ",			 "saltar ",			 "saltar ",					 "T E’ ",					 "saltar ",					 "sacar ",	 	 "saltar ",				"T E’ ",					"saltar "  },
	/*E’		19*/	{ "saltar ",				 "saltar ",			 "saltar ",			 "ç ", 			"saltar ",			 "saltar ",			 "+ T E’ ",   	"- T E’ ",			"ç ",			 "ç ",		" saltar ",		 "ç ",			 "ç ",			 "ç ",			 "ç ",			 "ç ",			 "ç",			 "saltar ",		 "ç ",				 "ç ",				 "saltar ",			 "saltar ",			 "saltar ",								 "saltar ",								 "saltar ",							 "saltar ",					 "ç ",			"ç ",			 "saltar ",		 "saltar ",				 "saltar ",									 "saltar ",					 "saltar ",						 "saltar ",						 "saltar ",						 "saltar ",							 "saltar ",						 "saltar ",							 "ç ",					 "saltar ",												 "saltar ",											 "saltar ",		 "saltar ",			 "saltar ",			 "saltar ",					 "saltar ",					 "saltar ",					 "ç ",	 		 "ç ",					"saltar ",					"saltar "  },
	/*T			20*/	{ "F T’ ", 					 "F T’ ",			 "F T’ ",			 "saltar ",		 "F T’ ",			 "F T’ ",			 "saltar ",		 "saltar ",		 "saltar ",		 "saltar ",		 "saltar ",		 "saltar ",		 "saltar ",		 "saltar ",		 "saltar ",		 "saltar ",		 "saltar ",		 "F T’ ",		 "saltar ",			 "saltar ",			 "F T’ ",			 "F T’ ",			 "saltar ",								 "saltar ", 							 "saltar ",							 "saltar ",					 "saltar ",		"saltar ",		 "saltar ",		 "saltar ",				 "saltar ",									 "saltar ",					 "saltar ",						 "saltar ",						 "saltar ",						 "saltar ",							 "saltar ",						 "saltar ",							 "saltar ",				 "saltar ",												 "saltar ",											 "saltar ",		 "saltar ",			 "saltar ",			 "saltar ",					 "F T’ ",					 "saltar ",					 "sacar ", 		 "saltar ",				"F T’ ",					"saltar "  },
	/*T’		21*/	{ "saltar ",				 "saltar ",			 "saltar ",			 "ç ",			 "saltar ",			 "saltar ",			 "ç ",			 "ç ",			 "* F T’ ",		 "/ F T’ ",		 "saltar ",		 "ç ",			 "ç ",			 "ç ",			 "ç ",			 "ç ", 			 "ç ",			 "saltar ",		 "ç ",				 "ç ",				 "saltar ",			 "saltar ",			 "saltar ",								 "saltar ",								 "saltar ",							 "saltar ",					 "ç ",			"ç ",			 "saltar ",		 "saltar ",				 "saltar ",									 "saltar ",					 "saltar ",					 	 "saltar ",						 "saltar ",						 "saltar ",						 	 "saltar ",						 "saltar ",						 	 "ç ",					 "saltar ",												 "saltar ",											 "saltar ",		 "saltar ",			 "saltar ",			 "saltar ",			 		 "saltar ",					 "saltar ",					 "ç ",	 	 	 "ç ",					"saltar ",					"saltar "  },
	/*F			22*/	{ "id ",					 "num ",			 "( L ) ",			 "saltar ",		 "litcad ",			 "litcar ",			 "saltar ",		 "saltar ",		 "saltar ",		 "saltar ",		 "saltar ",		 "saltar ",		 "saltar ",		 "saltar ",		 "saltar ",		 "saltar ",		 "saltar ",		 "! L ",		 "saltar ",			 "saltar ",			 "true ",			 "false ",			 "saltar ",								 "saltar ",								 "saltar ",							 "saltar ",					 "saltar ",		"saltar ",		 "saltar ",		 "saltar ",				 "saltar ",									 "saltar ",					 "saltar ",						 "saltar ",						 "saltar ",						 "saltar ",						 "read ( list-param ) ; ",			 "saltar ",							 "saltar ",				 "saltar ",												 "saltar ",											 "saltar ",		 "saltar ",			 "saltar ",			 "saltar ",				 "idf ( list-param ) ",			 "saltar ",					 "sacar ", 		 "saltar ",			"call id ( L sig-param ) ",		"saltar "  },
	/*$			23*/	{ "saltar ",				 "saltar ",			 "saltar ",			 "saltar ",		 "saltar ",			 "saltar ",			 "saltar ",		 "saltar ",		 "saltar ",		 "saltar ",		 "saltar ",		 "saltar ",		 "saltar ",		 "saltar ",		 "saltar ",		 "saltar ",		 "saltar ",		 "saltar ",		 "saltar ",			 "saltar ",			 "saltar ",			 "saltar ",			 "saltar ",								 "saltar ",								 "saltar ",							 "saltar ",					 "saltar ",		"saltar ",		 "saltar ",		 "saltar ",				 "saltar ",									 "saltar ",					 "saltar ",						 "saltar ",						 "saltar ",						 "saltar ",							 "saltar ",						 "saltar ",							 "saltar ",				 "saltar ",												 "saltar ",											 "saltar ",		 "saltar ",			 "saltar ",			 "saltar ",					 "saltar ",					 "saltar ",					 "aceptar ", 	 "saltar ",				"saltar ",					"saltar "  } };
        