package AoC2020.Day4;

public class PassportInformation {
    //byr (Birth Year)
    private String birthYear;
    //    iyr (Issue Year)
    private String issueYear;
    //    eyr (Expiration Year)
    private String expirationYear;
    //    hgt (Height)
    private String height;
    //    hcl (Hair Color)
    private String hairColor;
    //    ecl (Eye Color)
    private String eyeColor;
    //    pid (Passport ID)
    private String passportId;
    //    cid (Country ID)
    private String countryId;

    public PassportInformation() {
    }

    public PassportInformation(String birthYear, String issueYear, String expirationYear, String height, String hairColor, String eyeColor, String passportId, String countryId) {
        this.birthYear = birthYear;
        this.issueYear = issueYear;
        this.expirationYear = expirationYear;
        this.height = height;
        this.hairColor = hairColor;
        this.eyeColor = eyeColor;
        this.passportId = passportId;
        this.countryId = countryId;
    }

    public String getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(String birthYear) {
        this.birthYear = birthYear;
    }

    public String getIssueYear() {
        return issueYear;
    }

    public void setIssueYear(String issueYear) {
        this.issueYear = issueYear;
    }

    public String getExpirationYear() {
        return expirationYear;
    }

    public void setExpirationYear(String expirationYear) {
        this.expirationYear = expirationYear;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getHairColor() {
        return hairColor;
    }

    public void setHairColor(String hairColor) {
        this.hairColor = hairColor;
    }

    public String getEyeColor() {
        return eyeColor;
    }

    public void setEyeColor(String eyeColor) {
        this.eyeColor = eyeColor;
    }

    public String getPassportId() {
        return passportId;
    }

    public void setPassportId(String passportId) {
        this.passportId = passportId;
    }

    public String getCountryId() {
        return countryId;
    }

    public void setCountryId(String countryId) {
        this.countryId = countryId;
    }

    public Boolean isValid() {
        return this.birthYear != null && this.issueYear != null && this.expirationYear != null && this.height != null && this.hairColor != null && this.eyeColor != null && this.passportId != null;
    }
}
