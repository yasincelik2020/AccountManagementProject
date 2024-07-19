package pojos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class UserServiceResponsePojo {
    private Boolean is_active;
    private String subscription_id;
    private String password;
    private Long organization_id;
    private Integer default_role_id;
    private Integer id;
    private Integer app_id;
    private String email;
    private String username;
    private Status status;
    private Integer created_by;
    private Integer status_id;

    public UserServiceResponsePojo() {
    }

    public Integer getStatus_id() {
        return status_id;
    }

    public void setStatus_id(Integer status_id) {
        this.status_id = status_id;
    }

    public Integer getCreated_by() {
        return created_by;
    }

    public void setCreated_by(Integer created_by) {
        this.created_by = created_by;
    }

    @Override
    public String toString() {
        return "UserServiceResponsePojo{" +
                "is_active=" + is_active +
                ", subscription_id='" + subscription_id + '\'' +
                ", password='" + password + '\'' +
                ", organization_id=" + organization_id +
                ", default_role_id=" + default_role_id +
                ", id=" + id +
                ", app_id=" + app_id +
                ", email='" + email + '\'' +
                ", username='" + username + '\'' +
                ", status=" + status +
                '}';
    }

    public Boolean getIs_active() {
        return is_active;
    }

    public void setIs_active(Boolean is_active) {
        this.is_active = is_active;
    }

    public String getSubscription_id() {
        return subscription_id;
    }

    public void setSubscription_id(String subscription_id) {
        this.subscription_id = subscription_id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Long getOrganization_id() {
        return organization_id;
    }

    public void setOrganization_id(Long organization_id) {
        this.organization_id = organization_id;
    }

    public Integer getDefault_role_id() {
        return default_role_id;
    }

    public void setDefault_role_id(Integer default_role_id) {
        this.default_role_id = default_role_id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getApp_id() {
        return app_id;
    }

    public void setApp_id(Integer app_id) {
        this.app_id = app_id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
