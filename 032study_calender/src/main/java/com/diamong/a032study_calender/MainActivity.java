package com.diamong.a032study_calender;

import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.Toolbar;
import android.text.Selection;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.applikeysolutions.cosmocalendar.utils.SelectionType;
import com.applikeysolutions.cosmocalendar.view.CalendarView;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

public class MainActivity extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener {
    private CalendarView calendarView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setSupportActionBar((Toolbar) findViewById(R.id.toolbar));

        calendarView = findViewById(R.id.calendar_view);
        calendarView.setCalendarOrientation(OrientationHelper.HORIZONTAL);

        ((RadioGroup) findViewById(R.id.rg_selection_type)).setOnCheckedChangeListener(this);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.clear_selections:
                clearSelectionsMenuClick();
                return true;
            case R.id.show_selections:
                List<Calendar> days = calendarView.getSelectedDates();

                String result = "";
                for (int i = 0; i < days.size(); i++) {
                    Calendar calendar = days.get(i);
                    int day = calendar.get(Calendar.DAY_OF_MONTH);
                    int month = calendar.get(Calendar.MONTH);
                    int year = calendar.get(Calendar.YEAR);

                    String week = new SimpleDateFormat("EE").format(calendar.getTime());
                    String day_full = year + "년" + month + "월" + day + "일" + week + "요일";
                    result += (day_full + "\n");
                }

                Toast.makeText(this, result, Toast.LENGTH_SHORT).show();
                return true;

            default:
                return super.onOptionsItemSelected(item);

        }

    }

    private void clearSelectionsMenuClick() {
        calendarView.clearSelections();
    }

    @Override
    public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {

        clearSelectionsMenuClick();
        switch (checkedId){
            case R.id.single:
                calendarView.setSelectionType(SelectionType.SINGLE);
                break;
            case R.id.multiple:
                calendarView.setSelectionType(SelectionType.MULTIPLE);
                break;
            case R.id.rb_range:
                calendarView.setSelectionType(SelectionType.RANGE);
                break;
            case R.id.rb_none:
                calendarView.setSelectionType(SelectionType.NONE);
                break;
        }

    }
}
