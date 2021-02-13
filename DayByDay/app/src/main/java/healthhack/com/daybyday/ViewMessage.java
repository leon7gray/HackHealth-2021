package healthhack.com.daybyday;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ViewMessage extends AppCompatActivity
{
    TextView tvViewMessage;
    Button btDelete;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_message);

        tvViewMessage = findViewById(R.id.tvViewMessage);
        btDelete = findViewById(R.id.btDelete);

        SharedPreferences preferences = getSharedPreferences(ApplicationClass.MY_LIST,
                MODE_PRIVATE);
        SharedPreferences.Editor editor = getSharedPreferences(ApplicationClass.MY_LIST,
                MODE_PRIVATE)
                .edit();

        String message = preferences.getString("user" + getIntent().getIntExtra("index", 0), null);

        tvViewMessage.setText(message);

        btDelete.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {

                Intent intent = new Intent(ViewMessage.this, DailyAffirmations.class);

                intent.putExtra("index", getIntent().getIntExtra("index", 0));
                setResult(RESULT_OK, intent);
                ViewMessage.this.finish();
            }
        });

    }
}