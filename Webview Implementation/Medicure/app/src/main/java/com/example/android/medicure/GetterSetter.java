package com.example.android.medicure;

/**
 * Created by sony on 28-04-2017.
 */

public class GetterSetter {
    String name,disease,allergy,sugar,blood,hemoglobin,bone,checksugar,checkblood,checkHemoglobin;

    private static final GetterSetter g=new GetterSetter();

    public static GetterSetter getinstance(){

        return g;
    }

    public String getAllergy() {
        return allergy;
    }

    public String getCheckHemoglobin() {
        return checkHemoglobin;
    }

    public void setCheckHemoglobin(String checkHemoglobin) {
        this.checkHemoglobin = checkHemoglobin;
    }

    public String getBlood() {
        return blood;
    }

    public String getCheckblood() {
        return checkblood;
    }

    public void setCheckblood(String checkblood) {
        this.checkblood = checkblood;
    }

    public String getBone() {
        return bone;
    }

    public String getDisease() {
        return disease;
    }

    public String getHemoglobin() {
        return hemoglobin;
    }

    public String getName() {
        return name;
    }

    public String getSugar() {
        return sugar;
    }

    public void setAllergy(String allergy) {
        this.allergy = allergy;
    }

    public void setBlood(String blood) {
        this.blood = blood;
    }

    public void setBone(String bone) {
        this.bone = bone;
    }

    public void setDisease(String disease) {
        this.disease = disease;
    }

    public void setHemoglobin(String hemoglobin) {
        this.hemoglobin = hemoglobin;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSugar(String sugar) {
        this.sugar = sugar;
    }

    public void setChecksugar(String checksugar) {
        this.checksugar = checksugar;
    }

    public String getChecksugar() {
        return checksugar;
    }
}
