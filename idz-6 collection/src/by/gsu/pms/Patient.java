package by.gsu.pms;

import java.util.Comparator;

public class Patient implements Comparable<Patient> {
    private int id;
    private String surname;
    private String name;
    private String patronymic;
    private String address;
    private int numPhone;
    private int numMedCard;
    private String diagnosis;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getNumPhone() {
        return numPhone;
    }

    public void setNumPhone(int numPhone) {
        this.numPhone = numPhone;
    }

    public int getNumMedCard() {
        return numMedCard;
    }

    public void setNumMedCard(int numMedCard) {
        this.numMedCard = numMedCard;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    public Patient(int id, String surname, String name, String patronymic, String address, int numPhone, int numMedCard, String diagnosis) {
        this.id = id;
        this.surname = surname;
        this.name = name;
        this.patronymic = patronymic;
        this.address = address;
        this.numPhone = numPhone;
        this.numMedCard = numMedCard;
        this.diagnosis = diagnosis;
    }

    @Override
    public String toString() {
        return id + ";" + surname + ";" + name + ";" + patronymic + ";" + address + ";" + numPhone + ";" + numMedCard + ";" + diagnosis;
    }


    @Override
    public int compareTo(Patient o) {
        return surname.compareTo(o.getSurname());
    }
}
