package itos.ilawyer;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    //Explicit
    private UserTABLE objUserTABLE;


    private EditText userEditText,passwordEditText;
    private TextView signUpTextView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // initial Widget
        initialWidget();
        // Connected SQLite
        connetedSQLite(); //ทำ สำหรับเครื่องใหม่
        /*
        final Button LoginButton = (Button) findViewById(R.id.Loginbutton);
        LoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent menuPage = new Intent(MainActivity.this, MenuTab.class);
                startActivity(menuPage);
            }
        }); // Click Login
        */
      //  final TextView RegisTextView = (TextView) findViewById(R.id.RegisterText);
        signUpTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent regisPage = new Intent(MainActivity.this, signup.class);
                startActivity(regisPage);
            }
        }); // Click text Register


    } // Main Method

    private void initialWidget() {
        userEditText = (EditText) findViewById(R.id.EmailText);
        passwordEditText = (EditText) findViewById(R.id.PasswordText);
        //passwordEditText.setTransformationMethod(new PasswordTransformationMethod());

        signUpTextView = (TextView) findViewById(R.id.RegisterText);

    }// Function InitialWidget()

    public void clickLogin(View view) {
        String strUser = userEditText.getText().toString().trim();
        String strPassword = passwordEditText.getText().toString().trim();
        // Check zero
        if (strUser.equals("") || strPassword.equals("")) {
            //Have space
            errorDilog("ไม่พบข้อมูล", "กรุณากรอกช้อมูลให้ครบ");

        } else {
            // No Space
            checkUserPassword(strUser, strPassword);
        }
    }// Function Login

    private void errorDilog(String strTitle, String strMessage) {
        AlertDialog.Builder objBuilder = new AlertDialog.Builder(this);
        //objBuilder.setIcon(R.drawable)
        objBuilder.setTitle(strTitle);
        objBuilder.setMessage(strMessage);
        objBuilder.setCancelable(false);
        objBuilder.setPositiveButton("ตกลง", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int which) {
                dialogInterface.dismiss();
            }
        });
        objBuilder.show();
    }// Function ErrorDlog

    private void connetedSQLite() {
        objUserTABLE = new UserTABLE(this);
    }// connetedSqlite Function

    private void checkUserPassword(String strUser, String strPassword) {
        try {
            String[] strMyResult = objUserTABLE.searchUserPassword(strUser);
            if (strPassword.equals(strMyResult[2])) {
                //Password True
                welcomeDialog(strUser);

            } else {
                // Password Fail
                errorDilog("Password False", "Please Try Again Password False");
            }
        } catch (Exception e) {
            errorDilog("Uesr False", "ไม่มี " + strUser + " ในฐานข้อมูลของเรา");
        }
    }//Check UserPassword

    private void welcomeDialog(String strName) {
        AlertDialog.Builder objBuilder = new AlertDialog.Builder(this);
        //objBuilder.setIcon()
        objBuilder.setTitle("Welcome");
        objBuilder.setMessage("ยินดีต้อนรับ " + strName + "\n" + "เข้าสู่ระบบ");
        objBuilder.setCancelable(false);
        objBuilder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int which) {
               Intent objInent = new Intent(MainActivity.this,MenuTab.class); //
               // Intent objInent = new Intent(MainActivity.this, tab_main.class);
                startActivity(objInent);
                finish();
                //dialogInterface.dismiss();
            }
        });
        objBuilder.show();
    }// Show Welcome Sucess


}//
