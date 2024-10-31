package br.com_ifg.infra;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DataUtils {
    private static final String FORMATO_PADRAO = "dd/MM/yyyy HH:mm:ss";

    public static String formatarData(Date data) {
        SimpleDateFormat formatter = new SimpleDateFormat(FORMATO_PADRAO);
        return formatter.format(data);
    }

    public static Date parseData(String dataStr) throws Exception {
        SimpleDateFormat formatter = new SimpleDateFormat(FORMATO_PADRAO);
        return formatter.parse(dataStr);
    }
}