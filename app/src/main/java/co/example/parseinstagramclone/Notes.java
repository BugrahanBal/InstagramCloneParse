package co.example.parseinstagramclone;

public class Notes {
    // DATABASE DATABASE DATABASE

       /* //putta yine hashmap gibi
        //save in background with callbak callback GEERİYE DÖNÜP HATA VEREBİLİR

        ParseObject object  = new ParseObject("Fruits");
        object.put("name","banana");
        object.put("calories",150);

        object.saveInBackground(new SaveCallback() {
            @Override
            public void done(ParseException e) {
                if(e!=null){
                    Toast.makeText(getApplicationContext(),e.getLocalizedMessage(),Toast.LENGTH_LONG).show();
                }else {
                    Toast.makeText(getApplicationContext(),"Object Saved",Toast.LENGTH_LONG).show();
                }
            }
        });


        // query serverdan okuma işlemidir.
        // Fruit sınıfından parseobject verisi cekeceğim demek.
        // tüm serverlarda query ile yaparız. SQl ..

        ParseQuery<ParseObject> query = ParseQuery.getQuery("Fruits");
        query.getInBackground("fZY57Oq4bw", new GetCallback< ParseObject >() {
            @Override
            public void done(ParseObject object, ParseException e) {
                if ( e != null){
                    e.printStackTrace();
                }else {
                    String objectName = object.getString("name"); // name de birebir aynı olacak.
                    int objectCalories = object.getInt("calories");


                    Log.e("elma ",objectName);
                    System.out.println("Object Name : " + objectName);
                    System.out.println("Object Calories : " + objectCalories);

                }
            }
        });
        */

        /*
        ParseQuery<ParseObject> query = ParseQuery.getQuery("Fruits");
        //query.whereEqualTo("name","banana"); // filtreleme sql e benziyor..
        query.whereLessThan("calories",130);

        query.findInBackground(new FindCallback< ParseObject >() {
            @Override
            public void done(List< ParseObject > objects, ParseException e) {
                if(e!=null){
                    e.printStackTrace();
                }else{
                    if(objects.size()>0){
                        for(ParseObject object : objects){

                            String objectName= object.getString("name");
                            int objectCalorie= object.getInt("calories");

                            System.out.println("Object Name : " + objectName);
                            System.out.println("Object Calories : " +objectCalorie);

                        }
                    }
                }

            }
        });
        */


    // USER USER USER

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
    /*
        ParseUser.logInInBackground("James", "12346", new LogInCallback() {
            @Override
            public void done(ParseUser user, ParseException e) {
                if(e!=null){
                    e.printStackTrace();
                    Toast.makeText(SignUpActivity.this,e.getLocalizedMessage(),Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(SignUpActivity.this,"Welcome " + user.getUsername(),Toast.LENGTH_LONG).show();
                }
            }
        });


    */

}
