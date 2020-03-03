package com.example.coinclicker2020;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.view.ViewGroup.LayoutParams;

public class ShopActivity extends AppCompatActivity {

    int coins;

    LinearLayout upgradeList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop);

        upgradeList = findViewById(R.id.linearLayout);

        Bundle bun = getIntent().getExtras();
        coins = bun.getInt("coins");

        changeCoinsText();

        showUpgrades();
    }

    private void changeCoinsText()
    {
        TextView coinText = findViewById(R.id.txtCoins);
        String c = coins + " coins";
        coinText.setText(c);
    }

    private void showUpgrades()
    {
        if(coins > 25)
        {
            String name = getString(R.string.upgrade_AutoClicker) + " " + getString(R.string.upgrade_AutoClicker_price);
            addButton(name, 25, 0.1);
        }
    }

    private void addButton(String text, final int price, final double cps)
    {
        Button button = new Button(this);
        button.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT));
        button.setText(text);
        //button.setPadding(15, 15, 15, 5);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                upgrade(price, cps);
            }
        });
        upgradeList.addView(button);
    }

    private void upgrade(int price, double cps)
    {
        if(coins > price)
        {
            //take price from coins
            coins -= price;
            changeCoinsText();

            //add cps
        }
    }

    public void closeShop(View view)
    {
        finish();
    }
}
