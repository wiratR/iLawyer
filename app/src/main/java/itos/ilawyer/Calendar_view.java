package itos.ilawyer;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CalendarView;
import android.widget.TextView;
import android.widget.Toast;

public class Calendar_view extends AppCompatActivity {

    CalendarView myCalendarView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar_view);

        myCalendarView = (CalendarView) findViewById(R.id.calendarView);
        myCalendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(CalendarView view, int year, int month, int dayOfMonth) {
                Toast.makeText(getApplicationContext(),
                                "Year : " + year + "\n"
                                + "Month : " + year + "\n"
                                + "Day of Month : "
                                + dayOfMonth,Toast.LENGTH_LONG
                ).show();
            }
        }); // Calendar View


    } // Main Method
}
