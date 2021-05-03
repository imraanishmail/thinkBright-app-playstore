package imraan.imraan.thinkbright

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

import com.google.android.material.floatingactionbutton.FloatingActionButton

class AboutUs2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about_us2)
    }

    fun onNext(view: View) {
        var btnNext2 = Button(this)
        btnNext2 = findViewById(R.id.btnNext2)
        val intent = Intent(this, AboutUs3::class.java).apply {
        }
        startActivity(intent)
    }

    fun onBack(view: View) {
        var btnBack2 = FloatingActionButton(this)
        btnBack2 = findViewById(R.id.btnBack2)
        val intent = Intent(this, AboutUs1::class.java).apply {
        }
        startActivity(intent)
    }
}