package com.devdrunk.chiangraicalling.fragment;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.devdrunk.chiangraicalling.dao.PlanceOfflineItemDao;
import com.devdrunk.chiangraicalling.dao.TypeOfflineItemDao;
import com.devdrunk.chiangraicalling.view.OfflineTypeListItem;

import java.util.ArrayList;

/**
 * Created by CRRU0001 on 08/06/2559.
 */

class DatabaseHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "cr_calling";
    private static final String DATABASE_TABLE_NAME = "tb_type";

    public static final String COLID = "typeId";
    public static final String COLTITLE = "typeName";

    DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    /**
     * This runs once after the installation and creates a database
     */
    @Override
    public void onCreate(SQLiteDatabase db) {
        // Here we are creating two columns in our database.
        // MyNotesID, which is the primary key and Title which will hold the
        // todo text
        db.execSQL("CREATE TABLE " + DATABASE_TABLE_NAME + " (" + COLID
                + " INTEGER PRIMARY KEY AUTOINCREMENT, " + COLTITLE + " TEXT)");


        db.execSQL("INSERT INTO "+ DATABASE_TABLE_NAME +" (" + COLID + ", " + COLTITLE+") " +
                "VALUES (1, 'เบอร์โทรศัพท์ฉุกเฉินและข้อมูลการท่องเที่ยว');");

        db.execSQL("INSERT INTO "+ DATABASE_TABLE_NAME +" (" + COLID + ", " + COLTITLE+") " +
                "VALUES (2, 'ด่านตรวจคนเข้าเมือง');");

        db.execSQL("INSERT INTO "+ DATABASE_TABLE_NAME +" (" + COLID + ", " + COLTITLE+") " +
                "VALUES (3, 'สำนักงานการท่องเที่ยว');");

        db.execSQL("INSERT INTO "+ DATABASE_TABLE_NAME +" (" + COLID + ", " + COLTITLE+") " +
                "VALUES (4, 'สถานีตำรวจ');");

        db.execSQL("INSERT INTO "+ DATABASE_TABLE_NAME +" (" + COLID + ", " + COLTITLE+") " +
                "VALUES (5, 'รายชื่อโรงพยาบาล');");

        db.execSQL("INSERT INTO "+ DATABASE_TABLE_NAME +" (" + COLID + ", " + COLTITLE+") " +
                "VALUES (6, 'คลีนิกทันตแพทย์');");

        db.execSQL("INSERT INTO "+ DATABASE_TABLE_NAME +" (" + COLID + ", " + COLTITLE+") " +
                "VALUES (7, 'ที่ทำการไปรษณีย์');");

        db.execSQL("INSERT INTO "+ DATABASE_TABLE_NAME +" (" + COLID + ", " + COLTITLE+") " +
                "VALUES (8, 'ข้อมูลการเดินทาง');");

        db.execSQL("INSERT INTO "+ DATABASE_TABLE_NAME +" (" + COLID + ", " + COLTITLE+") " +
                "VALUES (9, 'ข้อมูลสนามบิน');");


        db.execSQL("INSERT INTO "+ DATABASE_TABLE_NAME +" (" + COLID + ", " + COLTITLE+") " +
                "VALUES (10, 'ธนาคารกรุงเทพฯ');");

        db.execSQL("INSERT INTO "+ DATABASE_TABLE_NAME +" (" + COLID + ", " + COLTITLE+") " +
                "VALUES (11, 'ธนาคารกรุงศรีอยุธยา');");

        db.execSQL("INSERT INTO "+ DATABASE_TABLE_NAME +" (" + COLID + ", " + COLTITLE+") " +
                "VALUES (12, 'ธนาคารแห่งประเทศไทย');");

        db.execSQL("INSERT INTO "+ DATABASE_TABLE_NAME +" (" + COLID + ", " + COLTITLE+") " +
                "VALUES (13, 'ธนาคารกสิกรไทย');");

        db.execSQL("INSERT INTO "+ DATABASE_TABLE_NAME +" (" + COLID + ", " + COLTITLE+") " +
                "VALUES (14, 'ธนาคารไทยพาณิชย์');");

        db.execSQL("INSERT INTO "+ DATABASE_TABLE_NAME +" (" + COLID + ", " + COLTITLE+") " +
                "VALUES (15, 'บูทแลกเปลี่ยนเงินต่างประเทศ');");



        createTbPlance(db);

        Log.e("Database = = = = = =  = ", " OK ");

    }

    public void createTbPlance(SQLiteDatabase db){
        db.execSQL("CREATE TABLE tb_plance (tId INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "tName TEXT," +
                "tTel TEXT," +
                "typeId INTEGER)");



        db.execSQL("INSERT INTO tb_plance (tName,tTel,typeId) " +
                "VALUES ('บริการรถพยาบาล','1669',1);");
        db.execSQL("INSERT INTO tb_plance (tName,tTel,typeId) " +
                "VALUES ('บริการสอบถามข้อมูล','1113',1);");
        db.execSQL("INSERT INTO tb_plance (tName,tTel,typeId) " +
                "VALUES ('สายด่วนตำรวจ','191',1);");
        db.execSQL("INSERT INTO tb_plance (tName,tTel,typeId) " +
                "VALUES ('ศูนย์ดับเพลิงเชียงราย','199',1);");
        db.execSQL("INSERT INTO tb_plance (tName,tTel,typeId) " +
                "VALUES ('ศูนย์ป้องกันและปราบปรามการโจรกรรมรถยนต์','1192',1);");
        db.execSQL("INSERT INTO tb_plance (tName,tTel,typeId) " +
                "VALUES ('สำนักงาน ททท. ภาคใต้ เขต 2','053744674',1);");


        db.execSQL("INSERT INTO tb_plance (tName,tTel,typeId) " +
                "VALUES ('เชียงของ','0 5379 1663',2);");
        db.execSQL("INSERT INTO tb_plance (tName,tTel,typeId) " +
                "VALUES ('เชียงแสน','0 5374 0249',2);");
        db.execSQL("INSERT INTO tb_plance (tName,tTel,typeId) " +
                "VALUES ('แม่สาย','0 5373 1008',2);");

        db.execSQL("INSERT INTO tb_plance (tName,tTel,typeId) " +
                "VALUES ('สถานีตำรวจทางหลวง','0 5374 2441',3);");
        db.execSQL("INSERT INTO tb_plance (tName,tTel,typeId) " +
                "VALUES ('บริการข้อมูลข่าวสาร','1672',3);");
        db.execSQL("INSERT INTO tb_plance (tName,tTel,typeId) " +
                "VALUES ('สำนักงานข่าวสารการท่องเที่ยว','0 5371 7433',3);");
        db.execSQL("INSERT INTO tb_plance (tName,tTel,typeId) " +
                "VALUES ('สถานีตำรวจท่องเที่ยว','0 5371 7779',3);");

        db.execSQL("INSERT INTO tb_plance (tName,tTel,typeId) " +
                "VALUES ('สถานีตำรวจภูธรบุญเรือง','0 5378 3445',4);");
        db.execSQL("INSERT INTO tb_plance (tName,tTel,typeId) " +
                "VALUES ('สถานีตำรวจภูธรเชียงของ','0 5379 1426',4);");
        db.execSQL("INSERT INTO tb_plance (tName,tTel,typeId) " +
                "VALUES ('สถานีตำรวจภูธรเชียงแสน','0 5377 7111',4);");
        db.execSQL("INSERT INTO tb_plance (tName,tTel,typeId) " +
                "VALUES ('สถานีตำรวจภูธรดอยหลวง','0 5379 0090',4);");
        db.execSQL("INSERT INTO tb_plance (tName,tTel,typeId) " +
                "VALUES ('สถานีตำรวจภูธรขุนตาล','0 5365 7034',4);");
        db.execSQL("INSERT INTO tb_plance (tName,tTel,typeId) " +
                "VALUES ('สถานีตำรวจภูธรเกาะช้าง','0 5367 5694',4);");
        db.execSQL("INSERT INTO tb_plance (tName,tTel,typeId) " +
                "VALUES ('สถานีตำรวจภูธรแม่อ้อ','0 5360 5295',4);");
        db.execSQL("INSERT INTO tb_plance (tName,tTel,typeId) " +
                "VALUES ('สถานีตำรวจภูธรแม่จัน','0 5371 1444',4);");
        db.execSQL("INSERT INTO tb_plance (tName,tTel,typeId) " +
                "VALUES ('สถานีตำรวจภูธรแม่เจดีย์','0 5378 9508',4);");
        db.execSQL("INSERT INTO tb_plance (tName,tTel,typeId) " +
                "VALUES ('สถานีตำรวจภูธรแม่ฟ้าหลวง','0 5376 7109',4);");
        db.execSQL("INSERT INTO tb_plance (tName,tTel,typeId) " +
                "VALUES ('สถานีตำรวจภูธรแม่ลาว','0 5377 8199',4);");
        db.execSQL("INSERT INTO tb_plance (tName,tTel,typeId) " +
                "VALUES ('สถานีตำรวจภูธรแม่สาย','0 5373 1444',4);");
        db.execSQL("INSERT INTO tb_plance (tName,tTel,typeId) " +
                "VALUES ('สถานีตำรวจภูธรแม่สรวย','0 5378 6004',4);");
        db.execSQL("INSERT INTO tb_plance (tName,tTel,typeId) " +
                "VALUES ('สถานีตำรวจภูธรแม่ยาว','0 5373 7191',4);");
        db.execSQL("INSERT INTO tb_plance (tName,tTel,typeId) " +
                "VALUES ('สถานีตำรวจภูธรเมืองเชียงราย','0 5371 1588',4);");
        db.execSQL("INSERT INTO tb_plance (tName,tTel,typeId) " +
                "VALUES ('สถานีตำรวจภูธรป่าแดด','0 5376 1012',4);");
        db.execSQL("INSERT INTO tb_plance (tName,tTel,typeId) " +
                "VALUES ('สถานีตำรวจภูธรพาน','0 5372 1515',4);");
        db.execSQL("INSERT INTO tb_plance (tName,tTel,typeId) " +
                "VALUES ('สถานีตำรวจภูธรพญาเม็งราย','0 5379 9113',4);");
        db.execSQL("INSERT INTO tb_plance (tName,tTel,typeId) " +
                "VALUES ('สถานีตำรวจภูธรเทิง','0 5379 4405',4);");
        db.execSQL("INSERT INTO tb_plance (tName,tTel,typeId) " +
                "VALUES ('สถานีตำรวจภูธรเวียงชัย','0 5376 9236',4);");
        db.execSQL("INSERT INTO tb_plance (tName,tTel,typeId) " +
                "VALUES ('สถานีตำรวจภูธรเวียงเชียงรุ้ง','0 5395 3155',4);");
        db.execSQL("INSERT INTO tb_plance (tName,tTel,typeId) " +
                "VALUES ('สถานีตำรวจภูธรเวียงแก่น','0 5360 8318',4);");
        db.execSQL("INSERT INTO tb_plance (tName,tTel,typeId) " +
                "VALUES ('สถานีตำรวจภูธรเวียงป่าเป้า','0 5378 1466',4);");


        db.execSQL("INSERT INTO tb_plance (tName,tTel,typeId) " +
                "VALUES ('โรงพยาบาลเชียงรายประชานุเคราะห์','0 5371 1300',5);");
        db.execSQL("INSERT INTO tb_plance (tName,tTel,typeId) " +
                "VALUES ('โรงพยาบาลเชียงแสน','0 5377 7317',5);");
        db.execSQL("INSERT INTO tb_plance (tName,tTel,typeId) " +
                "VALUES ('โรงพยาบาลค่ายเม็งรายมหาราช','0 5371 7649',5);");
        db.execSQL("INSERT INTO tb_plance (tName,tTel,typeId) " +
                "VALUES ('โรงพยาบาลเกษมราษฏร์ ศรีบุรินทร์','0 5391 0999',5);");
        db.execSQL("INSERT INTO tb_plance (tName,tTel,typeId) " +
                "VALUES ('โรงพยาบาลขุนตาล','0 5360 6221',5);");
        db.execSQL("INSERT INTO tb_plance (tName,tTel,typeId) " +
                "VALUES ('โรงพยาบาลแม่จัน','0 5377 1300',5);");
        db.execSQL("INSERT INTO tb_plance (tName,tTel,typeId) " +
                "VALUES ('โรงพยาบาลแม่ฟ้าหลวง','0 5373 0191',5);");
        db.execSQL("INSERT INTO tb_plance (tName,tTel,typeId) " +
                "VALUES ('โรงพยาบาลแม่ลาว','0 5360 3113',5);");
        db.execSQL("INSERT INTO tb_plance (tName,tTel,typeId) " +
                "VALUES ('โรงพยาบาลสมเด็จพระยุพราชเชียงของ','0 5379 1206',5);");
        db.execSQL("INSERT INTO tb_plance (tName,tTel,typeId) " +
                "VALUES ('โรงพยาบาลสมเด็จพระญาณสังวร','0 5360 3123',5);");
        db.execSQL("INSERT INTO tb_plance (tName,tTel,typeId) " +
                "VALUES ('โรงพยาบาลแม่สาย','0 5373 1300',5);");
        db.execSQL("INSERT INTO tb_plance (tName,tTel,typeId) " +
                "VALUES ('โรงพยาบาลแม่สรวย','0 5378 6017',5);");
        db.execSQL("INSERT INTO tb_plance (tName,tTel,typeId) " +
                "VALUES ('โรงพยาบาลโอเวอร์บรุ๊ค','0 5371 1366',5);");
        db.execSQL("INSERT INTO tb_plance (tName,tTel,typeId) " +
                "VALUES ('โรงพยาบาลป่าแดด','0 5365 4479',5);");
        db.execSQL("INSERT INTO tb_plance (tName,tTel,typeId) " +
                "VALUES ('โรงพยาบาลพาน','0 5372 1345',5);");
        db.execSQL("INSERT INTO tb_plance (tName,tTel,typeId) " +
                "VALUES ('โรงพยาบาลอำเภอพญาเม็งราย','0 5379 9033',5);");
        db.execSQL("INSERT INTO tb_plance (tName,tTel,typeId) " +
                "VALUES ('โรงพยาบาลเทิง','0 5379 5259',5);");
        db.execSQL("INSERT INTO tb_plance (tName,tTel,typeId) " +
                "VALUES ('โรงพยาบาลเวียงเชียงรุ้ง','0 5395 3137',5);");
        db.execSQL("INSERT INTO tb_plance (tName,tTel,typeId) " +
                "VALUES ('โรงพยาบาลเวียงแก่น','0 5360 8146',5);");
        db.execSQL("INSERT INTO tb_plance (tName,tTel,typeId) " +
                "VALUES ('โรงพยาบาลเวียงป่าเป้า','0 5378 1342',5);");

        db.execSQL("INSERT INTO tb_plance (tName,tTel,typeId) " +
                "VALUES ('คลินิกบ้านรักฟัน','0 5374 5042',6);");
        db.execSQL("INSERT INTO tb_plance (tName,tTel,typeId) " +
                "VALUES ('คลินิกปกรณ์ทันตกรรม','0 5379 5846',6);");
        db.execSQL("INSERT INTO tb_plance (tName,tTel,typeId) " +
                "VALUES ('คลินิกประจักษ์ทันตกรรม','0 5371 4724',6);");
        db.execSQL("INSERT INTO tb_plance (tName,tTel,typeId) " +
                "VALUES ('คลินิกทันตแพทย์สมพงษ์','0 5371 1741',6);");
        db.execSQL("INSERT INTO tb_plance (tName,tTel,typeId) " +
                "VALUES ('ทันตศิลป์รักษาฟัน','0 5372 1368',6);");
        db.execSQL("INSERT INTO tb_plance (tName,tTel,typeId) " +
                "VALUES ('คลินิกยิ้มสวย','0 5371 1733',6);");

        db.execSQL("INSERT INTO tb_plance (tName,tTel,typeId) " +
                "VALUES ('ที่ทำการไปรษณีย์บ้านดู่','0 5379 3905',7);");
        db.execSQL("INSERT INTO tb_plance (tName,tTel,typeId) " +
                "VALUES ('ที่ทำการไปรษณีย์จันจว้า','0 5377 5102',7);");
        db.execSQL("INSERT INTO tb_plance (tName,tTel,typeId) " +
                "VALUES ('ที่ทำการไปรษณีย์เชียงของ','0 5379 1555',7);");
        db.execSQL("INSERT INTO tb_plance (tName,tTel,typeId) " +
                "VALUES ('ที่ทำการไปรษณีย์เชียงราย','0 5371 3685',7);");
        db.execSQL("INSERT INTO tb_plance (tName,tTel,typeId) " +
                "VALUES ('ที่ทำการไปรษณีย์เชียงแสน','0 5377 7116',7);");
        db.execSQL("INSERT INTO tb_plance (tName,tTel,typeId) " +
                "VALUES ('ที่ทำการไปรษณีย์ห้วยไคร้','0 5376 3009',7);");
        db.execSQL("INSERT INTO tb_plance (tName,tTel,typeId) " +
                "VALUES ('ที่ทำการไปรษณีย์ขุนตาล','0 5365 7318',7);");
        db.execSQL("INSERT INTO tb_plance (tName,tTel,typeId) " +
                "VALUES ('ที่ทำการไปรษณีย์ลานนา','0 5371 7131',7);");
        db.execSQL("INSERT INTO tb_plance (tName,tTel,typeId) " +
                "VALUES ('ที่ทำการไปรษณีย์แม่จัน','0 5377 1979',7);");
        db.execSQL("INSERT INTO tb_plance (tName,tTel,typeId) " +
                "VALUES ('ที่ทำการไปรษณีย์แม่เจดีย์','0 5378 9324',7);");
        db.execSQL("INSERT INTO tb_plance (tName,tTel,typeId) " +
                "VALUES ('ที่ทำการไปรษณีย์แม่คำ','0 5377 9114',7);");
        db.execSQL("INSERT INTO tb_plance (tName,tTel,typeId) " +
                "VALUES ('ที่ทำการไปรษณีย์แม่ลาว','0 5372 9103',7);");
        db.execSQL("INSERT INTO tb_plance (tName,tTel,typeId) " +
                "VALUES ('ที่ทำการไปรษณีย์แม่สาย','0 5373 1402',7);");
        db.execSQL("INSERT INTO tb_plance (tName,tTel,typeId) " +
                "VALUES ('ที่ทำการไปรษณีย์แม่สรวย','0 5378 6101',7);");
        db.execSQL("INSERT INTO tb_plance (tName,tTel,typeId) " +
                "VALUES ('ที่ทำการไปรษณีย์แม่เย็น','0 5395 7039',7);");
        db.execSQL("INSERT INTO tb_plance (tName,tTel,typeId) " +
                "VALUES ('ที่ทำการไปรษณีย์ป่าแดด','0 5376 1043',7);");
        db.execSQL("INSERT INTO tb_plance (tName,tTel,typeId) " +
                "VALUES ('ที่ทำการไปรษณีย์พาน','0 5372 1498',7);");
        db.execSQL("INSERT INTO tb_plance (tName,tTel,typeId) " +
                "VALUES ('ที่ทำการไปรษณีย์พญาเม็งราย','0 5379 9074',7);");
        db.execSQL("INSERT INTO tb_plance (tName,tTel,typeId) " +
                "VALUES ('ที่ทำการไปรษณีย์ปล้อง','0 5395 4183',7);");
        db.execSQL("INSERT INTO tb_plance (tName,tTel,typeId) " +
                "VALUES ('ที่ทำการไปรษณีย์เทิง','160 5379 538972',7);");
        db.execSQL("INSERT INTO tb_plance (tName,tTel,typeId) " +
                "VALUES ('ที่ทำการไปรษณีย์เวียงชัย','0 5376 9234',7);");
        db.execSQL("INSERT INTO tb_plance (tName,tTel,typeId) " +
                "VALUES ('ที่ทำการไปรษณีย์เวียงแก่น','0 5360 8028',7);");
        db.execSQL("INSERT INTO tb_plance (tName,tTel,typeId) " +
                "VALUES ('ที่ทำการไปรษณีย์เวียงป่าเป้า','0 5378 1198',7);");

        db.execSQL("INSERT INTO tb_plance (tName,tTel,typeId) " +
                "VALUES ('สถานีขนส่งผู้โดยสารเชียงราย','0 5371 1369',8);");
        db.execSQL("INSERT INTO tb_plance (tName,tTel,typeId) " +
                "VALUES ('อินทราทัวร์','0 5371 1235',8);");
        db.execSQL("INSERT INTO tb_plance (tName,tTel,typeId) " +
                "VALUES ('คฤหาสน์ทัวร์','0 5374 2429',8);");
        db.execSQL("INSERT INTO tb_plance (tName,tTel,typeId) " +
                "VALUES ('สยามเฟิสท์ทัวร์','0 5371 1882',8);");
        db.execSQL("INSERT INTO tb_plance (tName,tTel,typeId) " +
                "VALUES ('บริษัท ขนส่ง จำกัด (บขส.)','1490',8);");
        db.execSQL("INSERT INTO tb_plance (tName,tTel,typeId) " +
                "VALUES ('โชครุ่งทวีทัวร์ จำกัด ห้วยไคร้','0 5376 3034',8);");
        db.execSQL("INSERT INTO tb_plance (tName,tTel,typeId) " +
                "VALUES ('โชครุ่งทวีทัวร์ จำกัด แม่จัน','0 5377 1657',8);");
        db.execSQL("INSERT INTO tb_plance (tName,tTel,typeId) " +
                "VALUES ('โชครุ่งทวีทัวร์ จำกัด แม่ฟ้าหลวง','08 9191 6710',8);");
        db.execSQL("INSERT INTO tb_plance (tName,tTel,typeId) " +
                "VALUES ('โชครุ่งทวีทัวร์ จำกัด แม่คำ','08 69126 654',8);");
        db.execSQL("INSERT INTO tb_plance (tName,tTel,typeId) " +
                "VALUES ('โชครุ่งทวีทัวร์ จำกัด แม่สาย','0 5364 0123',8);");
        db.execSQL("INSERT INTO tb_plance (tName,tTel,typeId) " +
                "VALUES ('โชครุ่งทวีทัวร์ จำกัด เมืองเชียงราย','0 5371 4045',8);");
        db.execSQL("INSERT INTO tb_plance (tName,tTel,typeId) " +
                "VALUES ('โชครุ่งทวีทัวร์ จำกัด พาน','0 5372 1247',8);");
        db.execSQL("INSERT INTO tb_plance (tName,tTel,typeId) " +
                "VALUES ('สมบัติทัวร์ สำนักงานกลาง','02 792 1444',8);");
        db.execSQL("INSERT INTO tb_plance (tName,tTel,typeId) " +
                "VALUES ('สมบัติทัวร์ บ้านต้า','0 5379 7096',8);");
        db.execSQL("INSERT INTO tb_plance (tName,tTel,typeId) " +
                "VALUES ('สมบัติทัวร์ เชียงของ','0 5379 1644',8);");
        db.execSQL("INSERT INTO tb_plance (tName,tTel,typeId) " +
                "VALUES ('สมบัติทัวร์ เชียงแสน','08 3603 2754',8);");
        db.execSQL("INSERT INTO tb_plance (tName,tTel,typeId) " +
                "VALUES ('สมบัติทัวร์ แม่จัน','0 5377 1656',8);");
        db.execSQL("INSERT INTO tb_plance (tName,tTel,typeId) " +
                "VALUES ('สมบัติทัวร์ แม่สาย','0 5364 6473',8);");
        db.execSQL("INSERT INTO tb_plance (tName,tTel,typeId) " +
                "VALUES ('สมบัติทัวร์ เมืองเชียงราย','0 5371 4971',8);");
        db.execSQL("INSERT INTO tb_plance (tName,tTel,typeId) " +
                "VALUES ('สมบัติทัวร์ นางแล','0 5370 6353',8);");
        db.execSQL("INSERT INTO tb_plance (tName,tTel,typeId) " +
                "VALUES ('สมบัติทัวร์ พาน','0 5365 8877',8);");
        db.execSQL("INSERT INTO tb_plance (tName,tTel,typeId) " +
                "VALUES ('สมบัติทัวร์ ตะเคียนคู่','0 5370 1338',8);");
        db.execSQL("INSERT INTO tb_plance (tName,tTel,typeId) " +
                "VALUES ('สมบัติทัวร์ เทิง','0 5379 5452',8);");



        db.execSQL("INSERT INTO tb_plance (tName,tTel,typeId) " +
                "VALUES ('ท่าอากาศยานแม่ฟ้าหลวง เชียงราย','0 5379 8000',9);");
        db.execSQL("INSERT INTO tb_plance (tName,tTel,typeId) " +
                "VALUES ('เอสเอจี (นกมินิ)','1318',9);");
        db.execSQL("INSERT INTO tb_plance (tName,tTel,typeId) " +
                "VALUES ('แอร์เอเชีย สนามบิน','0 5379 3545',9);");
        db.execSQL("INSERT INTO tb_plance (tName,tTel,typeId) " +
                "VALUES ('แอร์เอเชีย สำรองที่นั่ง จองตั๋ว','02 515 9999',9);");
        db.execSQL("INSERT INTO tb_plance (tName,tTel,typeId) " +
                "VALUES ('การบินไทย สนามบิน','0 5379 8200',9);");
        db.execSQL("INSERT INTO tb_plance (tName,tTel,typeId) " +
                "VALUES ('การบินไทย สำรองที่นั่ง จองตั๋ว','0 53711179',9);");
        db.execSQL("INSERT INTO tb_plance (tName,tTel,typeId) " +
                "VALUES ('โอเรียนท์ ไทย (วันทูโก) สนามบิน','0 5379 3555',9);");
        db.execSQL("INSERT INTO tb_plance (tName,tTel,typeId) " +
                "VALUES ('โอเรียนท์ ไทย (วันทูโก) สำรองที่นั้ง จองตั๋ว','1126',9);");

        db.execSQL("INSERT INTO tb_plance (tName,tTel,typeId) " +
                "VALUES ('- สาขาบิ๊กซีเชียงราย','0 5374 7058',10);");
        db.execSQL("INSERT INTO tb_plance (tName,tTel,typeId) " +
                "VALUES ('- สาขาเมืองเชียงราย','0 5371 1258',10);");
        db.execSQL("INSERT INTO tb_plance (tName,tTel,typeId) " +
                "VALUES ('- สาขาห้าแยกพ่อขุนเม็งราย','0 5371 8113',10);");
        db.execSQL("INSERT INTO tb_plance (tName,tTel,typeId) " +
                "VALUES ('- สาขาแม่จัน','0 5377 1059',10);");
        db.execSQL("INSERT INTO tb_plance (tName,tTel,typeId) " +
                "VALUES ('- สาขามหาวิทยาลัยแม่ฟ้าหลวง','0 5378 7710',10);");
        db.execSQL("INSERT INTO tb_plance (tName,tTel,typeId) " +
                "VALUES ('- สาขามหาวิทยาลัยราชภัฏเชียงราย','0 5377 6281',10);");
        db.execSQL("INSERT INTO tb_plance (tName,tTel,typeId) " +
                "VALUES ('- สาขาแม่สาย','0 5373 2701',10);");
        db.execSQL("INSERT INTO tb_plance (tName,tTel,typeId) " +
                "VALUES ('- สาขาแม่สรวย','0 5378 6012',10);");
        db.execSQL("INSERT INTO tb_plance (tName,tTel,typeId) " +
                "VALUES ('- สาขาพาน','0 5372 1234',10);");
        db.execSQL("INSERT INTO tb_plance (tName,tTel,typeId) " +
                "VALUES ('- สาขาแม่ขะจาน','0 5370 4411',10);");
        db.execSQL("INSERT INTO tb_plance (tName,tTel,typeId) " +
                "VALUES ('- สาขาเทสโก้โลตัส แม่สาย','0 5373 4561',10);");



        db.execSQL("INSERT INTO tb_plance (tName,tTel,typeId) " +
                "VALUES ('- สาขาเมืองเชียงราย','0 5371 1607',11);");
        db.execSQL("INSERT INTO tb_plance (tName,tTel,typeId) " +
                "VALUES ('- สาขามหาวิทยาลัยแม่ฟ้าหลวง','0 5391 2121',11);");
        db.execSQL("INSERT INTO tb_plance (tName,tTel,typeId) " +
                "VALUES ('- สาขาห้าแยกพ่อขุนเม็งราย','0 5371 1793',11);");
        db.execSQL("INSERT INTO tb_plance (tName,tTel,typeId) " +
                "VALUES ('- สาขาแม่สาย','0 5364 0769-71',11);");
        db.execSQL("INSERT INTO tb_plance (tName,tTel,typeId) " +
                "VALUES ('- สาขาพาน','0 5372 1251',11);");
        db.execSQL("INSERT INTO tb_plance (tName,tTel,typeId) " +
                "VALUES ('- สาขาปตท. ริมกก เชียงราย','0 5371 8383',11);");


        db.execSQL("INSERT INTO tb_plance (tName,tTel,typeId) " +
                "VALUES ('- เชียงราย','0 5371 4029',12);");


        db.execSQL("INSERT INTO tb_plance (tName,tTel,typeId) " +
                "VALUES ('- เชียงของ','0 5365 5393',13);");
        db.execSQL("INSERT INTO tb_plance (tName,tTel,typeId) " +
                "VALUES ('- เชียงแสน','0 5371 1515',13);");
        db.execSQL("INSERT INTO tb_plance (tName,tTel,typeId) " +
                "VALUES ('- สาขาห้าแยกพ่อขุนเม็งราย','0 5374 8311',13);");
        db.execSQL("INSERT INTO tb_plance (tName,tTel,typeId) " +
                "VALUES ('- สาขาถนนซุปเปอร์ไฮเวย์ เชียงราย','0 5375 4144',13);");
        db.execSQL("INSERT INTO tb_plance (tName,tTel,typeId) " +
                "VALUES ('- สาขาย่อยห้วยไคร้ แม่จัน','0 5366 7825',13);");
        db.execSQL("INSERT INTO tb_plance (tName,tTel,typeId) " +
                "VALUES ('- สาขาแม่จัน','0 5366 0721',13);");
        db.execSQL("INSERT INTO tb_plance (tName,tTel,typeId) " +
                "VALUES ('- สาขาแม่สาย','0 5364 0786',13);");
        db.execSQL("INSERT INTO tb_plance (tName,tTel,typeId) " +
                "VALUES ('- สาขาป่าแดด','0 5365 4282',13);");



        db.execSQL("INSERT INTO tb_plance (tName,tTel,typeId) " +
                "VALUES ('- เชียงของ','0 5379 1119',14);");
        db.execSQL("INSERT INTO tb_plance (tName,tTel,typeId) " +
                "VALUES ('- เชียงแสน','0 5377 7041',14);");
        db.execSQL("INSERT INTO tb_plance (tName,tTel,typeId) " +
                "VALUES ('- สาขาย่อยสามเหลี่ยมทองคำ','0 5378 4242',14);");
        db.execSQL("INSERT INTO tb_plance (tName,tTel,typeId) " +
                "VALUES ('- สาขาบ้านดู่ (เชียงราย)','0 5370 3163',14);");
        db.execSQL("INSERT INTO tb_plance (tName,tTel,typeId) " +
                "VALUES ('- สาขาสี่แยกแม่กรณ์ (เชียงราย)','0 5374 6369',14);");
        db.execSQL("INSERT INTO tb_plance (tName,tTel,typeId) " +
                "VALUES ('- บิ๊กซี เชียงราย','0 5374 6971',14);");
        db.execSQL("INSERT INTO tb_plance (tName,tTel,typeId) " +
                "VALUES ('- สาขาเมืองเชียงราย','0 5371 1901',14);");
        db.execSQL("INSERT INTO tb_plance (tName,tTel,typeId) " +
                "VALUES ('- สาขาแม่จัน','0 5366 1014',14);");
        db.execSQL("INSERT INTO tb_plance (tName,tTel,typeId) " +
                "VALUES ('- สาขาแม่สาย','0 5373 2164',14);");
        db.execSQL("INSERT INTO tb_plance (tName,tTel,typeId) " +
                "VALUES ('- สาขาเวียงชัย','0 5376 9099',14);");
        db.execSQL("INSERT INTO tb_plance (tName,tTel,typeId) " +
                "VALUES ('- สาขาเวียงป่าเป้า','0 5378 1101',14);");

        db.execSQL("INSERT INTO tb_plance (tName,tTel,typeId) " +
                "VALUES ('ธนาคารกสิกรไทย สนามบินเชียงราย','0 5379 8266',15);");





    }


    /**
     * This would run after the user updates the app. This is in case you want
     * to modify the database
     */
    @Override
    public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2) {
        // TODO Auto-generated method stub
    }

    /**
     * This method adds a record to the database. All we pass in is the todo
     * text
     */
    public long addRecord(String title) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(COLTITLE, title);

        return db.insert(DATABASE_TABLE_NAME, null, cv);
    }




    /**
     * //This method returns all notes from the database
     */
    public ArrayList<TypeOfflineItemDao> getAllNotes() {
        SQLiteDatabase db = this.getReadableDatabase();
        ArrayList<TypeOfflineItemDao> listItems = new ArrayList<TypeOfflineItemDao>();

        Cursor cursor = db.rawQuery("SELECT * from " + DATABASE_TABLE_NAME,
                new String[] {});

        if (cursor.moveToFirst()) {
            do {
                TypeOfflineItemDao note = new TypeOfflineItemDao();

                note.tId = cursor.getInt(cursor.getColumnIndex(COLID));

                note.tName = cursor.getString(cursor.getColumnIndex(COLTITLE));

                listItems.add(note);
            } while (cursor.moveToNext());
        }

        cursor.close();

        return listItems;
    }

    public ArrayList<PlanceOfflineItemDao> getWhereId(String typeId) {
        SQLiteDatabase db = this.getReadableDatabase();
        ArrayList<PlanceOfflineItemDao> listItems = new ArrayList<PlanceOfflineItemDao>();

        Cursor cursor = db.rawQuery("SELECT * from tb_plance WHERE typeId = " +
                typeId + " ORDER BY tName ASC",
                new String[] {});


        if (cursor.moveToFirst()) {
            do {
                PlanceOfflineItemDao note = new PlanceOfflineItemDao();

                note.lTel = cursor.getString(cursor.getColumnIndex("tTel"));

                note.lName = cursor.getString(cursor.getColumnIndex("tName"));

                listItems.add(note);
            } while (cursor.moveToNext());
        }


        cursor.close();

        return listItems;
    }

    /*
     * //This method deletes a record from the database.
     */
    public void deleteNote(long id) {
        SQLiteDatabase db = this.getReadableDatabase();

        String string = String.valueOf(id);
        db.execSQL("DELETE FROM " + DATABASE_TABLE_NAME + " WHERE " + COLID
                + "=" + id + "");
    }
}
