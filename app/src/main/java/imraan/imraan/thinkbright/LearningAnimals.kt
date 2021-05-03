package imraan.imraan.thinkbright

import android.content.Intent
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import androidx.fragment.app.Fragment
import imraan.imraan.thinkbright.fragments.AboutFragment
import imraan.imraan.thinkbright.fragments.HomeFragment
import imraan.imraan.thinkbright.fragments.QuizFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class LearningAnimals : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_learning_animals)
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

        //Lion Sound
        var imgViewLion = ImageView(this)
        imgViewLion = findViewById(R.id.imgViewLion)

        val lionSound = MediaPlayer.create(this,R.raw.lion)
        imgViewLion.setOnClickListener(View.OnClickListener {
            lionSound?.start()
        })

        // Cow Sound
        var imgViewCow = ImageView(this)
        imgViewCow = findViewById(R.id.imgViewCow)

        val cowSound = MediaPlayer.create(this,R.raw.cow)
        imgViewCow.setOnClickListener(View.OnClickListener {
            cowSound?.start()
        })

        // Pig Sound
        var imgViewPig = ImageView(this)
        imgViewPig = findViewById(R.id.imgViewPig)

        val pigSound = MediaPlayer.create(this,R.raw.pig)
        imgViewPig.setOnClickListener(View.OnClickListener {
            pigSound?.start()
        })

        // Elephant Sound
        var imgViewElephant = ImageView(this)
        imgViewElephant = findViewById(R.id.imgViewElephant)

        val elephantSound = MediaPlayer.create(this,R.raw.elephant)
        imgViewElephant.setOnClickListener(View.OnClickListener {
            elephantSound?.start()
        })

        // Cat Sound
        var imgViewCat = ImageView(this)
        imgViewCat = findViewById(R.id.imgViewCat)

        val catSound = MediaPlayer.create(this,R.raw.cat)
        imgViewCat.setOnClickListener(View.OnClickListener {
            catSound?.start()
        })

        // Dog sound
        var imgViewDog = ImageView(this)
        imgViewDog = findViewById(R.id.imgViewDog)

        val dogSound = MediaPlayer.create(this,R.raw.dog)
        imgViewDog.setOnClickListener(View.OnClickListener {
            dogSound?.start()
        })
    }

    fun makeCurrentFragment(fragment: Fragment) =
            supportFragmentManager.beginTransaction().apply {
                replace(R.id.fl_wrapper, fragment)
                commit()
            }

    fun onQuiz(view: View) {
        var btnQuizYourselfAnimals = Button(this)
        btnQuizYourselfAnimals = findViewById(R.id.btnQuizYourselfAnimals)
        val intent = Intent(this, AnimalsQuiz1::class.java).apply {
        }
        startActivity(intent)
    }
}