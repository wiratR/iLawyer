package itos.ilawyer;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class signup extends AppCompatActivity {

    //Explicit
    private UserTABLE objUserTABLE;
    private EditText registerUserEditText,
            registerPasswordEditText,registerPassword2EditText;
    private Button signUpButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        connectSqLite();
        initialWidget();

    }

    private void connectSqLite() {
        objUserTABLE = new UserTABLE(this);
    }

    private void initialWidget() {
        registerUserEditText = (EditText) findViewById(R.id.registerEmailtext);
        registerPasswordEditText = (EditText) findViewById(R.id.registerPasswordtext);
        registerPassword2EditText = (EditText) findViewById(R.id.Confirmtext);
      //   registerPasswordEditText.setTransformationMethod(new PasswordTransformationMethod());
      //  registerPassword2EditText.setTransformationMethod(new PasswordTransformationMethod());
    }


    public void clickSignUp(View view) {
        String strRegisterUser = registerUserEditText.getText().toString().trim();
        String strRegisterPassword = registerPasswordEditText.getText().toString().trim();
        String strConfirmPassword = registerPassword2EditText.getText().toString().trim();
        //Boolean flagConfirm = false;

        // Check zero
        if (strRegisterUser.equals("") || strRegisterPassword.equals("") || strConfirmPassword.equals("")) {
            //Have space
            errorDilog("ไม่พบข้อมูล", "กรุณากรอกช้อมูลให้ครบ");

        } else {
            // No Space
            if(strRegisterPassword.equals(strConfirmPassword)) {
                // Compare String
                objUserTABLE.addNewUser(strRegisterUser, strConfirmPassword, "testadmin");  // Add Table
                addDatasucessDilod(strRegisterUser);
            }else{
                errorDilog("ข้อมูลผิดพลาด","กรุนากรอกข้อมูลใหม่อีกครั้ง");
            }
        }
    }// Click SignUp

    private void addDatasucessDilod(String strName) {
        AlertDialog.Builder objBuilder = new AlertDialog.Builder(this);
        //objBuilder.setIcon()
        objBuilder.setTitle("Welcome");
        objBuilder.setMessage("ทำการลงทะเบียนผู้ใช้ " + strName + "\n" + "สำเร็จ");
        objBuilder.setCancelable(false);
        objBuilder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int which) {
                // dialogInterface.dismiss();
                Intent objInent = new Intent(signup.this, MainActivity.class);
                startActivity(objInent);
                finish();
            }
        });
        objBuilder.show();
    }//Dilog Sucess

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
    }// DilogError


}
