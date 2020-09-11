package com.example.stayfit;
import androidx.appcompat.app.AppCompatActivity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;

public class RemainderActivity extends AppCompatActivity implements View.OnClickListener {
    private int notificationId=1;
    Button back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_remainder);

        findViewById(R.id.btnset).setOnClickListener(this);
        findViewById(R.id.btncancel).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        EditText et = findViewById(R.id.etmess);
        TimePicker tp = findViewById(R.id.tp);

        Intent i = new Intent(RemainderActivity.this, AlaramReceiver.class);
        i.putExtra("notification id", notificationId);
        i.putExtra("message", et.getText().toString());

        PendingIntent ai = PendingIntent.getBroadcast(
                RemainderActivity.this, 0, i, PendingIntent.FLAG_CANCEL_CURRENT);

        AlarmManager am = (AlarmManager) getSystemService(ALARM_SERVICE);

        switch (view.getId()) {

            case R.id.btnset:

                int hour = tp.getCurrentHour();
                int minute = tp.getCurrentMinute();
                Calendar st = Calendar.getInstance();
                st.set(Calendar.HOUR_OF_DAY, hour);
                st.set(Calendar.MINUTE, minute);
                st.set(Calendar.SECOND, 0);
                long ast = st.getTimeInMillis();

                am.set(AlarmManager.RTC_WAKEUP, ast, ai);
                Toast.makeText(this, "Done!", Toast.LENGTH_SHORT).show();
                break;

            case R.id.btncancel:
                am.cancel(ai);
                Toast.makeText(this, "Cancelled!", Toast.LENGTH_SHORT).show();
                break;
        }

    }
}