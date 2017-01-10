package edu.auburn.eng.csse.comp3710;
import android.content.Context;
import android.database.Cursor;
import android.database.CursorWrapper;

import static edu.auburn.eng.csse.comp3710.CookingDbSchema.*;

/**
 * Created by croxson on 5/4/16.
 */
public class CookCursorWrapper extends CursorWrapper {

    public CookCursorWrapper(Cursor cursor){
        super(cursor);
    }

    public void getCook(int num){
        int id = getInt(getColumnIndex(HistoryTable.Cols.ID));
        long date = getLong(getColumnIndex(HistoryTable.Cols.date));
        int time = getInt(getColumnIndex(HistoryTable.Cols.time));
        String dish = getString(getColumnIndex(HistoryTable.Cols.Dish));
        double price = getDouble(getColumnIndex(HistoryTable.Cols.price));
        double lng = getDouble(getColumnIndex((HistoryTable.Cols.Lng)));
        double lat = getDouble(getColumnIndex(HistoryTable.Cols.Lat));

        User user = User.getUser();
        user.setCookId(id, num);
        user.setCookLng(lng, num);
        user.setCookLat(lat, num);
        user.setFoodItem(dish, num);
        user.setPrice(price, num);
        user.setDate(date, num);
        user.setTime(time, num);
    }
}
