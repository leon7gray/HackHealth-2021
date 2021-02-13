package healthhack.com.daybyday;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
{
    TextView tvName;
    Button btDaily, btStreak, btChangeName, btCharity;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SharedPreferences preferences = getSharedPreferences(ApplicationClass.MY_NAME, MODE_PRIVATE);
        String user = preferences.getString("user", "");

        tvName = findViewById(R.id.tvName);
        btDaily = findViewById(R.id.btDaily);
        btStreak = findViewById(R.id.btStreak);
        btChangeName = findViewById(R.id.btChangeName);
        btCharity = findViewById(R.id.btCharity);

        tvName.setText(user);

        btDaily.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                startActivity(new Intent(MainActivity.this, DailyAffirmations.class));
            }
        });

        btStreak.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                startActivity(new Intent(MainActivity.this, Streak.class));
            }
        });

        btChangeName.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                SharedPreferences.Editor editor = getSharedPreferences(ApplicationClass.MY_NAME,
                        MODE_PRIVATE)
                        .edit();
                editor.putString("user", "");
                editor.commit();

                startActivity(new Intent(MainActivity.this, NewUser.class));
                MainActivity.this.finish();
            }
        });

        btCharity.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                startActivity(new Intent(MainActivity.this, Charity.class));
            }
        });
    }
}