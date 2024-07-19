package pojos;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SubscriptionPojo{
	private Integer organization_seat_occupied;
	private String default_role_name;
	private Boolean is_active;
	private Integer membership_type_id;
	private String membership_type_name;
	private Boolean is_owner;
	private String app_short_name;
	private String organization_name;
	private String subscription_id;
	private String app_name;
	private Integer user_id;
	private Long organization_id;
	private Integer default_role_id;
	private Integer id;
	private Boolean is_individual_membership;
	private Integer app_id;
	private String username;

	public Integer getOrganization_seat_occupied() {
		return organization_seat_occupied;
	}

	public void setOrganization_seat_occupied(Integer organization_seat_occupied) {
		this.organization_seat_occupied = organization_seat_occupied;
	}

	public String getDefault_role_name() {
		return default_role_name;
	}

	public void setDefault_role_name(String default_role_name) {
		this.default_role_name = default_role_name;
	}

	public Boolean getIs_active() {
		return is_active;
	}

	public void setIs_active(Boolean is_active) {
		this.is_active = is_active;
	}

	public Integer getMembership_type_id() {
		return membership_type_id;
	}

	public void setMembership_type_id(Integer membership_type_id) {
		this.membership_type_id = membership_type_id;
	}

	public String getMembership_type_name() {
		return membership_type_name;
	}

	public void setMembership_type_name(String membership_type_name) {
		this.membership_type_name = membership_type_name;
	}

	public Boolean getIs_owner() {
		return is_owner;
	}

	public void setIs_owner(Boolean is_owner) {
		this.is_owner = is_owner;
	}

	public String getApp_short_name() {
		return app_short_name;
	}

	public void setApp_short_name(String app_short_name) {
		this.app_short_name = app_short_name;
	}

	public String getOrganization_name() {
		return organization_name;
	}

	public void setOrganization_name(String organization_name) {
		this.organization_name = organization_name;
	}

	public String getSubscription_id() {
		return subscription_id;
	}

	public void setSubscription_id(String subscription_id) {
		this.subscription_id = subscription_id;
	}

	public String getApp_name() {
		return app_name;
	}

	public void setApp_name(String app_name) {
		this.app_name = app_name;
	}

	public Integer getUser_id() {
		return user_id;
	}

	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
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

	public Boolean getIs_individual_membership() {
		return is_individual_membership;
	}

	public void setIs_individual_membership(Boolean is_individual_membership) {
		this.is_individual_membership = is_individual_membership;
	}

	public Integer getApp_id() {
		return app_id;
	}

	public void setApp_id(Integer app_id) {
		this.app_id = app_id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Override
	public String toString() {
		return "SubscriptionPojo{" +
				"organization_seat_occupied=" + organization_seat_occupied +
				", default_role_name='" + default_role_name + '\'' +
				", is_active=" + is_active +
				", membership_type_id=" + membership_type_id +
				", membership_type_name='" + membership_type_name + '\'' +
				", is_owner=" + is_owner +
				", app_short_name='" + app_short_name + '\'' +
				", organization_name='" + organization_name + '\'' +
				", subscription_id='" + subscription_id + '\'' +
				", app_name='" + app_name + '\'' +
				", user_id=" + user_id +
				", organization_id=" + organization_id +
				", default_role_id=" + default_role_id +
				", id=" + id +
				", is_individual_membership=" + is_individual_membership +
				", app_id=" + app_id +
				", username='" + username + '\'' +
				'}';
	}
}
