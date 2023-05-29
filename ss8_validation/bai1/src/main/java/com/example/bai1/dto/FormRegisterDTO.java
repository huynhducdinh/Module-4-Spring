package com.example.bai1.dto;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.*;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Date;


public class FormRegisterDTO implements Validator {

    private Integer id;
    @NotBlank(message = "Họ ko được để trống")
    @Size(min = 1, max = 45, message = "Tên có độ dài tối thiểu 5, tối đa 45 ký tự.")
    private String firstName;
    @NotBlank(message = "Tên ko được để trống")
    @Size(min = 1, max = 45, message = "Tên có độ dài tối thiểu 5, tối đa 45 ký tự.")
    private String lastName;
    @NotBlank(message = "Số điện thoại ko được để trống")
    @Pattern(regexp = "^0\\d{9}$", message = "Số điện thoại phải có 10 số,bắt đầu bằng số 0")
    private String phone;
    @NotBlank(message = "Tuổi không được để trống")
    private String age;
    @NotBlank(message = "email không được để trống")
    @Email(message = "Sai định  dạng")
    @Size(min = 5, max = 45, message = "Nhập đúng độ dài của email .5 kí tự trở lên")
    private String email;

    public FormRegisterDTO() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public FormRegisterDTO(Integer id, String firstName, String lastName, String phone, String age, String email) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.age = age;
        this.email = email;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        FormRegisterDTO form = (FormRegisterDTO) target;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        try {
            LocalDate age = LocalDate.parse( form.age, formatter);
            LocalDate now = LocalDate.now();
            int yearOld = Period.between(age, now).getYears();
            if (yearOld < 18) {
                errors.rejectValue("age", "","Tuổi tối thiểu là 18 vui lòng kiểm tra lại");
            }
        } catch (DateTimeParseException e) {
            errors.rejectValue("age", "","Định dạng ngày không hợp lệ, vui lòng kiểm tra lại");
        }
    }
}
