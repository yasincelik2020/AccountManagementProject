package pojos;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class MembershipTypePojo{

	private Boolean is_enabled;
	private String name;
	private Boolean is_individual_plan;
	private Integer subscription_type_id;
	private Integer id;
	private Integer app_id;



	public Boolean getIs_enabled() {
		return is_enabled;
	}

	public void setIs_enabled(Boolean is_enabled) {
		this.is_enabled = is_enabled;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Boolean getIs_individual_plan() {
		return is_individual_plan;
	}

	public void setIs_individual_plan(Boolean is_individual_plan) {
		this.is_individual_plan = is_individual_plan;
	}

	public Integer getSubscription_type_id() {
		return subscription_type_id;
	}

	public void setSubscription_type_id(Integer subscription_type_id) {
		this.subscription_type_id = subscription_type_id;
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

	@Override
	public String toString() {
		return "MembershipTypePojo{" +
				"is_enabled=" + is_enabled +
				", name='" + name + '\'' +
				", is_individual_plan=" + is_individual_plan +
				", subscription_type_id=" + subscription_type_id +
				", id=" + id +
				", app_id=" + app_id +
				'}';
	}
}
