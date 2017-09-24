package com.naufalprakoso.baking.ui.step;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.naufalprakoso.baking.R;

public class RecipeDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe_detail);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Show the Up button in the action bar.
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        if (savedInstanceState == null) {
            // Create the detail fragment and add it to the activity
            // using a fragment transaction.

            Integer position = getIntent().getIntExtra("POSITION",0);
            Integer length = getIntent().getIntExtra("LENGTH",0);

            Bundle arguments = new Bundle();
            arguments.putString(RecipeDetailFragment.ARG_DATA,
                    getIntent().getStringExtra(RecipeDetailFragment.ARG_DATA));
            arguments.putInt("POSITION", position);
            arguments.putInt("LENGTH", length);
            RecipeDetailFragment fragment = new RecipeDetailFragment();
            fragment.setArguments(arguments);

            getSupportFragmentManager().beginTransaction().
                    add(R.id.frame_container,
                            fragment).commit();
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home) {
            onBackPressed();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}