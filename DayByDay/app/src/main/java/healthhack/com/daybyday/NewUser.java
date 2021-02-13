package healthhack.com.daybyday;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ShareActionProvider;
import android.widget.Toast;

public class NewUser extends AppCompatActivity
{
    EditText etName;
    Button btSubmit;




    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_user);

        etName = findViewById(R.id.etName);
        btSubmit = findViewById(R.id.btSubmit);

        SharedPreferences preferences = getSharedPreferences(ApplicationClass.MY_NAME, MODE_PRIVATE);
        String user = preferences.getString("user", "");

        if (user != "")
        {
            startActivity(new Intent(NewUser.this, MainActivity.class));
            NewUser.this.finish();
        }

        btSubmit.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                if (etName.getText().toString().isEmpty())
                {
                    Toast.makeText(NewUser.this, "Don't forget to enter your name!",
                            Toast.LENGTH_SHORT).show();
                }
                else
                {
                    String name = etName.getText().toString().trim();

                    SharedPreferences.Editor editor = getSharedPreferences(ApplicationClass.MY_NAME,
                            MODE_PRIVATE)
                            .edit();
                    editor.putString("user", name);
                    editor.commit();
                    startActivity(new Intent(NewUser.this, MainActivity.class));
                    NewUser.this.finish();
                }
            }
        });
    }
}