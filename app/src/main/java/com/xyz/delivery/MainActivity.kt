package com.xyz.delivery

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private val TAG = "XYZDelivery"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val etComida = findViewById<EditText>(R.id.etComida)
        val etCantidad = findViewById<EditText>(R.id.etCantidad)
        val etDireccion = findViewById<EditText>(R.id.etDireccion)
        val btnConfirmar = findViewById<Button>(R.id.btnConfirmar)

        btnConfirmar.setOnClickListener {
            val comida = etComida.text.toString().trim()
            val cantidad = etCantidad.text.toString().trim()
            val direccion = etDireccion.text.toString().trim()

            val resumen = "Pedido: $comida\nCantidad: $cantidad\nDirección: $direccion"

            // Logcat (debug + info)
            Log.d(TAG, "Botón presionado -> $resumen")
            Log.i(TAG, "Pedido generado")

            // Toast (alerta simple)
            Toast.makeText(this, "Pedido generado", Toast.LENGTH_SHORT).show()

            // AlertDialog (detalle del pedido)
            AlertDialog.Builder(this)
                .setTitle("Resumen del pedido")
                .setMessage(resumen)
                .setPositiveButton("OK", null)
                .show()
        }
    }

    override fun onStop() {
        super.onStop()
        Log.i(TAG, "App pasó a segundo plano / cerrándose (onStop)")
    }

    override fun onDestroy() {
        Log.i(TAG, "App destruida (onDestroy) - registro de cierre")
        super.onDestroy()
    }
}
