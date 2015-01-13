package zw.co.noityu.notifyu.entities;


/**
 * Created by Munya on 11/5/2014.
 */
public class User {
    private String userName ;
    private String password ;
    private String firstName ;
    private String lastName ;
    private String userId ;
    private int schoolId ;
    private String schoolName ;
    private String gender ;


    public User() {

    }

    public User(String userName, String password, String userId, int schoolId, String schoolName, String gender) {
        this.userName = userName;
        this.password = password;
        this.userId = userId;
        this.schoolId = schoolId;
        this.schoolName = schoolName;
        this.gender = gender;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public int getSchoolId() {
        return schoolId;
    }

    public void setSchoolId(int schoolId) {
        this.schoolId = schoolId;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
