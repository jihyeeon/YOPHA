package com.example.yopha;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class Fragment3 extends Fragment {
    String[] main_menu = {"증상 검색", "약품 검색"};
    String[] body = {"머리","배","어깨"};
    String[] symptom = {"발열","오한","근육"};
    String[] disease = {"감기","몸살"};

    public static Fragment3 newInstance() {
        return new Fragment3();
    }

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup v = (ViewGroup) inflater.inflate(R.layout.fragment3, container, false);

        TextView yopha = (TextView)v.findViewById(R.id.yopha);
        yopha.setText("YOPHA");
        Spinner spinner =(Spinner) v.findViewById(R.id.main_spinner);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(v.getContext(),android.R.layout.simple_spinner_item, main_menu);
        spinner.setAdapter(adapter);

        Spinner body_sp =(Spinner) v.findViewById(R.id.body_spinner);
        ArrayAdapter<String> adapter1 = new ArrayAdapter<>(v.getContext(),android.R.layout.simple_spinner_item, body);
        body_sp.setAdapter(adapter1);

        Spinner symptom_sp =(Spinner) v.findViewById(R.id.symptom_spinner);
        ArrayAdapter<String> adapter2 = new ArrayAdapter<>(v.getContext(),android.R.layout.simple_spinner_item, symptom);
        symptom_sp.setAdapter(adapter2);

        Spinner disease_sp =(Spinner) v.findViewById(R.id.disease_spinner);
        ArrayAdapter<String> adapter3 = new ArrayAdapter<>(v.getContext(),android.R.layout.simple_spinner_item, disease);
        disease_sp.setAdapter(adapter3);

        TextView tv1 = (TextView) v.findViewById(R.id.tv1);
        tv1.setText("아픈 신체 부위를 선택 하십시오.");

        TextView tv2 = (TextView) v.findViewById(R.id.tv2);
        tv2.setText("어떤 증상이 있는지 선택 하십시오.");

        TextView tv3 = (TextView) v.findViewById(R.id.tv3);
        tv3.setText("예상 병명을 선택 하십시오.");

        //나중에 수정할 부분----
        final Button nextButton = v.findViewById(R.id.next);
        nextButton.setOnClickListener(new View.OnClickListener() { //next 버튼이 눌리면 fragment3_1로 이동합니다.
            @Override
            public void onClick(View v) {
                ((MainActivity)getActivity()).replaceFragment(Fragment3_1.newInstance());
            }
        }); //

        return v;
    }
}