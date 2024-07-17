package stepdefinitions.API;

import io.cucumber.java.Before;

import static base_urls.Gm3BaseUrl.setSpec;

public class HooksAPI {

    @Before("@Api1")// tüm senoriolar öncesi calisir
    public static void setUp() {
        setSpec();// spec objesi null kalmamasi icin her senorya öncesi cagirilir.



    }
}
