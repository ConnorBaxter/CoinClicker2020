package com.example.coinclicker2020;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    View v;

    int coins;
    double cps;

    int coinsPerClick;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        v = this.getWindow().getDecorView();

        coins = 0;
        cps = 0;
        coinsPerClick = 1;
    }

    public void coinClicked(View view)
    {
        coins += coinsPerClick;
        TextView newCoins = findViewById(R.id.txtCoins);
        String c = coins + " coins";
        newCoins.setText(c);
    }

    public void openShop(View view)
    {
        Intent newWin = new Intent(this, ShopActivity.class);
        Bundle bun = new Bundle();
        bun.putInt("coins", coins);
        newWin.putExtras(bun);
        startActivity(newWin);
    }

    public void openSettings(View view)
    {
        Intent newWin = new Intent(this, SettingsActivity.class);
        startActivity(newWin);
    }

    public void updateCoinsFromShop(int coinsDeducted)
    {
        coins -= coinsDeducted;
    }
}
