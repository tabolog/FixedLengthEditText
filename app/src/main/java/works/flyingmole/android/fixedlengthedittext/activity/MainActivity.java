package works.flyingmole.android.fixedlengthedittext.activity;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import works.flyingmole.android.fixedlengthedittext.R;
import works.flyingmole.android.fixedlengthedittext.fragment.MainFragment;

public class MainActivity extends AppCompatActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		getSupportFragmentManager()
				.beginTransaction()
				.replace(R.id.container, MainFragment.getInstance())
				.commit();
	}
}
