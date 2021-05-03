package imraan.imraan.thinkbright

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import com.google.android.material.floatingactionbutton.FloatingActionButton

class AboutUs1 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about_us1)
    }

    fun onNext(view: View) {
        var btnNext = Button(this)
        btnNext = findViewById(R.id.btnNext)
        val intent = Intent(this, AboutUs2::class.java).apply {
        }
        startActivity(intent)
    }

    fun onBack(view: View) {
        var btnBack1 = FloatingActionButton(this)
        btnBack1 = findViewById(R.id.btnBack1)
        val intent = Intent(this, Welcome2::class.java).apply {
        }
        startActivity(intent)
    }
}