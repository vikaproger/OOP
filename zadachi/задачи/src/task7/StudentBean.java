package task7;

import java.io.Serializable;

public class StudentBean implements Serializable{
    //поля
    private String name, surname, middleName;
    private  int id;
    private int[] scores;

    //конструктор
    public StudentBean() {
    }

    //методы get и set
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

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int[] getScores() {
        return scores;
    }

    public int getScore(int index){
        return scores[index];
    }

    public void setScores(int[] scores) {
        this.scores = scores;
    }

    public void  setScores(int index, int score){
        scores[index]=score;
    }
}
