package Algorithm.Get_started;

import java.math.BigInteger;

public class jiecheng {
    public static void main(String[] args) {
        System.out.println(mul(new BigInteger("100")).toString());
    }

    public static BigInteger mul(BigInteger i) {
        if (i.intValue() > 1) {
            Integer ii = Integer.valueOf(i.intValue() - 1);
            return i.multiply(mul(new BigInteger(ii.toString())));
        }
        return i;
    }
}
