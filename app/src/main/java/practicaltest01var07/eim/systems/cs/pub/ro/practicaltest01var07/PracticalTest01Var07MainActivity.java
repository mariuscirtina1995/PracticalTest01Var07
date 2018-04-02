package practicaltest01var07.eim.systems.cs.pub.ro.practicaltest01var07;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class PracticalTest01Var07MainActivity extends AppCompatActivity {

    private final static int SECONDARY_ACTIVITY_REQUEST_CODE = 1;

    private EditText textBox1 = null;
    private EditText textBox2 = null;
    private EditText textBox3 = null;
    private EditText textBox4 = null;
    private Button setButton = null;

    private ButtonClickListener buttonClickListener = new ButtonClickListener();
    private class ButtonClickListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            switch(view.getId()) {
                case R.id.setButton:

                    if(!CheckNumbers())
                    {
                        ToastFunction();
                        break;
                    }

                    Intent intent = new Intent(getApplicationContext(), PracticalTestV1Var07SecondaryActivity.class);

                    /*
                    int numberOfClicks = Integer.parseInt(leftEditText.getText().toString()) +
                            Integer.parseInt(rightEditText.getText().toString());
*/
                    int number1 = Integer.parseInt(textBox1.getText().toString());
                    intent.putExtra("editText1", number1);

                    int number2 = Integer.parseInt(textBox2.getText().toString());
                    intent.putExtra("editText2", number2);

                    int number3 = Integer.parseInt(textBox3.getText().toString());
                    intent.putExtra("editText3", number3);

                    int number4 = Integer.parseInt(textBox4.getText().toString());
                    intent.putExtra("editText4", number4);

                    startActivityForResult(intent, SECONDARY_ACTIVITY_REQUEST_CODE);

                    break;

            }
        }
    }

    public boolean CheckNumbers()
    {
        return true;
    }

    public void ToastFunction()
    {
        Toast.makeText(this, "Imput must be number", Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical_test01_var07_main);

        textBox1 = findViewById(R.id.editText1);
        textBox2 = findViewById(R.id.editText2);
        textBox3 = findViewById(R.id.editText3);
        textBox4 = findViewById(R.id.editText4);
        setButton = findViewById(R.id.setButton);
        setButton.setOnClickListener(buttonClickListener);
    }


    @Override
    protected void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putString("textBox1", textBox1.getText().toString());
        savedInstanceState.putString("textBox2", textBox2.getText().toString());
        savedInstanceState.putString("textBox3", textBox3.getText().toString());
        savedInstanceState.putString("textBox4", textBox4.getText().toString());
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        if (savedInstanceState.containsKey("textBox1")) {
            textBox1.setText(savedInstanceState.getString("textBox1"));
        } else {
            textBox1.setText(String.valueOf(0));
        }
        if (savedInstanceState.containsKey("textBox2")) {
            textBox2.setText(savedInstanceState.getString("textBox2"));
        } else {
            textBox2.setText(String.valueOf(0));
        }
        if (savedInstanceState.containsKey("textBox3")) {
            textBox3.setText(savedInstanceState.getString("textBox3"));
        } else {
            textBox3.setText(String.valueOf(0));
        }
        if (savedInstanceState.containsKey("textBox4")) {
            textBox4.setText(savedInstanceState.getString("textBox4"));
        } else {
            textBox4.setText(String.valueOf(0));
        }
    }
}
