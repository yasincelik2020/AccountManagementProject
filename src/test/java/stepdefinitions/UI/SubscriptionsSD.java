package stepdefinitions.UI;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.ProfilePage;
import pages.SubscriptionsPage;
import utilities.ReusableMethods;

import static org.junit.Assert.assertTrue;
import static utilities.ReusableMethods.JavascriptUtils.getTextByText;
import static utilities.ReusableMethods.JavascriptUtils.getTextByValue;

public class SubscriptionsSD extends ReusableMethods {
    SubscriptionsPage subscriptionsPage = new SubscriptionsPage();
    ProfilePage profilePage = new ProfilePage();
    @When("Klicken Sie in der Seitenleiste auf das Modul „Meine Abonnements“.")
    public void klickenSieInDerSeitenleisteAufDasModulMeineAbonnements() {
        clickMethod(subscriptionsPage.mySubscriptions);
    }

    @Then("Es wird überprüft, ob die Abonnementkarte angezeigt wird.")
    public void esWirdÜberprüftObDieAbonnementkarteAngezeigtWird() {
        assertTrue(subscriptionsPage.cardBody.isDisplayed());
    }

    @When("Klicken Sie auf die Abonnementkarte")
    public void klickenSieAufDieAbonnementkarte() {
        clickMethod(subscriptionsPage.cardBody);
    }

    @Then("Es wird überprüft,  ob der Name Subscriber der Benutzername ist.")
    public void esWirdÜberprüftObDerNameSubscriberDerBenutzernameIst() {
        getTextByValue(subscriptionsPage.subscriberName,profilePage.usernameBoxForText,"value");

    }

    @Then("Es wird überprüft,  ob Subscription Type Guest Membership ist")
    public void esWirdÜberprüftObSubscriptionTypeGuestMembershipIst() {
        getTextByText(subscriptionsPage.subscriberTo,"Quaspareparts Gateway App");
    }

    @Then("Es wird überprüft,  ob Subscribes To Quaspareparts Gateway App ist")
    public void esWirdÜberprüftObSubscribesToQuasparepartsGatewayAppIst() {
        getTextByText(subscriptionsPage.subscriberType,"Guest Membership");
    }

    @Then("Stellen Sie sicher, dass die Subscription ID lautet")
    public void stellenSieSicherDassDieSubscriptionIDLautet() {
        getTextByText(subscriptionsPage.subscriberID,"5b04d78b-da49-412a-ac3e-01530b416817");
    }
}
