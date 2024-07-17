package pojos;

public class MembershipTypePojo{
	private Boolean isEnabled;
	private String name;
	private Boolean isIndividualPlan;
	private Integer subscriptionTypeId;
	private Integer id;
	private Integer appId;

	public void setIsEnabled(Boolean isEnabled){
		this.isEnabled = isEnabled;
	}

	public Boolean isIsEnabled(){
		return isEnabled;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public void setIsIndividualPlan(Boolean isIndividualPlan){
		this.isIndividualPlan = isIndividualPlan;
	}

	public Boolean isIsIndividualPlan(){
		return isIndividualPlan;
	}

	public void setSubscriptionTypeId(Integer subscriptionTypeId){
		this.subscriptionTypeId = subscriptionTypeId;
	}

	public Integer getSubscriptionTypeId(){
		return subscriptionTypeId;
	}

	public void setId(Integer id){
		this.id = id;
	}

	public Integer getId(){
		return id;
	}

	public void setAppId(Integer appId){
		this.appId = appId;
	}

	public Integer getAppId(){
		return appId;
	}

	@Override
 	public String toString(){
		return 
			"MembershipTypePojo{" + 
			"is_enabled = '" + isEnabled + '\'' + 
			",name = '" + name + '\'' + 
			",is_individual_plan = '" + isIndividualPlan + '\'' + 
			",subscription_type_id = '" + subscriptionTypeId + '\'' + 
			",id = '" + id + '\'' + 
			",app_id = '" + appId + '\'' + 
			"}";
		}
}
