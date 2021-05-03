package imraan.imraan.thinkbright

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ListView
import android.widget.TextView
import androidx.fragment.app.Fragment
import imraan.imraan.thinkbright.fragments.AboutFragment
import imraan.imraan.thinkbright.fragments.HomeFragment
import imraan.imraan.thinkbright.fragments.QuizFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class AnimalQuizResults : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_animal_quiz_results)
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
        val animal_answer = intent.getStringExtra(EXTRA_MESSAGE2)
        val user_score = findViewById<TextView>(R.id.txtAnimalScoreTotalCorrect).apply {
            text = animal_answer.toString()
        }

        val message = intent3.getStringExtra(EXTRA_MESSAGE3)
        val name = findViewById<TextView>(R.id.txtAnimalName).apply {
            text = message
        }

        val animalListView = findViewById<ListView>(R.id.listViewAnimalResultsBox)
        animalListView.adapter = AnimalListAdapter(this) // tells list what to render
    }

    fun makeCurrentFragment(fragment: Fragment) =
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fl_wrapper, fragment)
            commit()
        }

    fun onClearClick(view: View) {
        var listview = ListView(this)
        listview = findViewById(R.id.listViewAnimalResultsBox)
        listview.setAdapter(null)
        var txtName = TextView(this)
        txtName = findViewById(R.id.txtAnimalName)
        txtName.text = ""
        var txtScore = TextView(this)
        txtScore = findViewById(R.id.txtAnimalScoreTotalCorrect)
        txtScore.text = ""
        score2 = 0
    }
    class AnimalListAdapter(context: Context): BaseAdapter() {
        private val mContext: Context
        val animal_q1_user = intentAnimal1.getStringExtra(EXTRA_MESSAGE8)
        val animal_q2_user = intentAnimal2.getStringExtra(EXTRA_MESSAGE9)
        val animal_q3_user = intentAnimal3.getStringExtra(EXTRA_MESSAGE10)
        val animal_q4_user = intentAnimal4.getStringExtra(EXTRA_MESSAGE11)
        val user_answer = arrayListOf<String>("            " + animal_q1_user.toString(), "            " + animal_q2_user.toString(), "            " + animal_q3_user.toString(), "            " + animal_q4_user.toString())
        val correct_answer = arrayListOf<String>("                         Lion", "                        Cow", "                          Cat", "                         Dog")
        init {
            mContext = context
        }
        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
            val layoutInflator = LayoutInflater.from(mContext)
            val rowMain = layoutInflator.inflate(R.layout.row_main_animal, parent, false)
            val questionNum = rowMain.findViewById<TextView>(R.id.questionNumAnimal)
            questionNum.text = (position + 1).toString()
            val radSelected = rowMain.findViewById<TextView>(R.id.userAnswerAnimal)
            radSelected.text = user_answer.get(position)
            val correctAnswer = rowMain.findViewById<TextView>(R.id.correctAnswerAnimal)
            correctAnswer.text = correct_answer.get(position)
            return rowMain
        }

        override fun getItem(position: Int): Any {
            return "TEST STRING"
        }

        override fun getItemId(position: Int): Long {
            return position.toLong()
        }

        override fun getCount(): Int {
            return user_answer.size
        }

    }
}