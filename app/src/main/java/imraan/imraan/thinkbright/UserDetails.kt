package imraan.imraan.thinkbright

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import imraan.imraan.thinkbright.fragments.AboutFragment
import imraan.imraan.thinkbright.fragments.HomeFragment
import imraan.imraan.thinkbright.fragments.QuizFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

val EXTRA_MESSAGE3 =  "com.example.thinkbright.AstronomyQuizResults.MESSAGE"
var intent2 = Intent()
var intent3 = Intent()
class UserDetails : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_details)

        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottomNavigationView)
        val homeFragment = HomeFragment()
        val aboutFragment = AboutFragment()
        val quizFragment = QuizFragment()
        makeCurrentFragment(homeFragment)

        bottomNavigationView.setOnNavigationItemSelectedListener {
            when(it.itemId) {
                R.id.ic_home ->  intent = Intent(this, Welcome2::class.java).apply {
                }
                R.id.ic_info -> intent = Intent(this, AboutUs1::class.java).apply {
                }
                R.id.ic_school -> intent = Intent(this, UserDetails::class.java).apply {
                }
            }
            startActivity(intent)
            true
        }
    }

    fun makeCurrentFragment(fragment: Fragment) =
            supportFragmentManager.beginTransaction().apply {
                replace(R.id.fl_wrapper, fragment)
                commit()
            }

    fun onGo(view: View) {
        var btnGo = Button(this)
        btnGo = findViewById(R.id.btnGo)

        val intent = Intent(this, Quizzes::class.java).apply {
        }
        startActivity(intent)

        var editText = TextView(this)
        editText = findViewById(R.id.txtEnterName)
        var displayText = editText.getText().toString()
        intent2 = Intent(this, AstronomyQuizResults::class.java).apply {
            putExtra(EXTRA_MESSAGE3, displayText)
        }
        intent3 = Intent(this, AnimalQuizResults::class.java).apply {
            putExtra(EXTRA_MESSAGE3, displayText)
        }
    }
}