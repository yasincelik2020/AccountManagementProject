package pojos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class UserGroup_CreatePojo {
    private Integer id;
    private Integer user_group_id;
    private Integer user_id;
    private Boolean is_head;

    public UserGroup_CreatePojo() {
    }

    public UserGroup_CreatePojo(Integer id, Integer user_group_id, Integer user_id, Boolean is_head) {
        this.id = id;
        this.user_group_id = user_group_id;
        this.user_id = user_id;
        this.is_head = is_head;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUser_group_id() {
        return user_group_id;
    }

    public void setUser_group_id(Integer user_group_id) {
        this.user_group_id = user_group_id;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public Boolean getIs_head() {
        return is_head;
    }

    public void setIs_head(Boolean is_head) {
        this.is_head = is_head;
    }

    @Override
    public String toString() {
        return "UserGroup_CreatePojo{" +
                "id=" + id +
                ", user_group_id=" + user_group_id +
                ", user_id=" + user_id +
                ", is_head=" + is_head +
                '}';
    }
}
