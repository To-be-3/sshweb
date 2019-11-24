package cn.ljb.sshweb.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.*;
import java.util.Date;

//@JsonIgnoreProperties({"department"}) 在实体类上用注解把懒加载的依赖对象忽略掉，只不过在返回给前端的json数据中没有了department这个对象属性
                                        // 另一种方式是在User.hbm.xml中配置，具体看<many-to-one>，这个方式有department
@Entity
public class User {
    private int id;
    @NotEmpty(message = "用户名不能为空")
    private  String username;
    @NotEmpty(message = "密码不能为空")
    private String password;
    @NotNull(message = "部门不能为空")
    private Department department;
    @DecimalMin(value = "1.0")
    @DecimalMax(value = "2.6")
    public Double height;
    @Email
    public String email;

    //SpringMVC支持用注解代替@ initBinder注解及方法:具体看BaseController类
//    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Past
    private Date birthday;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Double getHeight() {
        return height;
    }

    public void setHeight(Double height) {
        this.height = height;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public User() {

    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", department=" + department +
                ", height=" + height +
                ", email='" + email + '\'' +
                ", birthday=" + birthday +
                '}';
    }

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "username")
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Basic
    @Column(name = "password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (id != user.id) return false;
        if (username != null ? !username.equals(user.username) : user.username != null) return false;
        if (password != null ? !password.equals(user.password) : user.password != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (username != null ? username.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        return result;
    }
}
