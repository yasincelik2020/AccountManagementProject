package pojos;

public class UserIdAppIdMembershipGetPojo {
	private String default_role_name;
	private Boolean is_active;
	private Integer membership_type_id;
	private Boolean is_owner;
	private String created_at;
	private String app_short_name;
	private String organization_name;
	private Boolean is_default;
	private Integer created_by;
	private String subscription_id;
	private String app_name;
	private String updated_at;
	private Integer user_id;
	private Long organization_id;
	private Integer updated_by;
	private Integer default_role_id;
	private String app_logo_url;
	private Integer id;
	private Boolean is_individual_membership;
	private String app_id;
	private String username;

	public void setdefault_role_name(String default_role_name){
		this.default_role_name = default_role_name;
	}

	public String getdefault_role_name(){
		return default_role_name;
	}

	public void setis_active(Boolean is_active){
		this.is_active = is_active;
	}

	public Boolean isis_active(){
		return is_active;
	}

	public void setmembership_type_id(Integer membership_type_id){
		this.membership_type_id = membership_type_id;
	}

	public Integer getmembership_type_id(){
		return membership_type_id;
	}

	public void setis_owner(Boolean is_owner){
		this.is_owner = is_owner;
	}

	public Boolean isis_owner(){
		return is_owner;
	}

	public void setcreated_at(String created_at){
		this.created_at = created_at;
	}

	public String getcreated_at(){
		return created_at;
	}

	public void setapp_short_name(String app_short_name){
		this.app_short_name = app_short_name;
	}

	public String getapp_short_name(){
		return app_short_name;
	}

	public void setorganization_name(String organization_name){
		this.organization_name = organization_name;
	}

	public String getorganization_name(){
		return organization_name;
	}

	public void setis_default(Boolean is_default){
		this.is_default = is_default;
	}

	public Boolean isis_default(){
		return is_default;
	}

	public void setcreated_by(Integer created_by){
		this.created_by = created_by;
	}

	public Integer getcreated_by(){
		return created_by;
	}

	public void setsubscription_id(String subscription_id){
		this.subscription_id = subscription_id;
	}

	public String getsubscription_id(){
		return subscription_id;
	}

	public void setapp_name(String app_name){
		this.app_name = app_name;
	}

	public String getapp_name(){
		return app_name;
	}

	public void setupdated_at(String updated_at){
		this.updated_at = updated_at;
	}

	public String getupdated_at(){
		return updated_at;
	}

	public void setuser_id(Integer user_id){
		this.user_id = user_id;
	}

	public Integer getuser_id(){
		return user_id;
	}

	public void setorganization_id(Long organization_id){
		this.organization_id = organization_id;
	}

	public Long getorganization_id(){
		return organization_id;
	}

	public void setupdated_by(Integer updated_by){
		this.updated_by = updated_by;
	}

	public Integer getupdated_by(){
		return updated_by;
	}

	public void setdefault_role_id(Integer default_role_id){
		this.default_role_id = default_role_id;
	}

	public Integer getdefault_role_id(){
		return default_role_id;
	}

	public void setapp_logo_url(String app_logo_url){
		this.app_logo_url = app_logo_url;
	}

	public String getapp_logo_url(){
		return app_logo_url;
	}

	public void setId(Integer id){
		this.id = id;
	}

	public Integer getId(){
		return id;
	}

	public void setis_individual_membership(Boolean is_individual_membership){
		this.is_individual_membership = is_individual_membership;
	}

	public Boolean isis_individual_membership(){
		return is_individual_membership;
	}

	public void setAppId(String app_id){
		this.app_id = app_id;
	}

	public String getAppId(){
		return app_id;
	}

	public void setUsername(String username){
		this.username = username;
	}

	public String getUsername(){
		return username;
	}

	@Override
 	public String toString(){
		return 
			"user_idAppId{" + 
			"default_role_name = '" + default_role_name + '\'' + 
			",is_active = '" + is_active + '\'' + 
			",membership_type_id = '" + membership_type_id + '\'' + 
			",is_owner = '" + is_owner + '\'' + 
			",created_at = '" + created_at + '\'' + 
			",app_short_name = '" + app_short_name + '\'' + 
			",organization_name = '" + organization_name + '\'' + 
			",is_default = '" + is_default + '\'' + 
			",created_by = '" + created_by + '\'' + 
			",subscription_id = '" + subscription_id + '\'' + 
			",app_name = '" + app_name + '\'' + 
			",updated_at = '" + updated_at + '\'' + 
			",user_id = '" + user_id + '\'' + 
			",organization_id = '" + organization_id + '\'' + 
			",updated_by = '" + updated_by + '\'' + 
			",default_role_id = '" + default_role_id + '\'' + 
			",app_logo_url = '" + app_logo_url + '\'' + 
			",id = '" + id + '\'' + 
			",is_individual_membership = '" + is_individual_membership + '\'' + 
			",app_id = '" + app_id + '\'' + 
			",username = '" + username + '\'' + 
			"}";
		}
}
