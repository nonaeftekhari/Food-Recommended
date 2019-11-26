package com.example.foodrecommended_asd;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import java.nio.file.attribute.PosixFileAttributes;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private TextView textViewResult;
    private FoodAPI foodAPI;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textViewResult = findViewById(R.id.text_view_result);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://10.0.2.2:8000/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        foodAPI = retrofit.create(FoodAPI.class);

        //getRest();
        //getRestZip(48201);
        //createRest();
        //getUserID("test@gmail.com");
        //createUser("jonsmith2@gmail.com", "p@ssw0rd", "jonsmith2");
        //getItemRest(2);
        //createItem("Tonkotsu Ramen", "Pork, Noodle, and Green Onion", 4, 11.95);
        //getRatingRest(2);
        creatRating();



        /*


        // This code below is to add the html file into the app
        StrictMode.VmPolicy.Builder builder = new StrictMode.VmPolicy.Builder();
        StrictMode.setVmPolicy(builder.build()); // ignores URI

        // Creating a javascript object to pass through the .addJavaScriptInterface
        JavaInter javaInterObj = new JavaInter(this);
        AccountSignup exAccount = new AccountSignup();
        Restaurant exRestaurant = new Restaurant();

        WebView view = (WebView) this.findViewById(R.id.webView);
        view.getSettings().setJavaScriptEnabled(true);
        // The browser is what's used to view the webView
        final WebView browser=(WebView)view.findViewById(R.id.webView);

        WebSettings webSettings = browser.getSettings();
        webSettings.setJavaScriptEnabled(true); // Enableing Javascript

        browser.loadUrl("file:///android_asset/index.html");// The code above is the html file added into the app.
        browser.getSettings().setJavaScriptEnabled(true);

        browser.addJavascriptInterface(javaInterObj, "Android");
        browser.addJavascriptInterface(exAccount, "AccountMethods");
        browser.addJavascriptInterface(exRestaurant, "Restaurant");

        // Color for background #3498db

        */

    } // End of MainActivity

    public void getRest() {
        Call<List<Rest>> call = foodAPI.getRests();

        call.enqueue(new Callback<List<Rest>>() {
            @Override
            public void onResponse(Call<List<Rest>> call, Response<List<Rest>> response) {
                if (!response.isSuccessful()) {
                    textViewResult.setText(response.code());
                    return;
                }

                List<Rest> rests = response.body();

                for (Rest rest : rests) {
                    String content = "";
                    content += rest.getId() + "\n";
                    content += rest.getRestName() + "\n";
                    content += rest.getZipcode() + "\n";
                    content += rest.getRestRating() + "\n";
                    content += rest.getWebsite() + "\n";
                    content += rest.getPhone() + "\n";
                    content += rest.getRestPrice() + "\n";
                    content += rest.getCategory() + "\n\n";

                    textViewResult.append(content);

                }
            }

            @Override
            public void onFailure(Call<List<Rest>> call, Throwable t) {
                textViewResult.setText(t.getMessage());
            }
        });

    }

    private void getRestZip(int zip) {
        Call<List<Rest>> call = foodAPI.getRestZip(zip);

        call.enqueue(new Callback<List<Rest>>() {
            @Override
            public void onResponse(Call<List<Rest>> call, Response<List<Rest>> response) {
                if (!response.isSuccessful()) {
                    textViewResult.setText(response.code());
                    return;
                }

                List<Rest> rests = response.body();

                for (Rest rest : rests) {
                    String content = "";
                    content += rest.getId() + "\n";
                    content += rest.getRestName() + "\n";
                    content += rest.getZipcode() + "\n";
                    content += rest.getRestRating() + "\n";
                    content += rest.getWebsite() + "\n";
                    content += rest.getPhone() + "\n";
                    content += rest.getRestPrice() + "\n";
                    content += rest.getCategory() + "\n\n";

                    textViewResult.append(content);

                }
            }

            @Override
            public void onFailure(Call<List<Rest>> call, Throwable t) {
                textViewResult.setText(t.getMessage());
            }
        });

    }

    private void createRest() {
        Rest rest = new Rest("Jet's Pizza", 48201, "https://www.jetspizza.com/", 3132977000.0, 0);

        Call<Rest> call = foodAPI.createRest(rest);

        call.enqueue(new Callback<Rest>() {
            @Override
            public void onResponse(Call<Rest> call, Response<Rest> response) {
                if (!response.isSuccessful()) {
                    textViewResult.setText(response.code());
                    return;
                }

                Rest restResponse = response.body();

                String content = "";
                content += response.code() + "\n";
                content += restResponse.getId() + "\n";
                content += restResponse.getRestName() + "\n";
                content += restResponse.getZipcode() + "\n";
                content += restResponse.getRestRating() + "\n";
                content += restResponse.getWebsite() + "\n";
                content += restResponse.getPhone() + "\n";
                content += restResponse.getRestPrice() + "\n";
                content += restResponse.getCategory() + "\n\n";

                textViewResult.append(content);
            }

            @Override
            public void onFailure(Call<Rest> call, Throwable t) {
                textViewResult.setText(t.getMessage());
            }
        });
    }

    private void getUserID(String userEmail) {
        Call call = foodAPI.getUserID(userEmail);

        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                if (!response.isSuccessful()) {
                    textViewResult.setText(response.code());
                    return;
                }

                User user = response.body();

                String content = "";
                content += user.getUserEmail() + "\n";
                content += user.getName() + "\n";
                content += user.getPassword() + "\n\n";

                textViewResult.append(content);

            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                textViewResult.setText(t.getMessage());
            }
        });
    }

    private void createUser(String userEmail, String password, String name) {
        User user = new User(userEmail, password, name);

        Call<User> call = foodAPI.createUser(user);

        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                if (!response.isSuccessful()) {
                    textViewResult.setText(response.code());
                    return;
                }

                User createUser = response.body();

                String content = "";
                content += response.code() + "\n";
                content += createUser.getUserEmail() + "\n";
                content += createUser.getName() + "\n";
                content += createUser.getPassword() + "\n\n";

                textViewResult.append(content);

            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                textViewResult.setText(t.getMessage());
            }
        });

    }

    private void getItemRest(int id) {
        Call<List<Item>> call = foodAPI.getItemRest(id);

        call.enqueue(new Callback<List<Item>>() {
            @Override
            public void onResponse(Call<List<Item>> call, Response<List<Item>> response) {
                if (!response.isSuccessful()) {
                    textViewResult.setText(response.code());
                    return;
                }
                List<Item> items = response.body();

                for (Item item : items) {
                    String content = "";
                    content += item.getId() + "\n";
                    content += item.getItemName() + "\n";
                    content += item.getItemPrice() + "\n";
                    content += item.getItemRating() + "\n";
                    content += item.getDescription() + "\n";
                    content += item.getRestId() + "\n\n";

                    textViewResult.append(content);

                }

            }

            @Override
            public void onFailure(Call<List<Item>> call, Throwable t) {
                textViewResult.setText(t.getMessage());
            }
        });
    }

    public void createItem(String itemName, String description, int restId, double itemPrice) {
        Item item = new Item(itemName, description, restId, itemPrice);

        Call<Item> call = foodAPI.createItem(item);

        call.enqueue(new Callback<Item>() {
            @Override
            public void onResponse(Call<Item> call, Response<Item> response) {
                if (!response.isSuccessful()) {
                    textViewResult.setText(response.code());
                    return;
                }

                Item item = response.body();

                String content = "";
                content += response.code() + "\n";
                content += item.getId() + "\n";
                content += item.getItemName() + "\n";
                content += item.getItemPrice() + "\n";
                content += item.getItemRating() + "\n";
                content += item.getDescription() + "\n";
                content += item.getRestId() + "\n\n";

                textViewResult.append(content);

            }


            @Override
            public void onFailure(Call<Item> call, Throwable t) {
                textViewResult.setText(t.getMessage());
            }
        });
    }

    public void getRatingRest(int id) {
        Call<List<Rating>> call = foodAPI.getRatingRest(id);

        call.enqueue(new Callback<List<Rating>>() {
            @Override
            public void onResponse(Call<List<Rating>> call, Response<List<Rating>> response) {
                if (!response.isSuccessful()) {
                    textViewResult.setText(response.code());
                    return;
                }

                List<Rating> ratings = response.body();

                for (Rating rating : ratings) {
                    String content = "";
                    content += rating.getId() + "\n";
                    content += rating.getUserEmail() + "\n";
                    content += rating.getRestId() + "\n";
                    content += rating.getReview() + "\n";
                    content += rating.getRating() + "\n\n";


                    textViewResult.append(content);

                }
            }

            @Override
            public void onFailure(Call<List<Rating>> call, Throwable t) {
                textViewResult.setText(t.getMessage());
            }
        });
    }

    public void creatRating() {
        Rating rating = new Rating("root@gmail.com", 2, "Too Salty for me", 3);

        Call<Rating> call = foodAPI.createRating(rating);

        call.enqueue(new Callback<Rating>() {
            @Override
            public void onResponse(Call<Rating> call, Response<Rating> response) {
                if (!response.isSuccessful()) {
                    textViewResult.setText(response.code());
                    return;
                }

                Rating rating = response.body();


                String content = "";
                content += response.code() + "\n";
                content += rating.getId() + "\n";
                content += rating.getUserEmail() + "\n";
                content += rating.getRestId() + "\n";
                content += rating.getReview() + "\n";
                content += rating.getRating() + "\n\n";


                textViewResult.append(content);


            }

            @Override
            public void onFailure(Call<Rating> call, Throwable t) {
                textViewResult.setText(t.getMessage());
            }
        });


    }


    /*

    public class JavaInter{
        private String message;
        Context jContext;

        JavaInter(){ }

        JavaInter(Context c){
            jContext = c;
        }

        @JavascriptInterface // This will post a toast, and take you to the GPS
        public void showLocation() {
            Intent intent = new Intent(MainActivity.this, MapsActivity.class);
            startActivity(intent);
        }

        @JavascriptInterface
        public void showMessage(String msg) {
            this.message = msg;
            Toast.makeText(jContext, msg, Toast.LENGTH_LONG).show(); // This is a toast!
        }


        @JavascriptInterface // This will return the zip code into the form
        public String zipForm(){
            MapsActivity obj1 = new MapsActivity();
            return obj1.getZip();
        }

        @JavascriptInterface
        public void sendMessage(String msg){
            this.message = msg;
        }

        String getMessage(){
            return this.message;
        }

    }

    */

}


