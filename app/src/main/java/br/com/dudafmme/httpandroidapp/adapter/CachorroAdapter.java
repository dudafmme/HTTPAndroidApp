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
import br.com.dudafmme.httpandroidapp.activities.MainActivity;
import br.com.dudafmme.httpandroidapp.model.Cachorro;

/**
 * Created by eduana on 21/09/2016.
 */

public class CachorroAdapter extends RecyclerView.Adapter<CachorroAdapter.CachorroViewHolder> {

    Context mContext;
    private ArrayList<Cachorro> mCachorros;
    private AoClicarNoCachorroListener mListener;

    public CachorroAdapter(Context ctx, ArrayList<Cachorro> cachorros) {
        mContext = ctx;
        this.mCachorros = cachorros;
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
        CachorroViewHolder vh = new CachorroViewHolder(view, (MainActivity) view.getContext());
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
    public void onBindViewHolder(final CachorroViewHolder holder, final int position) {
        final Cachorro cachorro = mCachorros.get(position);
        holder.idTextView.setText(cachorro.getId());
        holder.nomeTextView.setText(cachorro.getNome());
        holder.racaTextView.setText(cachorro.getRaca());
        holder.cachorroCheckBox.setChecked(cachorro.isDogSelected());

    }


    public interface AoClicarNoCachorroListener {
        void aoClicarNoCachorro(View v, int position, Cachorro c);
    }

    public static class CachorroViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private TextView idTextView;
        private TextView nomeTextView;
        private TextView racaTextView;
        private CheckBox cachorroCheckBox;
        private MainActivity mainActivity;

        public CachorroViewHolder(View parent, MainActivity mActivity) {
            super(parent);
            this.mainActivity = mActivity;
            idTextView = (TextView) parent.findViewById(R.id.id_tv);
            nomeTextView = (TextView) parent.findViewById(R.id.nome_tv);
            racaTextView = (TextView) parent.findViewById(R.id.raca_tv);
            cachorroCheckBox = (CheckBox) parent.findViewById(R.id.check_dog_cb);
            cachorroCheckBox.setOnClickListener(this);

        }

        @Override
        public void onClick(View v) {
            mainActivity.prepararSelecao(v, getAdapterPosition());
        }
    }
}
