package model;

public class CustomerModel {

    private int customerid;
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

    public int getCustomerid() {
        return customerid;
    }

    public String getEmail() {
        return email;
    }

    public String getAddress() {
        return address;
    }

    public CustomerModel(int customerid, String name, String address, String email, String phone) {
        this.customerid = customerid;
        this.phone = phone;
        this.name = name;
//        this.birthday = birthdate;
        this.address = address;
        this.email = email;
    }
}
