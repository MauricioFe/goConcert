package util;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;

public class MoedaBrUtil {
    public static final String PORTUGUES = "pt";
    public static final String BRASIL = "br";

    public static String formaMoeda(BigDecimal valor) {
        NumberFormat formatoBR = DecimalFormat.getCurrencyInstance(new Locale(PORTUGUES, BRASIL));
        return formatoBR.format(valor).replace("R$", "R$ ");
    }
}
