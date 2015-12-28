package awesome.kunsang.activityfragmentcommunication;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.Spinner;

import de.greenrobot.event.EventBus;


/**
 * A simple {@link Fragment} subclass.
 */
public class JustFragment extends Fragment{

    static EditText editText;
    View view;
    public JustFragment() {
        // Required empty public constructor
    }

    public static Fragment newInstance() {
        JustFragment instance;
        instance = new JustFragment();

        return instance;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        view= inflater.inflate(R.layout.fragment_just, container, false);
        editText=(EditText)view.findViewById(R.id.editText);
        return view;
    }


    public static class EditTextNull {
        public boolean editTextNull;
        public EditTextNull() {
            if(editText.length()<1)
            {
                editTextNull=true;
            }
            else {
                editTextNull=false;
            }
        }
    }
}
