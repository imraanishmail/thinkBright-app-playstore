package imraan.imraan.thinkbright

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.fragment.app.Fragment
import imraan.imraan.thinkbright.fragments.AboutFragment
import imraan.imraan.thinkbright.fragments.HomeFragment
import imraan.imraan.thinkbright.fragments.QuizFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class LearningAstronomy : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_learning_astronomy)
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

    fun onQuiz(view: View) {
        var btnQuizYourselfAstro = Button(this)
        btnQuizYourselfAstro = findViewById(R.id.btnQuizYourselfAstro)
        val intent = Intent(this, AstronomyQuiz1::class.java).apply {
        }
        startActivity(intent)
    }
}