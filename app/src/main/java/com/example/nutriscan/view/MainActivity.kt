package com.example.nutriscan.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.nutriscan.R
import androidx.fragment.app.Fragment
import com.example.nutriscan.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        loadFragment(HomeFragment())
        binding.navView.background = null // hide abnormal layer in bottom nav
        binding.navView.setOnItemSelectedListener{
            when(it.itemId){
                R.id.navigation_home ->{
                    loadFragment(HomeFragment())
                    true
                }
                R.id.navigation_title ->{
                    loadFragment(TitleFragment())
                    true
                }
                R.id.navigation_notification ->{
                    loadFragment(NotificationFragment())
                    true
                }
                R.id.navigation_profile ->{
                    loadFragment(ProfileFragment())
                    true
                }else->{
                    false
                }
            }
        }


    }
    private  fun loadFragment(fragment: Fragment){
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.container,fragment)
        transaction.commit()
    }

    override fun onBackPressed() {
        super.onBackPressed()
        finishAffinity()
    }
}