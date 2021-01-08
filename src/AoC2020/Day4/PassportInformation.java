package AoC2020.Day4;

public class PassportInformation {
    //byr (Birth Year)
    Integer birthYear;
    //    iyr (Issue Year)
    Integer issueYear;
    //    eyr (Expiration Year)
    Integer expirationYear;
    //    hgt (Height)
    Integer height;
    //    hcl (Hair Color)
    String hairColor;
    //    ecl (Eye Color)
    String eyeColor;
    //    pid (Passport ID)
    String passportId;
    //    cid (Country ID)
    Integer countryId;

    public PassportInformation() {
    }

    public PassportInformation(Integer birthYear, Integer issueYear, Integer expirationYear, Integer height, String hairColor, String eyeColor, String passportId, Integer countryId) {
        this.birthYear = birthYear;
        this.issueYear = issueYear;
        this.expirationYear = expirationYear;
        this.height = height;
        this.hairColor = hairColor;
        this.eyeColor = eyeColor;
        this.passportId = passportId;
        this.countryId = countryId;
    }

    public Integer getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(Integer birthYear) {
        this.birthYear = birthYear;
    }

    public Integer getIssueYear() {
        return issueYear;
    }

    public void setIssueYear(Integer issueYear) {
        this.issueYear = issueYear;
    }

    public Integer getExpirationYear() {
        return expirationYear;
    }

    public void setExpirationYear(Integer expirationYear) {
        this.expirationYear = expirationYear;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
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

    public Integer getCountryId() {
        return countryId;
    }

    public void setCountryId(Integer countryId) {
        this.countryId = countryId;
    }

    public Boolean isValid() {
        return this.birthYear != null && this.issueYear != null && this.expirationYear != null && this.height != null && this.hairColor != null && this.eyeColor != null && this.passportId != null;
    }
}
