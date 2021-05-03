package imraan.imraan.thinkbright

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class Welcome2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome2)
    }

    fun aboutClick(view: View) {
        var btnAboutUs = Button(this)
        btnAboutUs = findViewById(R.id.btnAboutUs)
        val intent = Intent(this, AboutUs1::class.java).apply {
        }
        startActivity(intent)

    }

    fun quizClick(view: View) {
        var btnStartQuiz = Button(this)
        btnStartQuiz = findViewById(R.id.btnStartQuiz)
        val intent = Intent(this, UserDetails::class.java).apply {
        }
        startActivity(intent)

    }
}