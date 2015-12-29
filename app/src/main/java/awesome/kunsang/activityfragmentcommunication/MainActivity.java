package awesome.kunsang.activityfragmentcommunication;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import static awesome.kunsang.activityfragmentcommunication.Fragment1.newInstance1;
import static awesome.kunsang.activityfragmentcommunication.Fragment2.newInstance2;
import static awesome.kunsang.activityfragmentcommunication.Fragment3.newInstance3;
import static awesome.kunsang.activityfragmentcommunication.JustFragment.*;

public class MainActivity extends AppCompatActivity {
    private ViewPager pager;
    String text;
    Button button;
    TextView textview;
    private ViewPagerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        pager = (ViewPager) findViewById(R.id.viewpager);
        button=(Button)findViewById(R.id.button);
        textview=(TextView)findViewById(R.id.textView);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                EditText editText;
                int currentPage=pager.getCurrentItem();
                Log.i("current page",""+currentPage);
                View view;
                switch (currentPage)
                {
                    case 0:
                       JustFragment  justFragment = (JustFragment) adapter.instantiateItem(pager, 0);
                        view = justFragment.getView();
                        if(view==null)
                        {
                            Log.i("log","null view");
                            return;
                        }
                        editText=(EditText)view.findViewById(R.id.editText);
                        text=editText.getText().toString();

                        break;
                    case 1:
                        Fragment1  fragment1 = (Fragment1) adapter.instantiateItem(pager, 1);
                        view = fragment1.getView();
                        editText=(EditText)view.findViewById(R.id.editText);
                        text=editText.getText().toString();

                        break;
                    case 2:
                        Fragment2  fragment2 = (Fragment2) adapter.instantiateItem(pager, 2);
                        view = fragment2.getView();
                        editText=(EditText)view.findViewById(R.id.editText);
                        text=editText.getText().toString();

                        break;
                    case 3:
                        Fragment3  fragment3 = (Fragment3) adapter.instantiateItem(pager,3);
                        view = fragment3.getView();
                        editText=(EditText)view.findViewById(R.id.editText);
                        text=editText.getText().toString();

                        break;
                }
                textview.setText(text);
            }
        });
        setPagerAdapter();

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
            Log.i("current view pager",""+i);
            switch (i)
            {
                case 0:return newInstance();
                case 1:return  newInstance1();
                case 2:return newInstance2();
                case 3: return newInstance3();

            }

            return newInstance();
        }

        @Override
        public int getCount() {
            return 4;
        }
    }
}
