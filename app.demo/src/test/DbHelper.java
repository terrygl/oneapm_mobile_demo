package test;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * 数据库操作类
 * 
 * 对应预览中的Database
 * 
 * @author zxy
 * 
 */
public class DbHelper extends SQLiteOpenHelper {

	public static void testSql() {
		ImageFetchOp.testImage();
	}

	private final static String TAG = "DbHelper"; // 程序标志
	private final static String DATABASE_NAME = "locke_db";
	private final static int DATABASE_VERSION = 1;
	private final static String TABLE_NAME = "tbl_users";
	private final static String CREATE_TABLE_USERS = "CREATE TABLE IF NOT EXISTS tbl_users(id INTEGER PRIMARY KEY AUTOINCREMENT,name TEXT,password TEXT,regdate date)";
	private final static String DROP_TABLE_USERS = "DROP TABLE IF EXIST tbl_users";
	private final static String FIELD_ID = "id";
	public final static String SQL_RAWQUERY = "select id,name,password,regdate FROM tbl_users";

	public DbHelper(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		db.execSQL(CREATE_TABLE_USERS);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		db.execSQL(DROP_TABLE_USERS);
		onCreate(db);
	}

	/*
	 * 添加一条User记录
	 * 
	 * @param user 用户记录
	 * 
	 * @return 返回插入的行 id
	 */
	public long addUser(User user) {
		SQLiteDatabase db = null;
		try {
			// 转化SQLite日期格式
			SimpleDateFormat dateFormat = new SimpleDateFormat(
					"yyyy-MM-dd HH:mm:ss");
			ContentValues values = new ContentValues();
			values.put("name", user.getName());
			values.put("password", user.getPwd());

			db = this.getWritableDatabase();

			long result = db.insert(TABLE_NAME, null, values);
			return result;
		} catch (SQLiteException e) {
			return -1;
		} finally {
			if (db.isOpen())
				db.close();
		}
	}

	/*
	 * 查询记录
	 * 
	 * @return 获取到的行记录
	 */
	public List<User> queryUsers() {
		Cursor c = null;
		SQLiteDatabase db = null;
		List<User> result = new ArrayList<User>();
		try {
			db = this.getReadableDatabase();
			c = db.query(TABLE_NAME, new String[] { "id", "name", "password",
					"regdate" }, null, null, null, null, null, "id asc");

			c.moveToFirst();
			while (!c.isAfterLast()) {
				User user = new User();
				user.setUid(c.getInt(0));
				user.setName(c.getString(1));
				user.setPwd(c.getString(2));

				result.add(user);
				c.moveToNext();
			}
			return result;
		} catch (SQLiteException e) {
			Log.e(TAG, e.getMessage());
			return null;
		} finally {
			if (!c.isClosed()) {
				c.close();
			}
			if (db.isOpen()) {
				db.close();
			}
		}
	}

	/*
	 * 删除一条用户记录
	 * 
	 * @return 是否删除成功
	 */
	public boolean delete(User user) {
		SQLiteDatabase db = null;
		try {
			db = this.getWritableDatabase();
			String where = FIELD_ID + "=?";
			String[] whereValue = { Integer.toString(user.getUid()) };
			long result = db.delete(TABLE_NAME, where, whereValue);
			return result > 0;
		} catch (SQLiteException e) {
			return false;
		} finally {
			if (db.isOpen()) {
				db.close();
			}
		}
	}

	/*
	 * 更新一条记录
	 * 
	 * @return 是否更新成功
	 */
	public boolean update(User user) {
		SQLiteDatabase db = null;
		try {
			db = this.getWritableDatabase();
			String where = FIELD_ID + "=?";
			String[] whereValue = { Integer.toString(user.getUid()) };
			ContentValues values = new ContentValues();
			values.put("name", user.getName());
			values.put("password", user.getPwd());

			long result = db.update(TABLE_NAME, values, where, whereValue);
			return result > 0;
		} catch (SQLiteException e) {
			return false;
		} finally {
			if (db.isOpen()) {
				db.close();
			}
		}
	}
}