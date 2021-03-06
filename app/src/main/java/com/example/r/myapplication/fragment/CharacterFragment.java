package com.example.r.myapplication.fragment;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import com.example.r.myapplication.adapters.ListItemAdapter;
import com.example.r.myapplication.R;
import com.example.r.myapplication.loaders.listLoaders.ListLoader;
import com.example.r.myapplication.model.lists.Comics;
import com.example.r.myapplication.model.lists.Events;
import com.example.r.myapplication.model.lists.Series;

public class CharacterFragment extends GeneralInfoFragment{
    private ListItemAdapter<Comics> comicsAdapter;
    private ListLoader<Comics> comicsLoader;

    private ListLoader<Series> seriesLoader;
    private ListItemAdapter<Series> seriesAdapter;

    private ListLoader<Events> eventsLoader;
    private ListItemAdapter<Events> eventsAdapter;

    public static CharacterFragment newInstance(int charId) {
        Bundle args = new Bundle();
        args.putInt(ARG_ITEM_ID, charId);
        args.putInt(ARG_ITEM_TYPE, ListLoader.CHARACTER_TYPE);

        CharacterFragment characterFragment = new CharacterFragment();
        characterFragment.setArguments(args);
        return characterFragment;
    }

    @Override
    public void makeAdapters() {
        Log.d("checki", "makeAdapters: ");
        comicsAdapter = newAdapter(ListLoader.COMICS_TYPE);
        seriesAdapter = newAdapter(ListLoader.SERIES_TYPE);
        eventsAdapter = newAdapter(ListLoader.EVENTS_TYPE);

        listOfRecyclerView.get(0).setAdapter(comicsAdapter);
        listOfRecyclerView.get(1).setAdapter(seriesAdapter);
        listOfRecyclerView.get(2).setAdapter(eventsAdapter);
    }

    @Override
    public void loadLists() {
        comicsLoader.loadItems();
        seriesLoader.loadItems();
        eventsLoader.loadItems();
        Log.d("checki", "loadLists: ");
    }

    @Override
    public void findRV(View view) {
        super.listOfRecyclerView.add((RecyclerView) view.findViewById(R.id.comics_recycler_view));
        super.listOfRecyclerView.add((RecyclerView) view.findViewById(R.id.series_recycler_view));
        super.listOfRecyclerView.add((RecyclerView) view.findViewById(R.id.events_recycler_view));
        Log.d("checki", "findRV: ");
    }

    @Override
    public void makeLoaders(View view) {
        Log.d("checki", "makeLoaders: ");
        comicsLoader = newListLoader(ListLoader.COMICS_TYPE, view, listOfRecyclerView.get(0));
        seriesLoader = newListLoader(ListLoader.SERIES_TYPE, view, listOfRecyclerView.get(1));
        eventsLoader = newListLoader(ListLoader.EVENTS_TYPE, view, listOfRecyclerView.get(2));
    }

}
