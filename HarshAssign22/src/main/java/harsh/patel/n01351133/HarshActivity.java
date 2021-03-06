//harsh patel,n01351133 section c
package harsh.patel.n01351133;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

public class HarshActivity extends AppCompatActivity {

    Button nextBtn;
    LinearLayout pizzanovaLt, pizzaLt, popularLt;

    Boolean pizzaSelected = false;
    String seectedPizza = "";

    int imgId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE){

        }
        pizzanovaLt = findViewById(R.id.harshPizaNv);
        pizzaLt = findViewById(R.id.harshPizaPz);
        popularLt = findViewById(R.id.harshPopPizza);


        pizzanovaLt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SelectPizza("PizzaNova");

            }

        });
        pizzaLt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SelectPizza("pizza");

            }
        });
        popularLt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SelectPizza("popularPizza");

            }
        });

        nextBtn = findViewById(R.id.harshNext);
        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(pizzaSelected){
                    Intent i = new Intent(HarshActivity.this,PatelActivity2.class);
                    i.putExtra("pizzaNm",seectedPizza);
                    //Toast.makeText(HarshActivity.this, seectedPizza, Toast.LENGTH_SHORT).show();
                    i.putExtra("imgId",imgId);
                    startActivity(i);

                }else {
                    String msg = getResources().getString(R.string.toast_One);
                    Toast.makeText(HarshActivity.this, msg, Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.my_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId())
        {
            case R.id.harshMenu:
                Toast.makeText(this, "Help website", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(Intent.ACTION_VIEW,
                        Uri.parse("https://food.ndtv.com/food-drinks/an-ultimate-guide-on-how-to-order-a-pizza-1905628"));
                startActivity(intent);
                break;

            case R.id.harshpizza:
                Toast.makeText(this,
                        R.string.pizza_websitename,
                        Toast.LENGTH_SHORT).show();
                Intent intent2 = new Intent(Intent.ACTION_VIEW,
                        Uri.parse("https://www.dominos.ca/en/"));
                startActivity(intent2);
                break;

            case R.id.myname:
                String name1 = getResources().getString(R.string.menu3);
                Toast.makeText(this, name1, Toast.LENGTH_SHORT).show();
                break;

        }
        return super.onOptionsItemSelected(item);
    }

    private void SelectPizza(String pizzaCatg){

        switch (pizzaCatg){
            case "PizzaNova":
                pizzanovaLt.setBackgroundColor(0xff00B8D4);
                pizzaLt.setBackgroundColor(0xffeeeeee);
                popularLt.setBackgroundColor(0xffeeeeee);
                seectedPizza = "Pizza Nova";
                imgId  = R.drawable.nova;
                break;

            case "pizza":
                pizzaLt.setBackgroundColor(0xff00B8D4);
                pizzanovaLt.setBackgroundColor(0xffeeeeee);
                popularLt.setBackgroundColor(0xffeeeeee);
                seectedPizza = "Pizza Pizza";
                imgId  = R.drawable.pizza;
                break;

            case "popularPizza":
                popularLt.setBackgroundColor(0xff00B8D4);
                pizzanovaLt.setBackgroundColor(0xffeeeeee);
                pizzaLt.setBackgroundColor(0xffeeeeee);
                seectedPizza = "PopularPizza";
                imgId  = R.drawable.popular;
                break;
        }
        pizzaSelected = true;

    }
}