package com.example.weixin;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class TabFragment extends Fragment {

	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		
		TextView textView=new TextView(getActivity());
		Bundle bundle=getArguments(); 
		String title=bundle.getString("title");
		textView.setText(title);
		View view=inflater.inflate(R.layout.jj,null);
		
		 return view;
	}
	
}
