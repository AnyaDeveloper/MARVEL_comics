package com.example.r.myapplication.fragment;

import android.os.Bundle;

import com.example.r.myapplication.loaders.listLoaders.ListLoader;
import com.example.r.myapplication.model.Comics;
import com.example.r.myapplication.model.LoadingObject;

public class ChosenListFragment<T extends LoadingObject> extends GeneralListFragment<T> {

    private static final String ARG_CHARACTER_ID = "character_id";

    private int chrId;

    public static ChosenListFragment newInstance(int dataType, int chrId){
        Bundle args = new Bundle();
        args.putInt(ARG_DATA_TYPE, dataType);
        args.putInt(ARG_CHARACTER_ID, chrId);

        ChosenListFragment<Comics> chosenListFragment = new ChosenListFragment<>();
        chosenListFragment.setArguments(args);
        return chosenListFragment;
    }

    @Override
    protected void initListLoader() {
        setLoader(new ListLoader<>(getListLoaderListener(), chrId, itemsType));
    }

    @Override
    protected void inflateMenu() {}

    @Override
    protected void unpackingArguments(Bundle args) {
        if (args != null && args.containsKey(ARG_CHARACTER_ID) && args.containsKey(ARG_DATA_TYPE)) {
            chrId = args.getInt(ARG_CHARACTER_ID);
            itemsType = args.getInt(ARG_DATA_TYPE);
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        chrId = 0;
    }
}