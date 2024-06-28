package pages;

import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class RolesPage {
    public RolesPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }
}
