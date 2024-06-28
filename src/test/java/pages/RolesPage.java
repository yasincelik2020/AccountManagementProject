package pages;

import org.openqa.selenium.support.PageFactory;
import utilities.ParallelDriver;

public class RolesPage {
    public RolesPage() {
        PageFactory.initElements(ParallelDriver.getDriver(), this);
    }
}
