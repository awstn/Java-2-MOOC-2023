
public class CountryLiteracyData {
    private String country;
    private int year;
    private String gender;
    private double literacyPercentage;
    
    public CountryLiteracyData(String country, int year, String gender, double literacyPercentage){
        this.country = country;
        this.year = year;
        this.gender = gender;
        this.literacyPercentage = literacyPercentage;
    }
    
    public double getPercentage(){
        return this.literacyPercentage;
    }
    
    @Override
    public String toString(){
        return this.getCountry() + " (" + this.getYear() + "), " + this.getGender() + ", " + this.getPercentage();
    }

    public String getCountry() {
        return country;
    }

    public int getYear() {
        return year;
    }

    public String getGender() {
        return gender;
    }
}
/*
public class Result {

 

    private String sex;

    private String country;

    private int year;

    private double literacyPercent;

 

    public Result(String sex, String country, int year, double literacyPercent) {

        this.sex = sex;

        this.country = country;

        this.year = year;

        this.literacyPercent = literacyPercent;

    }

 

    public double getLiteracyPercent() {

        return literacyPercent;

    }

 

    @Override

    public String toString() {

        return this.country + " (" + this.year + "), " + this.sex + ", " + this.literacyPercent;

    }

}
*/