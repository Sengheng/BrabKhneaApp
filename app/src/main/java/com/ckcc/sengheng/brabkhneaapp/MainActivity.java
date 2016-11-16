package com.ckcc.sengheng.brabkhneaapp;

import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.TypedValue;
import android.view.View;
import android.widget.Toast;

import com.ckcc.sengheng.brabkhneaapp.adapter.PostalAdapterListener;
import com.ckcc.sengheng.brabkhneaapp.adapter.PostalsAdapter;
import com.ckcc.sengheng.brabkhneaapp.container.Postal;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private PostalsAdapter adapter;
    private List<Postal> postalList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        initCollapsingToolbar();

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);

        postalList = new ArrayList<>();
        adapter = new PostalsAdapter(this, postalList);

        adapter.setPostalsAdapterListener(new PostalAdapterListener() {
            @Override
            public void onItemClick(int position) {
                Toast.makeText(getApplicationContext(),"Position: "+position,Toast.LENGTH_SHORT).show();
            }
        });

        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(this, 4);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.addItemDecoration(new GridSpacingItemDecoration(4, dpToPx(10), true));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);

        prepareAlbums();

        try {
           // Glide.with(this).load(R.drawable.cover).into((ImageView) findViewById(R.id.backdrop));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Initializing collapsing toolbar
     * Will show and hide the toolbar provinceKh on scroll
     */
    private void initCollapsingToolbar() {
        final CollapsingToolbarLayout collapsingToolbar =
                (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar);
        collapsingToolbar.setTitle(" ");
        AppBarLayout appBarLayout = (AppBarLayout) findViewById(R.id.appbar);
        appBarLayout.setExpanded(true);

        // hiding & showing the provinceKh when toolbar expanded & collapsed
        appBarLayout.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            boolean isShow = false;
            int scrollRange = -1;

            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
                if (scrollRange == -1) {
                    scrollRange = appBarLayout.getTotalScrollRange();
                }
                if (scrollRange + verticalOffset == 0) {
                    collapsingToolbar.setTitle(getString(R.string.app_name));
                    isShow = true;
                } else if (isShow) {
                    collapsingToolbar.setTitle(" ");
                    isShow = false;
                }
            }
        });
    }

    /**
     * Adding few albums for testing
     */
    private void prepareAlbums() {
         int[] covers = new int[]{
                R.drawable.album1,
                R.drawable.album2,
                R.drawable.album3,
                R.drawable.album4,
                R.drawable.album5,
                R.drawable.album6,
                R.drawable.album7,
                R.drawable.album8,
                R.drawable.album9,
                R.drawable.album10,
                R.drawable.album11};

       /* String[] covers = new String[]{
                "ស",
                "ច",
                "ន",
                "ប្រ",
                "អ",
                "ប"};*/
        int[] colors = new int[]{
                Color.parseColor("#f44336"),
                Color.parseColor("#e91e63"),
                Color.parseColor("#9c27b0"),
                Color.parseColor("#7986cb"),
                Color.parseColor("#64b5f6"),
                Color.parseColor("#4db6ac")};

        String[] ProvincesKh = new String[]{
                "ភ្នំពេញ",
                "សៀម រាប"
        };

        String[] ProvincesEn = new String[]{
                "Phnom Penh",
                "Siem Reap"
        };




        Postal a = new Postal(ProvincesKh[0],ProvincesEn[0], covers[0], colors[0]);
        postalList.add(a);

        a = new Postal(ProvincesKh[1],ProvincesEn[1], covers[1], colors[1]);
        postalList.add(a);

        a = new Postal(ProvincesKh[1],ProvincesEn[1], covers[1], colors[1]);
        postalList.add(a);

        a = new Postal(ProvincesKh[1],ProvincesEn[1], covers[1], colors[1]);
        postalList.add(a);

        a = new Postal(ProvincesKh[1],ProvincesEn[1], covers[1], colors[1]);
        postalList.add(a);

        a = new Postal(ProvincesKh[1],ProvincesEn[1], covers[1], colors[1]);
        postalList.add(a);

        a = new Postal(ProvincesKh[1],ProvincesEn[1], covers[1], colors[1]);
        postalList.add(a);

        a = new Postal(ProvincesKh[0],ProvincesEn[0], covers[0], colors[0]);
        postalList.add(a);

        a = new Postal(ProvincesKh[0],ProvincesEn[0], covers[0], colors[0]);
        postalList.add(a);

        a = new Postal(ProvincesKh[0],ProvincesEn[0], covers[0], colors[0]);
        postalList.add(a);

        a = new Postal(ProvincesKh[0],ProvincesEn[0], covers[0], colors[0]);
        postalList.add(a);

        a = new Postal(ProvincesKh[0],ProvincesEn[0], covers[0], colors[0]);
        postalList.add(a);


        a = new Postal(ProvincesKh[0],ProvincesEn[0], covers[0], colors[0]);
        postalList.add(a);

        a = new Postal(ProvincesKh[0],ProvincesEn[0], covers[0], colors[0]);
        postalList.add(a);





        adapter.notifyDataSetChanged();
    }

    /**
     * RecyclerView item decoration - give equal margin around grid item
     */
    public class GridSpacingItemDecoration extends RecyclerView.ItemDecoration {

        private int spanCount;
        private int spacing;
        private boolean includeEdge;

        public GridSpacingItemDecoration(int spanCount, int spacing, boolean includeEdge) {
            this.spanCount = spanCount;
            this.spacing = spacing;
            this.includeEdge = includeEdge;
        }

        @Override
        public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
            int position = parent.getChildAdapterPosition(view); // item position
            int column = position % spanCount; // item column

            if (includeEdge) {
                outRect.left = spacing - column * spacing / spanCount; // spacing - column * ((1f / spanCount) * spacing)
                outRect.right = (column + 1) * spacing / spanCount; // (column + 1) * ((1f / spanCount) * spacing)

                if (position < spanCount) { // top edge
                    outRect.top = spacing;
                }
                outRect.bottom = spacing; // item bottom
            } else {
                outRect.left = column * spacing / spanCount; // column * ((1f / spanCount) * spacing)
                outRect.right = spacing - (column + 1) * spacing / spanCount; // spacing - (column + 1) * ((1f /    spanCount) * spacing)
                if (position >= spanCount) {
                    outRect.top = spacing; // item top
                }
            }
        }
    }

    /**
     * Converting dp to pixel
     */
    private int dpToPx(int dp) {
        Resources r = getResources();
        return Math.round(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, r.getDisplayMetrics()));
    }
}