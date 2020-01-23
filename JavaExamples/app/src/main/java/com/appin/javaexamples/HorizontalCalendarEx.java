package com.appin.javaexamples;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.TextView;

import java.util.Calendar;

import devs.mulham.horizontalcalendar.HorizontalCalendar;
import devs.mulham.horizontalcalendar.HorizontalCalendarView;
import devs.mulham.horizontalcalendar.model.CalendarItemStyle;
import devs.mulham.horizontalcalendar.utils.HorizontalCalendarListener;
import devs.mulham.horizontalcalendar.utils.HorizontalCalendarPredicate;

public class HorizontalCalendarEx extends AppCompatActivity {
TextView textView,textView2,textView3;
public Calendar startDate,endDate;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_horizontal_calendar_ex);

        /* starts before 1 month from now */
         startDate = Calendar.getInstance();
        startDate.add(Calendar.MONTH, -1);

        /* ends after 1 month from now */
        endDate = Calendar.getInstance();
        endDate.add(Calendar.MONTH, 1);

        final HorizontalCalendar horizontalCalendar = new HorizontalCalendar.Builder(this, R.id.calendarView)
                .range(startDate, endDate)
                .datesNumberOnScreen(5)
                .build();
        textView= findViewById(R.id.textView);
        textView2 = findViewById(R.id.textView2);
        textView3 = findViewById(R.id.textView3);
final StringBuilder stringBuilder = new StringBuilder();;
        textView.setText("Date selected by clicking:");
        //textView2.setText("Date selected by calendar scrolling:");
        //textView3.setText("Date selected by long clicking:");
        horizontalCalendar.getSelectedItemStyle().setColorMiddleText(Color.BLUE);
        horizontalCalendar.setCalendarListener(new HorizontalCalendarListener() {
            @Override
            public void onDateSelected(Calendar date, int position) {
                textView.setText("Date selected by clicking: "+date.get(Calendar.DAY_OF_MONTH));
              checkSelected(date);
            }
public void checkSelected(Calendar date){

     stringBuilder.append("Date Selected : "+date.get(Calendar.DAY_OF_MONTH)+"\n");
     textView2.setText(stringBuilder.toString());
}
            @Override
            public void onCalendarScroll(HorizontalCalendarView calendarView,
                                         int dx, int dy) {
                //textView2.setText("Date selected by calendar scrolling: "+dx);
            }

            @Override
            public boolean onDateLongClicked(Calendar date, int position) {
                //textView3.setText("Date selected by long clicking: "+date);
                return true;
            }
        });


    }
}
