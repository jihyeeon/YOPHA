package com.example.yopha;

import android.content.Context;
import android.graphics.Color;
import android.location.LocationManager;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import net.daum.mf.map.api.MapPOIItem;
import net.daum.mf.map.api.MapPoint;
import net.daum.mf.map.api.MapView;

import java.util.ArrayList;
import java.util.List;

import static com.example.yopha.MainActivity.latitude;
import static com.example.yopha.MainActivity.longitude;


public class Fragment1 extends Fragment {
    private FirebaseDatabase mDatabase;
    private DatabaseReference mReference;
    private ChildEventListener mChild;

    private ListView listView;
    private ArrayAdapter<String> adapter;
    List<Object> Array = new ArrayList();
    ViewGroup v;
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v = (ViewGroup) inflater.inflate(R.layout.fragment1, container, false);
        final MapView mapView = new MapView(getActivity());
        ViewGroup mapViewContainer = v.findViewById(R.id.map_view);
        mapViewContainer.addView(mapView);

        mapView.setMapCenterPoint(MapPoint.mapPointWithGeoCoord(latitude, longitude), true);

        initDatabase();

        listView = v.findViewById(R.id.test);
        adapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_dropdown_item_1line, new ArrayList<String>());
        listView.setAdapter(adapter);

        mReference = mDatabase.getInstance().getReference();
        mReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for(DataSnapshot messageData : dataSnapshot.getChildren()){

                    String msg2 = messageData.getValue().toString();
                    if(msg2.length() < 20) break;

                    int num =  msg2.indexOf("경도");
                    int length = msg2.length();
                    String lat = msg2.substring(num,length);
                    int end = lat.indexOf(",");
                    lat = lat.substring(3,end);

                    int num2 =  msg2.indexOf("위도");
                    int length2 = msg2.length();
                    String lon = msg2.substring(num2,length2);
                    int end2 = lon.indexOf(",");
                    lon = lon.substring(3,end2);

                    int num3 =  msg2.indexOf("약국명");
                    int length3 = msg2.length();
                    String name = msg2.substring(num3,length3);
                    int end3 = name.indexOf(",");
                    name = name.substring(4,end3);


                    try{
                        double DoubleLon = Double.parseDouble(lon);
                        double DoubleLat = Double.parseDouble(lat);
                    }catch (NumberFormatException e){

                        continue;
                    }
                    //마커찍기---
                    double DoubleLon = Double.parseDouble(lon);
                    double DoubleLat = Double.parseDouble(lat);

                    if(DoubleLat > longitude- 0.1 && DoubleLat < longitude + 0.1 && DoubleLon > latitude- 0.1 && DoubleLon < latitude + 0.1) {

                        MapPoint mapPoint = MapPoint.mapPointWithGeoCoord(Double.parseDouble(lon), Double.parseDouble(lat)); // 마커 찍을 위치 설정
                        MapPOIItem marker = new MapPOIItem();
                        marker.setItemName(name);
                        marker.setTag(0);
                        marker.setMapPoint(mapPoint);
                        marker.setMarkerType(MapPOIItem.MarkerType.BluePin); // 기본으로 제공하는 BluePin 마커 모양.
                        marker.setSelectedMarkerType(MapPOIItem.MarkerType.RedPin); // 마커를 클릭했을때, 기본으로 제공하는 RedPin 마커 모양.
                        mapView.addPOIItem(marker);
                    }
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        //거리순, 가격순 버튼 정의 및 이벤트 처리
        final Button distanceButton = v.findViewById(R.id.distanceButton);
        final Button priceButton = v.findViewById(R.id.priceButton);

        distanceButton.setOnClickListener(new View.OnClickListener() { // 거리순 버튼이 눌렸을 때
            @Override
            public void onClick(View v) {
                distanceButton.setBackgroundColor(Color.WHITE);
                priceButton.setBackgroundColor(Color.TRANSPARENT);

                ((MainActivity)getActivity()).removeEdit();
            }
        });

        priceButton.setOnClickListener(new View.OnClickListener() { // 가격순 버튼이 눌렸을 때
            @Override
            public void onClick(View v) {
               priceButton.setBackgroundColor(Color.WHITE);
               distanceButton.setBackgroundColor(Color.TRANSPARENT);

               ((MainActivity)getActivity()).addEdit();
            }
        }); //

        //나중에 수정할 부분----
        final Button nextButton = v.findViewById(R.id.next);
        nextButton.setOnClickListener(new View.OnClickListener() { //next 버튼이 눌리면 fragment1_1로 이동합니다.
            @Override
            public void onClick(View v) {
                ((MainActivity)getActivity()).replaceFragment(Fragment1_1.newInstance());
            }
        }); //
        return v;
    }

    private void initDatabase() {

        mDatabase = FirebaseDatabase.getInstance();

        mReference = mDatabase.getReference("log");
        mReference.child("log").setValue("check");


        mChild = new ChildEventListener() {


            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        };
        mReference.addChildEventListener(mChild);
    }



}

