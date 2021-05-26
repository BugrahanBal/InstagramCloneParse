package co.example.parseinstagramclone;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.parse.LogInCallback;
import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SignUpCallback;

public class SignUpActivity extends AppCompatActivity {

    EditText usernameText,passwordText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        usernameText =findViewById(R.id.name);
        passwordText =findViewById(R.id.password);

        ParseUser parseUser = ParseUser.getCurrentUser(); // güncel kullanıc varsa al

        if(parseUser !=null){
            Intent intent = new Intent(getApplicationContext(),FeedActivity.class);
            startActivity(intent);
        }


    }

    public void signIn(View view){

        ParseUser.logInInBackground(usernameText.getText().toString(), passwordText.getText().toString(), new LogInCallback() {
            @Override
            public void done(ParseUser user, ParseException e) {
                if(e!=null){
                    Toast.makeText(SignUpActivity.this,e.getLocalizedMessage(),Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(SignUpActivity.this,"Welcome !"+user.getUsername() ,Toast.LENGTH_LONG).show();

                    Intent intent = new Intent(getApplicationContext(),FeedActivity.class);
                    startActivity(intent);


                }
            }
        });



    }
    public void signUp(View view){

        ParseUser user = new ParseUser();
        user.setUsername(usernameText.getText().toString().trim());
        user.setPassword(passwordText.getText().toString().trim());

        user.signUpInBackground(new SignUpCallback() {
            @Override
            public void done(ParseException e) {
                if ( e!= null){
                    Toast.makeText(SignUpActivity.this,e.getLocalizedMessage(),Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(SignUpActivity.this,"User Created !" ,Toast.LENGTH_LONG).show();

                    Intent intent = new Intent(getApplicationContext(),FeedActivity.class);
                    startActivity(intent);
                }


            }
        });
           /*
        ParseUser user = new ParseUser(); //default olarak kullanıcı adı ve sifresi vermek gerekli
        user.setUsername("Jamess");
        user.setPassword("123456");

        user.signUpInBackground(new SignUpCallback() { // database e save in background da oldugu gibi userda callbacklı olan ınbackground secildi ki eger hata varsa göstersin
            @Override
            public void done(ParseException e) {
                if(e!=null){
                    e.printStackTrace();
                }else{
                    Toast.makeText(SignUpActivity.this,"User Signed Up",Toast.LENGTH_LONG).show();
                }
            }
        });

    */



    }











}