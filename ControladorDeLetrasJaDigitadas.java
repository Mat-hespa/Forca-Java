import java.sql.Struct;

public class ControladorDeLetrasJaDigitadas implements Cloneable
{
    private String letrasJaDigitadas;

    public ControladorDeLetrasJaDigitadas ()
    {
        this.letrasJaDigitadas = "";
    }

    public boolean isJaDigitada (char letra)
    {
        // percorrer o String this.letrasJaDigitadas e verificar se ele
        // possui a letra fornecida, retornando true em caso afirmativo
        // ou false em caso negativo
        for (int i=0; i<this.letrasJaDigitadas.length(); i++) {
            if (this.letrasJaDigitadas.charAt(i) == letra){
                return true;
            }
        }
        return false;
    }

    public void registre (char letra) throws Exception
    {
		// verifica se a letra fornecida ja foi digitada (pode usar
		// o método this.isJaDigitada, para isso), lancando uma exceção
		// em caso afirmativo.
		// concatena a letra fornecida a this.letrasJaDigitadas.
        if (isJaDigitada(letra)){
            throw new Exception("Letra fornecida já digitada");
        }
        this.letrasJaDigitadas += letra;
    }

    public String toString ()
    {
		// retorna um String com TODAS as letras presentes em
		// this.letrasJaDigitadas separadas por vírgula (,).

        String string = "";
        for (int i=0; i<this.letrasJaDigitadas.length()-1; i++) {
            string += this.letrasJaDigitadas.charAt(i) + ", ";
        }
        return string;
    }

    public boolean equals (Object obj)
    {
        // verificar se this e obj são iguais
        if (this == obj) return true;
        if (obj == null) return false;
        if (this.getClass() != obj.getClass()) return false;

        ControladorDeLetrasJaDigitadas controLetters = (ControladorDeLetrasJaDigitadas) obj;
        if (this.letrasJaDigitadas != controLetters.letrasJaDigitadas) return false;
        return true;
    }

    public int hashCode ()
    {
        // calcular e retornar o hashcode de this
    }

    public ControladorDeLetrasJaDigitadas(
    ControladorDeLetrasJaDigitadas controladorDeLetrasJaDigitadas)
    throws Exception // construtor de cópia
    {
        // copiar c.letrasJaDigitadas em this.letrasJaDigitadas
    }

    public Object clone ()
    {
        // criar uma cópia do this com o construtor de cópia e retornar
    }
}
