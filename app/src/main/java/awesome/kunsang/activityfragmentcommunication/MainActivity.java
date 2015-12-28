package awesome.kunsang.activityfragmentcommunication;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import de.greenrobot.event.EventBus;

import static awesome.kunsang.activityfragmentcommunication.JustFragment.*;

public class MainActivity extends AppCompatActivity {
    private ViewPager pager;

    Button button;
    EventBus bus = EventBus.getDefault();
    private ViewPagerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        pager = (ViewPager) findViewById(R.id.viewpager);
        button=(Button)findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EventBus bus = EventBus.getDefault();
                bus.post(new JustFragment.EditTextNull());
            }
        });
        setPagerAdapter();
        bus.register(this);
    }
    public void onEvent(JustFragment.EditTextNull event) {
        if(event.editTextNull)
        {
            Log.i("null","true");
        }
        else
        {
            Log.i("null","false");
        }
    }
    private void setPagerAdapter() {
        adapter = new ViewPagerAdapter(getSupportFragmentManager());
        pager.setAdapter(adapter);
    }

    public class ViewPagerAdapter  extends FragmentPagerAdapter {

        public ViewPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int i) {
            return newInstance();
        }

        @Override
        public int getCount() {
            return 1;
        }
    }
}
