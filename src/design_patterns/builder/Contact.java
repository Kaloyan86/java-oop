package design_patterns.builder;

import java.util.concurrent.ScheduledThreadPoolExecutor;

public class Contact {

    private String name;
    private String number;
    private String company;
    private String title;
    private String email;
    private String website;
    private String birthday;

    private Contact(Builder builder) {
        this.name = builder.name;
        this.number = builder.number;
        this.company = builder.company;
        this.title = builder.title;
        this.email = builder.email;
        this.website = builder.website;
        this.birthday = builder.birthday;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.trim().equals("") || name.length() < 2) {
            throw new IllegalStateException("The name must contain at least 2 characters!");
        }

        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        if (number == null || number.trim().equals("") || number.length() < 5) {
            throw new IllegalStateException("The name must contain at least 5 characters!");
        }

        this.number = number;
    }

    public String getCompany() {
        return company;
    }

    public String getTitle() {
        return title;
    }

    public String getEmail() {
        return email;
    }

    public String getWebsite() {
        return website;
    }

    public String getBirthday() {
        return birthday;
    }

    @Override
    public String toString() {
        return "Contact{" +
               "name='" + name + '\'' +
               ", number='" + number + '\'' +
               ", company='" + company + '\'' +
               ", title='" + title + '\'' +
               ", email='" + email + '\'' +
               ", website='" + website + '\'' +
               ", birthday=" + birthday +
               '}';
    }

    public static class Builder {

        private String name;
        private String number;
        private String company;
        private String title;
        private String email;
        private String website;
        private String birthday;

        // Required fields
        public Builder(String name, String number) {
            this.name = name;
            this.number = number;
        }

        // Optional fields
        public Builder company(String company) {
            this.company = company;
            return this;
        }

        public Builder title(String title) {
            this.title = title;
            return this;
        }

        public Builder email(String email) {
            this.email = email;
            return this;
        }

        public Builder website(String website) {
            this.website = website;
            return this;
        }

        public Builder birthday(String birthday) {
            this.birthday = birthday;
            return this;
        }

        public Contact build() {
            validate();
            return new Contact(this);
        }

        private void validate() {

            StringBuilder errorMessages = new StringBuilder();

            if (name == null || name.trim().equals("") || name.length() < 2) {
                errorMessages.append("The name must contain at least 2 characters!");
            }

            if (number == null || number.trim().equals("") || number.length() < 5) {
                errorMessages.append(System.lineSeparator())
                             .append("The number must contain at least 5 characters!");
            }

            if (errorMessages.length() > 0) {
                throw new IllegalStateException(errorMessages.toString());
            }
        }
    }
}
