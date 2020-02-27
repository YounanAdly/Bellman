package com.example.android.bellman.Fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.android.bellman.Adapter.AttractionAdapter;
import com.example.android.bellman.Adapter.EventAdapter;
import com.example.android.bellman.Adapter.HotspotsAdapter;
import com.example.android.bellman.Common.Common;
import com.example.android.bellman.Model.Attraction;
import com.example.android.bellman.Model.BellmanList;
import com.example.android.bellman.Model.Event;
import com.example.android.bellman.Model.Hotspots;
import com.example.android.bellman.R;
import com.example.android.bellman.Service.BellmanService;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeFragment extends Fragment{


    ImageView calendar, notification;

    BellmanService mService;

    private ArrayList<Hotspots> hotspots;
    private ArrayList<Attraction> attractions;
    private ArrayList<Event> events;

    private RecyclerView.LayoutManager mHotspotsLayoutManager;
    private RecyclerView.LayoutManager mAttractionLayoutManager;
    private RecyclerView.LayoutManager mEventLayoutManager;
    private RecyclerView mHotspotsRecyclerView;
    private RecyclerView mAttractionRecyclerView;
    private RecyclerView mEventRecyclerView;

    private HotspotsAdapter hotspotsAdapter;
    private AttractionAdapter attractionAdapter;
    private EventAdapter eventAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.home_fragment, container, false);


        calendar = v.findViewById(R.id.calendar);
        notification = v.findViewById(R.id.notification);
        appBarIcons();



        mService = Common.getBellmanService();

        mHotspotsRecyclerView = (RecyclerView) v.findViewById(R.id.hotspotsRecycler);
        mAttractionRecyclerView = (RecyclerView) v.findViewById(R.id.attractionsRecycler);
        mEventRecyclerView = (RecyclerView) v.findViewById(R.id.eventRecycler);


        mHotspotsLayoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
        mAttractionLayoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
        mEventLayoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);


        mHotspotsRecyclerView.setLayoutManager(mHotspotsLayoutManager);
        mAttractionRecyclerView.setLayoutManager(mAttractionLayoutManager);
        mEventRecyclerView.setLayoutManager(mEventLayoutManager);


        hotspots = new ArrayList<>();
        hotspotsAdapter = new HotspotsAdapter(getActivity(), hotspots);
        mHotspotsRecyclerView.setAdapter(hotspotsAdapter);


        attractions = new ArrayList<>();
        attractionAdapter = new AttractionAdapter(getActivity(), attractions);
        mAttractionRecyclerView.setAdapter(attractionAdapter);

        events = new ArrayList<>();
        eventAdapter = new EventAdapter(getActivity(), events);
        mEventRecyclerView.setAdapter(eventAdapter);


        loadHotspotsList();
        loadAttractionList();
        loadEventList();
        return v;

    }

    private void appBarIcons() {
        calendar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(), "Calendar Icon", Toast.LENGTH_SHORT).show();
            }
        });

        notification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(), "Notification Icon", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void loadAttractionList() {

        mService.getHome().enqueue(new Callback<BellmanList>() {
            @Override
            public void onResponse(Call<BellmanList> call, Response<BellmanList> response) {
                attractions.clear();
                attractions.addAll(response.body().getData().getAttractions());
                mAttractionRecyclerView.getAdapter().notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<BellmanList> call, Throwable t) {
                Log.d("===LoadAttraction", "onResponse: " + t);
            }
        });
    }

    private void loadEventList() {

        mService.getHome().enqueue(new Callback<BellmanList>() {
            @Override
            public void onResponse(Call<BellmanList> call, Response<BellmanList> response) {
                events.clear();
                events.addAll(response.body().getData().getEvents());
                mEventRecyclerView.getAdapter().notifyDataSetChanged();

            }

            @Override
            public void onFailure(Call<BellmanList> call, Throwable t) {
                Log.d("===LoadEvents", "onResponse: " + t);
            }
        });
    }

    private void loadHotspotsList() {
        mService.getHome().enqueue(new Callback<BellmanList>() {
            @Override
            public void onResponse(Call<BellmanList> call, Response<BellmanList> response) {
                hotspots.clear();
                hotspots.addAll(response.body().getData().getHotSpots());
                mHotspotsRecyclerView.getAdapter().notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<BellmanList> call, Throwable t) {
                Log.d("===LoadHotSpots", "onResponse: " + t);
            }
        });
    }

}
