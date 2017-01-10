package edu.auburn.eng.csse.comp3710;
import android.database.Cursor;
import android.database.CursorWrapper;

import static edu.auburn.eng.csse.comp3710.CookingDbSchema.*;

/**
 * Created by croxson on 5/4/16.
 */
public class UserCursorWrapper extends CursorWrapper {

    public UserCursorWrapper(Cursor cursor){
        super(cursor);
    }

    public void getUser(){
        int id = getInt(getColumnIndex(UserTable.Cols.ID));
        String FName = getString(getColumnIndex(UserTable.Cols.FirstN));
        String LName = getString(getColumnIndex(UserTable.Cols.LastN));
        double lng = getDouble(getColumnIndex((UserTable.Cols.Lng)));
        double lat = getDouble(getColumnIndex(UserTable.Cols.Lat));
        String PNum = getString(getColumnIndex(UserTable.Cols.PhoneNum));

        User user = User.getUser();
        user.setId(id);
        user.setLng(lng);
        user.setLat(lat);
        user.setFirstName(FName);
        user.setLastName(LName);
        user.setPhoneNum(PNum);
    }
}
