package com.example.edunomics;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.Switch;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener,LoginDialog.LoginDialogListenerFull{
    AutoCompleteTextView search;
    String[] hints;
    AnimatorSet set,setknow;
    ImageView img,imge;
    ScrollView scroll;
    Button button_career,button_skill;
    ImageButton img_button_search;
    LinearLayout ll_knowmore,ll_indystry,ll_why,ll_edu;
    ArrayAdapter<String> array_adapter;
    TextView tv_imp,tv_oppr,tv_initia,tv_blogs,tv_login;
    @SuppressLint("ResourceType")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        search=findViewById(R.id.search);
        img=findViewById(R.id.img9);
        button_career=findViewById(R.id.button_career);
        button_skill=findViewById(R.id.button_skill);
        img_button_search=findViewById(R.id.img_button_search);
        ll_knowmore=findViewById(R.id.ll_know_more);
        img_button_search.setOnClickListener(this);
        button_career.setOnClickListener(this);
        button_skill.setOnClickListener(this);
        tv_imp=findViewById(R.id.tv_impact);
        tv_oppr=findViewById(R.id.tv_oppor);
        tv_initia=findViewById(R.id.tv_innit);
        tv_blogs=findViewById(R.id.tv_blogs);
        tv_login=findViewById(R.id.tv_login);
        tv_imp.setOnClickListener(this);
        tv_oppr.setOnClickListener(this);
        tv_initia.setOnClickListener(this);
        tv_blogs.setOnClickListener(this);
        tv_login.setOnClickListener(this);
        ll_indystry=findViewById(R.id.ll_indutry);
        ll_why=findViewById(R.id.ll_why);
        ll_edu=findViewById(R.id.ll_edu);
        imge=findViewById(R.id.imge);




        hints = getResources().getStringArray(R.array.hints);
        array_adapter = new ArrayAdapter<>(MainActivity.this,android.R.layout.simple_list_item_1,hints);
        search.setAdapter(array_adapter);

        scroll = findViewById(R.id.scroll);
        scroll.setSmoothScrollingEnabled(true);
        Animation animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.move_know);
        ll_knowmore.startAnimation(animation);
        set = (AnimatorSet) AnimatorInflater.loadAnimator(this,R.anim.move);
        set.setTarget(img);
        set.start();



    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.button_career:
                search.setHint("How to get a Career?");
                break;
            case R.id.button_skill:
                search.setHint("How to get a Skill?");
                break;
            case R.id.img_button_search:
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setMessage("Requested blog is not present!")
                        .setCancelable(true)
                        .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                            }
                        });
                AlertDialog alert = builder.create();
                alert.show();
                break;
            case R.id.tv_impact:
                final View view = findViewById(R.id.heading_impact);
                view.requestFocus();
                final Rect scrollBounds = new Rect();
                scroll.getHitRect(scrollBounds);
                if (!view.getLocalVisibleRect(scrollBounds)) {
                    new Handler().post(new Runnable() {
                        @Override
                        public void run() {
                            scroll.smoothScrollTo(50, view.getTop());
                        }
                    });
                }
                break;
            case R.id.tv_oppor:
                final View view1 = findViewById(R.id.heading_oppor);
                view1.requestFocus();
                final Rect scrollBounds1 = new Rect();
                scroll.getHitRect(scrollBounds1);
                if (!view1.getLocalVisibleRect(scrollBounds1)) {
                    new Handler().post(new Runnable() {
                        @SuppressLint("ResourceType")
                        @Override
                        public void run() {
                            scroll.smoothScrollTo(50, view1.getTop());
                            set = (AnimatorSet) AnimatorInflater.loadAnimator(MainActivity.this,R.anim.move);
                            set.setTarget(ll_indystry);
                            set.start();
                            Animation animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.move_know);
                            ll_why.startAnimation(animation);


                        }
                    });
                }
                break;
            case R.id.tv_innit:
                final View view2 = findViewById(R.id.heading_initiatives);
                view2.requestFocus();
                final Rect scrollBounds2 = new Rect();
                scroll.getHitRect(scrollBounds2);
                if (!view2.getLocalVisibleRect(scrollBounds2)) {
                    new Handler().post(new Runnable() {
                        @SuppressLint("ResourceType")
                        @Override
                        public void run() {
                            scroll.smoothScrollTo(50, view2.getTop());
                            set = (AnimatorSet) AnimatorInflater.loadAnimator(MainActivity.this,R.anim.move);
                            set.setTarget(imge);
                            set.start();
                            Animation animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.move_know);
                            ll_edu.startAnimation(animation);
                        }
                    });
                }
                break;
            case R.id.tv_blogs:
                AlertDialog.Builder builder1 = new AlertDialog.Builder(this);
                builder1.setMessage("Blogs will be added shortly!")
                        .setCancelable(true)
                        .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                            }
                        });
                AlertDialog alert1 = builder1.create();
                alert1.show();
                break;
            case R.id.tv_login:

                LoginDialog loginDialog = new LoginDialog();
                loginDialog.show(getSupportFragmentManager(), "login dialog");

                break;
        }
    }


    @Override
    public void applyTextsfull(String favoriteemail, String favoritepassword)
    {
        startActivity(new Intent(this, ChatActivity.class));

    }
}
