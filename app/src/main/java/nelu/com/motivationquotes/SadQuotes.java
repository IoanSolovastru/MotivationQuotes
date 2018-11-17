package nelu.com.motivationquotes;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

public class SadQuotes extends MainActivity {
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private List<String> images;

    private DrawerLayout SadDrawerLayout;
    private ActionBarDrawerToggle toggle;
    private NavigationView navigationView;

    @Override
    protected void onCreate(@Nullable final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sad_quotes);

        //Implementing navigation bar
        SadDrawerLayout = findViewById(R.id.load_images_drawer_layout); //Main Activity layout
        toggle = new ActionBarDrawerToggle(this, SadDrawerLayout, R.string.open, R.string.close);
        SadDrawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        navigationView = findViewById(R.id.navigation_view);
        navigationView.setNavigationItemSelectedListener(this);

        recyclerView = findViewById(R.id.recycle_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        images = new ArrayList();

        adapter = new MyAdapter(images,SadQuotes.this);
        recyclerView.setAdapter(adapter);
    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case R.id.quotesGym:
                startActivity(new Intent(SadQuotes.this, GymActivity.class));
                break;
            case R.id.quotes_load_images:
                startActivity(new Intent(SadQuotes.this, LoadImages.class));
                break;
        }
        getMainLayoutDrawer().closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(toggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

}
