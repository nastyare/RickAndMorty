package Adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.rickandmorty.R
import com.squareup.picasso.Picasso
import data.Character

class CharacterAdapter(private val characters: List<Character>): RecyclerView.Adapter<RecyclerView.ViewHolder>() {


    class ImageViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val imageView: ImageView = itemView.findViewById(R.id.imageView)


        fun bindImage(character: Character) {
            Picasso.get()
                .load(character.image)
                .into(imageView)
        }
    }
    class NameViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val nameTextView: TextView = itemView.findViewById(R.id.nameText)

        fun bindName(character: Character) {
            nameTextView.text = character.name
        }
    }
    class SpeciesViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val speciesTextView: TextView = itemView.findViewById(R.id.speciesText)

        fun bindSpecies(character: Character) {
            speciesTextView.text = character.species
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return when (viewType) {
            Character.imageType -> ImageViewHolder(inflater.inflate(R.layout.images, parent, false))
            Character.nameType -> NameViewHolder(inflater.inflate(R.layout.names, parent, false))
            Character.speciesType -> SpeciesViewHolder(inflater.inflate(R.layout.species, parent, false))
            else -> throw IllegalArgumentException("Invalid view type")
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val character = characters[position]
        when (holder) {
            is ImageViewHolder -> holder.bindImage(character)
            is NameViewHolder -> holder.bindName(character)
            is SpeciesViewHolder -> holder.bindSpecies(character)
        }
    }

    override fun getItemCount() = characters.size
    override fun getItemViewType(position: Int): Int {
        return characters[position].getType()
    }

}