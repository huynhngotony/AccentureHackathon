package com.example.kevinsacer.trophy;

import android.widget.ImageView;

public  class TrophyModel {

    private String name;
    private String level;

    public TrophyModel(String fname, String flevel){
        name = fname;
        level = flevel;
    }

    public String getImage() {
        String result = name+level;
        return result;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }


}
