package com.example.avina.slicepay;


import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import static com.example.avina.slicepay.R.id.gridview;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentGrid extends Fragment {

    public GridView gridView;

    public FragmentGrid() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v =  inflater.inflate(R.layout.fragment_grid, container, false);
        gridView = (GridView) v.findViewById(gridview);
        gridView.setAdapter(new ImageAdapter(v.getContext()));

        if(getActivity().getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) {
            gridView.setNumColumns(2);
        } else { gridView.setNumColumns(3);}
        return v;
        }

    public class ImageAdapter extends BaseAdapter {
        private Context context;

        public ImageAdapter(Context c) {
            context = c;
        }

        public int getCount() {
            return imageIds.length;
        }

        public Object getItem(int position) {
            return null;
        }

        public long getItemId(int position) {
            return 0;
        }

        public View getView(int position, View convertView, ViewGroup parent) {
            ImageView imageView;

            if (convertView == null) {
                imageView = new ImageView(context);
                imageView.setLayoutParams(new GridView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,300));
                imageView.setScaleType(ImageView.ScaleType.CENTER);
            } else {
                imageView = (ImageView) convertView;
            }

            imageView.setImageResource(imageIds[position]);
            return imageView;
        }

        private Integer[] imageIds = {
                R.drawable.image1, R.drawable.image2,
                R.drawable.image3, R.drawable.image4,
                R.drawable.image5, R.drawable.image6,
                R.drawable.image7, R.drawable.image8,
                R.drawable.image9, R.drawable.image10,
                R.drawable.image11, R.drawable.iamge12,
                R.drawable.image13, R.drawable.image14,
                R.drawable.image15, R.drawable.image16,
                R.drawable.image17, R.drawable.image18,
                R.drawable.image19, R.drawable.image20
        };
    }

}
