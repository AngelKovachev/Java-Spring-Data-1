package test.exam.models.service;

import test.exam.models.entities.Gender;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

public class GenderServiceModel {

    private Gender gender;

    public GenderServiceModel() {
    }

    @Enumerated(EnumType.STRING)
    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }
}
