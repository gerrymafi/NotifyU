package zw.co.noityu.notifyu.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteConstraintException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.widget.Toast;

import zw.co.noityu.notifyu.database.DbTable.*;
import zw.co.noityu.notifyu.entities.Notification;
import zw.co.noityu.notifyu.entities.User;

public class DbTask {
	private Context mContext;
	private SQLiteDatabase db;

	public DbTask(Context context, SQLiteDatabase db) {
		this.db = db;
		mContext = context;
	}

	public void upgrade() {
		mContext.deleteDatabase(DbHelper.DATABASE_NAME);
	}

	public void saveUser(User user, Context c) {
		try {
			ContentValues values = new ContentValues();
			values.put(USERENTRY.USERNAME, user.getUserName());
			values.put(USERENTRY.PASSWORD, user.getPassword());
			values.put(USERENTRY.FIRSTNAME, user.getFirstName());
			values.put(USERENTRY.LASTNAME, user.getLastName());
			values.put(USERENTRY.USERID, user.getUserId());
			values.put(USERENTRY.SCHOOLID, user.getSchoolId());
			values.put(USERENTRY.SCHOOLNAME, user.getSchoolName());
			values.put(USERENTRY.GENDER, user.getGender());
			db.insertWithOnConflict(USERENTRY.TABLE_NAME, null,
					values, SQLiteDatabase.CONFLICT_REPLACE);
		} catch (SQLiteConstraintException e) {
			Toast.makeText(c, "Some fields must be unique",
					Toast.LENGTH_LONG).show();
		} catch (SQLiteException ex) {
			System.out.println(ex.getMessage());
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
	}

    public void SaveNotificaion(Notification notification, Context c) {
        try {
            ContentValues values = new ContentValues();
            values.put(NOTIFICATIONENTRY.CATEGORY, notification.getCategory());
            values.put(NOTIFICATIONENTRY.HEADER, notification.getHeader());
            values.put(NOTIFICATIONENTRY.MESSAGE, notification.getMessage());
            values.put(NOTIFICATIONENTRY.DATERECEIVED, notification.getDateReceived().toString());
            db.insertWithOnConflict(USERENTRY.TABLE_NAME, null,
                    values, SQLiteDatabase.CONFLICT_REPLACE);
        } catch (SQLiteConstraintException e) {
            Toast.makeText(c, "Some fields must be unique",
                    Toast.LENGTH_LONG).show();
        } catch (SQLiteException ex) {
            System.out.println(ex.getMessage());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }


	public Cursor readAllUsers() {
		String[] allColumns = new String[] {
				USERENTRY.USERID,
				USERENTRY.FIRSTNAME };
		Cursor c = db.query(USERENTRY.TABLE_NAME, allColumns,
				null, null, null, null, null);
		if (c != null) {
			c.moveToFirst();
		}
		return c;
	}

    public Cursor readAllNotifications() {
        String[] allColumns = new String[] {
                NOTIFICATIONENTRY.CATEGORY,
                NOTIFICATIONENTRY.HEADER,
                NOTIFICATIONENTRY.MESSAGE,
                NOTIFICATIONENTRY.DATERECEIVED };
        Cursor c = db.query(USERENTRY.TABLE_NAME, allColumns,
                null, null, null, null, null);
        if (c != null) {
            c.moveToFirst();
        }
        return c;
    }

    public Cursor readAllNotificationsByCategory(String category) {
        String[] allColumns = new String[] {
                NOTIFICATIONENTRY.CATEGORY,
                NOTIFICATIONENTRY.HEADER,
                NOTIFICATIONENTRY.MESSAGE,
                NOTIFICATIONENTRY.DATERECEIVED };
        String where = NOTIFICATIONENTRY.CATEGORY + "='"
                + category+"'";
        Cursor c = db.query(USERENTRY.TABLE_NAME, allColumns,
                where, null, null, null, null);
        if (c != null) {
            c.moveToFirst();
        }
        return c;
    }
	
	/*public User[] readAllEntries() {
		Cursor c = db.query(USERENTRY.TABLE_NAME, null,
				null, null, null, null, null);
		if (c != null) {
			c.moveToFirst();
		}
		int rows = c.getCount();
		User[] reg = new User[rows];
		for(int i=0;i<rows;i++){
			User user = new User();
			user.setMobileNumber(c.getString(0));
			user.setNumberType(c.getString(1));
			user.setFirstName(c.getString(2));
			user.setSurname(c.getString(3));
			user.setGender(c.getString(4));
			user.setNationality(c.getString(5));
			user.setIdentificationNumber(c.getString(6));
			user.setPassportNumber(c.getString(7));
			user.setDateOfBirth(c.getString(8));
			user.setAlternateMobileNumber(c.getString(9));
			user.setAddress(c.getString(10));
			user.setCompanyName(c.getString(11));
			user.setCertificateOfIncorporation(c.getString(12));
			user.setAdministratorName(c.getString(13));
			user.setAdministratorSurname(c.getString(14));
			user.setCompanyAddress(c.getString(15));
			user.setProofOfResidence(c.getString(16));
			user.setNationalId(c.getString(17));
			user.setRegistrationForm(c.getString(18));
			reg[i] = user;
			c.moveToNext();
		}
		return reg;
	}
    */

	/*public Cursor readSingleEntry(String username) {
		String[] allColumns = new String[] {
                DbTable.USERENTRY
				
		};
		String where = USERENTRY.MOBILENUMBER + "='"
				+ mobilenumber+"'";
		Cursor c = db.query(USERENTRY.TABLE_NAME, allColumns,
				where, null, null, null, null);
		if (c != null) {
			c.moveToFirst();
		}
		return c;
	}*/

	/*public User readSingleReg(String mobilenumber) {
		String[] allColumns = new String[] {
				USERENTRY.MOBILENUMBER,
				USERENTRY.NUMBERTYPE,
				USERENTRY.FIRSTNAME,
				USERENTRY.SURNAME,
				USERENTRY.GENDER,
				USERENTRY.NATIONALITY,
				USERENTRY.IDENTIFICATIONNUMBER,
				USERENTRY.PASSPORTNUMBER,
				USERENTRY.DATEOFBIRTH,
				USERENTRY.ALTERNATEMOBILENUMBER,
				USERENTRY.ADDRESS,
				USERENTRY.COMPANYNAME,
				USERENTRY.CERTIFICATEOFINCORPORATION,
				USERENTRY.ADMINISTRATORNAME,
				USERENTRY.ADMINISTRATORSURNAME,
				USERENTRY.COMPANYADRESS,
				USERENTRY.PROOFOFRESIDENCE,
				USERENTRY.NATIONALID,
				USERENTRY.REGISTRATIONFORM };
		String where = USERENTRY.MOBILENUMBER + "='"
				+ mobilenumber+"'";
		Cursor c = db.query(USERENTRY.TABLE_NAME, allColumns,
				where, null, null, null, null);
		if (c != null) {
			c.moveToFirst();
		}

		User user = new User();
		user.setMobileNumber(c.getString(0));
		user.setNumberType(c.getString(1));
		user.setFirstName(c.getString(2));
		user.setSurname(c.getString(3));
		user.setGender(c.getString(4));
		user.setNationality(c.getString(5));
		user.setIdentificationNumber(c.getString(6));
		user.setPassportNumber(c.getString(7));
		user.setDateOfBirth(c.getString(8));
		user.setAlternateMobileNumber(c.getString(9));
		user.setAddress(c.getString(10));
		user.setCompanyName(c.getString(11));
		user.setCertificateOfIncorporation(c.getString(12));
		user.setAdministratorName(c.getString(13));
		user.setAdministratorSurname(c.getString(14));
		user.setCompanyAddress(c.getString(15));
		user.setProofOfResidence(c.getString(16));
		user.setNationalId(c.getString(17));
		user.setRegistrationForm(c.getString(18));
		return user;
	}*/
	
	/*public boolean deleteRecord(String number){
		File a = Constants.proofOfResidencePicture;
		File b = Constants.nationalIdPicture;
		File c = Constants.registrationFormPicture;
		if(a.exists()){
			a.delete();
		}
		if(b.exists()){
			b.delete();
		}
		if(c.exists()){
			c.delete();
		}
		Log.d("record deleted","##########"+number);
        return db.delete(USERENTRY.TABLE_NAME, USERENTRY.MOBILENUMBER + "='" + number+"'", null) > 0;
        
    }*/

}
