import android.content.Intent
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import es.duarry.loginbasico.Animales
import es.duarry.loginbasico.VerAnimal
import es.duarry.loginbasico.databinding.ItemAnimalesBinding

class AnimalesViewHolder(view:View):RecyclerView.ViewHolder(view) {
    val binding = ItemAnimalesBinding.bind(view)

    fun render(animalesModel: Animales){
        binding.tvNombre.text = animalesModel.nombre
        binding.tvDNI.text = animalesModel.Dni
        binding.tvRaza.text = animalesModel.raza
        Glide.with(binding.ivAnimales.context).load(animalesModel.foto).into(binding.ivAnimales)
        binding.btnVerAnimal.setOnClickListener{
            val intent = Intent(binding.root.context, VerAnimal::class.java)
            intent.putExtra("cod", animalesModel.cod)
            intent.putExtra("nombre", animalesModel.nombre)
            intent.putExtra("raza", animalesModel.raza)
            intent.putExtra("fecha_nacimiento", animalesModel.fechNac)
            intent.putExtra("sexo", animalesModel.sexo)
            intent.putExtra("dni", animalesModel.Dni)
            intent.putExtra("foto", animalesModel.foto)
            binding.root.context.startActivity(intent)
        }
    }
}