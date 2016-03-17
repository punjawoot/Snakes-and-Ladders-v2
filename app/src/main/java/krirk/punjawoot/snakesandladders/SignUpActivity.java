package krirk.punjawoot.snakesandladders;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.preference.DialogPreference;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class SignUpActivity extends AppCompatActivity {

    // Explicit
    private EditText nameEditText,userEditText, passwordEditText;
    private RadioGroup avataRadioGroup;
    private RadioButton avata1RadioButton, avata2RadioButton, avata3RadioButton, avata4RadioButton, avata5RadioButton;
    private String nameString, userString, passwordString, avataString;
    public int[] avataInts = {R.drawable.build1, R.drawable.build2, R.drawable.build3, R.drawable.build4, R.drawable.build5};



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        // Bind Widget
        bindWidget();

        // Avata Controller
        avataController();


    }  // Main Method

    private void avataController() {

        avataRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                switch (checkedId) {
                    case R.id.radioButton:
                        avataString = "0";
                        break;
                    case R.id.radioButton2:
                        avataString = "1";
                        break;
                    case R.id.radioButton3:
                        avataString = "2";
                        break;
                    case R.id.radioButton4:
                        avataString = "3";
                        break;
                    case R.id.radioButton5:
                        avataString = "4";
                        break;
                }

            } // onChacked
        });

    } // AvataControlles

    public void clickSignUpSign(View view) {
        nameString = nameEditText.getText().toString().trim();
        userString = userEditText.getText().toString().trim();
        passwordString = passwordEditText.getText().toString().trim();

        // Check Space
        if (nameString.equals("") || userString.equals("") || passwordString.equals("")) {
            //Have Space
            Toast.makeText(SignUpActivity.this, "กรุณากรองข้อมูลให้ครบถ้วน", Toast.LENGTH_SHORT).show();

        } else if (!checkAvataChoose()) {
            // Not Choose Avata
            Toast.makeText(SignUpActivity.this, "กรุณาเลือกอวต้าก่อนนะ", Toast.LENGTH_SHORT) .show();

        } else {
            confirmData();
        }


        //clickSingUpsign

    }

    private void confirmData() {

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setIcon(avataInts[Integer.parseInt(avataString)]);
        builder.setTitle("คุณ " + nameString);
        builder.setMessage("user = " + userString + "\n" + "password = " + passwordString);
        builder.setCancelable(false);
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                upDataToServer();
                dialog.dismiss();
            }
        });
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        builder.show();

    }// confirmData

    private void upDataToServer() {

    } // upDataSever

    private boolean checkAvataChoose() {

        boolean bolAvataChoose = true;  // Choose Avata
        bolAvataChoose = avata1RadioButton.isChecked() ||
                avata2RadioButton.isChecked() ||
                avata3RadioButton.isChecked() ||
                avata4RadioButton.isChecked() ||
                avata5RadioButton.isChecked();

        return bolAvataChoose;
    } //


    private void bindWidget() {

        nameEditText = (EditText) findViewById(R.id.editText);
        userEditText = (EditText) findViewById(R.id.editText2);
        passwordEditText = (EditText) findViewById(R.id.editText3);
        avataRadioGroup = (RadioGroup) findViewById(R.id.ragAvata);
        avata1RadioButton = (RadioButton) findViewById(R.id.radioButton);
        avata2RadioButton = (RadioButton) findViewById(R.id.radioButton2);
        avata3RadioButton = (RadioButton) findViewById(R.id.radioButton3);
        avata4RadioButton = (RadioButton) findViewById(R.id.radioButton4);
        avata5RadioButton = (RadioButton) findViewById(R.id.radioButton5);



    } // bindWidget

} // Main Class
