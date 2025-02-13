package com.example.formularzeosobowe;

// Klasa reprezentująca aplikację kandydata
public class Application {
    private String id;
    private String firstName;
    private String lastName;
    private int age;
    private String address;
    private String education;
    private String pesel;
    private String drivingLicense;
    private String transport;
    private String experience;
    private String aboutMe;

    // Gettery i settery dla każdego pola
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }

    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }

    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }

    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }

    public String getEducation() { return education; }
    public void setEducation(String education) { this.education = education; }

    public String getPesel() { return pesel; }
    public void setPesel(String pesel) { this.pesel = pesel; }

    public String getDrivingLicense() { return drivingLicense; }
    public void setDrivingLicense(String drivingLicense) { this.drivingLicense = drivingLicense; }

    public String getTransport() { return transport; }
    public void setTransport(String transport) { this.transport = transport; }

    public String getExperience() { return experience; }
    public void setExperience(String experience) { this.experience = experience; }

    public String getAboutMe() { return aboutMe; }
    public void setAboutMe(String aboutMe) { this.aboutMe = aboutMe; }
}
