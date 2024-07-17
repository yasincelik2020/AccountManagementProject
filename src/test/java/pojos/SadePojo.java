package pojos;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SadePojo{

	private String subscription_id;
	private Integer user_id;
	private Long organization_id;
	private Integer id;
	private Integer app_id;
	private Integer created_by;
	private String username;

	public void setsubscription_id(String subscription_id){
		this.subscription_id = subscription_id;
	}

	public String getsubscription_id(){
		return subscription_id;
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

	public void setId(Integer id){
		this.id = id;
	}

	public Integer getId(){
		return id;
	}

	public void setapp_id(Integer app_id){
		this.app_id = app_id;
	}

	public Integer getapp_id(){
		return app_id;
	}

	public void setcreated_by(Integer created_by){
		this.created_by = created_by;
	}

	public Integer getcreated_by(){
		return created_by;
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
			"SadePojo{" + 
			"subscription_id = '" + subscription_id + '\'' + 
			",user_id = '" + user_id + '\'' + 
			",organization_id = '" + organization_id + '\'' + 
			",id = '" + id + '\'' + 
			",app_id = '" + app_id + '\'' + 
			",created_by = '" + created_by + '\'' + 
			",username = '" + username + '\'' + 
			"}";
		}
}
