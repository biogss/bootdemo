package org.wang.bootdemo.model;

import org.apache.tomcat.util.security.Escape;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * This class was generated by MyBatis Generator.
 * This class corresponds to the database table t_user
 *
 * @mbg.generated do_not_delete_during_merge
 */
@Component
public class User implements Serializable {
    /**
     * Database Column Remarks:
     *   用户编号
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_user.user_id
     *
     * @mbg.generated
     */
    private Integer userId;

    /**
     * Database Column Remarks:
     *   用户名
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_user.user_name
     *
     * @mbg.generated
     */
    private String userName;

    /**
     * Database Column Remarks:
     *   手机号码
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_user.mobile_no
     *
     * @mbg.generated
     */
    private String mobileNo;

    /**
     * Database Column Remarks:
     *   电子邮箱
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_user.email
     *
     * @mbg.generated
     */
    private String email;

    /**
     * Database Column Remarks:
     *   性别 0-女1-男
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_user.sex
     *
     * @mbg.generated
     */
    private String sex;

    /**
     * Database Column Remarks:
     *   身份证号码
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_user.idno
     *
     * @mbg.generated
     */
    private String idno;

    /**
     * Database Column Remarks:
     *   生日 yyyy-mm-dd
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_user.birthday
     *
     * @mbg.generated
     */
    private String birthday;

    /**
     * Database Column Remarks:
     *   创建时间
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_user.create_time
     *
     * @mbg.generated
     */
    private Date createTime;

    /**
     * Database Column Remarks:
     *   更新时间
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_user.update_time
     *
     * @mbg.generated
     */
    private Date updateTime;

    /**
     * Database Column Remarks:
     *   头像
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_user.photo
     *
     * @mbg.generated
     */
    private String photo;

    /**
     * Database Column Remarks:
     *   密码
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_user.password
     *
     * @mbg.generated
     */
    private String password;

    /**
     * Database Column Remarks:
     *   姓名
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_user.name
     *
     * @mbg.generated
     */
    private String name;

    /**
     * Database Column Remarks:
     *   联系地址
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_user.address
     *
     * @mbg.generated
     */
    private String address;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table t_user
     *
     * @mbg.generated
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_user.user_id
     *
     * @return the value of t_user.user_id
     *
     * @mbg.generated
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_user.user_id
     *
     * @param userId the value for t_user.user_id
     *
     * @mbg.generated
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_user.user_name
     *
     * @return the value of t_user.user_name
     *
     * @mbg.generated
     */
    public String getUserName() {
        return userName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_user.user_name
     *
     * @param userName the value for t_user.user_name
     *
     * @mbg.generated
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_user.mobile_no
     *
     * @return the value of t_user.mobile_no
     *
     * @mbg.generated
     */
    public String getMobileNo() {
        return mobileNo;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_user.mobile_no
     *
     * @param mobileNo the value for t_user.mobile_no
     *
     * @mbg.generated
     */
    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_user.email
     *
     * @return the value of t_user.email
     *
     * @mbg.generated
     */
    public String getEmail() {
        return email;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_user.email
     *
     * @param email the value for t_user.email
     *
     * @mbg.generated
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_user.sex
     *
     * @return the value of t_user.sex
     *
     * @mbg.generated
     */
    public String getSex() {
        return sex;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_user.sex
     *
     * @param sex the value for t_user.sex
     *
     * @mbg.generated
     */
    public void setSex(String sex) {
        this.sex = sex;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_user.idno
     *
     * @return the value of t_user.idno
     *
     * @mbg.generated
     */
    public String getIdno() {
        return idno;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_user.idno
     *
     * @param idno the value for t_user.idno
     *
     * @mbg.generated
     */
    public void setIdno(String idno) {
        this.idno = idno;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_user.birthday
     *
     * @return the value of t_user.birthday
     *
     * @mbg.generated
     */
    public String getBirthday() {
        return birthday;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_user.birthday
     *
     * @param birthday the value for t_user.birthday
     *
     * @mbg.generated
     */
    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_user.create_time
     *
     * @return the value of t_user.create_time
     *
     * @mbg.generated
     */
    public Date getCreateTime() {
        if (createTime == null) {
            return null;
        }else {
            return (Date) createTime.clone();
        }

    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_user.create_time
     *
     * @param createTime the value for t_user.create_time
     *
     * @mbg.generated
     */
    public void setCreateTime(Date createTime) {
        if(createTime == null){
            this.createTime = null;
        }else {
            this.createTime = (Date) createTime.clone();
        }

    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_user.update_time
     *
     * @return the value of t_user.update_time
     *
     * @mbg.generated
     */
    public Date getUpdateTime() {
        if (updateTime == null){
            return null;
        }else {
            return (Date) updateTime.clone();
        }

    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_user.update_time
     *
     * @param updateTime the value for t_user.update_time
     *
     * @mbg.generated
     */
    public void setUpdateTime(Date updateTime) {
        if(updateTime == null){
            this.updateTime = null;
        }else{
            this.updateTime = (Date) updateTime.clone();
        }

    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_user.photo
     *
     * @return the value of t_user.photo
     *
     * @mbg.generated
     */
    public String getPhoto() {
        return photo;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_user.photo
     *
     * @param photo the value for t_user.photo
     *
     * @mbg.generated
     */
    public void setPhoto(String photo) {
        this.photo = photo;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_user.password
     *
     * @return the value of t_user.password
     *
     * @mbg.generated
     */
    public String getPassword() {
        return password;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_user.password
     *
     * @param password the value for t_user.password
     *
     * @mbg.generated
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_user.name
     *
     * @return the value of t_user.name
     *
     * @mbg.generated
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_user.name
     *
     * @param name the value for t_user.name
     *
     * @mbg.generated
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_user.address
     *
     * @return the value of t_user.address
     *
     * @mbg.generated
     */
    public String getAddress() {
        return address;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_user.address
     *
     * @param address the value for t_user.address
     *
     * @mbg.generated
     */
    public void setAddress(String address) {
        this.address = address;
    }
}