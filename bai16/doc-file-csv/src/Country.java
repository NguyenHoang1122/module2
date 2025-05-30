public class Country {
    int id;
    String countryCode;
    String country;

    public Country() {
    }

    public Country(int id, String countryCode, String country) {
        this.id = id;
        this.countryCode = countryCode;
        this.country = country;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return "| " + id + " |    " + countryCode + "       | " + country ;
    }
}
