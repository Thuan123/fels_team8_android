package group8.com.e_learning.database;

import android.provider.BaseColumns;

/**
 * Created by nomore on 12/11/2015.
 */
public final class ELearningDB {
    public ELearningDB(){}
    public static abstract class Elearning implements BaseColumns {
        public static final String TABLE_USER = "User" ;
        public static final String TABLE_LESSON = "Lesson";
        public static final String TABLE_LESSON_WORD = "LessonWord";
        public static final String TABLE_CATEGORY = "Category";
        public static final String TABLE_WORD_ANSWER = "Word Answer";
        public static final String TABLE_WORD = "Word";



        public static final String COLUMN_ID = "id";
        public static final String COLUMN_CREATE_AT = "Create at";
        public static final String COLUMN_UPDATE_AT = "Update at";

        public static final String COLUMN_USER_ID = "User id";
        public static final String COLUMN_RESULT = "Result";

        public static final String COLUMN_LESSON_ID = "Lesson id";
        public static final String COLUMN_WORD_ID = "Word id";
        public static final String COLUMN_WORD_ANSWER_ID = "Word answer id";

        public static final String COLUMN_NAME = "Name";
        public static final String COLUMN_CONTENT = "Content";
        public static final String COLUMN_CORRECT = "Correct";
        public static final String COLUMN_CATEGORY_ID = "Category id";


    }


}
