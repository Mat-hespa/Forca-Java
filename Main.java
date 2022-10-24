import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class Main {

    @Test
    public void tracinhosMessageTestError() {
        try {
            Tracinhos tracinhos = new Tracinhos(0);
        } catch (Exception e) {
            assertEquals(e.getMessage(), "Tamanho incorreto!");
        }
    }

    @Test
    public void tracinhosMessageTestNull() {
        try {
            Tracinhos tracinhos = new Tracinhos(null);
        } catch (Exception e) {
            assertEquals(e.getMessage(), "Construtor de copia vazio");
        }
    }

    @Test
    public void tracinhosMessageTestRange() {
        try {
            Tracinhos tracinhos = new Tracinhos(5);
            tracinhos.revele(11, 'a');
        } catch (Exception e) {
            assertEquals(e.getMessage(), "Posicao negativa, ou igual ou maior que o tamanho do texto");
        }
    }

    @Test
    public void tracinhosIsAindaComTracinhosTest() {
        try {
            Tracinhos tracinhos = new Tracinhos(5);
            assertTrue(tracinhos.isAindaComTracinhos());
        } catch (Exception e) {
        }
    }

    @Test
    public void tracinhosMessageTestInvalidPosition() {
        try {
            Tracinhos tracinhos = new Tracinhos(5);
            tracinhos.revele(0, 'a');
        } catch (Exception e) {
            assertEquals(e.getMessage(), "Valor inválido de posição!");
        }
    }

    @Test
    public void tracinhosIsAindaComTracinhosFalseTest() {
        try {
            Tracinhos tracinhos = new Tracinhos(10);
            for (int i = 0; i < 10; i++) {
                tracinhos.revele(i, 'a');
            }
            boolean valor = tracinhos.isAindaComTracinhos();
            assertEquals(valor, false);
        } catch (Exception e) {}
    }

    @Test
    public void tracinhosEqualsTest() {
        try {
            Tracinhos tracinhos = new Tracinhos(5);
            Tracinhos tracinhos2 = new Tracinhos(5);
            assertTrue(tracinhos.equals(tracinhos2));
        } catch (Exception e) {}
    }

    @Test
    public void tracinhosEqualsTestFalse() {
        try {
            Tracinhos tracinhos = new Tracinhos(10);
            Tracinhos tracinhos2 = new Tracinhos(10);
            assertTrue(tracinhos.equals(tracinhos2));
        } catch (Exception e) {}
    }

    @Test
    public void tracinhosToStringTest() {
        try {
            Tracinhos tracinhos = new Tracinhos(10);
            String valor = tracinhos.toString();

            assertEquals(valor, "_ _ _ _ _ _ _ _ _ _ ");
        } catch (Exception e) {}
    }

    @Test
    public void tracinhosEqualsCloneTest() {
        try {
            Tracinhos tracinhos = new Tracinhos(10);
            Tracinhos tracinhos2 = (Tracinhos) tracinhos.clone();
            assertTrue(tracinhos.equals(tracinhos2));
        } catch (Exception e) {}
    }

    @Test
    public void tracinhosCloneTest() {
        try {
            Tracinhos tracinhos = new Tracinhos(5);
            Tracinhos tracinhosCopia = (Tracinhos) tracinhos.clone();

            assertEquals(tracinhos, tracinhosCopia);
        } catch (Exception e) {}
    }

    @Test
    public void controladorDeErrosTestNull() {
        try {
            ControladorDeErros erros = new ControladorDeErros(null);
            
        } catch (Exception e) {
            assertEquals(e.getMessage(), "Construtor de copia vazio");
        }
    }

    @Test
    public void tracinhosHashCodeTest() {
        try {
            Tracinhos tracinhos = new Tracinhos(10);
            int valor = tracinhos.hashCode();

            assertEquals(valor, 678405271);
        } catch (Exception e) {}
    }

    @Test
    public void controladorDeErrosTest() {
        try {
            ControladorDeErros erros = new ControladorDeErros(0);

        } catch (Exception e) {
            assertEquals(e.getMessage(), "Quantidade maxima de erros fornecida nao positiva");
        }
    }

    @Test
    public void controladorDeErrosTestMessage() {
        try {
            ControladorDeErros erros = new ControladorDeErros(2); 

            erros.registreUmErro();
            erros.registreUmErro();
            erros.registreUmErro();
            
        } catch (Exception e) {
            assertEquals(e.getMessage(), "Quantidade maxima de erros ja atingida");
        }
    }

    @Test
    public void controladorDeErrosTestToString() {
        try {
            ControladorDeErros erros = new ControladorDeErros(2); 
            erros.registreUmErro();
            assertEquals(erros.toString(), "1/2");           
        } catch (Exception e) {}
    }

    @Test
    public void controladorDeErrosTestHashCode() {
        try {
            ControladorDeErros erros = new ControladorDeErros(2); 
            erros.registreUmErro();
            assertEquals(erros.hashCode(), 5592);
        } catch (Exception e) {}
    }


    @Test
    public void controladorDeErrosTestClone() {
        try {
            ControladorDeErros erros = new ControladorDeErros(2); 
            ControladorDeErros errosClone = (ControladorDeErros) erros.clone();
            assertTrue(erros.equals(errosClone));
        } catch (Exception e) {}
    }

    @Test
    public void controladorDeLetrasTestIsJaDigitadaFalse() {
        ControladorDeLetrasJaDigitadas controladorDeLetrasJaDigitadas = new ControladorDeLetrasJaDigitadas();

        assertFalse(controladorDeLetrasJaDigitadas.isJaDigitada('A'));
    }

    @Test
    public void controladorDeLetrasTestIsJaDigitada() {
        try {
            ControladorDeLetrasJaDigitadas controladorDeLetrasJaDigitadas = new ControladorDeLetrasJaDigitadas();
            controladorDeLetrasJaDigitadas.registre('C');
            assertTrue(controladorDeLetrasJaDigitadas.isJaDigitada('C'));
        } catch(Exception e){}
    }

    @Test
    public void controladorDeLetrasTestIsJaDigitadaRegistre() {
        try {
            ControladorDeLetrasJaDigitadas controladorDeLetrasJaDigitadas = new ControladorDeLetrasJaDigitadas();
            controladorDeLetrasJaDigitadas.registre('C');
            controladorDeLetrasJaDigitadas.registre('C');
        } catch(Exception e){
            assertEquals(e.getMessage(), "Letra fornecida ja digitada");
        }
    }

    @Test
    public void controladorDeLetrasTestIsJaDigitadaToString() {
        try {
            ControladorDeLetrasJaDigitadas controladorDeLetrasJaDigitadas = new ControladorDeLetrasJaDigitadas();
            controladorDeLetrasJaDigitadas.registre('A');
            controladorDeLetrasJaDigitadas.registre('E');
            controladorDeLetrasJaDigitadas.registre('I');
            controladorDeLetrasJaDigitadas.registre('O');
            assertEquals(controladorDeLetrasJaDigitadas.toString(), "A, E, I, O, ");
        } catch(Exception e) {}
    }

    @Test
    public void controladorDeLetrasTestIsJaDigitadaHashCode() {
        try {
            ControladorDeLetrasJaDigitadas controladorDeLetrasJaDigitadas = new ControladorDeLetrasJaDigitadas();
            controladorDeLetrasJaDigitadas.registre('A');
            controladorDeLetrasJaDigitadas.registre('B');
            assertEquals(controladorDeLetrasJaDigitadas.hashCode(), 2250);
        } catch(Exception e) {}
    }

    @Test
    public void palavraTest() {
        try {
            Palavra palavra = new Palavra("");

        } catch(Exception e) {
            assertEquals(e.getMessage(), "Texto nulo ou vazio");
        }
    }

    @Test
    public void controladorDeLetrasTestIsJaDigitadaClone() {
        ControladorDeLetrasJaDigitadas controladorDeLetrasJaDigitadas = new ControladorDeLetrasJaDigitadas();
        ControladorDeLetrasJaDigitadas controladorDeLetrasJaDigitadas2 = (ControladorDeLetrasJaDigitadas) controladorDeLetrasJaDigitadas.clone();
        assertTrue(controladorDeLetrasJaDigitadas.equals(controladorDeLetrasJaDigitadas2));
    }

    @Test
    public void palavraTestNull() {
        try {
            Palavra palavra = new Palavra(null);

        } catch(Exception e) {
            assertEquals(e.getMessage(), "Texto nulo ou vazio");
        }
    }

    @Test
    public void palavraTestGetQuantidade() {
        try {
            Palavra palavra = new Palavra("TESTE");

            assertEquals(palavra.getQuantidade('T'), 2);
        } catch (Exception e) {}
    }

    @Test
    public void palavraTestGetTamanho() {
        try {
            Palavra palavra = new Palavra("PORTA");

            assertEquals(palavra.getTamanho(), 5);
        } catch (Exception e) {}
    }

    @Test
    public void palavraTestToString() {
        try {
            Palavra palavra = new Palavra("PORTA");

            assertEquals(palavra.toString(), "PORTA");
        } catch (Exception e) {}
    }

    @Test
    public void palavraTestGetPosicaoDaIezimaOcorrencia() {
        try {
            Palavra palavra = new Palavra("TESTE");

            assertEquals(palavra.getPosicaoDaIezimaOcorrencia(2, 'T'), 4);
        } catch (Exception e) {}
    }

    @Test
    public void palavraTestHashCode() {
        try {
            Palavra palavra = new Palavra("TESTE");

            assertEquals(palavra.hashCode(), 79714078);
        } catch (Exception e) {}
    }

    @Test
    public void palavraTestEquals() {
        try {
            Palavra palavra = new Palavra("PORTA");
            Palavra palavra2 = new Palavra("PORTA");

            assertTrue(palavra.equals(palavra2));
        } catch (Exception e) {}
    }

    @Test
    public void palavraTestEqualsFalse() {
        try {
            Palavra palavra = new Palavra("PORTA");
            Palavra palavra2 = new Palavra("PORTAA");

            assertFalse(palavra.equals(palavra2));
        } catch (Exception e) {}
    }

    @Test
    public void palavraTestCompareToFalse() {
        try {
            Palavra palavra = new Palavra("PORTA");
            Palavra palavra2 = new Palavra("PORTAS");

            assertEquals(palavra.compareTo(palavra2), -1);
        } catch (Exception e) {}
    }

    @Test
    public void palavraTestCompareTo() {
        try {
            Palavra palavra = new Palavra("PORTA");
            Palavra palavra2 = new Palavra("PORTA");

            assertEquals(palavra.compareTo(palavra2), 0);
        } catch (Exception e) {}
    }
}
