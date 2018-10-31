package silverwing.christina.flickrphotos;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>{

    private static final String TAG = "RecyclerViewAdapter";

    private ArrayList<String> view_image_headers = new ArrayList<>();
    private ArrayList<String> view_images = new ArrayList<>();
    private Context view_context;

    public RecyclerViewAdapter(ArrayList<String> view_image_headers, ArrayList<String> view_images, Context view_context) {
        this.view_image_headers = view_image_headers;
        this.view_images = view_images;
        this.view_context = view_context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.image_listitem, viewGroup, false);
        ViewHolder holder = new ViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, final int i) {
        Log.d(TAG, "onBindViewHolder: called.");

        Glide.with(view_context)
                .asBitmap()
                .load(view_images.get(i))
                .into(viewHolder.image_view);

        viewHolder.image_header.setText(view_image_headers.get(i));

        viewHolder.parent_image_view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: clicked on: " + view_image_headers.get(i));
            }
        });
    }

    @Override
    public int getItemCount() {
        return view_image_headers.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView image_view;
        TextView image_header;
        ConstraintLayout parent_image_view;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            image_view = itemView.findViewById(R.id.image_view);
            image_header = itemView.findViewById(R.id.image_header);
            parent_image_view = itemView.findViewById(R.id.parent_image_view);

        }
    }
}
