public class verificador {

    public String verificador(int num)
    {
        if (num < 21)
        {
            return "Menor";
        }
        if (num > 21)
        {
            return "Perdiste";
        }
        if (num == 21)
        {
            return "Ganaste";
        }

        return "Menor";
    }




}
