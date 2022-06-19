package ghaythali1710.e_commerce_store_app;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;

public class RVHolder extends RecyclerView.ViewHolder {
    /****/
    private TextView text;
    private ImageView image;

    RVHolder(final View itemView, int text_id, int image_id, final OnItemClickListenerCustom listener) {
        super(itemView);
        text = itemView.findViewById(text_id);
        image = itemView.findViewById(image_id);
        /****/
        itemView.setOnClickListener(v -> {
            if (listener != null) {
                int position = getAdapterPosition();
                if (position != RecyclerView.NO_POSITION) {
                    listener.OnItemClickCustom(position, itemView);
                }
            }
        });
    }

    public ImageView getImage() {
        return image;
    }

    public void setImage(ImageView imageView) {
        this.image = imageView;
    }

    public TextView getText() {
        return text;
    }

    public void setText(TextView textView) {
        this.text = textView;
    }
}