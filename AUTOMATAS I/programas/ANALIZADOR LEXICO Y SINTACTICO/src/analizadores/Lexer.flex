package analizadores;
import static analizadores.Tokens.*;

%%
%class Lexer
%type Tokens
L=[a-zA-Z_]
D=[0-9]
espacio=[ ,\t,\r]+
espacios=[ ,\t,\r]?
comillas=[\"]+
comillasS=[']+
opAg=[\(,\),\[,\],{,}]
opAr=[*,\+,\-,/,%]
opRe=[<,>]
opLo=[&,|,!]
com=[\,]
SMB=[\!,#,$,%,&,\(,\),*,\+,\,,\-,\.,/,:,;,<,=,>,?,@,\[,\],\^,_,`,{,|,},ç]+

%{
    public String lexeme;
%}
%%

true|
false|
if|
while|
repeat|
else|
then|
do|
endif|
endwhile|
programa|
int|
float|
char|
string|
boolean|
read|
write|
procedimiento|
funcion|
endProcedimiento|
endFuncion|
endPrograma|
idp|
idf|
return {lexeme=yytext(); return Reservada;}

(" "|"\t"|\r)+ {/*Ignore*/}
"//".* {/*Ignore*/}
("/*")({comillas}|{L}|{D}|{espacio}|{SMB}|{comillasS}|{opAg}|{opAr}|{opLo}|{opRe}|"\n")*("*/") {/*Ignore*/}

"<=" {lexeme=yytext(); return Menor_que;}
">=" {lexeme=yytext(); return Mayor_que;}
"==" {lexeme=yytext(); return Igual;}
"!=" {lexeme=yytext(); return Diferente_de;}
"\n" {lexeme=yytext(); return Salto;}
"=" {lexeme=yytext(); return Asignacion;}
";"	{lexeme=yytext(); return Punto_coma;}
":"	{lexeme=yytext(); return Dos_puntos;}

{comillas}({L}|{D}|{espacio}|{SMB})*{comillas} {lexeme=yytext(); return Litcad;}
{comillasS}({L}|{D}){comillasS} {lexeme=yytext(); return Litcar;}
{com} {lexeme=yytext();return Coma;}
{opAg} {lexeme=yytext(); return Agrupacion;}
{opAr} {lexeme=yytext(); return Aritmetico;}
{opLo} {lexeme=yytext(); return Logico;}
{opRe} {lexeme=yytext(); return Relacional;}
{L}({L}|{D})* {lexeme=yytext(); return id;}

("(-"{D}+")")|{D}+ {lexeme=yytext(); return Numero_Entero;}
([1-9][0-9]*|-[1-9][0-9]*|0)\.([0-9]*[1-9]|[0-9]*[1-9]((e|E)(\+|-)[1-9][0-9]*)) {lexeme=yytext(); return Numero_Flotante;}
 . {return ERROR;}
