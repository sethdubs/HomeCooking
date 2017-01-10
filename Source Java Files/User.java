package edu.auburn.eng.csse.comp3710;

import android.content.Context;
import android.graphics.Bitmap;
import android.location.LocationListener;
import android.location.LocationManager;
import android.widget.TextView;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by Seth Williams on 4/16/2016.
 */
public class User {

    private static User mUser;
    private double mLat;
    private double mLng;
    private ArrayList<Double> cookLat;
    private ArrayList<Double> cookLng;
    private LatLng mCoords;
    private String mFirstName;
    private String mLastName;
    private int id;
    private ArrayList<Integer> cookId;
    private MarkerOptions mMarkerOptions;
    private Marker mMarker;
    //private Bitmap mPicture;
    private ArrayList<Double> mPrice;
    private ArrayList<String> mFoodItem;
    private ArrayList<Date> mDate;
    private ArrayList<Integer> mTime;
    private String mPhoneNum;
    private int currentMarker;

    private User(){
        cookId = new ArrayList<>();
        cookLat = new ArrayList<>();
        cookLng = new ArrayList<>();
        mPrice = new ArrayList<>();
        mFoodItem = new ArrayList<>();
        mDate = new ArrayList<>();
        mTime = new ArrayList<>();
        currentMarker = -1;
    }

    public static User getUser(){
        if(mUser == null)
            mUser = new User();
        return mUser;
    }

    public void setLat(double lat) {
        mLat = lat;
    }

    public void setLng(double lng) {
        mLng = lng;
    }

    public double getLat() {
        return mLat;
    }

    public double getLng() {
        return mLng;
    }

    public void createLatLng() {
        mCoords = new LatLng(mLat, mLng);
    }

    public LatLng getLatLng () {
        return mCoords;
    }

    public void createMarkerOptions() {
        mMarkerOptions = new MarkerOptions().position(mCoords);
    }

    public MarkerOptions getmMarkerOptions() {
        return mMarkerOptions;
    }

    public Marker makeMarker(GoogleMap map) {
        mMarker = map.addMarker(mMarkerOptions);
        return mMarker;
    }

    public void setCurrentMarker(int lat){
        currentMarker = cookLat.indexOf(lat);
    }

    public int getCurrentMarker(){
        return currentMarker;
    }

    public void setLocation() {

    }

    public void setCookLng(double lng, int num){
        if(num < cookLng.size())
            cookLng.set(num, lng);
        else
            cookLng.add(lng);
    }

    public double getCookLng(int num){
        return cookLng.get(num);
    }

    public void setCookLat(double lat, int num){
        if(num < cookLat.size())
            cookLat.set(num, lat);
        else
            cookLat.add(lat);
    }

    public double getCookLat(int num){
        return cookLat.get(num);
    }

    public void setCookId(int id, int num){
        if(num < cookId.size())
            cookId.set(num, id);
        else
            cookId.add(id);
    }

    public double getCookId(int num){
        return cookId.get(num);
    }

    public int sizeCookId(){
        return cookId.size();
    }

    public void setTime(int time, int num){
        if(num < mTime.size())
            mTime.set(num, time);
        else
            mTime.add(time);
    }

    public int getTime(int num){
        return mTime.get(num);
    }

    public void setFoodItem(String item, int num){
        if(num < mFoodItem.size())
            mFoodItem.set(num, item);
        else
            mFoodItem.add(item);
    }

    public String getFoodItem(int num){
        return mFoodItem.get(num);
    }

    public void setPrice(double price, int num){
        if(num < mPrice.size())
            mPrice.set(num, price);
        else
            mPrice.add(price);
    }

    public Double getPrice(int num){
        return mPrice.get(num);
    }

    public String getFirstName() {
        return mFirstName;
    }

    public void setFirstName(String firstName) {
        mFirstName = firstName;
    }

    public String getLastName() {
        return mLastName;
    }

    public void setLastName(String lastName) {
        mLastName = lastName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDate(int num) {
        return mDate.get(num);
    }

    public void setDate(Date date, int num) {
        if(num < mDate.size())
            mDate.set(num, date);
        else
            mDate.add(date);
    }

    public void setDate(long date, int num){
        if(num < mDate.size())
            mDate.set(num, new Date(date));
        else
            mDate.add(new Date(date));
    }

    public String getPhoneNum() {
        return mPhoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        mPhoneNum = phoneNum;
    }

    public int getCurrentId(){
        return cookId.size();
    }
}


