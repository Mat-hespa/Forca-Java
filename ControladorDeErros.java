public class ControladorDeErros implements Cloneable
{
    private int qtdMax, qtdErr=0;

    public ControladorDeErros (int qtdMax) throws Exception
    {
		// verifica se qtdMax fornecida não é positiva, lançando
		// uma exceção.
		// armazena qtdMax fornecida em this.qtdMax.

        if (qtdMax <= 0) {
            throw new Exception("Quantidade maxima de erros fornecida não positiva");
        }
        this.qtdMax = qtdMax;
    }

    public void registreUmErro () throws Exception
    {
        // verifica se this.qtdErr ja é igual a this.qtdMax,
        // lançando excecao em caso positivo ou
        // incrementando this.qtdErr em caso negativo

        if (this.qtdErr == this.qtdMax) {
            throw new Exception("Quantidade maxima de erros já atingida");
        }
        this.qtdErr += 1;
    }

    public boolean isAtingidoMaximoDeErros  ()
    {
        // returna true se this.qtdErr for igual a this.qtdMax,
        // ou então false, caso contrario.
        if (this.qtdErr == this.qtdMax) {
            return true;
        }
        return false;
    }

    @Override
    public String toString ()
    {
        return this.qtdErr + "/" + this.qtdMax;
    }

    @Override
    public boolean equals (Object obj)
    {
        // verificar se this e obj possuem o mesmo conteúdo, retornando
        // true no caso afirmativo ou false no caso negativo
        if (this == obj) return true;
        if (obj == null) return false;
        if (this.getClass() != obj.getClass()) return false;

        ControladorDeErros controlErrors = (ControladorDeErros) obj;
        if (this.qtdMax != controlErrors.qtdMax) return false;
        if (this.qtdErr != controlErrors.qtdErr) return false;
        return true;
    }

    @Override
    public int hashCode ()
    {
        // calcular e retornar o hashcode de this
    }
    public ControladorDeErros (ControladorDeErros c) throws Exception // construtor de cópia
    {
        // copiar c.qtdMax e c.qtdErr, respectivamente em, this.qtdMax e this.qtdErr
    }

    public Object clone ()
    {
        // returnar uma cópia de this
    }
}
