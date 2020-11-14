package model;

public class CustomerModel {

    private String customerid;
    private String phone;
    private String name;
    private String birthday;
    private String address;
    private String email;

    public String getBirthday() {
        return birthday;
    }


    public String getPhone() {
        return phone;
    }

    public String getName() {
        return name;
    }

    public String getCustomerid() {
        return customerid;
    }

    public String getEmail() {
        return email;
    }

    public String getAddress() {
        return address;
    }

    public CustomerModel(String customerid, String phone, String name, String birthdate, String address, String email) {
        this.customerid = customerid;
        this.phone = phone;
        this.name = name;
        this.birthday = birthdate;
        this.address = address;
        this.email = email;
    }
}
