package com.example.r.myapplication.model.characterInfo;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class CharacterInfoData {

    @SerializedName("results")
    public List<CharacterInfo> information;
}
