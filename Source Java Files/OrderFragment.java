package edu.auburn.eng.csse.comp3710;
import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class OrderFragment extends Fragment{
    Button mOrderButton;
    public static TextView mFood;
    public static TextView mPrice;
    OnButtonClickedListener mListener;
    public static String food;
    public static String price;


    public interface OnButtonClickedListener {
        public void onButtonClicked6(View v);
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
        View v = inflater.inflate(R.layout.fragment_order, container, false);

        mOrderButton = (Button)v.findViewById(R.id.submit_order);
        mFood = (TextView)v.findViewById(R.id.food);
        mPrice = (TextView)v.findViewById(R.id.price);

        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ButtonClickedListener6(v);
            }
        };

        mOrderButton.setOnClickListener(listener);
        return v;
    }

    public void ButtonClickedListener6(View v) {
        /*switch (v.getId()) {
            case R.id.search_button:
                break;
            case R.id.map_button:
                break;
        }*/
        mListener.onButtonClicked6(v);

    }

}
