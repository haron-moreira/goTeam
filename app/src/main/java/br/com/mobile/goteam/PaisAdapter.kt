package br.com.mobile.goteam

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso


class PaisAdapter (
    val paises: List<Pais>,
    val onClick: (Pais) -> Unit
        ) : RecyclerView.Adapter<PaisAdapter.PaisViewHolder>() {

            class PaisViewHolder(view: View) : RecyclerView.ViewHolder(view) {
                val cardNome: TextView
                val cardCapital: TextView
                val cardImage: ImageView
                val cardView: CardView

                init {
                    cardNome = view.findViewById(R.id.cardNome)
                    cardCapital = view.findViewById(R.id.cardCapital)
                    cardImage = view.findViewById(R.id.cardImage)
                    cardView = view.findViewById(R.id.cardPais)
                }

            }

    override fun getItemCount() = this.paises.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PaisViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.adapter_pais, parent, false)

        val holder = PaisViewHolder(view)
        return holder
    }

    override fun onBindViewHolder(holder: PaisViewHolder, position: Int) {
        val pais = this.paises[position]

        holder.cardNome.text = pais.nome
        holder.cardCapital.text = pais.capital

        Picasso.with(
            holder.itemView.context
        ).load(pais.bandeira).fit().into(holder.cardImage,
        object: com.squareup.picasso.Callback{
            override fun onError() {

            }

            override fun onSuccess() {

            }
        })

        holder.itemView.setOnClickListener{this.onClick(pais)}
    }

}