package imraan.imraan.thinkbright

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.Fragment
import imraan.imraan.thinkbright.fragments.AboutFragment
import imraan.imraan.thinkbright.fragments.HomeFragment
import imraan.imraan.thinkbright.fragments.QuizFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class AstronomyQuizResults : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_astronomy_quiz_results)
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

        val astro_answer1 = intent.getStringExtra(EXTRA_MESSAGE)
        val user_score = findViewById<TextView>(R.id.txtAstroScoreTotalCorrect).apply {
            text = astro_answer1.toString()
        }
        //var name = TextView(this)
        val message = intent2.getStringExtra(EXTRA_MESSAGE3)
        val name = findViewById<TextView>(R.id.txtAstroName).apply {
            text = message
        }

        val astroListView = findViewById<ListView>(R.id.listViewAstroResultsBox)
        astroListView.adapter = AstroListAdapter(this) // tells list what to render
    }

    fun makeCurrentFragment(fragment: Fragment) =
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fl_wrapper, fragment)
            commit()
        }

    fun onClearClick(view: View) {
        var listview = ListView(this)
        listview = findViewById(R.id.listViewAstroResultsBox)
        listview.setAdapter(null)
        var txtName = TextView(this)
        txtName = findViewById(R.id.txtAstroName)
        txtName.text = ""
        var txtScore = TextView(this)
        txtScore = findViewById(R.id.txtAstroScoreTotalCorrect)
        txtScore.text = ""
        score = 0
    }



    class AstroListAdapter(context: Context): BaseAdapter() {
        val mContext: Context
        val astro_q1_user = intentAstro1.getStringExtra(EXTRA_MESSAGE4)
        val astro_q2_user = intentAstro2.getStringExtra(EXTRA_MESSAGE5)
        val astro_q3_user = intentAstro3.getStringExtra(EXTRA_MESSAGE6)
        val astro_q4_user = intentAstro4.getStringExtra(EXTRA_MESSAGE7)
        public var user_answer = arrayListOf<String>("       " + astro_q1_user.toString(), "       " + astro_q2_user.toString(), "       " + astro_q3_user.toString(), "       " + astro_q4_user.toString())
        public var correct_answer = arrayListOf<String>("                   Earth", "                Jupiter", "                 Saturn", "              Neptune")

        init {
            mContext = context

        }
        //renders out each row
        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
            val layoutInflator = LayoutInflater.from(mContext)
            val rowMain = layoutInflator.inflate(R.layout.row_main, parent, false)
            val questionNum = rowMain.findViewById<TextView>(R.id.questionNum)
            questionNum.text = (position + 1).toString()
            val radSelected = rowMain.findViewById<TextView>(R.id.userAnswer)
            //user_answer.toMutableList().add(0, "User Answer")
            //correct_answer.toMutableList().add(0, "Correct Answer")
            radSelected.text = user_answer.get(position)
            val correctAnswer = rowMain.findViewById<TextView>(R.id.correctAnswer)
            correctAnswer.text = correct_answer.get(position)

            //val questionNumHeader = rowMain.findViewById<TextView>(R.id.questionNumHeader)
           // questionNumHeader.text = header.get(position)


            return rowMain
//            val textView = TextView(mContext)
//            textView.text = "HERE is my ROW for my LISTVIEW"
//            return textView
        }

        override fun getItem(position: Int): Any {
            return "TEST STRING"
        }

        override fun getItemId(position: Int): Long {
            return position.toLong()
        }

        // number of rows in list
        override fun getCount(): Int {
            return user_answer.size
        }



        //var btnClear: Button = findViewById<Button>(R.id.btnClearAstroResults)

    }
}