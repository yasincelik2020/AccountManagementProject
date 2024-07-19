package pojos;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class UserServicePostBodyPojo02 {
	private String subscription_id;
	private Long organization_id;
	private Integer default_role_id;
	private Integer app_id;
	private String email;

	public String getSubscription_id() {
		return subscription_id;
	}

	public void setSubscription_id(String subscription_id) {
		this.subscription_id = subscription_id;
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

	@Override
 	public String toString(){
		return 
			"UserServicePostBodyPojo{" + 
			"subscription_id = '" + subscription_id + '\'' + 
			",organization_id = '" + organization_id + '\'' + 
			",default_role_id = '" + default_role_id + '\'' + 
			",app_id = '" + app_id + '\'' + 
			",email = '" + email + '\'' + 
			"}";
		}
}
