package edu.auburn.eng.csse.comp3710;

/**
 * Created by croxson on 5/3/16.
 */
public class CookingDbSchema {
    public static final class UserTable{
        public static final String Name = "users";
        public static final class Cols{
            public static final String ID = "id";
            public static final String FirstN = "firstName";
            public static final String LastN = "lastName";
            public static final String PhoneNum = "phone";
            public static final String Lng = "long";
            public static final String Lat = "lat";
        }
    }
    public static final class HistoryTable{
        public static final String Name = "history";
        public static final class Cols{
            public static final String ID = "id";
            public static final String Dish = "dish";
            public static final String date = "date";
            public static final String time = "time";
            public static final String price = "price";
            public static final String Lng = "long";
            public static final String Lat = "lat";
        }
    }
}
