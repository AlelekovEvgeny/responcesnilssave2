package com.snilssave.modele;

public class SnilsByAdditionalDataResponse {
    private Long id;
    private String familyName;
    private String firstName;
    private String patronymic;
    private String snilsNum;
    private String birthDate;
    private String gender;

    private SnilsPassportRF snilsPassportRF;

    public SnilsByAdditionalDataResponse() {
    }

    public String getFamilyName() {
        return familyName;
    }

    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSnilsNum() {
        return snilsNum;
    }

    public void setSnilsNum(String snilsNum) {
        this.snilsNum = snilsNum;
    }

    public SnilsPassportRF getSnilsPassportRF() {
        return snilsPassportRF;
    }

    public void setSnilsPassportRF(SnilsPassportRF snilsPassportRF) {
        this.snilsPassportRF = snilsPassportRF;
    }

    @Override
    public String toString() {
        return "insert into SNILS_SAVE_RESPONSE s values (" +
                "'','" + familyName +'\'' +
                ", '" + firstName +'\'' +
                ", '" + patronymic +'\'' +
                ", '" + snilsNum +'\'' +
                ", '" + birthDate +'\'' +
                ", '" + gender +'\'' +
                ",sysdate)";
    }
}
