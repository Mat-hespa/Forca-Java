import org.junit.jupiter.api.Test;



import static org.junit.jupiter.api.Assertions.*;

public class CenariosTest {
/*
    Cenário Jogador perdedor
    nome: perdeJogoTestVazio

    Métodos usados no teste:
    1 - palavra = Palavra("");
    2 - Fim "Texto nulo ou vazio".
  */

  @Test
  public void perdeJogoTestVazio() {
    try {
      Palavra palavra = new Palavra("");
    } catch (Exception e) {
      assertEquals("Texto nulo ou vazio", e.getMessage());
    }
  }


/*
    Cenário perdedor com letras repetidas
    Nome: perdeLetrasRepetidas

    Métodos usados no teste:
    1 - palavra = Palavra("CLASSE");
    2 - palavra.getTamanho();
    3 - new ControladorDeLetrasJaDigitadas();
    4 - new ControladorDeErros((int) (tamanho * 0.6));
    5 - controladorDeErros.isAtingidoMaximoDeErros()
    6 - controladorDeLetrasJaDigitadas.isJaDigitada()
    7 - controladorDeErros.registreUmErro();
    8 - palavra.getQuantidade();
    9 - tracinhos.revele();
    10 - controladorDeLetrasJaDigitadas.registre();
    11 - FIM!
  */

  @Test
  public void perdeLetrasRepetidas() throws Exception {
    try {
      char[] wordLetters = "CLASSE".toCharArray();
      Palavra palavra = new Palavra("CLASSE");
      int tamanho = palavra.getTamanho();
      Tracinhos tracinhos = new Tracinhos(tamanho);
      ControladorDeLetrasJaDigitadas controladorDeLetrasJaDigitadas = new ControladorDeLetrasJaDigitadas();
      ControladorDeErros controladorDeErros = new ControladorDeErros((int) (tamanho * 0.6));
      for (int i = 0; !controladorDeErros.isAtingidoMaximoDeErros(); i++) {
        char letter = wordLetters[i];
        if(controladorDeLetrasJaDigitadas.isJaDigitada(letter)) {
          assertTrue(controladorDeLetrasJaDigitadas.isJaDigitada(letter));
          System.out.println("Letra repetida!");
          controladorDeErros.registreUmErro();
          break;
        }
        else if (palavra.getQuantidade(letter) > 0) tracinhos.revele(i, letter);
        else {
          controladorDeErros.registreUmErro();
        }
        controladorDeLetrasJaDigitadas.registre(letter);
      }
    } catch (Exception e) {
      throw e;
    }
  }
}

