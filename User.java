public class User {

    private String id;
    private String password;
    private String nickname;

    public User(){}
    public User(String id, String password, String nickname){
        this.id = id;
        this.password = password;
        this.nickname = nickname;

    }

    public String getId() {
        return id;
    }
    public void setid(String id){
        this.id = id;
    }
    public String getPassword(){
        return password;
    }
    public void setPassword(String password){
        this.password = password;
    }
    public String getNickname(){
        return nickname;
    }
    public void setNickname(String nickname){
        this.nickname = nickname;
    }


}