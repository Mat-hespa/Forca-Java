import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class CenariosTest {
  /*
   Cenário vitorioso
   Nome: ganhaJogoTest

   Métodos usados no teste:
   1 - palavra = BancoDePalavras.getPalavraSorteada();
   2 - tamanho = word.getTamanho();
   3 - tracinhos = Tracinhos(size);
   4 - controladorDeLetrasJaDigitadas = ControladorDeLetrasJaDigitadas();
   5 - controladorDeErros = ControladorDeErros(tamanho*0.6);
   6 - Tracinhos.isAindaComTracinhos()
   7 - controladorDeLetrasJaDigitadas.isJaDigitada()
   8 - palavra.getQuantidade()
   9 - palavra.getPosicaoDaIezimaOcorrencia(i, letra);
   10 - tracinhos.revele(posicao, letra);
   11 - controladorDeLetrasJaDigitadas.registre()
   12 - Vence o jogo.
  */

  @Test
  public void ganhaJogoTest() {
    try {
      Palavra palavra = BancoDePalavras.getPalavraSorteada();
      int tamanho = palavra.getTamanho();
      List<Character> removedDuplicatesLetters = GFG.removeDuplicate(palavra.toString().toCharArray(), tamanho);
      Tracinhos tracinhos = new Tracinhos(tamanho);
      ControladorDeLetrasJaDigitadas controladorDeLetrasJaDigitadas = new ControladorDeLetrasJaDigitadas();
      ControladorDeErros controladorDeErros = new ControladorDeErros((int) (tamanho * 0.6));

      for (int i = 0; tracinhos.isAindaComTracinhos(); i++) {
        char letra = removedDuplicatesLetters.get(i);
        if (controladorDeLetrasJaDigitadas.isJaDigitada(letra)) break;
        int qtd = palavra.getQuantidade(letra);
        for (int j = 0; j < qtd; j++) {
          int posicao = palavra.getPosicaoDaIezimaOcorrencia(j, letra);
          tracinhos.revele(posicao, letra);
        }
        controladorDeLetrasJaDigitadas.registre(letra);
      }
      String assertion = "";
      for (int i = 0; i < palavra.getTamanho(); i++) {
        char letra = palavra.toString().charAt(i);
        assertion += letra + " ";
      }
      assertEquals(assertion, tracinhos.toString());
      if (!tracinhos.isAindaComTracinhos() && !controladorDeErros.isAtingidoMaximoDeErros()) {
        System.out.println("Teste encerrado. Jogador venceu!");
      }
    } catch (Exception e) {
      System.out.println(e.toString());
    }
  }

  /*
    Cenário Jogador perdedor
    Nome: perdeJogoTest

    Métodos usados no teste:
    1 - palavra = BancoDePalavras.getPalavraSorteada();
    2 - tamanho = palavra.getTamanho();
    3 - controladorDeLetrasJaDigitadas = ControladorDeLetrasJaDigitadas();
    4 - controladorDeErros = ControladorDeErros(tamanho*0.6);
    5 - GFG.removeDuplicates(palavra, tamanho);
    6 - controladorDeErros.isAtingidoMaximoDeErros()
    7 - palavra.getQuantidade() // garante que nenhuma letra correta foi digitada.
    8 - controladorDeLetrasJaDigitadas.registre()
    9 - controladorDeErros.registreUmErro()
  */

  @Test
  public void perdeJogoTest() throws Exception {
    Character[] alphabet = new Character[26];
    for (int i = 0; i < "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray().length; i++) {
      char[] arr = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
      alphabet[i] = arr[i];
    }
    try {
      Palavra palavra = BancoDePalavras.getPalavraSorteada();
      int tamanho = palavra.getTamanho();
      ControladorDeLetrasJaDigitadas controladorDeLetrasJaDigitadas = new ControladorDeLetrasJaDigitadas();
      ControladorDeErros controladorDeErros = new ControladorDeErros((int) (tamanho * 0.6));

      List<Character> listLetters = GFG.removeDuplicate(palavra.toString().toCharArray(), tamanho);
      Character[] wrongLetters = new Character[alphabet.length - listLetters.size()];
      int index = 0;
      int count = 0;
      while(count < alphabet.length) {
        if(!listLetters.contains(alphabet[count])) {
          wrongLetters[index] = alphabet[count];
          index++;
        }
        count++;
      }

      for (int i = 0; !controladorDeErros.isAtingidoMaximoDeErros(); i++) {
        char letra = wrongLetters[i];
        int qtd = palavra.getQuantidade(letra);
        controladorDeLetrasJaDigitadas.registre(letra);
        assertEquals(0, qtd);
        controladorDeErros.registreUmErro();
      }
      assertTrue(controladorDeErros.isAtingidoMaximoDeErros());
      if (controladorDeErros.isAtingidoMaximoDeErros()) {
        System.out.println("Teste encerrado. Jogador perdeu!");
      }
    } catch (Exception e) {
        throw e;
    }
  }


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
    5 - ctrErros.isAtingidoMaximoDeErros()
    6 - controladorDeLetrasJaDigitadas.isJaDigitada()
    7 - controladorDeErros.registreUmErro();
    8 - palavra.getQuantidade();
    9 - tracinhos.revele();
    10 - ctrLetras.registre();
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

