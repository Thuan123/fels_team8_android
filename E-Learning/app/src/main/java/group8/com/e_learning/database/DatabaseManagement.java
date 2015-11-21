package group8.com.e_learning.database;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import group8.com.e_learning.entities.User;

/**
 * Created by nomore on 17/11/2015.
 */
public class DatabaseManagement {

    private SQLiteHelper dbHelper = SQLiteHelper.getInstace();
    private SQLiteDatabase db;
    public void openToReadDb()
    {
        db = dbHelper.getReadableDatabase();
    }
    public User getUser(String userName)
    {
        openToReadDb();
        String projection[] = {
          ELearningDB.Elearning.COLUMN_USER_NAME,
          ELearningDB.Elearning.COLUMN_USER_PASS
        },
               selection = ELearningDB.Elearning.COLUMN_USER_NAME + "=?"
        ,
               selectionArgs[] = {
                       userName
               };

        Cursor cursor = db.query(
                ELearningDB.Elearning.TABLE_USER,
                projection,
                selection,
                selectionArgs,
                null,
                null,
                null
        );
        cursor.moveToFirst();
        User result = new User();
        result.setUserName(cursor.getString(cursor.getColumnIndex(ELearningDB.Elearning.COLUMN_USER_NAME)));
        result.setPassWord(cursor.getString(cursor.getColumnIndex(ELearningDB.Elearning.COLUMN_USER_PASS)));
        return result;

    }
}
