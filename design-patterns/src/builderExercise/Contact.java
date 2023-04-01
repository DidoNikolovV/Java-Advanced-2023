package builderExercise;

public class Contact {

    public static class Builder {
        private String name;
        private String number;
        private String company;
        private String title;
        private String email;
        private String website;
        private String birthday;

        private boolean buildComplete;

        private void ensureNotComplete() {
            if(buildComplete) {
                throw new IllegalStateException("Contact already built. Create new Builder.");
            }
        }

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setNumber(String number) {
            this.number = number;
            return this;
        }



        public Builder setCompany(String company) {
            this.company = company;
            return this;
        }

        public Builder setTitle(String title) {
            this.title = title;
            return this;
        }


        public Builder setEmail(String email) {
            this.email = email;
            return this;
        }

        public Builder setWebsite(String website) {
            this.website = website;
            return this;
        }

        public Builder setBirthday(String birthday) {
            this.birthday = birthday;
            return this;
        }

        public Contact build() {
            this.buildComplete = true;
            return new Contact(name, number, company, title, email, website, birthday);
        }
    }

    private String name;
    private String number;
    private String company;
    private String title;
    private String email;
    private String website;
    private String birthday;

    public Contact(String name, String number) {
        this.setName(name);
        this.setNumber(number);
    }

    private Contact(String name, String number, String company) {
        this(name, number);
        this.company = company;
    }

    private Contact(String name, String number, String company, String title) {
        this(name, number, company);
        this.title = title;
    }

    private Contact(String name, String number, String company, String title, String email) {
        this(name, number, company, title);
        this.email = email;
    }

    private Contact(String name, String number, String company, String title, String email, String website) {
        this(name, number, company, title, email);
        this.website = website;
    }

    public Contact(String name, String number, String company, String title, String email, String website, String birthday) {
        this(name, number, company, title, email, website);
        this.birthday = birthday;
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
}
