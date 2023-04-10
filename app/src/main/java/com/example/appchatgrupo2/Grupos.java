package com.example.appchatgrupo2;

public class Grupos {

    private int Participants;
    private String Name;

    public Grupos(String name, int participants) {
        Name = name;
        Participants = participants;
    }

    public int getParticipants() {
        return Participants;
    }

    public void setParticipants(int participants) {
        Participants = participants;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }
}






