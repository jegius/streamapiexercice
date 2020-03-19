package models;

public class Person {
    private Long id;
    private String firstName;
    private String lastName;
    private Long age;
    private String email;
    private String phone;
    private Gender gender;

    private Person() {
    }

    public Person(
            String firstName,
            Long id,
            String lastName,
            Long age,
            String email,
            String phone,
            Gender gender
    ) {
        this.firstName = firstName;
        this.id = id;
        this.lastName = lastName;
        this.age = age;
        this.email = email;
        this.phone = phone;
        this.gender = gender;
    }

    public Person(Person object) {
        this(
                object.getFirstName(),
                object.getId(),
                object.getLastName(),
                object.getAge(),
                object.getEmail(),
                object.getPhone(),
                object.getGender()
        );
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public Long getId() {
        return id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public static WebsiteBuilder websiteBuilder() {
        return new Person().new WebsiteBuilder();
    }

    public Long getAge() {
        return age;
    }

    public void setAge(Long age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public class WebsiteBuilder {
        private WebsiteBuilder() {
        }

        public WebsiteBuilder setId(Long id) {
            Person.this.id = id;
            return this;
        }

        public WebsiteBuilder setFirstName(String firstName) {
            Person.this.firstName = firstName;
            return this;
        }

        public WebsiteBuilder setLastName(String lastName) {
            Person.this.lastName = lastName;
            return this;
        }

        public WebsiteBuilder setEmail(String email) {
            Person.this.email = email;
            return this;
        }

        public WebsiteBuilder setPhone(String phone) {
            Person.this.phone = phone;
            return this;
        }

        public WebsiteBuilder setAge(Long age) {
            Person.this.age = age;
            return this;
        }

        public WebsiteBuilder setGender(Gender gender) {
            Person.this.gender = gender;
            return this;
        }

        public Person build() {
            return Person.this;
        }

    }

}
