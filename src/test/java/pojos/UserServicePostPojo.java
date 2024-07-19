package pojos;

public class UserServicePostPojo {
    private String subscription_id;
    private String organization_id;
    private String default_role_id;
    private String app_id;
    private String email;

    public String getsubscription_id() {
        return subscription_id;
    }

    public UserServicePostPojo() {
    }

    public void setsubscription_id(String subscription_id) {
        this.subscription_id = subscription_id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getApp_id() {
        return app_id;
    }

    public void setApp_id(String app_id) {
        this.app_id = app_id;
    }

    public String getdefault_role_id() {
        return default_role_id;
    }

    public void setdefault_role_id(String default_role_id) {
        this.default_role_id = default_role_id;
    }

    public String getorganization_id() {
        return organization_id;
    }

    public void setorganization_id(String organization_id) {
        this.organization_id = organization_id;
    }


    @Override
    public String toString(){
        return
                "UserServicePostPojo{" +
                        "subscription_id = '" + subscription_id + '\'' +
                        ",organization_id = '" + organization_id + '\'' +
                        ",default_role_id = '" + default_role_id + '\'' +
                        ",app_id = '" + app_id + '\'' +
                        ",email = '" + email + '\'' +
                        "}";
    }
}
