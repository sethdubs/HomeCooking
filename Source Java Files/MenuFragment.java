package edu.auburn.eng.csse.comp3710;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * Created by Taehui on 4/20/16.
 */
public class MenuFragment extends Fragment {

    Button mHome;
    Button mHistory;
    Button mProfile;
    Button mSearch;

    OnButtonClickedListener mListener;

    public interface OnButtonClickedListener {
        public void onButtonClicked3(View v);
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
        View v = inflater.inflate(R.layout.fragment_menu, container, false);

        mHome = (Button)v.findViewById(R.id.home_menu);
        mSearch = (Button)v.findViewById(R.id.search_menu);
        mHistory = (Button)v.findViewById(R.id.history_menu);
        mProfile = (Button)v.findViewById(R.id.profile_menu);

        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ButtonClickedListener(v);
            }
        };

        mHome.setOnClickListener(listener);
        mSearch.setOnClickListener(listener);
        mHistory.setOnClickListener(listener);
        mProfile.setOnClickListener(listener);

        return v;
    }

    public void ButtonClickedListener(View v) {
        switch (v.getId()) {
            case R.id.home_menu:
                break;
            case R.id.search_menu:
                break;
            case R.id.history_menu:
                break;
            case R.id.profile_menu:
                break;
        }

        mListener.onButtonClicked3(v);

    }

}
