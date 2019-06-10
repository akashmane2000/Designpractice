package com.example.designpractice;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Development development_frag;
    Design design_frag;
    Marketing marketing_frag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        development_frag=new Development();
        design_frag=new Design();
        marketing_frag=new Marketing();

        BottomNavigationView nav=findViewById(R.id.nav);
        final FrameLayout content=findViewById(R.id.content_layout);
        change_fragment(development_frag);
        nav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem)
            {
               switch(menuItem.getItemId())
               {
                   case R.id.item1:
                       change_fragment(development_frag);
                       Animation a=AnimationUtils.loadAnimation(MainActivity.this,R.anim.custom_animation);
                       content.startAnimation(a);



                   break;
                   case R.id.item2:
                       change_fragment(design_frag);
                       Animation b=AnimationUtils.loadAnimation(MainActivity.this,R.anim.custom_animation);
                       content.startAnimation(b);
                   break;
                   case R.id.item3:
                        change_fragment(marketing_frag);
                       Animation c=AnimationUtils.loadAnimation(MainActivity.this,R.anim.custom_animation);
                       content.startAnimation(c);
                       break;


               }
               return false;


            }
        });



    }

    private void change_fragment(Fragment fragment)
    {
        FragmentTransaction fragmentTransaction=getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.content_layout,fragment);
        fragmentTransaction.commit();



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.main,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id=item.getItemId();
        switch(id)
        {
            case R.id.item1:
                Toast.makeText(MainActivity.this,"hii",Toast.LENGTH_LONG);
                break;
            case R.id.item2:
                Toast.makeText(MainActivity.this,"hello",Toast.LENGTH_LONG);
                break;
            case R.id.item3:
                Toast.makeText(MainActivity.this,"bye",Toast.LENGTH_LONG);
                break;








        }
        return super.onOptionsItemSelected(item);
    }
}
