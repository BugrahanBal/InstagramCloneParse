package co.example.parseinstagramclone;

import android.app.Application;

import com.parse.Parse;

public class ParseStarterClass extends Application {

    // EXTENDE DİKKAT MANİFESTTE APP ALTINA


    @Override
    public void onCreate() {
        super.onCreate();

        // datalarımız online sunucuda tutulacak.
        // bizim serverımızında ıd vs olması lazım ki apple bağlayalım.
        // firebasede embeded sekildeydi
        // burada kendimiz bir server kuracagız
        // parse sunucumuzu olusturmak icin back4appe gireriz
        // parse opensource olunca dunyadakı bircok server parse ile ilgili kodları kendi serverlerina koydu
        // projelerimizle baglayabilecegimiz arayüzler geliştirdiler
        // back4app direk parse serveri yapmak icin kurulmus bir site
        // aws de parse ile calısabilecegimiz serverlar mevcut

        // set log level
        Parse.setLogLevel(Parse.LOG_LEVEL_DEBUG); // logcatte parse logları ne olsun

        Parse.initialize(new Parse.Configuration.Builder(this)
            .applicationId("74njKhen6k0a8ave6kw4E9FtfBlOQJwPtcI1NuVE")
                .clientKey("qnsmZIQh3zX94gpp2RPvGtJTnakB7XHqA9co1U8b")
                    .server("https://parseapi.back4app.com/")
                        .build()
        );




    }
}
