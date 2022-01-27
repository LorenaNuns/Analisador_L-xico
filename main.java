
/* Documentação
     Identificadores de variável: A-Z, a-z, 0-9
     Operadores: +,-,*,/
     Delimitadores: {}, []
     Palavras reservadas: int, if, else, while
*/
import java.util.Scanner;

public class main {

  public static void main(String[] args) {

    String lexema;
    String[] vetor_split;
    Scanner in = new Scanner(System.in);
    System.out.print("Digite uma frase: ");
    lexema = in.nextLine(); // o nextLine faz a string receber toda a frase e n somente uma palavra

    analisador an = new analisador();
    an.an_lexico(lexema);
  }

}