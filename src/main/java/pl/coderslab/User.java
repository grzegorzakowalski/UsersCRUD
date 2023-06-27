package pl.coderslab;

public class User {
    private int id;
    private String userName;
    private String email;
    private String password;

    private int visible;


    public User(String userName, String email, String password) {
        this.userName = userName;
        this.email = email;
        this.password = password;
        this.id = 0;
        visible = 1;
    }

    public User(int id, String userName, String email, String password) {
        this.id = id;
        this.userName = userName;
        this.email = email;
        this.password = password;
        visible = 1;
    }

    public User(){
        this.userName = null;
        email = null;
        password = null;
        id = 0;
        visible = 0;
    }

    public User(int id, String userName, String email, String password, int visible) {
        this.id = id;
        this.userName = userName;
        this.email = email;
        this.password = password;
        setVisible(visible);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getVisible() {
        return visible;
    }

    public void setVisible(int visible) {
        if( visible > 0 ){
            this.visible = 1;
        } else {
            this.visible = 0;
        }
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", visible=" + visible +
                '}';
    }
}
