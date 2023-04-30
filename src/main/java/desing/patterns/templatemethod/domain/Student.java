/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package desing.patterns.templatemethod.domain;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

/**
 * @author Veljko
 */
public class Student {

    private String name;
    private String surname;
    private Index index;
    private Date dateBirth;
    private double gpa;

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(final String surname) {
        this.surname = surname;
    }

    public Index getIndex() {
        return index;
    }

    public void setIndex(final Index index) {
        this.index = index;
    }

    public Date getDateBirth() {
        return dateBirth;
    }

    public void setDateBirth(final Date dateBirth) {
        this.dateBirth = dateBirth;
    }

    public double getGpa() {
        return gpa;
    }

    public void setGpa(final double gpa) {
        this.gpa = gpa;
    }


    @Override
    public String toString() {
        return String.format("Student { name=%s, surname=%s, index=%s, dateBirth=%s, GPA=%S }", name, surname, index, new SimpleDateFormat("dd.MM.yyyy").format(dateBirth), gpa);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + Objects.hashCode(this.name);
        hash = 23 * hash + Objects.hashCode(this.surname);
        hash = 23 * hash + Objects.hashCode(this.index);
        hash = 23 * hash + Objects.hashCode(this.dateBirth);
        hash = 23 * hash + (int) (Double.doubleToLongBits(this.gpa) ^ (Double.doubleToLongBits(this.gpa) >>> 32));
        return hash;
    }

    @Override
    public boolean equals(final Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Student other = (Student) obj;
        if (Double.doubleToLongBits(this.gpa) != Double.doubleToLongBits(other.gpa)) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.surname, other.surname)) {
            return false;
        }
        if (!Objects.equals(this.index, other.index)) {
            return false;
        }
        return Objects.equals(this.dateBirth, other.dateBirth);
    }
}
