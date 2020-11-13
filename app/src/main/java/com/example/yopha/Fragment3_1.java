package com.example.yopha;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class Fragment3_1 extends Fragment {
    String[] main_menu = {"증상 검색", "약품 검색"};
    String[] name = {"정렬", "종류", "이름", "주변 약국", "최저가"};
    public static Fragment3_1 newInstance() {
        return new Fragment3_1();
    }
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup v = (ViewGroup) inflater.inflate(R.layout.fragment3_1, container, false);


        Spinner main =(Spinner) v.findViewById(R.id.main_spinner2);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(v.getContext(),android.R.layout.simple_spinner_item, main_menu);
        main.setAdapter(adapter);

        Spinner spinner = (Spinner)v.findViewById(R.id.spinner);
        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(v.getContext(), R.layout.spinner_item,name);
        adapter2.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        spinner.setAdapter(adapter2);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        //나중에 수정할 부분----
        final Button nextButton = v.findViewById(R.id.next);
        nextButton.setOnClickListener(new View.OnClickListener() { //next 버튼이 눌리면 fragment3_1로 이동합니다.
            @Override
            public void onClick(View v) {
                ((MainActivity)getActivity()).replaceFragment(Fragment3_2.newInstance());
            }
        }); //
        return v;
    }
}