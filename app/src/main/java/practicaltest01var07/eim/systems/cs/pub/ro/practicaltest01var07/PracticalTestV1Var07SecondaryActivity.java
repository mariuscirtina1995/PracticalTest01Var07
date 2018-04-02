package practicaltest01var07.eim.systems.cs.pub.ro.practicaltest01var07;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class PracticalTestV1Var07SecondaryActivity extends AppCompatActivity {

    private TextView textBox1 = null;
    private TextView textBox2 = null;
    private TextView textBox3 = null;
    private TextView textBox4 = null;
    private Button sumButton = null;
    private Button prodButton= null;

    private ButtonClickListener buttonClickListener = new ButtonClickListener();
    private class ButtonClickListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.sumButton:
                    int sum = Integer.parseInt(textBox1.getText().toString()) + Integer.parseInt(textBox2.getText().toString()) +
                            Integer.parseInt(textBox3.getText().toString()) + Integer.parseInt(textBox4.getText().toString());

                    ToastPrint(sum);
                    break;

                case R.id.productButton:
                    int prod = Integer.parseInt(textBox1.getText().toString()) * Integer.parseInt(textBox2.getText().toString()) *
                            Integer.parseInt(textBox3.getText().toString()) * Integer.parseInt(textBox4.getText().toString());

                    ToastPrint(prod);
                    break;

            }
        }
    }

    public void ToastPrint(int x)
    {
        Toast.makeText(this, "Result = " + x, Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical_test_v1_var07_secondary);

        textBox1 = findViewById(R.id.textView1);
        textBox2 = findViewById(R.id.textView2);
        textBox3 = findViewById(R.id.textView3);
        textBox4 = findViewById(R.id.textView4);

        sumButton = findViewById(R.id.sumButton);
        prodButton = findViewById(R.id.productButton);

        sumButton.setOnClickListener(buttonClickListener);
        prodButton.setOnClickListener(buttonClickListener);

        Intent intent = getIntent();
        if (intent != null && intent.getExtras().containsKey("editText1")) {
            int number1 = intent.getIntExtra("editText1", -1);
            textBox1.setText(String.valueOf(number1));
        }

        if (intent != null && intent.getExtras().containsKey("editText2")) {
            int number2 = intent.getIntExtra("editText2", -1);
            textBox2.setText(String.valueOf(number2));
        }

        if (intent != null && intent.getExtras().containsKey("editText3")) {
            int number3 = intent.getIntExtra("editText3", -1);
            textBox3.setText(String.valueOf(number3));
        }

        if (intent != null && intent.getExtras().containsKey("editText4")) {
            int number4 = intent.getIntExtra("editText4", -1);
            textBox4.setText(String.valueOf(number4));
        }
    }
}
