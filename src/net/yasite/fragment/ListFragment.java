package net.yasite.fragment;

import net.yasite.test.R;
import net.yasite.test.SecondListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

public class ListFragment extends Fragment{
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		View v = inflater.inflate(R.layout.fragment_list, null);
		RelativeLayout rel1 = (RelativeLayout) v.findViewById(R.id.relative1);
		rel1.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(getActivity(),SecondListActivity.class);
				getActivity().startActivity(intent);
			}
		});
		return v;
	}
}
