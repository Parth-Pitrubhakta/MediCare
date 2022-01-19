package com.example.medicare

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.activity_home_page.*

private const val TAG = "HomePage"

open class HomePage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_page)

        val homeFragement = HomeFragement()
        val medicineFragement = MedicineFragment()
        val vaccineFragment = VaccineFragment()
        val profileFragment = ProfileFragment()

        setCurrentFragment(homeFragement)

        bottomNavigationView.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.home -> setCurrentFragment(homeFragement)
                R.id.Medicine -> setCurrentFragment(medicineFragement)
                R.id.Vaccine -> setCurrentFragment(vaccineFragment)
                R.id.Profile -> setCurrentFragment(profileFragment)
            }
            true
        }
    }


    private fun setCurrentFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.flFragment, fragment)
            commit()
        }
    }

    fun getUrlFromIntentMedical(view: View) {
        val url =
            "https://www.google.com/search?rlz=1C1RXQR_enIN945IN945&tbs=lf:1,lf_ui:3&tbm=lcl&sxsrf=AOaemvL4tDtGUwcDFJ0dqXiH9auNLJHsjg:1634562076371&q=medicals+near+me&rflfq=1&num=10&sa=X&ved=2ahUKEwiP9LKfgtTzAhUJzzgGHUuLBDYQjGp6BAgUEDk&biw=1396&bih=649&dpr=1.38#rlfi=hd:;si:;mv:[[20.0165842,73.7738924],[19.9894399,73.7330253]];tbs:lrf:!1m4!1u3!2m2!3m1!1e1!2m1!1e3!3sIAE,lf:1,lf_ui:3"
        val intent = Intent(Intent.ACTION_VIEW)
        intent.data = Uri.parse(url)
        startActivity(intent)
    }

    fun getUrlFromIntentHospital(view: View) {
        val url =
            "https://www.google.com/search?rlz=1C1RXQR_enIN945IN945&tbs=lf:1,lf_ui:2&tbm=lcl&sxsrf=AOaemvJ46HX3R2fOyBoab2m1d9SfWvP4IQ:1636486748493&q=hospital+near+me&rflfq=1&num=10&sa=X&ved=2ahUKEwjq4MqahIz0AhVRyDgGHV27AeMQjGp6BAgMEGo&biw=1396&bih=649&dpr=1.38#rlfi=hd:;si:;mv:[[20.0190157,73.7938178],[19.976796699999998,73.7304221]];tbs:lrf:!1m4!1u3!2m2!3m1!1e1!1m4!1u2!2m2!2m1!1e1!2m1!1e2!2m1!1e3!3sIAE,lf:1,lf_ui:2"
        val intent = Intent(Intent.ACTION_VIEW)
        intent.data = Uri.parse(url)
        startActivity(intent)
    }

//    fun logout(view: View) {
//            Log.i(TAG, "User wants to logout")
//            FirebaseAuth.getInstance().signOut()
//            startActivity(Intent(this, LoginPage::class.java))
//            finish()
//    }

}
