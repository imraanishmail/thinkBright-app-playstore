package imraan.imraan.thinkbright

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import com.google.android.material.floatingactionbutton.FloatingActionButton

class AboutUs3 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about_us3)
    }

    fun onNext(view: View) {
        var btnNext3 = Button(this)
        btnNext3 = findViewById(R.id.btnNext3)
        val intent = Intent(this, Loading::class.java).apply {
        }
        startActivity(intent)
    }

    fun onBack(view: View) {
        var btnBack3 = FloatingActionButton(this)
        btnBack3 = findViewById(R.id.btnBack3)
        val intent = Intent(this, AboutUs2::class.java).apply {
        }
        startActivity(intent)
    }
}