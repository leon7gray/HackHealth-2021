package healthhack.com.daybyday;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddMessage extends AppCompatActivity
{
    EditText etAdd;
    Button btAdd;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_message);

        etAdd = findViewById(R.id.etAdd);
        btAdd = findViewById(R.id.btAdd);

        btAdd.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                if (etAdd.getText().toString().trim().isEmpty())
                {
                    Toast.makeText(AddMessage.this, "You left your message blank!",
                            Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Intent intent = new Intent(AddMessage.this, DailyAffirmations.class);
                    intent.putExtra("message", etAdd.getText().toString().trim());
                    setResult(RESULT_OK, intent);
                    AddMessage.this.finish();
                }
            }
        });


    }
}