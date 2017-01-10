package edu.auburn.eng.csse.comp3710;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class TimeFragment extends Fragment {
    Button mOKButton;

    OnButtonClickedListener mListener;

    public interface OnButtonClickedListener {
        public void onButtonClicked7(View v);
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            mListener = (OnButtonClickedListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString() + "must implement OnButtonClickedListener");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_time, container, false);

        mOKButton = (Button)v.findViewById(R.id.okBut);

        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ButtonClickedListener(v);
            }
        };

        mOKButton.setOnClickListener(listener);

        return v;
    }

    public void ButtonClickedListener(View v) {
        /*switch (v.getId()) {
            case R.id.search_button:
                break;
            case R.id.map_button:
                break;
        }*/
        mListener.onButtonClicked7(v);
    }
}
