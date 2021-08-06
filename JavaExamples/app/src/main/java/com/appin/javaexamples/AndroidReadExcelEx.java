package com.appin.javaexamples;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.content.res.AssetManager;
import android.util.Log;
import android.widget.TextView;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.InputStream;
import java.util.Iterator;


public class AndroidReadExcelEx extends AppCompatActivity {
    String TAG ="main";
    private TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_android_read_excel_ex);
        textView = findViewById(R.id.textview);
        readExcelFileFromAssets();

    }
    public void readExcelFileFromAssets() {

        try {

            InputStream myInput;
            // initialize asset manager
            AssetManager assetManager = getAssets();
            //  open excel sheet
            //myInput = assetManager.open("myexcelsheet.xls");//for xls file
            myInput = assetManager.open("sample.xlsx");//for xlsx file
            // Create a POI File System object
            //POIFSFileSystem myFileSystem = new POIFSFileSystem(myInput);//for xls file

            // Create a workbook using the File System
            //HSSFWorkbook myWorkBook = new HSSFWorkbook(myFileSystem);//for xls file
            XSSFWorkbook myWorkBook = new XSSFWorkbook(myInput);//for xlsx file

            // Get the first sheet from workbook
            //HSSFSheet mySheet = myWorkBook.getSheetAt(0);//for xls file
            XSSFSheet mySheet = myWorkBook.getSheetAt(0);//for xlsx file
            // We now need something to iterate through the cells.
            Iterator<Row> rowIter = mySheet.rowIterator();
            int rowno =0;
            textView.append("\n");
            for(int i =0;i<myWorkBook.getNumberOfSheets();i++){
                mySheet = myWorkBook.getSheetAt(i);
                textView.append(mySheet.getSheetName()+"\n");
            }
            while (rowIter.hasNext()) {
                Log.e(TAG, " row no "+ rowno );
                //HSSFRow myRow = (HSSFRow) rowIter.next();//for xls file
                XSSFRow myRow = (XSSFRow) rowIter.next();//for xlsx file
                if(rowno !=0) {
                    Iterator<Cell> cellIter = myRow.cellIterator();
                    int colno =0;
                    String sno="", date="", det="";
                    while (cellIter.hasNext()) {
                        //HSSFCell myCell = (HSSFCell) cellIter.next();//for xls file
                        XSSFCell myCell = (XSSFCell) cellIter.next();//for xlsx file
                        if (colno==0){
                            sno = myCell.toString();
                        }else if (colno==1){
                            date = myCell.toString();
                        }else if (colno==2){
                            det = myCell.toString();
                        }
                        colno++;
                        Log.e(TAG, " Index :" + myCell.getColumnIndex() + " -- " + myCell.toString());
                    }
                    textView.append( sno + " -- "+ date+ "  -- "+ det+"\n");

                }
                rowno++;
            }

        } catch (Exception e) {
            Log.e(TAG, "error "+ e.toString());
        }
    }

}