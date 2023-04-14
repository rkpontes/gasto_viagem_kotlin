package com.raphaelpontes.gastoviagem

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.raphaelpontes.gastoviagem.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonCalculate.setOnClickListener(this)

    }

    override fun onClick(view: View) {
        if (view.id == R.id.button_calculate) {
            calculate()
        }

    }

    private fun isValid(): Boolean {
        return binding.editDistance.text.toString() != ""
                && binding.editPrice.text.toString() != ""
                && binding.editAutonomy.text.toString() != ""
                && binding.editAutonomy.text.toString().toFloat() != 0f
    }

    private fun calculate() {
        if (isValid()) {
            val distance: Float = binding.editDistance.text.toString().toFloat()
            val price: Float = binding.editPrice.text.toString().toFloat()
            val autonomy: Float = binding.editAutonomy.text.toString().toFloat()
            val totalValue: Float = (distance * price / autonomy)
            val totalValueStr = "R$ ${"%.2f".format(totalValue)}"
            binding.textTotalValue.text = totalValueStr
        } else {
            Toast.makeText(this, R.string.validate_fill_all_fields, Toast.LENGTH_SHORT).show()
        }


    }

}