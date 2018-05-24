package entity;

import java.util.Date;

/**
 * 用户实体
 * @author 李恒
 *
 */
public class User  implements java.io.Serializable {


    // Fields    

     private Integer id;
     private String username;
     private String password;
     private String phone;
     private Date createDate;
     private String status;


    // Constructors

    /** default constructor */
    public User() {
    }

    
    /** full constructor */
    public User(String username, String password, String phone, Date createDate, String status) {
        this.username = username;
        this.password = password;
        this.phone = phone;
        this.createDate = createDate;
        this.status = status;
    }

   
    // Property accessors

    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return this.username;
    }
    
    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return this.password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return this.phone;
    }
    
    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Date getCreateDate() {
        return this.createDate;
    }
    
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getStatus() {
        return this.status;
    }
    
    public void setStatus(String status) {
        this.status = status;
    }
   








}