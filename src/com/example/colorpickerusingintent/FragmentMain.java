package com.example.colorpickerusingintent;

import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class FragmentMain extends Fragment {
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
        Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main, container, false);
    }
    
	@Override
	public void onStart() {
		super.onStart();
		
		final Button colorBtn1 = (Button) getActivity().findViewById(R.id.color1);
		colorBtn1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
            	Log.i("button_clicked","Color 1 button clicked.");
            }
        });
		
		final Button colorBtn2 = (Button) getActivity().findViewById(R.id.color2);
		colorBtn2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
            	Log.i("button_clicked","Color 2 button clicked.");
            }
        });
	}
}
