package entity;

public class User {

    private String name;
    private String email;
    private Integer age;
    private String mobileNo;


    public User(String name, String email, Integer age, String mobileNo) {
        this.name = name;
        this.email = email;
        this.age = age;
        this.mobileNo = mobileNo;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public Integer getAge() {
        return age;
    }

    public String getMobileNo() {
        return mobileNo;
    }
}
