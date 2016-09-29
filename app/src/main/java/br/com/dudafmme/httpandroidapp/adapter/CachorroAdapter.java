package br.com.dudafmme.httpandroidapp.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import br.com.dudafmme.httpandroidapp.R;
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
        mCachorros = cachorros;
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
    public void onBindViewHolder(CachorroViewHolder holder, int position) {
        Cachorro cachorro = mCachorros.get(position);
        holder.idTextView.setText(cachorro.getId());
        holder.nomeTextView.setText(cachorro.getNome());
        holder.racaTextView.setText(cachorro.getRaca());
    }


    public interface AoClicarNoCachorroListener {
        void aoClicarNoCachorro(View v, int position, Cachorro c);
    }

    public static class CachorroViewHolder extends RecyclerView.ViewHolder {
        private TextView idTextView;
        private TextView nomeTextView;
        private TextView racaTextView;

        public CachorroViewHolder(View parent) {
            super(parent);
            idTextView = (TextView) parent.findViewById(R.id.id_tv);
            nomeTextView = (TextView) parent.findViewById(R.id.nome_tv);
            racaTextView = (TextView) parent.findViewById(R.id.raca_tv);
        }
    }
}
