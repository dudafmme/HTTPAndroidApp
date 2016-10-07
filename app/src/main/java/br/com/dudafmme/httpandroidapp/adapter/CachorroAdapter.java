package br.com.dudafmme.httpandroidapp.adapter;

import android.content.ClipData;
import android.content.ClipData.Item;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import br.com.dudafmme.httpandroidapp.R;
import br.com.dudafmme.httpandroidapp.model.Cachorro;

/**
 * Created by eduana on 21/09/2016.
 */

public class CachorroAdapter extends RecyclerView.Adapter<CachorroAdapter.CachorroViewHolder> {

    Context mContext;
    private ArrayList<Cachorro> mCachorros;
    private AoClicarNoCachorroListener mListener;

    @NonNull
    private OnItemCheckListener onItemClick;

    public CachorroAdapter(Context ctx, ArrayList<Cachorro> mCachorros, ArrayList<Cachorro> cachorros, @NonNull OnItemCheckListener onItemCheckListener) {
        mContext = ctx;
        this.mCachorros = cachorros;
        this.onItemClick = onItemCheckListener;
    }

    public void setAoClicarNoCachorroListener(AoClicarNoCachorroListener listener) {
        mListener = listener;
    }

    @Override
    public int getItemCount() {
        return mCachorros.size();
    }

    @Override
    public CachorroViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_dog, parent, false);
        CachorroViewHolder vh = new CachorroViewHolder(view);
        view.setTag(vh);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mListener != null) {
                    CachorroViewHolder vh = (CachorroViewHolder) v.getTag();
                    int position = vh.getAdapterPosition();
                    mListener.aoClicarNoCachorro(v, position, mCachorros.get(position));
                }
            }
        });
        return vh;
    }

    @Override
    public void onBindViewHolder(CachorroViewHolder holder, final int position) {
        final Cachorro cachorro = mCachorros.get(position);
        holder.idTextView.setText(cachorro.getId());
        holder.nomeTextView.setText(cachorro.getNome());
        holder.racaTextView.setText(cachorro.getRaca());

        holder.cachorroCheckBox.setChecked(cachorro.isDogSelected());
        holder.cachorroCheckBox.setTag(cachorro);
        holder.cachorroCheckBox
                .setOnClickListener(
                        new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                CheckBox cb = (CheckBox) v;
                                Cachorro dog = (Cachorro) cb.getTag();
                                dog.setDogSelected(cb.isChecked());
                                mCachorros.get(position).setDogSelected(cb.isChecked());

                                Toast.makeText(v.getContext(), "Checkbox: "
                                                + dog.getId() + " is " + cb.isChecked(),
                                        Toast.LENGTH_LONG).show();

                            }
                        }
                );

        if(holder.cachorroCheckBox.isChecked()){
            onItemClick.onItemCheck(cachorro);
        } else {
            onItemClick.onItemUncheck(cachorro);
        }
    }


    public interface AoClicarNoCachorroListener {
        void aoClicarNoCachorro(View v, int position, Cachorro c);
    }

    public static class CachorroViewHolder extends RecyclerView.ViewHolder {
        private TextView idTextView;
        private TextView nomeTextView;
        private TextView racaTextView;
        private CheckBox cachorroCheckBox;

        public CachorroViewHolder(View parent) {
            super(parent);
            idTextView = (TextView) parent.findViewById(R.id.id_tv);
            nomeTextView = (TextView) parent.findViewById(R.id.nome_tv);
            racaTextView = (TextView) parent.findViewById(R.id.raca_tv);
            cachorroCheckBox = (CheckBox) parent.findViewById(R.id.check_dog_cb);
            //cachorroCheckBox.setClickable(false);
        }
    }

    public interface OnItemCheckListener {
        void onItemCheck(Cachorro c);
        void onItemUncheck(Cachorro c);
    }

}
