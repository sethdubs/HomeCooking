package edu.auburn.eng.csse.comp3710;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.View;
import android.view.WindowManager;
import android.widget.PopupWindow;
import android.widget.Toast;

import java.util.logging.Handler;


public class HomeCookingActivity extends AppCompatActivity implements
        HomepageFragment.OnButtonClickedListener, CookingFragment.OnButtonClickedListener2,
        MenuFragment.OnButtonClickedListener, SearchFragment.OnButtonClickedListener,
         OrderFragment.OnButtonClickedListener,
        TimeFragment.OnButtonClickedListener, MapFragment.OnInfoWindowClickedListener, RegisterFragment.OnButtonClickedListener {//MapFragment.OnButtonClickedListener,
    int currentFragment = 20;
    private HomeCooking mHomeCooking;

    FragmentManager mManager;
    FragmentTransaction mTransaction;
    Fragment search, homepage, register, cooking, history, profile, map, time; //order
    OrderFragment order;
    /** Duration of wait **/
    private final int SPLASH_DISPLAY_LENGTH = 1000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_cooking);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mHomeCooking = new HomeCooking();

        mManager = getSupportFragmentManager();

        //create first
        register = new RegisterFragment();
        search = new SearchFragment();
        homepage = new HomepageFragment();
        cooking = new CookingFragment();
        history = new HistoryFragment();
        profile = new ProfileFragment();
        map = new MapFragment();
        order = new OrderFragment();
        time = new TimeFragment();

        if(savedInstanceState != null) {
            switch (savedInstanceState.getInt("currentFragment")) {
                case 0:
                    mTransaction = mManager.beginTransaction();
                    mTransaction.replace(R.id.fragment_container, homepage);
                    mTransaction.addToBackStack(null);
                    mTransaction.commit();
                    mManager.executePendingTransactions();
                    break;
                case 1:
                    mTransaction = mManager.beginTransaction();
                    mTransaction.replace(R.id.fragment_container, search);
                    mTransaction.addToBackStack(null);
                    mTransaction.commit();
                    mManager.executePendingTransactions();
                    break;
                case 2:
                    mTransaction = mManager.beginTransaction();
                    mTransaction.replace(R.id.fragment_container, register);
                    mTransaction.addToBackStack(null);
                    mTransaction.commit();
                    mManager.executePendingTransactions();
                    break;
                case 3:
                    mTransaction = mManager.beginTransaction();
                    mTransaction.replace(R.id.fragment_container, cooking);
                    mTransaction.addToBackStack(null);
                    mTransaction.commit();
                    mManager.executePendingTransactions();
                    break;
                case 4:
                    mTransaction = mManager.beginTransaction();
                    mTransaction.replace(R.id.fragment_container, history);
                    mTransaction.addToBackStack(null);
                    mTransaction.commit();
                    mManager.executePendingTransactions();
                    break;
                case 5:
                    mTransaction = mManager.beginTransaction();
                    mTransaction.replace(R.id.fragment_container, profile);
                    mTransaction.addToBackStack(null);
                    mTransaction.commit();
                    mManager.executePendingTransactions();
                    break;
                case 6:
                    mTransaction = mManager.beginTransaction();
                    mTransaction.replace(R.id.fragment_container, map);
                    mTransaction.addToBackStack(null);
                    mTransaction.commit();
                    mManager.executePendingTransactions();
                    break;
                case 7:
                    mTransaction = mManager.beginTransaction();
                    mTransaction.replace(R.id.fragment_container, order);
                    mTransaction.addToBackStack(null);
                    mTransaction.commit();
                    mManager.executePendingTransactions();
                    break;
                case 8:
                    mTransaction = mManager.beginTransaction();
                    mTransaction.replace(R.id.fragment_container, time);
                    mTransaction.addToBackStack(null);
                    mTransaction.commit();
                    mManager.executePendingTransactions();
                    break;

            }
        }
        else {
            mTransaction = mManager.beginTransaction();
            mTransaction.replace(R.id.fragment_container, register);
            mTransaction.addToBackStack(null);
            mTransaction.commit();
            mManager.executePendingTransactions();
        }

    }

    /*register */
    public void onButtonClicked8(View v){
                mTransaction = mManager.beginTransaction();
                mTransaction.replace(R.id.fragment_container, homepage);
                mTransaction.addToBackStack(null);
                mTransaction.commit();
                mManager.executePendingTransactions();
                currentFragment = 0;
    }

    /* homepage */
    public void onButtonClicked(View v) {
        switch(v.getId()) {
            case R.id.search_button:
                mTransaction = mManager.beginTransaction();
                mTransaction.replace(R.id.fragment_container, search);
                mTransaction.addToBackStack(null);
                mTransaction.commit();
                mManager.executePendingTransactions();
                currentFragment = 1;
                SearchFragment mSearchFragment = (SearchFragment) getSupportFragmentManager()
                        .findFragmentById(R.id.fragment_container);
                break;
            case R.id.cook_button:
                mTransaction = mManager.beginTransaction();
                mTransaction.replace(R.id.fragment_container, cooking);
                mTransaction.addToBackStack(null);
                mTransaction.commit();
                mManager.executePendingTransactions();
                currentFragment = 3;
                //CookingFragment mCookingFragment = (CookingFragment) getSupportFragmentManager()
                       // .findFragmentById(R.id.fragment_container);
                break;
        }
    }

    /* cooking */
    public void onButtonClicked2(View v) {
        switch (v.getId()) {
            case R.id.cooking_submit_button:
                mTransaction = mManager.beginTransaction();
                mTransaction.replace(R.id.fragment_container, homepage);
                mTransaction.addToBackStack(null);
                mTransaction.commit();
                mManager.executePendingTransactions();
                currentFragment = 0;
                //if submitted
                Toast.makeText(HomeCookingActivity.this, "       SUBMIT\nSUCCESSFULLY", Toast.LENGTH_SHORT).show();
                break;
        }
    }

    /* menu bar */
    public void onButtonClicked3(View v) {
        switch (v.getId()) {
            case R.id.home_menu:
                mTransaction = mManager.beginTransaction();
                mTransaction.replace(R.id.fragment_container, homepage);
                mTransaction.addToBackStack(null);
                mTransaction.commit();
                mManager.executePendingTransactions();
                currentFragment = 0;
                break;
            case R.id.history_menu:
                mTransaction = mManager.beginTransaction();
                //change homepage to history
                mTransaction.replace(R.id.fragment_container, history);
                mTransaction.addToBackStack(null);
                mTransaction.commit();
                mManager.executePendingTransactions();
                currentFragment = 4;
                break;
            case R.id.profile_menu:
                mTransaction = mManager.beginTransaction();
                //change homepage to profile
                mTransaction.replace(R.id.fragment_container, profile);
                mTransaction.addToBackStack(null);
                mTransaction.commit();
                mManager.executePendingTransactions();
                currentFragment = 5;
                break;
            case R.id.search_menu:
                mTransaction = mManager.beginTransaction();
                mTransaction.replace(R.id.fragment_container, search);
                currentFragment = 1;
                mTransaction.addToBackStack(null);
                mTransaction.commit();
                mManager.executePendingTransactions();
                break;
        }
    }

    /* search */
    public void onButtonClicked4(View v) {
        switch (v.getId()) {
            case R.id.search_button:
                mTransaction = mManager.beginTransaction();
                //change to list of page
                mTransaction.replace(R.id.fragment_container, search);
                mTransaction.addToBackStack(null);
                mTransaction.commit();
                mManager.executePendingTransactions();
                currentFragment = 1;
                break;
            case R.id.map_button:
                mTransaction = mManager.beginTransaction();
                mTransaction.replace(R.id.fragment_container, map);
                mTransaction.addToBackStack(null);
                mTransaction.commit();
                mManager.executePendingTransactions();
                currentFragment = 6;
                break;
            case R.id.order_1:
                mTransaction = mManager.beginTransaction();
                mTransaction.replace(R.id.fragment_container, order);
                mTransaction.addToBackStack(null);
                mTransaction.commit();
                mManager.executePendingTransactions();
                order.mFood.setText("Hamburger");
                order.mPrice.setText("$5");
                currentFragment = 7;
                break;
            case R.id.order_2:
                mTransaction = mManager.beginTransaction();
                mTransaction.replace(R.id.fragment_container, order);
                mTransaction.addToBackStack(null);
                mTransaction.commit();
                mManager.executePendingTransactions();
                currentFragment = 7;
                order.mFood.setText("Sushi");
                order.mPrice.setText("$8");
                break;
            case R.id.order_3:
                mTransaction = mManager.beginTransaction();
                mTransaction.replace(R.id.fragment_container, order);
                mTransaction.addToBackStack(null);
                mTransaction.commit();
                mManager.executePendingTransactions();
                currentFragment = 7;
                order.mFood.setText("Pizza");
                order.mPrice.setText("$6");
                break;
        }
    }
    public void onInfoWindowClick1() {
        User user = User.getUser();
        mTransaction = mManager.beginTransaction();
        mTransaction.replace(R.id.fragment_container, order);
        mTransaction.addToBackStack(null);
        mTransaction.commit();
        mManager.executePendingTransactions();
        currentFragment = 7;
        order.mFood.setText(user.getFoodItem(user.getCurrentMarker()));
        order.mPrice.setText("$" + user.getPrice(user.getCurrentMarker()).toString());
    }
    /* map */
//    public void onButtonClicked5(View v) {
//        switch (v.getId()) {
//            case R.id.map_button_frg:
//                mTransaction = mManager.beginTransaction();
//                mTransaction.replace(R.id.fragment_container,  order);
//                mTransaction.addToBackStack(null);
//                mTransaction.commit();
//                mManager.executePendingTransactions();
//                break;
//        }
//    }

    /*private void displayPopupWindow(View anchorView) {
        PopupWindow popup = new PopupWindow(HomeCookingActivity.this);
        View layout = getLayoutInflater().inflate(R.layout.fragment_map_popup, null);
        popup.setContentView(layout);
        // Set content width and height
        popup.setHeight(WindowManager.LayoutParams.WRAP_CONTENT);
        popup.setWidth(WindowManager.LayoutParams.WRAP_CONTENT);
        // Closes the popup window when touch outside of it - when looses focus
        popup.setOutsideTouchable(true);
        popup.setFocusable(true);
        // Show anchored to button
        popup.setBackgroundDrawable(new BitmapDrawable());
        popup.showAsDropDown(anchorView);
    }*/

    /* order */
    public void onButtonClicked6(View v) {
        switch (v.getId()) {
            case R.id.submit_order:
                mTransaction = mManager.beginTransaction();
                mTransaction.replace(R.id.fragment_container, time);
                mTransaction.addToBackStack(null);
                mTransaction.commit();
                mManager.executePendingTransactions();
                currentFragment = 8;
                break;

        }
    }

    /* time */
    public void onButtonClicked7(View v) {
        switch (v.getId()) {
            case R.id.okBut:
                mTransaction = mManager.beginTransaction();
                mTransaction.replace(R.id.fragment_container, homepage);
                mTransaction.addToBackStack(null);
                mTransaction.commit();
                mManager.executePendingTransactions();
                currentFragment = 7;
                //if submitted
                Toast.makeText(HomeCookingActivity.this, "       SUBMIT\nSUCCESSFULLY", Toast.LENGTH_SHORT).show();
                break;
        }
    }

    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putInt("currentFragment", currentFragment);
    }

    @Override
    public void onPause(){
        super.onPause();
        Context mContext = getApplicationContext();
        CookData mCook = CookData.getCook(mContext);
        User user = User.getUser();
        mCook.updateUser();
        for(int i = 0; i < user.sizeCookId(); i++) {
            mCook.updateCook(i);
        }
    }

    @Override
    public void onResume(){
        super.onResume();
        Context mContext = getApplicationContext();
        CookData mCook = CookData.getCook(mContext);
        mCook.restoreCooks();
        mCook.restoreUser();
    }
}
