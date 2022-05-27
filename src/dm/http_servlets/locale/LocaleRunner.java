package dm.http_servlets.locale;

import org.postgresql.core.Encoding;

import java.util.Locale;
import java.util.ResourceBundle;

public class LocaleRunner {
    public static void main(String[] args) {
        Locale locale = new Locale("ru", "RU");
        Locale localeEn = new Locale("en", "EN");
//        Locale.US
        System.out.println(Locale.US);
        System.out.println(Locale.getDefault());

        var translations = ResourceBundle.getBundle("translations");
        System.out.println(translations.getString("page.login.password"));
    }
}
