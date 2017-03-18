package com.example.murove.laisureApp.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by murove on 27/02/2017.
 */
public class dbAccolaisure extends SQLiteOpenHelper{
    // Logging string
    public static final String TAG = dbAccolaisure.class.getSimpleName();


    // Database name

    public static final String DATABASE_NAME ="my_dbAccolaisure";

    //Database Version
    public static final int DATABASE_VERSION = 2;

    //Database Table

    public static final String ACCOMMODATION_TABLE = "accommodation";
    public static final String CAR_HIRING_TABLE = "carHire";
    public static final String EVENTS_TABLE = "events";
    public static final String RESORTS_TABLE = "resorts";




    // fields for the Accommodation table

    public static final String KEY_ID = "id";
    public static final String KEY_ACCOMMODATION_NAME = "accommodation_name";
    public static final String KEY_PHONENUMBERS = "phonenumber";
    public static final String KEY_STARS_RATING = "stars_rating";
   // public static final String KEY_CITY = "city";
   public static final String KEY_PACKAGES = "packages";
    public static final String KEY_COST = "cost";

    // fields for the Car Hiring table

   // public static final String KEY_ID = "id";
    public static final String KEY_COMPANY_NAME = "company_name";
    public static final String KEY_ADDRESS = "address";
    public static final String KEY_CAR_MODEL = "car_model";
    public static final String KEY_NUMBER_PLATES = "number_plates";
    public static final String KEY_DRIVER_CONTACTS= "driver_contacts";
    public static final String KEY_DRIVER_NAME= "driver_name";
   // public static final String KEY_COST = "cost";



    // fields for Events table

   // public static final String KEY_ID = "id";
    public static final String KEY_ARTIST_NAME = "artist_name";
  //  public static final String KEY_PHONENUMBERS = "phonenumber";
    public static final String KEY_VENUE = "venue";
  //  public static final String KEY_CITY = "city";
    public static final String KEY_DATE= "date";
    public static final String KEY_TIME = "time";
   // public static final String KEY_COST = "cost";

    // fields for Resorts table

   // public static final String KEY_ID = "id";
    public static final String KEY_RESORT_NAME = "resorts_name";
    //public static final String KEY_PHONENUMBERS = "phonenumber";
    public static final String KEY_BOOKING_HOUSES = "booking_houses";
    public static final String KEY_ACTIVITIES = "activities";
    public static final String KEY_CITY = "city";
    //public static final String KEY_COST = "cost";
    public static final String KEY_CHECK_IN = "check_in";



    // CONSTRACTOR CALLING THE ARGUEMENTS
    public dbAccolaisure(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }



    // creating the AccoLaisure Database tables

    @Override
    public void onCreate(SQLiteDatabase db) {

        String CREATE_TABLE_ACCOMMODATION = "CREATE TABLE " + ACCOMMODATION_TABLE + "("
                + KEY_ID +   " INTEGER PRIMARY KEY, "
                + KEY_ACCOMMODATION_NAME + "TEXT, "
                + KEY_PHONENUMBERS + "TEXT, "
                + KEY_STARS_RATING + "TEXT, "
                + KEY_CITY + "TEXT, "
                + KEY_COST + "TEXT, "
                + KEY_PACKAGES + "TEXT, "+")";

           db.execSQL(CREATE_TABLE_ACCOMMODATION);

        String CREATE_TABLE_CAR_HIRING = "CREATE TABLE " + CAR_HIRING_TABLE + "("
                + KEY_ID +   " INTEGER PRIMARY KEY, "
                + KEY_COMPANY_NAME + "TEXT, "
                + KEY_PHONENUMBERS + "TEXT, "
                + KEY_ADDRESS + "TEXT, "
                + KEY_CAR_MODEL + "TEXT, "
                + KEY_NUMBER_PLATES + "TEXT, "
                + KEY_DRIVER_CONTACTS + "TEXT, "
                + KEY_COST + "TEXT, "
                +KEY_DRIVER_NAME +"TEXT, "+" )";

           db.execSQL(CREATE_TABLE_CAR_HIRING);


            String CREATE_TABLE_EVENTS = "CREATE TABLE " + EVENTS_TABLE + "("
                    + KEY_ID +   " INTEGER PRIMARY KEY, "
                    + KEY_ARTIST_NAME + "TEXT, "
                    + KEY_PHONENUMBERS + "TEXT, "
                    + KEY_VENUE + "TEXT, "
                    + KEY_CITY + "TEXT, "
                    + KEY_DATE + "TEXT, "
                    + KEY_TIME + "TEXT, "
                    + KEY_COST + "TEXT " + ")";

            db.execSQL(CREATE_TABLE_EVENTS);


            String CREATE_TABLE_RESORTS = "CREATE TABLE " + RESORTS_TABLE + "("
                    + KEY_ID +   " INTEGER PRIMARY KEY, "
                    + KEY_RESORT_NAME + "TEXT, "
                    + KEY_PHONENUMBERS + "TEXT, "
                    + KEY_BOOKING_HOUSES + "TEXT, "
                    + KEY_ACTIVITIES + "TEXT, "
                    + KEY_CITY + "TEXT, "
                    + KEY_COST + "TEXT, "
                    + KEY_CHECK_IN + "TEXT, "+")";

            db.execSQL(CREATE_TABLE_RESORTS);

        }


        // then upgrade the database
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        String queryA,queryE,queryR,queryCH;
        queryA =  "DROP TABLE IF EXIST " + ACCOMMODATION_TABLE;
        queryE =  "DROP TABLE IF EXIST " + EVENTS_TABLE;
        queryR =  "DROP TABLE IF EXIST " + RESORTS_TABLE ;
        queryCH = "DROP TABLE IF EXIST " + CAR_HIRING_TABLE;

// check if the upgrade is truely running

      //log.d(TAG, query);
            db.execSQL(queryA);
            db.execSQL(queryE);
            db.execSQL(queryR);
            db.execSQL(queryCH);

        onCreate(db);

    }
             //creating a method that saves Accommodation information to the Database

    public void insertAccommodation(String accoName, String phoneNumber,
                                    String city,String cost,String packages){

        SQLiteDatabase dbase = getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(KEY_ACCOMMODATION_NAME, accoName);
        values.put(KEY_PHONENUMBERS, phoneNumber);
       // values.put(KEY_STARS_RATING, stars);
        values.put(KEY_CITY, city);
        values.put(KEY_COST, cost);
        values.put(KEY_PACKAGES, packages);

        // inserting the row into the dbase
        long id = dbase.insert(ACCOMMODATION_TABLE, null, values);
        Log.d(TAG, "you have successfully inserted the record " + id);

    }

    //creating a method that saves Events information to the Database

    public void insertEvents(String artist, String phoneNumber, String venue,
                             String city, String date, String checkIn,
                             String cost ){

        SQLiteDatabase dbase = getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(KEY_ARTIST_NAME, artist);
        values.put(KEY_PHONENUMBERS, phoneNumber);
        values.put(KEY_VENUE, venue);
        values.put(KEY_CITY, city);
        values.put(KEY_DATE, date);
        values.put(KEY_COST, cost);

        // inserting the row into the dbase
        long id = dbase.insert(EVENTS_TABLE, null, values);
        Log.d(TAG, "you have successfully inserted the record " + id);

    }

    //creating a method that saves Car Hiring information to the Database

    public void insertCars(String companyName, String phoneNumber,
                           String carModel, String numberPlate, String address, String driverContacts,
                           String driverName, String cost){

        SQLiteDatabase dbase = getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(KEY_COMPANY_NAME, companyName);
        values.put(KEY_PHONENUMBERS, phoneNumber);
        values.put(KEY_CAR_MODEL, carModel);
        values.put(KEY_NUMBER_PLATES, numberPlate);
        values.put(KEY_DRIVER_CONTACTS, driverContacts);
        values.put(KEY_DRIVER_NAME, driverName);
        values.put(KEY_COST, cost);

        // inserting the row into the dbase
        long id = dbase.insert(CAR_HIRING_TABLE, null, values);
        Log.d(TAG, "you have successfully inserted the record " + id);

    }

    //creating a method that saves Resorts information to the Database

    public void insertResorts(String resortName, String phoneNumber, String bookingHouses,
                       String activities, String city, String  cost){

        SQLiteDatabase dbase = getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(KEY_RESORT_NAME, resortName);
        values.put(KEY_PHONENUMBERS, phoneNumber);
        values.put(KEY_BOOKING_HOUSES, bookingHouses);
        values.put(KEY_ACTIVITIES, activities);
        values.put(KEY_CITY, city);
        values.put(KEY_COST, cost);
        //values.put(KEY_CHECK_IN,checkIn );

        // inserting the row into the dbase
        long id = dbase.insert(RESORTS_TABLE, null, values);
        Log.d(TAG, "you have successfully inserted the record " + id);

    }


// to be revised
                // Declaring a ric value of type String (accomodation list)

       public ArrayList<HashMap<String, String>> getAccommodation(){
              ArrayList<HashMap<String, String>> accommodationList = new
                                              ArrayList<HashMap<String, String>>(); ;

           String selectQuery = "SELECT * FROM " + ACCOMMODATION_TABLE;
           SQLiteDatabase db = this.getReadableDatabase();

           // Cursor allows us to access different records by using position the table
           Cursor cursor = db.rawQuery(selectQuery, null);
           if(cursor.moveToFirst()){
               // move all results to our Hashmap
               do{
                   HashMap<String, String> map = new HashMap<>();
                   //now calling the first value under column id

                   map.put(KEY_ID, cursor.getString(0));
                   map.put(KEY_ACCOMMODATION_NAME, cursor.getString(1));
                   map.put(KEY_PHONENUMBERS, cursor.getString(2));
                   map.put(KEY_STARS_RATING, cursor.getString(3));
                   map.put(KEY_CITY, cursor.getString(4));
                   map.put(KEY_COST, cursor.getString(5));
                   map.put(KEY_PACKAGES, cursor.getString(6));


                   accommodationList.add(map);

               }while (cursor.moveToNext());

           }
           db.close();

           return accommodationList;
       }

    // Declaring a ric value of type String (Resorts list)
    public ArrayList<HashMap<String, String>> getResorts(){
        ArrayList<HashMap<String, String>> resortsList = new
                ArrayList<HashMap<String, String>>(); ;

        String selectQuery = "SELECT * FROM " + RESORTS_TABLE;
        SQLiteDatabase db = this.getReadableDatabase();

        // Cursor allows us to access different records by using position the table
        Cursor cursor = db.rawQuery(selectQuery, null);
        if(cursor.moveToFirst()){
            // move all results to our Hashmap
            do{
                HashMap<String, String> map = new HashMap<>();
                //now calling the first value under column id

                map.put(KEY_ID, cursor.getString(0));
                map.put(KEY_RESORT_NAME, cursor.getString(1));
                map.put(KEY_PHONENUMBERS, cursor.getString(2));
                map.put(KEY_BOOKING_HOUSES, cursor.getString(3));
                map.put(KEY_ACTIVITIES, cursor.getString(4));
                map.put(KEY_CITY, cursor.getString(5));
                map.put(KEY_COST, cursor.getString(6));
                map.put(KEY_CHECK_IN, cursor.getString(7));


                resortsList.add(map);

            }while (cursor.moveToNext());

        }
        db.close();

        return resortsList;
    }

    // Declaring a ric value of type String (events list)
    public ArrayList<HashMap<String, String>> getEvent(){
        ArrayList<HashMap<String, String>> eventList = new
                ArrayList<HashMap<String, String>>(); ;

        String selectQuery = "SELECT * FROM " + EVENTS_TABLE;
        SQLiteDatabase db = this.getReadableDatabase();

        // Cursor allows us to access different records by using position the table
        Cursor cursor = db.rawQuery(selectQuery, null);
        if(cursor.moveToFirst()){
            // move all results to our Hashmap
            do{
                HashMap<String, String> map = new HashMap<>();
                //now calling the first value under column id

                map.put(KEY_ID, cursor.getString(0));
                map.put(KEY_ARTIST_NAME, cursor.getString(1));
                map.put(KEY_PHONENUMBERS, cursor.getString(2));
                map.put(KEY_VENUE, cursor.getString(3));
                map.put(KEY_CITY, cursor.getString(4));
                map.put(KEY_DATE, cursor.getString(5));
                map.put(KEY_COST, cursor.getString(7));

                eventList.add(map);

            }while (cursor.moveToNext());

        }
        db.close();

        return eventList;
    }


    // Declaring a ric value of type String (car list)
    public ArrayList<HashMap<String, String>> getCar(){
        ArrayList<HashMap<String, String>> carList = new
                ArrayList<HashMap<String, String>>(); ;

        String selectQuery = "SELECT * FROM " + CAR_HIRING_TABLE;
        SQLiteDatabase db = this.getReadableDatabase();

        // Cursor allows us to access different records by using position the table
        Cursor cursor = db.rawQuery(selectQuery, null);
        if(cursor.moveToFirst()){
            // move all results to our Hashmap
            do{
                HashMap<String, String> map = new HashMap<>();
                //now calling the first value under column id

                map.put(KEY_ID, cursor.getString(0));
                map.put(KEY_COMPANY_NAME, cursor.getString(1));
                map.put(KEY_PHONENUMBERS, cursor.getString(2));
                map.put(KEY_CAR_MODEL, cursor.getString(3));
                map.put(KEY_NUMBER_PLATES, cursor.getString(4));
                map.put(KEY_DRIVER_CONTACTS, cursor.getString(5));
                map.put(KEY_COST, cursor.getString(6));

                carList.add(map);

            }while (cursor.moveToNext());

        }
        db.close();

        return carList;
    }


    ///////////////////method to delete a record from the Accommodation Database//////////////////

    // was called removeCustomer

            public void removeAccomodation(long _id){
                SQLiteDatabase db = getWritableDatabase();
                db.delete(ACCOMMODATION_TABLE, KEY_ID + " = " + _id, null);

                // stamnt of closing the database
                db.close();
            }

    // method to delete a record from the Resorts Database
    public void removeResort(long _id){
        SQLiteDatabase db = getWritableDatabase();
        db.delete(RESORTS_TABLE, KEY_ID + " = " + _id, null);


        // stamnt of closing the database
        db.close();
    }

    // method to delete a record from the Car Hiring Database

    public void removeCar(long _id){
        SQLiteDatabase db = getWritableDatabase();
        db.delete(CAR_HIRING_TABLE, KEY_ID + " = " + _id, null);


        // stamnt of closing the database
        db.close();
    }


    // method to delete a record from the Event Database

    public void removeEvent(long _id){
        SQLiteDatabase db = getWritableDatabase();
        db.delete(EVENTS_TABLE, KEY_ID + " = " + _id, null);


        // stamnt of closing the database
        db.close();
    }

    // creating a search for accommodation

    public ArrayList<HashMap<String, String>> searchAccommo(String searchParam){
        ArrayList<HashMap<String, String>> accommodationList = new
                ArrayList<HashMap<String, String>>();

        //searching  a row by customerName in a table

        String selectQuery = "SELECT * FROM " + ACCOMMODATION_TABLE + "WHERE " +
                KEY_ACCOMMODATION_NAME + "LIKE " + searchParam + "% ";
        SQLiteDatabase db = this.getReadableDatabase();

        // Cursor allows us to access different records by using position the table
        Cursor cursor = db.rawQuery(selectQuery, null);
        if(cursor.moveToFirst()){
            // move all results to our Hashmap
            do{
                HashMap<String, String> map = new HashMap<>();
                //now calling the first value under column id

                map.put(KEY_ID, cursor.getString(0));
                map.put(KEY_ACCOMMODATION_NAME, cursor.getString(1));
                map.put(KEY_PHONENUMBERS, cursor.getString(2));
                map.put(KEY_STARS_RATING, cursor.getString(3));
                map.put(KEY_CITY, cursor.getString(4));
                map.put(KEY_COST, cursor.getString(5));
                map.put(KEY_PACKAGES, cursor.getString(6));


                accommodationList.add(map);

            }while (cursor.moveToNext());

        }
        db.close();

        return accommodationList;
    }

    // creating a search for a car to hire

    public ArrayList<HashMap<String, String>> searchCar(String searchParam){
        ArrayList<HashMap<String, String>> carList = new
                ArrayList<HashMap<String, String>>();

        //searching  a row by customerName in a table

        String selectQuery = "SELECT * FROM " + CAR_HIRING_TABLE + "WHERE " +
                KEY_COMPANY_NAME + "LIKE " + searchParam + "% ";
        SQLiteDatabase db = this.getReadableDatabase();

        // Cursor allows us to access different records by using position the table
        Cursor cursor = db.rawQuery(selectQuery, null);
        if(cursor.moveToFirst()){
            // move all results to our Hashmap
            do{
                HashMap<String, String> map = new HashMap<>();
                //now calling the first value under column id

                map.put(KEY_ID, cursor.getString(0));
                map.put(KEY_COMPANY_NAME, cursor.getString(1));
                map.put(KEY_PHONENUMBERS, cursor.getString(2));
                map.put(KEY_CAR_MODEL, cursor.getString(3));
                map.put(KEY_NUMBER_PLATES, cursor.getString(4));
                map.put(KEY_DRIVER_CONTACTS, cursor.getString(5));
                map.put(KEY_COST, cursor.getString(6));

                carList.add(map);

            }while (cursor.moveToNext());

        }
        db.close();

        return carList;
    }

    // creating a search for a Resort

    public ArrayList<HashMap<String, String>> searchResort(String searchParam){
        ArrayList<HashMap<String, String>> resortsList = new
                ArrayList<HashMap<String, String>>();

        //searching  a row by customerName in a table

        String selectQuery = "SELECT * FROM " + RESORTS_TABLE + "WHERE " +
                KEY_RESORT_NAME + "LIKE " + searchParam + "% ";
        SQLiteDatabase db = this.getReadableDatabase();

        // Cursor allows us to access different records by using position the table
        Cursor cursor = db.rawQuery(selectQuery, null);
        if(cursor.moveToFirst()){
            // move all results to our Hashmap
            do{
                HashMap<String, String> map = new HashMap<>();
                //now calling the first value under column id

                map.put(KEY_ID, cursor.getString(0));
                map.put(KEY_RESORT_NAME, cursor.getString(1));
                map.put(KEY_PHONENUMBERS, cursor.getString(2));
                map.put(KEY_BOOKING_HOUSES, cursor.getString(3));
                map.put(KEY_ACTIVITIES, cursor.getString(4));
                map.put(KEY_CHECK_IN, cursor.getString(5));


                resortsList.add(map);

            }while (cursor.moveToNext());

        }
        db.close();

        return resortsList;
    }

    // creating a search for a Events
    public ArrayList<HashMap<String, String>> searchEvent(String searchParam){
        ArrayList<HashMap<String, String>> eventList = new
                ArrayList<HashMap<String, String>>();

        //searching  a row by customerName in a table

        String selectQuery = "SELECT * FROM " + EVENTS_TABLE + "WHERE " +
                KEY_ARTIST_NAME + "LIKE " + searchParam + "% ";
        SQLiteDatabase db = this.getReadableDatabase();

        // Cursor allows us to access different records by using position the table
        Cursor cursor = db.rawQuery(selectQuery, null);
        if(cursor.moveToFirst()){
            // move all results to our Hashmap
            do{
                HashMap<String, String> map = new HashMap<>();
                //now calling the first value under column id

                map.put(KEY_ID, cursor.getString(0));
                map.put(KEY_ARTIST_NAME, cursor.getString(1));
                map.put(KEY_PHONENUMBERS, cursor.getString(2));
                map.put(KEY_VENUE, cursor.getString(3));
                map.put(KEY_CITY, cursor.getString(4));
                map.put(KEY_DATE, cursor.getString(5));
                map.put(KEY_COST, cursor.getString(7));

                eventList.add(map);

            }while (cursor.moveToNext());

        }
        db.close();

        return eventList;
    }



}
