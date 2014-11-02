package ua.ievleva.enums;


public enum SexType {
    MALE("male"),
    FEMALE("female");

    private String gender;

    SexType(String gender) {
        this.gender = gender;
    }

    public String getSexType() {
        return gender;
    }

   public static SexType getSexType(String gender) {
       return SexType.valueOf(gender);
   }
}