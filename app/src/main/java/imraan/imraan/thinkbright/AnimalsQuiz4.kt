package imraan.imraan.thinkbright

import android.content.Intent
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Switch


val EXTRA_MESSAGE11 = "com.example.thinkbright.AnimalQuizResults.MESSAGE"
var userChoiceAnimal4 = ""
var intentAnimal4 = Intent()
class AnimalsQuiz4 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_animals_quiz4)

        var radGroupAnimal: RadioGroup = findViewById(R.id.radioGroupAnimal4)
        var saveBtn: Button = findViewById(R.id.btnSaveAnimal4)
        var radPig = RadioButton(this)
        radPig = findViewById(R.id.radPig4)
        var radElephant = RadioButton(this)
        radElephant = findViewById(R.id.radElephant4)
        var radCat = RadioButton(this)
        radCat = findViewById(R.id.radCat2)
        var radDog = RadioButton(this)
        radDog = findViewById(R.id.radDog2)

        saveBtn.setEnabled(false)

        radGroupAnimal.setOnCheckedChangeListener(
                RadioGroup.OnCheckedChangeListener{ group, checkedId ->
                    if(radPig.isChecked) {
                        saveBtn.setEnabled(true)
                    }
                    else if(radElephant.isChecked) {
                        saveBtn.setEnabled(true)
                    }
                    else if(radCat.isChecked) {
                        saveBtn.setEnabled(true)
                    }
                    else if(radDog.isChecked) {
                        saveBtn.setEnabled(true)
                    }
                    else {
                        saveBtn.setEnabled(false)
                    }
                })
    }

    fun onSave(view: View) {
        var radDog = RadioButton(this)
        radDog = findViewById(R.id.radDog2)
        if (radDog.isChecked) {
            score2++
        }
        val intent = Intent(this, AnimalQuizResults::class.java).apply {
            putExtra(EXTRA_MESSAGE2, score2.toString())
        }
        startActivity(intent)

        var radGroupAnimal4 = findViewById<RadioGroup>(R.id.radioGroupAnimal4)
        var animal4CheckedId = radGroupAnimal4.getCheckedRadioButtonId()
        var radBtnAnimal4: RadioButton = findViewById(animal4CheckedId)
        userChoiceAnimal4 = radBtnAnimal4.getText().toString()
        intentAnimal4 = Intent(this, AnimalQuizResults::class.java).apply {
            putExtra(EXTRA_MESSAGE11, userChoiceAnimal4)
        }
    }

    fun onSwitchClick(view: View) {
        var switchDog = Switch(this)
        switchDog = findViewById(R.id.switchDog)

        if(switchDog.isChecked) {
            val dogSound = MediaPlayer.create(this,R.raw.dog)
            dogSound?.start()
        }
    }
}