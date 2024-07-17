package pojos;

public class PermissionPojo{
	private String resource;
	private String action;
	private Integer id;
	private Integer app_id;

	public void setResource(String resource){
		this.resource = resource;
	}

	public String getResource(){
		return resource;
	}

	public void setAction(String action){
		this.action = action;
	}

	public String getAction(){
		return action;
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

	@Override
 	public String toString(){
		return 
			"PermissionPojo{" + 
			"resource = '" + resource + '\'' + 
			",action = '" + action + '\'' + 
			",id = '" + id + '\'' + 
			",app_id = '" + app_id + '\'' + 
			"}";
		}
}
