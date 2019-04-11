package com.snilssave.modele;

public class SnilsPassportRF {
    private Integer series;
    private Integer number;
    private String issueDate;
    private String issuer;
    private SnilsByAdditionalDataResponse owner;

    public SnilsPassportRF() {
    }

    public Integer getSeries() {
        return series;
    }

    public void setSeries(Integer series) {
        this.series = series;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(String issueDate) {
        this.issueDate = issueDate;
    }

    public String getIssuer() {
        return issuer;
    }

    public void setIssuer(String issuer) {
        this.issuer = issuer;
    }

    public SnilsByAdditionalDataResponse getOwner() {
        return owner;
    }

    public void setOwner(SnilsByAdditionalDataResponse owner) {
        this.owner = owner;
    }

    @Override
    public String toString() {
        return "SnilsPassportRF{" +
                "series=" + series +
                ", number=" + number +
                ", issueDate='" + issueDate + '\'' +
                ", issuer='" + issuer + '\'' +
                '}';
    }
}
