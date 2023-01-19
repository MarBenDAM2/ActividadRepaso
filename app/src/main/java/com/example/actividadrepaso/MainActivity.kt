package com.example.actividadrepaso

import android.content.res.Resources
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import com.example.actividadrepaso.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        buttonEditText(binding)

        cambioTexto(binding, resources)

        eliminarTexto(binding)
    }

}

fun buttonEditText(binding: ActivityMainBinding){

    binding.button.setOnClickListener{
        //Si pulsas el boton, la visibilidad del "editTextTextPersonName" se vuelve visible y si se vuelve a pulsar se vuelve invisible
        if(binding.editTextTextPersonName.visibility == View.INVISIBLE){
            binding.editTextTextPersonName.visibility = View.VISIBLE
            binding.button.text = "Finalizar"
        }else{
            binding.editTextTextPersonName.visibility = View.INVISIBLE
        }
    }

}

fun cambioTexto(binding: ActivityMainBinding, resources: Resources){
    binding.editTextTextPersonName.addTextChangedListener(object : TextWatcher {
        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
        }

        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            val texto_input = binding.editTextTextPersonName.text.toString()
            //Si el texto tiene Wayne mostramos la imagen
            if (texto_input == "Wayne") {

                binding.imageView.visibility = View.VISIBLE

            } else if (texto_input == "Joker"){
                //Esto es por si has puesto antes Wayne para que no se quede la imagen
                if (binding.imageView.visibility == View.VISIBLE){
                    binding.imageView.visibility = View.INVISIBLE
                }
                //Si es Joker le decimos que ponga el fondo del boton en morado mas clarito
                binding.button.setBackgroundColor(resources.getColor(R.color.purple_200))
                //Color del texto del boton en negro
                binding.button.setTextColor(resources.getColor(R.color.black))
                //Color de la pista del EditText en blanco al igual del color que escribas el texto
                binding.editTextTextPersonName.setHintTextColor(resources.getColor(R.color.white))
                binding.editTextTextPersonName.setTextColor(resources.getColor(R.color.white))
                //Color del fondo en morado
                binding.root.setBackgroundColor(resources.getColor(R.color.purple_500))

            }

        }

        override fun afterTextChanged(s: Editable?) {
        }
    })


}

fun eliminarTexto(binding: ActivityMainBinding){
    binding.editTextTextPersonName.onFocusChangeListener = View.OnFocusChangeListener { v, hasFocus ->
        if (hasFocus) {
            binding.editTextTextPersonName.hint = ""
        } else {
            binding.editTextTextPersonName.hint = "Escribe tu nombre"
        }
    }
}