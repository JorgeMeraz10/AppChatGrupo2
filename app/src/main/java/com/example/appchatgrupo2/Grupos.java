package com.example.appchatgrupo2;

public class Grupos {
    private int Icon;
    private String Name;
    private int Participants;

    public Grupos(int icon, String name, int participants) {
        Icon = icon;
        Name = name;
        Participants = participants;
    }

    public Grupos(String name, int icon, int participants) {
    }

    public int getIcon() {
        return Icon;
    }

    public void setIcon(int icon) {
        Icon = icon;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public int getParticipants() {
        return Participants;
    }

    public void setParticipants(int participants) {
        Participants = participants;
    }
}
