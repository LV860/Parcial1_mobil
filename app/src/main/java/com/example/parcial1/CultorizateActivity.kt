package com.example.parcial1

import android.os.Bundle
import android.widget.ListView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.gson.Gson
import com.google.gson.JsonObject
import com.google.gson.reflect.TypeToken
import java.io.IOException

class CultorizateActivity : AppCompatActivity() {
    private var mlista: ListView? = null
    private var mCultorizateAdapter: CultorizateAdapter? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cultorizate)

        // Inicialización de la ListView
        mlista = findViewById(R.id.listaCultorizate)

        // Cargar JSON desde los assets
        val jsonString = loadJSONFromAsset()

        // Parsear el JSON a una lista de objetos HistorialItem
        val cultorizatelList = parseJSON(jsonString) ?: listOf()

        // Inicialización del adaptador con la lista parseada
        mCultorizateAdapter = CultorizateAdapter(this, cultorizatelList)
        mlista?.adapter = mCultorizateAdapter

    }


    private fun loadJSONFromAsset(): String? {
        return try {
            val inputStream = assets.open("jugadores.json")
            val size = inputStream.available()
            val buffer = ByteArray(size)
            inputStream.read(buffer)
            inputStream.close()
            String(buffer, Charsets.UTF_8)
        } catch (ex: IOException) {
            ex.printStackTrace()
            return null
        }
    }

    private fun parseJSON(jsonString: String?): List<CulturizateItem>? {
        return jsonString?.let {
            val gson = Gson()
            val jsonObject = gson.fromJson(it, JsonObject::class.java)
            val jugadoresArray = jsonObject.getAsJsonArray("jugadores")
            val type = object : TypeToken<List<CulturizateItem>>() {}.type
            gson.fromJson<List<CulturizateItem>>(jugadoresArray, type)
        }
    }

}