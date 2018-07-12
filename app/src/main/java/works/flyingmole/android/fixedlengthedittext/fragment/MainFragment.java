package works.flyingmole.android.fixedlengthedittext.fragment;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import works.flyingmole.android.fixedlengthedittext.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class MainFragment extends Fragment {

	public static MainFragment getInstance() {
		MainFragment fragment = new MainFragment();
		fragment.setArguments(new Bundle());
		return fragment;
	}

	@Override
	public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
							 Bundle savedInstanceState) {
		ViewGroup view = (ViewGroup) inflater.inflate(R.layout.fragment_main, container, false);
		return view;
	}

}
