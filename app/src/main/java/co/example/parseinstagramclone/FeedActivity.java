package co.example.parseinstagramclone;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.Toast;

import com.parse.FindCallback;
import com.parse.GetDataCallback;
import com.parse.LogOutCallback;
import com.parse.ParseException;
import com.parse.ParseFile;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.ParseUser;

import java.util.ArrayList;
import java.util.List;

public class FeedActivity extends AppCompatActivity {

    ListView listView;
    ArrayList<String> usernamesFromParse;
    ArrayList<String> userCommentsFromParse;
    ArrayList<Bitmap> userImageFromParse;
    PostClass postClass;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.main_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId()==R.id.add_post){

            Intent intent = new Intent(getApplicationContext(),UpLoadActivity.class);
            startActivity(intent);

        }else if(item.getItemId()==R.id.logout){
            ParseUser.logOutInBackground(new LogOutCallback() {
                @Override
                public void done(ParseException e) {
                    if(e!=null){
                        Toast.makeText(getApplicationContext(),e.getLocalizedMessage(),Toast.LENGTH_LONG).show();
                    }else{
                        Intent intent = new Intent(getApplicationContext(),SignUpActivity.class);
                        startActivity(intent);
                    }
                }
            });
        }



        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feed);

        listView = findViewById(R.id.listView); // listviewin icerisinde olacak g??r??nt??leri de ayr?? xml de yapar??z.

        usernamesFromParse = new ArrayList<>();
        userCommentsFromParse = new ArrayList<>();
        userImageFromParse = new ArrayList<>();

        postClass =new PostClass(usernamesFromParse,userCommentsFromParse,userImageFromParse,this);

        listView.setAdapter(postClass);

        download();

        //dataalar?? indirip bu yukar??daki arraylere kaydetmek kald??
    }

    public void download(){

        // burada da firebase de oldugu gibi Query kullan??r??z zaten cogu data cekmede b??yle i??lemler s??z konusudur.

        ParseQuery<ParseObject> query = ParseQuery.getQuery("Posts");
        query.findInBackground(new FindCallback< ParseObject >() {
            @Override
            public void done(List< ParseObject > objects, ParseException e) {
                if(e!=null){
                    Toast.makeText(FeedActivity.this,e.getLocalizedMessage(),Toast.LENGTH_LONG).show();
                }else{

                    if(objects.size()>0){
                        for(ParseObject object : objects){

                            ParseFile parseFile = (ParseFile) object.get("image");
                            parseFile.getDataInBackground(new GetDataCallback() {
                                @Override
                                public void done(byte[] data, ParseException e) {
                                    if(e ==null && data!=null) {
                                        Bitmap bitmap = BitmapFactory.decodeByteArray(data,0,data.length);
                                        // byte dizisini decode edererk image e d??nd??recegiz.
                                        userImageFromParse.add(bitmap);
                                        usernamesFromParse.add(object.getString("username"));
                                        userCommentsFromParse.add(object.getString("comment"));

                                        postClass.notifyDataSetChanged(); // adapt??r?? noptify etmek.

                                    }
                                }
                            });


                        }
                    }


                }

            }
        });

    }



}