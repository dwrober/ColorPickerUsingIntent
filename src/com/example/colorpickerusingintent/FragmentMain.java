package com.example.colorpickerusingintent;

import android.app.Fragment;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;

public class FragmentMain extends Fragment {
	
	private SeekBar bender = null;
	
	private FrameLayout colorFrameBlend;
	
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
            	getColor1();
            }
        });
		
		final Button colorBtn2 = (Button) getActivity().findViewById(R.id.color2);
		colorBtn2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
            	Log.i("button_clicked","Color 2 button clicked.");
            	getColor2();
            }
        });
		
		bender = (SeekBar) getActivity().findViewById(R.id.benderSeeker);
		
		bender.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {
            int progressChanged = 0;
 
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser){
                progressChanged = progress;
                Log.i("seek_bar",Integer.toString(progressChanged));
                setBenderColor(progressChanged);
            }
 
            public void onStartTrackingTouch(SeekBar seekBar) {
                // TODO Auto-generated method stub
            	Log.i("seek_bar","onStartTrackingTouch");
            }
 
            public void onStopTrackingTouch(SeekBar seekBar) {
            	Log.i("seek_bar", "onStopTrackingTouch: " + Integer.toString(seekBar.getProgress()));
            }
        });
	}
	
	private void setBenderColor(int progress) {
		int red = progress;
		int green = 0;
		int blue = 0;
		
		colorFrameBlend = (FrameLayout) getActivity().findViewById(R.id.colorFrameBlend);
		colorFrameBlend.setBackgroundColor(Color.rgb(red, green, blue));
		
	}
	
	private void getColor1() {
		Intent intent = new Intent("msud.cs390H.ACTION_COLOR");
		getActivity().startActivityForResult(intent, 100);
	}
	
	private void getColor2() {
		Intent intent = new Intent("msud.cs390H.ACTION_COLOR");
		getActivity().startActivityForResult(intent, 200);
	}
}
