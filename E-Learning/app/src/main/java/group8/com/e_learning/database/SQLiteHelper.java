package group8.com.e_learning.database;
import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import group8.com.e_learning.database.ELearningDB.Elearning;
/**
 * Created by nomore on 12/11/2015.
 */
public class SQLiteHelper extends SQLiteOpenHelper{

    private static final String TEXT_TYPE = " TEXT";
    private static final String COMMA_SEP = ",";
    /*private static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE " + ELearningDB.Elearning.TABLE_NAME + " (" +
                    Elearning._ID + " INTEGER PRIMARY KEY," +
                    Elearning.COLUMN_NAME_ENTRY_ID + TEXT_TYPE + COMMA_SEP +
                    Elearning.COLUMN_NAME_TITLE + TEXT_TYPE + COMMA_SEP +
    ... // Any other options for the CREATE command
            " )";*/

   // private static final String SQL_DELETE_ENTRIES =
     //       "DROP TABLE IF EXISTS " + Elearning.TABLE_NAME;

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "ELearning.db";

    public SQLiteHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    public void onCreate(SQLiteDatabase db) {
       // db.execSQL(SQL_CREATE_ENTRIES);
    }
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // This database is only a cache for online data, so its upgrade policy is
        // to simply to discard the data and start over
       // db.execSQL(SQL_DELETE_ENTRIES);
        onCreate(db);
    }
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onUpgrade(db, oldVersion, newVersion);
    }

    public void putIntoDb()
    {
    /*    SQLiteDatabase db = mDbHelper.getWritableDatabase();

// Create a new map of values, where column names are the keys
        ContentValues values = new ContentValues();
        values.put(Elearning.COLUMN_NAME_ENTRY_ID, id);
        values.put(Elearning.COLUMN_NAME_TITLE, title);
        values.put(Elearning.COLUMN_NAME_CONTENT, content);

// Insert the new row, returning the primary key value of the new row
        long newRowId;
        newRowId = db.insert(
                Elearning.TABLE_NAME,
                Elearning.COLUMN_NAME_NULLABLE,
                values);
    }
    */

    }

   /* public void readFromDb()
    {

        SQLiteDatabase db = mDbHelper.getReadableDatabase();

// Define a projection that specifies which columns from the database
// you will actually use after this query.
        String[] projection = {
                FeedEntry._ID,
                FeedEntry.COLUMN_NAME_TITLE,
                FeedEntry.COLUMN_NAME_UPDATED,
        ...
        };

// How you want the results sorted in the resulting Cursor
        String sortOrder =
                FeedEntry.COLUMN_NAME_UPDATED + " DESC";

        Cursor c = db.query(
                FeedEntry.TABLE_NAME,  // The table to query
                projection,                               // The columns to return
                selection,                                // The columns for the WHERE clause
                selectionArgs,                            // The values for the WHERE clause
                null,                                     // don't group the rows
                null,                                     // don't filter by row groups
                sortOrder                                 // The sort order
        );
        */
        /*

        To look at a row in the cursor, use one of the Cursor move methods,
        which you must always call before you begin reading values.
         Generally, you should start by calling moveToFirst(),
          which places the "read position" on the first entry in the results.
           For each row, you can read a column's value by calling one of the Cursor get methods,
            such as getString() or getLong().
            For each of the get methods, you must pass the index position of the column you desire,
             which you can get by calling getColumnIndex() or getColumnIndexOrThrow(). For example:

        cursor.moveToFirst();
        long itemId = cursor.getLong(
                cursor.getColumnIndexOrThrow(FeedEntry._ID)
        );
        */


    }


    public void deleteFromDb()
    {
        /*
        // Define 'where' part of query.
        String selection = FeedEntry.COLUMN_NAME_ENTRY_ID + " LIKE ?";
// Specify arguments in placeholder order.
        String[] selectionArgs = { String.valueOf(rowId) };
// Issue SQL statement.
        db.delete(table_name, selection, selectionArgs);
        */
    }

    public void updateDb()
    {

        /*
        SQLiteDatabase db = mDbHelper.getReadableDatabase();

// New value for one column
ContentValues values = new ContentValues();
values.put(FeedEntry.COLUMN_NAME_TITLE, title);

// Which row to update, based on the ID
String selection = FeedEntry.COLUMN_NAME_ENTRY_ID + " LIKE ?";
String[] selectionArgs = { String.valueOf(rowId) };

int count = db.update(
    FeedReaderDbHelper.FeedEntry.TABLE_NAME,
    values,
    selection,
    selectionArgs);


        */

    }


}
