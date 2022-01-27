public class analisador {

  /*
   * Documentação
   * Identificadores de variável: A-Z, a-z, 0-9
   * Operadores: +,-,*,/, =
   * Delimitadores: ;, {, }, (, )
   * Palavras reservadas: int, if, else, while
   */
  public void an_lexico(String y) {

    String x = y;
    String[] vetor_split;
    vetor_split = x.split(" ");
    String[] vetor_identificador = x.split(" ");

    for (int i = 0; i < vetor_split.length; i++) {

      String aux;
      aux = vetor_split[i];

      // Validações das palavras reservadas: int, if, else, while

      if (aux.charAt(0) == 'i') { // validação p. reservada -> IF e INT
        if (aux.length() == 1) {
          vetor_identificador[i] = "identificador de variável";
        } else if (aux.charAt(1) == 'f' && aux.length() == 2) {
          vetor_identificador[i] = "palavra reservada";
        } else if (aux.charAt(1) == 'n') {
          if (aux.length() == 2) {
            vetor_identificador[i] = "identificador de variável";
          } else if (aux.charAt(2) == 't' && aux.length() == 3) {
            vetor_identificador[i] = "palavra reservada";
          } else {
            vetor_identificador[i] = "identificador de variável";
          }

        } else {
          vetor_identificador[i] = "identificador de variável";
        }

      } else if (aux.charAt(0) == 'e' && aux.length() == 4) { // validação p. reservada -> ELSE
        if (aux.charAt(1) == 'l') {
          if (aux.charAt(2) == 's') {
            if (aux.charAt(3) == 'e') { // verifica se a p. reservada ELSE
              vetor_identificador[i] = "palavra reservada";
            } else {
              vetor_identificador[i] = "identificador de variável";
            }
          } else {
            vetor_identificador[i] = "identificador de variável";
          }
        } else {
          vetor_identificador[i] = "identificador de variável";
        }
      } else if (aux.charAt(0) == 'w' && aux.length() == 5) { // validação p. reservada -> WHILE
        if (aux.charAt(1) == 'h') {
          if (aux.charAt(2) == 'i') {
            if (aux.charAt(3) == 'l') {
              if (aux.charAt(4) == 'e') {
                vetor_identificador[i] = "palavra reservada";
              } else {
                vetor_identificador[i] = "identificador de variável";
              }
            } else {
              vetor_identificador[i] = "identificador de variável";
            }
          } else {
            vetor_identificador[i] = "identificador de variável";
          }
        } else {
          vetor_identificador[i] = "identificador de variável";
        }
        // Validação dos operadores: +, -, *, /, =
      } else if (aux.charAt(0) == '+' && aux.length() == 1) { // validação operador -> +
        vetor_identificador[i] = "operador de soma";
      } else if (aux.charAt(0) == '+' && aux.length() > 1) {
        vetor_identificador[i] = "operador inválido";
      } else if (aux.charAt(0) == '-' && aux.length() == 1) { // validação operador -> -
        vetor_identificador[i] = "operador de subtração";
      } else if (aux.charAt(0) == '-' && aux.length() > 1) {
        vetor_identificador[i] = "operador inválido";
      } else if (aux.charAt(0) == '*' && aux.length() == 1) { // validação operador -> *
        vetor_identificador[i] = "operador de multiplicação";
      } else if (aux.charAt(0) == '*' && aux.length() > 1) {
        vetor_identificador[i] = "operador inválido";
      } else if (aux.charAt(0) == '/' && aux.length() == 1) { // validação operador -> /
        vetor_identificador[i] = "operador de divisão";
      } else if (aux.charAt(0) == '/' && aux.length() > 1) {
        vetor_identificador[i] = "operador inválido";
      } else if (aux.charAt(0) == '=' && aux.length() == 1) { // validação operador -> =
        vetor_identificador[i] = "operador de atribuição";
      } else if (aux.charAt(0) == '=' && aux.length() > 1) {
        vetor_identificador[i] = "operador inválido";

        // Validação dos delimitadores: ;, (, ), {, }
      } else if (aux.charAt(0) == ';' && aux.length() == 1) { // validação delimitador -> ;
        vetor_identificador[i] = "delimitador";
      } else if (aux.charAt(0) == ';' && aux.length() > 1) {
        vetor_identificador[i] = "delimitador inválido";
      } else if (aux.charAt(0) == '{' && aux.length() == 1) { // validação delimitador -> {
        vetor_identificador[i] = "delimitador";
      } else if (aux.charAt(0) == '{' && aux.length() > 1) {
        vetor_identificador[i] = "delimitador inválido";
      } else if (aux.charAt(0) == '}' && aux.length() == 1) { // validação delimitador -> }
        vetor_identificador[i] = "delimitador";
      } else if (aux.charAt(0) == '}' && aux.length() > 1) {
        vetor_identificador[i] = "delimitador inválido";
      } else if (aux.charAt(0) == '(' && aux.length() == 1) { // validação delimitador -> (
        vetor_identificador[i] = "delimitador";
      } else if (aux.charAt(0) == '(' && aux.length() > 1) {
        vetor_identificador[i] = "delimitador inválido";
      } else if (aux.charAt(0) == ')' && aux.length() == 1) { // validação delimitador -> )
        vetor_identificador[i] = "delimitador";
      } else if (aux.charAt(0) == ')' && aux.length() > 1) {
        vetor_identificador[i] = "delimitador inválido";

        // Validação do Identificador de variável
      } else if (!Character.isAlphabetic((aux.charAt(0))) && Character.isAlphabetic((aux.charAt(aux.length() - 1)))) {
        vetor_identificador[i] = "constante inválida"; // o ID é inválido se começar c/ caractere diferente de
                                                       // alphabetic
      } else if (Character.isAlphabetic((aux.charAt(0))) | Character.isAlphabetic((aux.charAt(aux.length() - 1)))) {
        vetor_identificador[i] = "identificador de variável"; // o ID é válido se possuir letras
      } else if (aux.matches("[0-9]+")) { // Valida as constantes inteiras
        try {
          int number = Integer.parseInt(aux); // analisa se na string há um nº e se for um inteiro, ele é convertido e
                                              // validado
          vetor_identificador[i] = "constante int";
        } catch (NumberFormatException ex) {
          vetor_identificador[i] = "constante inválida"; // se não for inteiro, é inválido
        }
      }
    }
    System.out.println("");
    for (int s = 0; s < vetor_split.length; s++) {
      System.out.println(vetor_split[s] + " -> " + vetor_identificador[s]);
    }

  }
}
