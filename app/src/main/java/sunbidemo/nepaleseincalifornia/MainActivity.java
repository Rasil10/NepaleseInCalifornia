package sunbidemo.nepaleseincalifornia;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    List<News> newsList;
    ArrayList<DrawerItem> navItemArrayList = new ArrayList<DrawerItem>();
    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    NewsRecyclerAdapter adapter;

    private CustomDrawerAdapter myAdapter;
    private ListView listView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        overridePendingTransition(R.anim.trans_left_in, R.anim.trans_left_out);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(null);
//        final DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
//        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
//                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
//        drawer.addDrawerListener(toggle);
//        toggle.syncState();
//        toggle.setDrawerIndicatorEnabled(false);
//
//
//        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
//        navigationView.setNavigationItemSelectedListener(this);
//
//

//
//
//        CollapsingToolbarLayout ctl = (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar);
//        ctl.setTitle("Nepalese In California");
//        ctl.setCollapsedTitleTextColor(getColor(R.color.white));

        listView = (ListView) findViewById(R.id.listView);
        getNavItems();
        myAdapter = new CustomDrawerAdapter(MainActivity.this, navItemArrayList);
        listView.setAdapter(myAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                DrawerItem drawerItem = new DrawerItem();
                drawerItem = navItemArrayList.get(i);
                String selectedValue = drawerItem.getItemName();

                initializeIntentToNavItem(selectedValue);

                Toast.makeText(MainActivity.this, selectedValue, Toast.LENGTH_SHORT).show();
            }
        });

        final DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        toggle.setDrawerIndicatorEnabled(false);
        ImageView navigationDrawerImageView = (ImageView) findViewById(R.id.menuOfToolbarMain);
        navigationDrawerImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (drawer.isDrawerVisible(GravityCompat.START)) {
                    drawer.closeDrawer(GravityCompat.START);
                } else {
                    drawer.openDrawer(GravityCompat.START);
                }
            }
        });


        newsList = getNewsList();
        initializeView();

    }

    private void initializeIntentToNavItem(String selectedItem) {

        if (selectedItem.equalsIgnoreCase("find places")) {
            Intent i=new Intent(MainActivity.this,FindAPlace_Activity.class);
            startActivity(i);

        } else if (selectedItem.equalsIgnoreCase("news")) {
            Toast.makeText(this, "news", Toast.LENGTH_SHORT).show();


        } else if (selectedItem.equalsIgnoreCase("events")) {
            Toast.makeText(this, "events", Toast.LENGTH_SHORT).show();


        } else if (selectedItem.equalsIgnoreCase("ecards")) {
            Toast.makeText(this, "ecards", Toast.LENGTH_SHORT).show();


        } else if (selectedItem.equalsIgnoreCase("currency converter")) {
            Toast.makeText(this, "currency converter", Toast.LENGTH_SHORT).show();


        } else if (selectedItem.equalsIgnoreCase("logout")) {
            Intent i=new Intent(MainActivity.this,LoginActivity.class);
            startActivity(i);

        }
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);

    }

    private List<News> getNewsList() {
        List<News> newsListB = new ArrayList<>();
        for (int i = 0; i <= 10; i++) {
            newsListB.add(new News(getResources().getString(R.string.news_content)));
        }

        return newsListB;
    }

    private void initializeView() {
        recyclerView = (RecyclerView) findViewById(R.id.mainRecyclerView);
        layoutManager = new LinearLayoutManager(this);
        adapter = new NewsRecyclerAdapter(newsList, MainActivity.this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {

            super.onBackPressed();
            overridePendingTransition(R.anim.trans_right_in, R.anim.trans_right_out);

        }
    }


    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

//        if (id == R.id.nav_find_place) {
//            Intent i = new Intent(MainActivity.this, FindAPlace_Activity.class);
//            startActivity(i);
//            // Handle the camera action
//        } else if (id == R.id.nav_news) {
//            Toast.makeText(this, "Find Place.", Toast.LENGTH_SHORT).show();
//
//        } else if (id == R.id.nav_events) {
//            Toast.makeText(this, "Events.", Toast.LENGTH_SHORT).show();
//
//
//        } else if (id == R.id.nav_ecard) {
//            Toast.makeText(this, "Ecards.", Toast.LENGTH_SHORT).show();
//
//
//        } else if (id == R.id.nav_currency_converter) {
//
//            Toast.makeText(this, "Curreny Converter.", Toast.LENGTH_SHORT).show();
//
//
//        } else if (id == R.id.nav_logout) {
//            Toast.makeText(this, "Logout.", Toast.LENGTH_SHORT).show();
//            startActivity(new Intent(this, LoginActivity.class));
//
//
//        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if ((keyCode == KeyEvent.KEYCODE_BACK)) {
            finish();
        }
        return super.onKeyDown(keyCode, event);
    }

    public void getNavItems() {
        int[] navImages =

                {
                        R.mipmap.find_place_icon, R.mipmap.news_icon, R.mipmap.events_icon, R.mipmap.ecard_icon, R.mipmap.curreny_converter_icon, R.mipmap.logout_icon
                };

        String[] navItems = getResources().getStringArray(R.array.nav_items);

        for (int i = 0; i < navImages.length; i++) {
            navItemArrayList.add(new DrawerItem(navItems[i], navImages[i]));

        }
    }
}
