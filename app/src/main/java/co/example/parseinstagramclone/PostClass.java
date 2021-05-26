package co.example.parseinstagramclone;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.ImageDecoder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;


//feed activitede parse e yüklediğim verileri download edecegim
//sonra o verileri bu post sınıfına atayacagım
//buradaki verileri de aldığım verileri customview e tek tek atayacagım.

public class PostClass extends ArrayAdapter<String> {

    private final ArrayList<String> userName;
    private final ArrayList<String> userComment;
    private final ArrayList<Bitmap> userImage;
    private Activity context;

    //bir sınıf yaptım baska sınıftan post classı cagırdıgımda bu 4 degiskeni vermemizi isteyecek.
    //burada da alınan verileri customview e baglayacagım


    public  PostClass (ArrayList<String> userName,ArrayList<String> userComment,ArrayList<Bitmap> userImage,Activity context){
        super(context,R.layout.custom_view,userName); //context i ister bir de hangi layout // listeye bagladık username yerine baska bir liste de olur

        this.userName = userName;
        this.userComment =userComment;
        this.userImage = userImage;
        this.context = context;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater layoutInflater = context.getLayoutInflater();
        // yeni bir view olusturacagım bu view custom viewi burada objelestirmek icin
        View customView = layoutInflater.inflate(R.layout.custom_view,null,true);

        TextView userNameText = customView.findViewById(R.id.customusername);
        TextView commentText = customView.findViewById(R.id.customcomment);
        ImageView imageView = customView.findViewById(R.id.custompostimage);


        userNameText.setText(userName.get(position));
        imageView.setImageBitmap(userImage.get(position));
        commentText.setText(userComment.get(position));







        return customView;
    }
}
