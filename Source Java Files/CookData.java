package edu.auburn.eng.csse.comp3710;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import static edu.auburn.eng.csse.comp3710.CookingDbSchema.*;

/**
 * Created by croxson on 5/3/16.
 */
public class CookData {
    private static CookData sCookData;
    private Context mContext;
    private SQLiteDatabase mDatabase;

    public static CookData getCook(Context context){
        if(sCookData == null)
            sCookData = new CookData(context);
        return sCookData;
    }

    private CookData(Context context){
        mContext = context.getApplicationContext();
        mDatabase = new CookingDbHelper(mContext).getWritableDatabase();
    }

    public void updateUser(){
        ContentValues values = getContentValues();
        mDatabase.insert(UserTable.Name, null, values);

    }

    public void updateCook(int num){
        ContentValues values = getContentValues2(num);
        mDatabase.insert(HistoryTable.Name, null, values);
    }

    private static ContentValues getContentValues() {
        ContentValues values = new ContentValues();
        User user = User.getUser();
        values.put(UserTable.Cols.ID, user.getId());
        values.put(UserTable.Cols.FirstN, user.getFirstName());
        values.put(UserTable.Cols.LastN, user.getLastName());
        values.put(UserTable.Cols.PhoneNum, user.getPhoneNum());
        values.put(UserTable.Cols.Lng, user.getLng());
        values.put(UserTable.Cols.Lat, user.getLat());
        return values;
    }

    private static ContentValues getContentValues2(int num){
        ContentValues values = new ContentValues();
        User user = User.getUser();
        values.put(HistoryTable.Cols.ID, user.getCookId(num));
        values.put(HistoryTable.Cols.Dish, user.getFoodItem(num));
        values.put(HistoryTable.Cols.date, user.getDate(num).getTime());
        values.put(HistoryTable.Cols.time, user.getTime(num));
        values.put(HistoryTable.Cols.price, user.getPrice(num));
        values.put(HistoryTable.Cols.Lng, user.getCookLng(num));
        values.put(HistoryTable.Cols.Lat, user.getCookLat(num));
        return values;
    }

    private CookCursorWrapper queryCooks(String whereclause, String[] whereArgs){
        Cursor cursor = mDatabase.query(HistoryTable.Name, null, whereclause, whereArgs, null, null, null);
        return new CookCursorWrapper(cursor);
    }

    public void restoreCooks(){
        User user = User.getUser();
        CookCursorWrapper cursorWrapper = queryCooks(null, null);

        try {
            cursorWrapper.moveToFirst();
            int count = 0;
            while (!cursorWrapper.isAfterLast()) {
                cursorWrapper.getCook(count);
                count++;
                cursorWrapper.moveToNext();
            }
        }
        finally{
            cursorWrapper.close();
        }

    }

    private UserCursorWrapper queryUser(String whereclause, String[] whereArgs){
        Cursor cursor = mDatabase.query(UserTable.Name, null, whereclause, whereArgs, null, null, null);
        return new UserCursorWrapper(cursor);
    }

    public void restoreUser(){
        UserCursorWrapper cursorWrapper = queryUser(null, null);

        try {
            cursorWrapper.moveToFirst();
            while (!cursorWrapper.isAfterLast()) {
                cursorWrapper.getUser();
                cursorWrapper.moveToNext();
            }
        }
        finally{
            cursorWrapper.close();
        }
    }
}
