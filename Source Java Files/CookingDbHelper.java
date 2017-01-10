package edu.auburn.eng.csse.comp3710;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import static edu.auburn.eng.csse.comp3710.CookingDbSchema.*;

/**
 * Created by croxson on 5/3/16.
 */
public class CookingDbHelper extends SQLiteOpenHelper {
    private static final int VERSION = 1;
    private static final String DATABASE_NAME = "cooking.db";

    public CookingDbHelper(Context context){
        super(context, DATABASE_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE table " + UserTable.Name + "(" + UserTable.Cols.ID + "," +
                UserTable.Cols.FirstN + "," + UserTable.Cols.LastN + ", " + UserTable.Cols.PhoneNum +
                ", " + UserTable.Cols.Lng + ", " + UserTable.Cols.Lat + ")");
        db.execSQL("CREATE table " + HistoryTable.Name + "(" + HistoryTable.Cols.ID + ", " + HistoryTable.Cols.Dish +
                ", " + HistoryTable.Cols.date + ", " + HistoryTable.Cols.time + ", " + HistoryTable.Cols.price + ", " +
                HistoryTable.Cols.Lng + ", " + HistoryTable.Cols.Lat + ")");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
