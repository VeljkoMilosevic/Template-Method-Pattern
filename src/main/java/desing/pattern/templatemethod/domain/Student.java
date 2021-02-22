/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package desing.pattern.templatemethod.domain;

import java.util.Date;
import java.util.Objects;

/**
 *
 * @author Veljko
 */
public class Student {

    private String name;
    private String surname;
    private Index index;
    private Date dateBirth;
    private double GPA;

    public Student() {
    }

    public Student(String name, String surname, Index index, Date dateBirth,double GPA) {
        this.name = name;
        this.surname = surname;
        this.index = index;
        this.dateBirth = dateBirth;
        this.GPA = GPA;
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

    public Index getIndex() {
        return index;
    }

    public void setIndex(Index index) {
        this.index = index;
    }

    public Date getDateBirth() {
        return dateBirth;
    }

    public void setDateBirth(Date dateBirth) {
        this.dateBirth = dateBirth;
    }

    public double getGPA() {
        return GPA;
    }

    public void setGPA(double GPA) {
        this.GPA = GPA;
    }
    
    

    @Override
    public String toString() {
        return "Student{" + "name=" + name + ", surname=" + surname + ", index=" + index + ", dateBirth=" + dateBirth + ", GPA=" + GPA + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + Objects.hashCode(this.name);
        hash = 23 * hash + Objects.hashCode(this.surname);
        hash = 23 * hash + Objects.hashCode(this.index);
        hash = 23 * hash + Objects.hashCode(this.dateBirth);
        hash = 23 * hash + (int) (Double.doubleToLongBits(this.GPA) ^ (Double.doubleToLongBits(this.GPA) >>> 32));
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
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
        if (Double.doubleToLongBits(this.GPA) != Double.doubleToLongBits(other.GPA)) {
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
