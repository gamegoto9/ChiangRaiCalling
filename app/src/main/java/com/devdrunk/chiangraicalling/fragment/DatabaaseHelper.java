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
                "VALUES (1, 'โทรศัพท์ฉุกเฉินและข้อมูลการท่องเที่ยว');");

        db.execSQL("INSERT INTO "+ DATABASE_TABLE_NAME +" (" + COLID + ", " + COLTITLE+") " +
                "VALUES (2, 'ด่านตรวจคนเข้าเมือง');");

        db.execSQL("INSERT INTO "+ DATABASE_TABLE_NAME +" (" + COLID + ", " + COLTITLE+") " +
                "VALUES (3, 'สำนักงานการท่องเที่ยว');");

        db.execSQL("INSERT INTO "+ DATABASE_TABLE_NAME +" (" + COLID + ", " + COLTITLE+") " +
                "VALUES (4, 'สถานีตำรวจ');");

        db.execSQL("INSERT INTO "+ DATABASE_TABLE_NAME +" (" + COLID + ", " + COLTITLE+") " +
                "VALUES (5, 'โรงพยาบาล');");

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
                "VALUES ('เชียงของ','053791663',2);");
        db.execSQL("INSERT INTO tb_plance (tName,tTel,typeId) " +
                "VALUES ('เชียงแสน','053740249',2);");
        db.execSQL("INSERT INTO tb_plance (tName,tTel,typeId) " +
                "VALUES ('แม่สาย','053731008',2);");

        db.execSQL("INSERT INTO tb_plance (tName,tTel,typeId) " +
                "VALUES ('สถานีตำรวจทางหลวง','053742441',3);");
        db.execSQL("INSERT INTO tb_plance (tName,tTel,typeId) " +
                "VALUES ('บริการข้อมูลข่าวสาร','1672',3);");
        db.execSQL("INSERT INTO tb_plance (tName,tTel,typeId) " +
                "VALUES ('สำนักงานข่าวสารการท่องเที่ยว','053717433',3);");
        db.execSQL("INSERT INTO tb_plance (tName,tTel,typeId) " +
                "VALUES ('สถานีตำรวจท่องเที่ยว','053717779',3);");

        db.execSQL("INSERT INTO tb_plance (tName,tTel,typeId) " +
                "VALUES ('สถานีตำรวจภูธรบุญเรือง','053783445',4);");
        db.execSQL("INSERT INTO tb_plance (tName,tTel,typeId) " +
                "VALUES ('สถานีตำรวจภูธรเชียงของ','053791426',4);");
        db.execSQL("INSERT INTO tb_plance (tName,tTel,typeId) " +
                "VALUES ('สถานีตำรวจภูธรเชียงแสน','053777111',4);");
        db.execSQL("INSERT INTO tb_plance (tName,tTel,typeId) " +
                "VALUES ('สถานีตำรวจภูธรดอยหลวง','053790090',4);");
        db.execSQL("INSERT INTO tb_plance (tName,tTel,typeId) " +
                "VALUES ('สถานีตำรวจภูธรขุนตาล','053657034',4);");
        db.execSQL("INSERT INTO tb_plance (tName,tTel,typeId) " +
                "VALUES ('สถานีตำรวจภูธรเกาะช้าง','053675694',4);");
        db.execSQL("INSERT INTO tb_plance (tName,tTel,typeId) " +
                "VALUES ('สถานีตำรวจภูธรแม่อ้อ','053605295',4);");
        db.execSQL("INSERT INTO tb_plance (tName,tTel,typeId) " +
                "VALUES ('สถานีตำรวจภูธรแม่จัน','053711444',4);");
        db.execSQL("INSERT INTO tb_plance (tName,tTel,typeId) " +
                "VALUES ('สถานีตำรวจภูธรแม่เจดีย์','053789508',4);");
        db.execSQL("INSERT INTO tb_plance (tName,tTel,typeId) " +
                "VALUES ('สถานีตำรวจภูธรแม่ฟ้าหลวง','053767109',4);");
        db.execSQL("INSERT INTO tb_plance (tName,tTel,typeId) " +
                "VALUES ('สถานีตำรวจภูธรแม่ลาว','053778199',4);");
        db.execSQL("INSERT INTO tb_plance (tName,tTel,typeId) " +
                "VALUES ('สถานีตำรวจภูธรแม่สาย','053731444',4);");
        db.execSQL("INSERT INTO tb_plance (tName,tTel,typeId) " +
                "VALUES ('สถานีตำรวจภูธรแม่สรวย','053786004',4);");
        db.execSQL("INSERT INTO tb_plance (tName,tTel,typeId) " +
                "VALUES ('สถานีตำรวจภูธรแม่ยาว','053737191',4);");
        db.execSQL("INSERT INTO tb_plance (tName,tTel,typeId) " +
                "VALUES ('สถานีตำรวจภูธรเมืองเชียงราย','053711588',4);");
        db.execSQL("INSERT INTO tb_plance (tName,tTel,typeId) " +
                "VALUES ('สถานีตำรวจภูธรป่าแดด','053761012',4);");
        db.execSQL("INSERT INTO tb_plance (tName,tTel,typeId) " +
                "VALUES ('สถานีตำรวจภูธรพาน','053721515',4);");
        db.execSQL("INSERT INTO tb_plance (tName,tTel,typeId) " +
                "VALUES ('สถานีตำรวจภูธรพญาเม็งราย','053799113',4);");
        db.execSQL("INSERT INTO tb_plance (tName,tTel,typeId) " +
                "VALUES ('สถานีตำรวจภูธรเทิง','053794405',4);");
        db.execSQL("INSERT INTO tb_plance (tName,tTel,typeId) " +
                "VALUES ('สถานีตำรวจภูธรเวียงชัย','053769236',4);");
        db.execSQL("INSERT INTO tb_plance (tName,tTel,typeId) " +
                "VALUES ('สถานีตำรวจภูธรเวียงเชียงรุ้ง','053953155',4);");
        db.execSQL("INSERT INTO tb_plance (tName,tTel,typeId) " +
                "VALUES ('สถานีตำรวจภูธรเวียงแก่น','053608318',4);");
        db.execSQL("INSERT INTO tb_plance (tName,tTel,typeId) " +
                "VALUES ('สถานีตำรวจภูธรเวียงป่าเป้า','053781466',4);");


        db.execSQL("INSERT INTO tb_plance (tName,tTel,typeId) " +
                "VALUES ('โรงพยาบาลเชียงรายประชานุเคราะห์','053711300',5);");
        db.execSQL("INSERT INTO tb_plance (tName,tTel,typeId) " +
                "VALUES ('โรงพยาบาลเชียงแสน','053777317',5);");
        db.execSQL("INSERT INTO tb_plance (tName,tTel,typeId) " +
                "VALUES ('โรงพยาบาลค่ายเม็งรายมหาราช','053717649',5);");
        db.execSQL("INSERT INTO tb_plance (tName,tTel,typeId) " +
                "VALUES ('โรงพยาบาลเกษมราษฏร์ ศรีบุรินทร์','053910999',5);");
        db.execSQL("INSERT INTO tb_plance (tName,tTel,typeId) " +
                "VALUES ('โรงพยาบาลขุนตาล','053606221',5);");
        db.execSQL("INSERT INTO tb_plance (tName,tTel,typeId) " +
                "VALUES ('โรงพยาบาลแม่จัน','053771300',5);");
        db.execSQL("INSERT INTO tb_plance (tName,tTel,typeId) " +
                "VALUES ('โรงพยาบาลแม่ฟ้าหลวง','053730191',5);");
        db.execSQL("INSERT INTO tb_plance (tName,tTel,typeId) " +
                "VALUES ('โรงพยาบาลแม่ลาว','053603113',5);");
        db.execSQL("INSERT INTO tb_plance (tName,tTel,typeId) " +
                "VALUES ('โรงพยาบาลสมเด็จพระยุพราชเชียงของ','053791206',5);");
        db.execSQL("INSERT INTO tb_plance (tName,tTel,typeId) " +
                "VALUES ('โรงพยาบาลสมเด็จพระญาณสังวร','053603123',5);");
        db.execSQL("INSERT INTO tb_plance (tName,tTel,typeId) " +
                "VALUES ('โรงพยาบาลแม่สาย','053731300',5);");
        db.execSQL("INSERT INTO tb_plance (tName,tTel,typeId) " +
                "VALUES ('โรงพยาบาลแม่สรวย','053786017',5);");
        db.execSQL("INSERT INTO tb_plance (tName,tTel,typeId) " +
                "VALUES ('โรงพยาบาลโอเวอร์บรุ๊ค','053711366',5);");
        db.execSQL("INSERT INTO tb_plance (tName,tTel,typeId) " +
                "VALUES ('โรงพยาบาลป่าแดด','053654479',5);");
        db.execSQL("INSERT INTO tb_plance (tName,tTel,typeId) " +
                "VALUES ('โรงพยาบาลพาน','053721345',5);");
        db.execSQL("INSERT INTO tb_plance (tName,tTel,typeId) " +
                "VALUES ('โรงพยาบาลอำเภอพญาเม็งราย','053799033',5);");
        db.execSQL("INSERT INTO tb_plance (tName,tTel,typeId) " +
                "VALUES ('โรงพยาบาลเทิง','053795259',5);");
        db.execSQL("INSERT INTO tb_plance (tName,tTel,typeId) " +
                "VALUES ('โรงพยาบาลเวียงเชียงรุ้ง','053953137',5);");
        db.execSQL("INSERT INTO tb_plance (tName,tTel,typeId) " +
                "VALUES ('โรงพยาบาลเวียงแก่น','053608146',5);");
        db.execSQL("INSERT INTO tb_plance (tName,tTel,typeId) " +
                "VALUES ('โรงพยาบาลเวียงป่าเป้า','053781342',5);");

        db.execSQL("INSERT INTO tb_plance (tName,tTel,typeId) " +
                "VALUES ('คลินิกบ้านรักฟัน','053745042',6);");
        db.execSQL("INSERT INTO tb_plance (tName,tTel,typeId) " +
                "VALUES ('คลินิกปกรณ์ทันตกรรม','053795846',6);");
        db.execSQL("INSERT INTO tb_plance (tName,tTel,typeId) " +
                "VALUES ('คลินิกประจักษ์ทันตกรรม','053714724',6);");
        db.execSQL("INSERT INTO tb_plance (tName,tTel,typeId) " +
                "VALUES ('คลินิกทันตแพทย์สมพงษ์','053711741',6);");
        db.execSQL("INSERT INTO tb_plance (tName,tTel,typeId) " +
                "VALUES ('ทันตศิลป์รักษาฟัน','053721368',6);");
        db.execSQL("INSERT INTO tb_plance (tName,tTel,typeId) " +
                "VALUES ('คลินิกยิ้มสวย','053711733',6);");

        db.execSQL("INSERT INTO tb_plance (tName,tTel,typeId) " +
                "VALUES ('ที่ทำการไปรษณีย์บ้านดู่','053793905',7);");
        db.execSQL("INSERT INTO tb_plance (tName,tTel,typeId) " +
                "VALUES ('ที่ทำการไปรษณีย์จันจว้า','053775102',7);");
        db.execSQL("INSERT INTO tb_plance (tName,tTel,typeId) " +
                "VALUES ('ที่ทำการไปรษณีย์เชียงของ','053791555',7);");
        db.execSQL("INSERT INTO tb_plance (tName,tTel,typeId) " +
                "VALUES ('ที่ทำการไปรษณีย์เชียงราย','053713685',7);");
        db.execSQL("INSERT INTO tb_plance (tName,tTel,typeId) " +
                "VALUES ('ที่ทำการไปรษณีย์เชียงแสน','053777116',7);");
        db.execSQL("INSERT INTO tb_plance (tName,tTel,typeId) " +
                "VALUES ('ที่ทำการไปรษณีย์ห้วยไคร้','053763009',7);");
        db.execSQL("INSERT INTO tb_plance (tName,tTel,typeId) " +
                "VALUES ('ที่ทำการไปรษณีย์ขุนตาล','053657318',7);");
        db.execSQL("INSERT INTO tb_plance (tName,tTel,typeId) " +
                "VALUES ('ที่ทำการไปรษณีย์ลานนา','053717131',7);");
        db.execSQL("INSERT INTO tb_plance (tName,tTel,typeId) " +
                "VALUES ('ที่ทำการไปรษณีย์แม่จัน','053771979',7);");
        db.execSQL("INSERT INTO tb_plance (tName,tTel,typeId) " +
                "VALUES ('ที่ทำการไปรษณีย์แม่เจดีย์','053789324',7);");
        db.execSQL("INSERT INTO tb_plance (tName,tTel,typeId) " +
                "VALUES ('ที่ทำการไปรษณีย์แม่คำ','053779114',7);");
        db.execSQL("INSERT INTO tb_plance (tName,tTel,typeId) " +
                "VALUES ('ที่ทำการไปรษณีย์แม่ลาว','053729103',7);");
        db.execSQL("INSERT INTO tb_plance (tName,tTel,typeId) " +
                "VALUES ('ที่ทำการไปรษณีย์แม่สาย','053731402',7);");
        db.execSQL("INSERT INTO tb_plance (tName,tTel,typeId) " +
                "VALUES ('ที่ทำการไปรษณีย์แม่สรวย','053786101',7);");
        db.execSQL("INSERT INTO tb_plance (tName,tTel,typeId) " +
                "VALUES ('ที่ทำการไปรษณีย์แม่เย็น','053957039',7);");
        db.execSQL("INSERT INTO tb_plance (tName,tTel,typeId) " +
                "VALUES ('ที่ทำการไปรษณีย์ป่าแดด','053761043',7);");
        db.execSQL("INSERT INTO tb_plance (tName,tTel,typeId) " +
                "VALUES ('ที่ทำการไปรษณีย์พาน','053721498',7);");
        db.execSQL("INSERT INTO tb_plance (tName,tTel,typeId) " +
                "VALUES ('ที่ทำการไปรษณีย์พญาเม็งราย','053799074',7);");
        db.execSQL("INSERT INTO tb_plance (tName,tTel,typeId) " +
                "VALUES ('ที่ทำการไปรษณีย์ปล้อง','053954183',7);");
        db.execSQL("INSERT INTO tb_plance (tName,tTel,typeId) " +
                "VALUES ('ที่ทำการไปรษณีย์เทิง','05379538972',7);");
        db.execSQL("INSERT INTO tb_plance (tName,tTel,typeId) " +
                "VALUES ('ที่ทำการไปรษณีย์เวียงชัย','053769234',7);");
        db.execSQL("INSERT INTO tb_plance (tName,tTel,typeId) " +
                "VALUES ('ที่ทำการไปรษณีย์เวียงแก่น','053608028',7);");
        db.execSQL("INSERT INTO tb_plance (tName,tTel,typeId) " +
                "VALUES ('ที่ทำการไปรษณีย์เวียงป่าเป้า','053781198',7);");

        db.execSQL("INSERT INTO tb_plance (tName,tTel,typeId) " +
                "VALUES ('สถานีขนส่งผู้โดยสารเชียงราย','053711369',8);");
        db.execSQL("INSERT INTO tb_plance (tName,tTel,typeId) " +
                "VALUES ('อินทราทัวร์','053711235',8);");
        db.execSQL("INSERT INTO tb_plance (tName,tTel,typeId) " +
                "VALUES ('คฤหาสน์ทัวร์','053742429',8);");
        db.execSQL("INSERT INTO tb_plance (tName,tTel,typeId) " +
                "VALUES ('สยามเฟิสท์ทัวร์','053711882',8);");
        db.execSQL("INSERT INTO tb_plance (tName,tTel,typeId) " +
                "VALUES ('บริษัท ขนส่ง จำกัด (บขส.)','1490',8);");
        db.execSQL("INSERT INTO tb_plance (tName,tTel,typeId) " +
                "VALUES ('โชครุ่งทวีทัวร์ จำกัด ห้วยไคร้','053763034',8);");
        db.execSQL("INSERT INTO tb_plance (tName,tTel,typeId) " +
                "VALUES ('โชครุ่งทวีทัวร์ จำกัด แม่จัน','053771657',8);");
        db.execSQL("INSERT INTO tb_plance (tName,tTel,typeId) " +
                "VALUES ('โชครุ่งทวีทัวร์ จำกัด แม่ฟ้าหลวง','0891916710',8);");
        db.execSQL("INSERT INTO tb_plance (tName,tTel,typeId) " +
                "VALUES ('โชครุ่งทวีทัวร์ จำกัด แม่คำ','0869126654',8);");
        db.execSQL("INSERT INTO tb_plance (tName,tTel,typeId) " +
                "VALUES ('โชครุ่งทวีทัวร์ จำกัด แม่สาย','053640123',8);");
        db.execSQL("INSERT INTO tb_plance (tName,tTel,typeId) " +
                "VALUES ('โชครุ่งทวีทัวร์ จำกัด เมืองเชียงราย','053714045',8);");
        db.execSQL("INSERT INTO tb_plance (tName,tTel,typeId) " +
                "VALUES ('โชครุ่งทวีทัวร์ จำกัด พาน','053721247',8);");
        db.execSQL("INSERT INTO tb_plance (tName,tTel,typeId) " +
                "VALUES ('สมบัติทัวร์ สำนักงานกลาง','027921444',8);");
        db.execSQL("INSERT INTO tb_plance (tName,tTel,typeId) " +
                "VALUES ('สมบัติทัวร์ บ้านต้า','053797096',8);");
        db.execSQL("INSERT INTO tb_plance (tName,tTel,typeId) " +
                "VALUES ('สมบัติทัวร์ เชียงของ','053791644',8);");
        db.execSQL("INSERT INTO tb_plance (tName,tTel,typeId) " +
                "VALUES ('สมบัติทัวร์ เชียงแสน','0836032754',8);");
        db.execSQL("INSERT INTO tb_plance (tName,tTel,typeId) " +
                "VALUES ('สมบัติทัวร์ แม่จัน','053771656',8);");
        db.execSQL("INSERT INTO tb_plance (tName,tTel,typeId) " +
                "VALUES ('สมบัติทัวร์ แม่สาย','053646473',8);");
        db.execSQL("INSERT INTO tb_plance (tName,tTel,typeId) " +
                "VALUES ('สมบัติทัวร์ เมืองเชียงราย','053714971',8);");
        db.execSQL("INSERT INTO tb_plance (tName,tTel,typeId) " +
                "VALUES ('สมบัติทัวร์ นางแล','053706353',8);");
        db.execSQL("INSERT INTO tb_plance (tName,tTel,typeId) " +
                "VALUES ('สมบัติทัวร์ พาน','053658877',8);");
        db.execSQL("INSERT INTO tb_plance (tName,tTel,typeId) " +
                "VALUES ('สมบัติทัวร์ ตะเคียนคู่','053701338',8);");
        db.execSQL("INSERT INTO tb_plance (tName,tTel,typeId) " +
                "VALUES ('สมบัติทัวร์ เทิง','053795452',8);");



        db.execSQL("INSERT INTO tb_plance (tName,tTel,typeId) " +
                "VALUES ('ท่าอากาศยานแม่ฟ้าหลวง เชียงราย','053798000',9);");
        db.execSQL("INSERT INTO tb_plance (tName,tTel,typeId) " +
                "VALUES ('เอสเอจี (นกมินิ)','1318',9);");
        db.execSQL("INSERT INTO tb_plance (tName,tTel,typeId) " +
                "VALUES ('แอร์เอเชีย สนามบิน','053793545',9);");
        db.execSQL("INSERT INTO tb_plance (tName,tTel,typeId) " +
                "VALUES ('แอร์เอเชีย สำรองที่นั่ง จองตั๋ว','025159999',9);");
        db.execSQL("INSERT INTO tb_plance (tName,tTel,typeId) " +
                "VALUES ('การบินไทย สนามบิน','053798200',9);");
        db.execSQL("INSERT INTO tb_plance (tName,tTel,typeId) " +
                "VALUES ('การบินไทย สำรองที่นั่ง จองตั๋ว','053711179',9);");
        db.execSQL("INSERT INTO tb_plance (tName,tTel,typeId) " +
                "VALUES ('โอเรียนท์ ไทย (วันทูโก) สนามบิน','053793555',9);");
        db.execSQL("INSERT INTO tb_plance (tName,tTel,typeId) " +
                "VALUES ('โอเรียนท์ ไทย (วันทูโก) สำรองที่นั้ง จองตั๋ว','1126',9);");

        db.execSQL("INSERT INTO tb_plance (tName,tTel,typeId) " +
                "VALUES ('- สาขาบิ๊กซีเชียงราย','053747058',10);");
        db.execSQL("INSERT INTO tb_plance (tName,tTel,typeId) " +
                "VALUES ('- สาขาเมืองเชียงราย','053711258',10);");
        db.execSQL("INSERT INTO tb_plance (tName,tTel,typeId) " +
                "VALUES ('- สาขาห้าแยกพ่อขุนเม็งราย','053718113',10);");
        db.execSQL("INSERT INTO tb_plance (tName,tTel,typeId) " +
                "VALUES ('- สาขาแม่จัน','053771059',10);");
        db.execSQL("INSERT INTO tb_plance (tName,tTel,typeId) " +
                "VALUES ('- สาขามหาวิทยาลัยแม่ฟ้าหลวง','053787710',10);");
        db.execSQL("INSERT INTO tb_plance (tName,tTel,typeId) " +
                "VALUES ('- สาขามหาวิทยาลัยราชภัฏเชียงราย','053776281',10);");
        db.execSQL("INSERT INTO tb_plance (tName,tTel,typeId) " +
                "VALUES ('- สาขาแม่สาย','053732701',10);");
        db.execSQL("INSERT INTO tb_plance (tName,tTel,typeId) " +
                "VALUES ('- สาขาแม่สรวย','053786012',10);");
        db.execSQL("INSERT INTO tb_plance (tName,tTel,typeId) " +
                "VALUES ('- สาขาพาน','053721234',10);");
        db.execSQL("INSERT INTO tb_plance (tName,tTel,typeId) " +
                "VALUES ('- สาขาแม่ขะจาน','053704411',10);");
        db.execSQL("INSERT INTO tb_plance (tName,tTel,typeId) " +
                "VALUES ('- สาขาเทสโก้โลตัส แม่สาย','053734561',10);");



        db.execSQL("INSERT INTO tb_plance (tName,tTel,typeId) " +
                "VALUES ('สาขาเมืองเชียงราย','053711607',11);");
        db.execSQL("INSERT INTO tb_plance (tName,tTel,typeId) " +
                "VALUES ('สาขามหาวิทยาลัยแม่ฟ้าหลวง','053912121',11);");
        db.execSQL("INSERT INTO tb_plance (tName,tTel,typeId) " +
                "VALUES ('สาขาห้าแยกพ่อขุนเม็งราย','053711793',11);");
        db.execSQL("INSERT INTO tb_plance (tName,tTel,typeId) " +
                "VALUES ('สาขาแม่สาย','053640769-71',11);");
        db.execSQL("INSERT INTO tb_plance (tName,tTel,typeId) " +
                "VALUES ('สาขาพาน','053721251',11);");
        db.execSQL("INSERT INTO tb_plance (tName,tTel,typeId) " +
                "VALUES ('สาขาปตท. ริมกก เชียงราย','053718383',11);");


        db.execSQL("INSERT INTO tb_plance (tName,tTel,typeId) " +
                "VALUES ('เชียงราย','053714029',12);");


        db.execSQL("INSERT INTO tb_plance (tName,tTel,typeId) " +
                "VALUES ('เชียงของ','053655393',13);");
        db.execSQL("INSERT INTO tb_plance (tName,tTel,typeId) " +
                "VALUES ('เชียงแสน','053711515',13);");
        db.execSQL("INSERT INTO tb_plance (tName,tTel,typeId) " +
                "VALUES ('สาขาห้าแยกพ่อขุนเม็งราย','053748311',13);");
        db.execSQL("INSERT INTO tb_plance (tName,tTel,typeId) " +
                "VALUES ('สาขาถนนซุปเปอร์ไฮเวย์ เชียงราย','053754144',13);");
        db.execSQL("INSERT INTO tb_plance (tName,tTel,typeId) " +
                "VALUES ('สาขาย่อยห้วยไคร้ แม่จัน','053667825',13);");
        db.execSQL("INSERT INTO tb_plance (tName,tTel,typeId) " +
                "VALUES ('สาขาแม่จัน','053660721',13);");
        db.execSQL("INSERT INTO tb_plance (tName,tTel,typeId) " +
                "VALUES ('สาขาแม่สาย','053640786',13);");
        db.execSQL("INSERT INTO tb_plance (tName,tTel,typeId) " +
                "VALUES ('สาขาป่าแดด','053654282',13);");



        db.execSQL("INSERT INTO tb_plance (tName,tTel,typeId) " +
                "VALUES ('เชียงของ','053791119',14);");
        db.execSQL("INSERT INTO tb_plance (tName,tTel,typeId) " +
                "VALUES ('เชียงแสน','053777041',14);");
        db.execSQL("INSERT INTO tb_plance (tName,tTel,typeId) " +
                "VALUES ('สาขาย่อยสามเหลี่ยมทองคำ','053784242',14);");
        db.execSQL("INSERT INTO tb_plance (tName,tTel,typeId) " +
                "VALUES ('สาขาบ้านดู่ (เชียงราย)','053703163',14);");
        db.execSQL("INSERT INTO tb_plance (tName,tTel,typeId) " +
                "VALUES ('สาขาสี่แยกแม่กรณ์ (เชียงราย)','053746369',14);");
        db.execSQL("INSERT INTO tb_plance (tName,tTel,typeId) " +
                "VALUES ('บิ๊กซี เชียงราย','053746971',14);");
        db.execSQL("INSERT INTO tb_plance (tName,tTel,typeId) " +
                "VALUES ('สาขาเมืองเชียงราย','053711901',14);");
        db.execSQL("INSERT INTO tb_plance (tName,tTel,typeId) " +
                "VALUES ('สาขาแม่จัน','053661014',14);");
        db.execSQL("INSERT INTO tb_plance (tName,tTel,typeId) " +
                "VALUES ('สาขาแม่สาย','053732164',14);");
        db.execSQL("INSERT INTO tb_plance (tName,tTel,typeId) " +
                "VALUES ('สาขาเวียงชัย','053769099',14);");
        db.execSQL("INSERT INTO tb_plance (tName,tTel,typeId) " +
                "VALUES ('สาขาเวียงป่าเป้า','053781101',14);");

        db.execSQL("INSERT INTO tb_plance (tName,tTel,typeId) " +
                "VALUES ('ธนาคารกสิกรไทย สนามบินเชียงราย','053798266',15);");





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
