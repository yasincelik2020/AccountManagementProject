package pojos;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class UserServiceGetBodyPojo02{
	private Boolean is_active;
	private Boolean is_email_verified;
	private String created_at;
	private String membership_created_at;
	private Integer created_by;
	private String subscription_id;
	private Integer status_id;
	private String updated_at;
	private Long organization_id;
	private Integer updated_by;
	private String membership_updated_at;
	private Integer id;
	private String email;
	private String username;

	public Boolean getIs_active() {
		return is_active;
	}

	public void setIs_active(Boolean is_active) {
		this.is_active = is_active;
	}

	public Boolean getIs_email_verified() {
		return is_email_verified;
	}

	public void setIs_email_verified(Boolean is_email_verified) {
		this.is_email_verified = is_email_verified;
	}

	public String getCreated_at() {
		return created_at;
	}

	public void setCreated_at(String created_at) {
		this.created_at = created_at;
	}

	public String getMembership_created_at() {
		return membership_created_at;
	}

	public void setMembership_created_at(String membership_created_at) {
		this.membership_created_at = membership_created_at;
	}

	public Integer getCreated_by() {
		return created_by;
	}

	public void setCreated_by(Integer created_by) {
		this.created_by = created_by;
	}

	public String getSubscription_id() {
		return subscription_id;
	}

	public void setSubscription_id(String subscription_id) {
		this.subscription_id = subscription_id;
	}

	public Integer getStatus_id() {
		return status_id;
	}

	public void setStatus_id(Integer status_id) {
		this.status_id = status_id;
	}

	public String getUpdated_at() {
		return updated_at;
	}

	public void setUpdated_at(String updated_at) {
		this.updated_at = updated_at;
	}

	public Long getOrganization_id() {
		return organization_id;
	}

	public void setOrganization_id(Long organization_id) {
		this.organization_id = organization_id;
	}

	public Integer getUpdated_by() {
		return updated_by;
	}

	public void setUpdated_by(Integer updated_by) {
		this.updated_by = updated_by;
	}

	public String getMembership_updated_at() {
		return membership_updated_at;
	}

	public void setMembership_updated_at(String membership_updated_at) {
		this.membership_updated_at = membership_updated_at;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	@Override
 	public String toString(){
		return 
			"UserServiceGetBodyPojo02{" + 
			"is_active = '" + is_active + '\'' + 
			",is_email_verified = '" + is_email_verified + '\'' + 
			",created_at = '" + created_at + '\'' + 
			",membership_created_at = '" + membership_created_at + '\'' + 
			",created_by = '" + created_by + '\'' + 
			",subscription_id = '" + subscription_id + '\'' + 
			",status_id = '" + status_id + '\'' + 
			",updated_at = '" + updated_at + '\'' + 
			",organization_id = '" + organization_id + '\'' + 
			",updated_by = '" + updated_by + '\'' + 
			",membership_updated_at = '" + membership_updated_at + '\'' + 
			",id = '" + id + '\'' + 
			",email = '" + email + '\'' + 
			",username = '" + username + '\'' + 
			"}";
		}
}
