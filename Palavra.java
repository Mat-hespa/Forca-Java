public class Palavra implements Comparable<Palavra>
{
    private String texto;

    public Palavra (String texto) throws Exception
    {
		// verifica se o texto recebido é nulo ou então vazio,
		// ou seja, sem nenhum caractere, lançando exceção.
		// armazena o texto recebido em this.texto.
        if (texto == null || texto == ""){
            throw new Exception("Texto nulo ou vazio");
        }
        this.texto = texto;
    }

    public int getQuantidade (char letra)
    {
        // percorre o String this.texto, conta e retorna
        // quantas letras existem nele iguais a letra fornecida
        byte contador = 0;
        for (int i=0; i<this.texto.length(); i++) {
            if (letra == this.texto.charAt(i)){
                contador += 1;
            }
        }
        return contador;
    }

    public int getPosicaoDaIezimaOcorrencia (int i, char letra) throws Exception
    {
        // se i==0, retorna a posicao em que ocorre a primeira
        // aparicao de letra fornecida em this.texto;
        // se i==1, retorna a posicao em que ocorre a segunda
        // aparicao de letra fornecida em this.texto;
        // se i==2, retorna a posicao em que ocorre a terceira
        // aparicao de letra fornecida em this.texto;
        // e assim por diante.
        // lançar excecao caso nao encontre em this.texto
        // a Iézima aparição da letra fornecida.
        int iAux = i+1;
        int numApair = 0;
        for(int counter=0;i<this.texto.length();counter++){
            if(letra == this.texto.charAt(counter)){
                numApair++;
                if(numApair == iAux) return counter;
            }
        }
        throw new Exception("Letra nao existente!");

    }

    public int getTamanho ()
    {
        return this.texto.length();
    }

    @Override
    public String toString ()
    {
        return this.texto;
    }

    @Override
    public boolean equals (Object obj)
    {
        // verificar se this e obj possuem o mesmo conteúdo, retornando
        // true no caso afirmativo ou false no caso negativo
        if (this == obj) return true;
        if (obj == null) return false;
        if (this.getClass() != obj.getClass()) return false;

        Palavra controlPalavra = (Palavra) obj;
        if (!this.texto.equals(controlPalavra.texto)) return false;
        return true;
    }

    @Override
    public int hashCode ()
    {
        // calcular e retornar o hashcode de this
        int ret = 23;

        ret = 13*ret+ (this.texto).hashCode();  //new String mostra redundancia, por isso esta somente this.texto

        if(ret<0)ret=-ret;

        return ret;
    }

    public int compareTo (Palavra palavra)
    {
        return this.texto.compareTo(palavra.texto);
    }
}
