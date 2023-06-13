package model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class UserDto {
    private int id;
    private String firstName;
    private String lastName;
    private String maidenName;
    private int age;
    private String gender;
    private String email;
    private String phone;
    private String username;
    private String password;
    private String birthDate;
    private String image;
    private String bloodGroup;
    private int height;
    private double weight;
    private String eyeColor;
    @JsonProperty("hair")
    private HairDto hair;
    private String domain;
    private String ip;
    @JsonProperty("address")
    private AddressDto address;
    private String macAddress;
    private String university;
    @JsonProperty("bank")
    private BankDto bank;
    @JsonProperty("company")
    private CompanyDto company;
    private String ein;
    private String ssn;
    private String userAgent;
}