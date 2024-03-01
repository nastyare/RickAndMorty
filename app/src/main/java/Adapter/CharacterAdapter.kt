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


        fun bind(character: Character) {
            Picasso.get()
                .load(character.image)
                .into(imageView)
        }
    }
    class NameViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val nameTextView: TextView = itemView.findViewById(R.id.nameText)

        fun bind(character: Character) {
            nameTextView.text = character.name
        }
    }
    class SpeciesViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val speciesTextView: TextView = itemView.findViewById(R.id.speciesText)

        fun bind(character: Character) {
            speciesTextView.text = character.species
        }
    }


    /*override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return when (viewType) {
            TYPE_IMAGE -> ImageViewHolder(inflater.inflate(R.layout.images, parent, false))
            TYPE_NAME -> NameViewHolder(inflater.inflate(R.layout.names, parent, false))
            TYPE_SPECIES -> SpeciesViewHolder(inflater.inflate(R.layout.species, parent, false))
            else -> throw IllegalArgumentException("Invalid view type")
        }
    }*/
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return when (viewType) {
            Character.TYPE_IMAGE -> ImageViewHolder(inflater.inflate(R.layout.images, parent, false))
            Character.TYPE_NAME -> NameViewHolder(inflater.inflate(R.layout.names, parent, false))
            Character.TYPE_SPECIES -> SpeciesViewHolder(inflater.inflate(R.layout.species, parent, false))
            else -> throw IllegalArgumentException("Invalid view type")
        }
    }



    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val character = characters[position]
        when (holder) {
            is ImageViewHolder -> holder.bind(character)
            is NameViewHolder -> holder.bind(character)
            is SpeciesViewHolder -> holder.bind(character)
        }
    }



    override fun getItemCount() = characters.size

    /*override fun getItemViewType(position: Int): Int {
        return when (characters[position].getType()) {
            "image" -> TYPE_IMAGE
            "name" -> TYPE_NAME
            "species" -> TYPE_SPECIES
            else -> throw IllegalArgumentException("Unknown type")
        }
    }*/
    override fun getItemViewType(position: Int): Int {
        return characters[position].getType()
    }

}